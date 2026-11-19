# Releasing

Releases are cut from `main`. The tag and the GitHub release are created by CI **after** the
artifacts reach Maven Central, so a tag always points at a version that is actually published.

## 1. Prepare the release commit

Open a PR that contains only the release bookkeeping:

- bump `library_version` in [gradle.properties](gradle.properties);
- move the `Unreleased` entries of [CHANGELOG.md](CHANGELOG.md) into a `## [X.Y.Z] - YYYY-MM-DD`
  section and add the compare link at the bottom of the file;
- run `./gradlew updateDocumentedVersions` and commit the [README.md](README.md) it rewrites.

Tags up to and including `0.4.1` have no `v` prefix; from the next release on the workflow creates
`vX.Y.Z`. Spell both sides of the compare link the way the tags actually exist in the repository, so
the first prefixed release links as `compare/0.4.1...vX.Y.Z` and every one after it as
`compare/vA.B.C...vX.Y.Z`.

The documentation site needs no edit: `docs_hooks/versions.py` substitutes `library_version` and the
version catalog into the pages while MkDocs builds them, and the site is deployed after the version
is already bumped. `checkDocumentedVersions` runs in the `lint` job and fails if the README was not
regenerated.

The usual CI checks run on that PR. Merge it once they are green.

## 2. Run the release workflow

Actions → **Release** → *Run workflow*, with `version` set to `X.Y.Z` or `X.Y.Z-prerelease` — for
example `1.0.0` or `1.0.0-beta01` — in both cases without the `v` prefix, which the workflow adds to
the tag itself. A version carrying a pre-release suffix is published like any other and marked as a
pre-release on GitHub.

Set `dry_run` to `true` first if you want a rehearsal. The workflow runs the release checks, signs
both editions with a temporary key and verifies the same bundle layout used for publishing.

The workflow refuses to start when

- `version` is neither `X.Y.Z` nor `X.Y.Z-prerelease`,
- it differs from `library_version` in `gradle.properties`,
- a tag for it already exists in either scheme, except when resuming a deployment for the commit
  already tagged `vX.Y.Z`,
- `CHANGELOG.md` has no section for that version.

The workflow runs Android instrumented tests and installs and launches the Lite and Full consumers
from staged Maven artifacts. On `macos-26` it runs `spotlessCheck` and
`libraryCompileIosArm64 libraryTests libraryApiCheck`, then builds, links and launches the two
iOS consumer editions on the selected iPhone simulator. Failed consumer checks upload their
dependency and launch diagnostics. These checks also run in a dry run.

After verification succeeds, the release workflow performs these steps.

1. Stage and sign all five modules for Lite and Full, including Android, iOS device and iOS
   simulator publications. Combine the verified Maven files into one bundle.
2. Upload the bundle as one Central Portal deployment. Wait for validation of both editions,
   publish that deployment and confirm the artifacts are available on Maven Central.
3. Push `vX.Y.Z` and create a GitHub release whose body is the CHANGELOG section.
4. Deploy the documentation (KDoc + MkDocs to GitHub Pages).

## 3. If something fails

- **A check failed before the upload.** Fix it on `main` and run the workflow again with the same
  version.
- **The upload or a later step failed.** Check the run summary and
  [Central Portal](https://central.sonatype.com/publishing/deployments) for
  `yandex-mapkit-kmp-VERSION-COMMIT_SHA`. If the accepted deployment is still processing, validated
  or published, run the workflow again from the original commit and set `deployment_id` to its UUID.
  This also handles a failed tag or GitHub release step after both editions reach Maven Central.
  If the branch advanced, dispatch from a release branch pointing to the original commit.
- **Central reports a failed deployment.** Check its validation errors and confirm the version is
  absent from Maven Central before preparing a corrected bundle. Releasing fixes to an already
  published version requires new Maven coordinates.

## Backports

`main` is the only long-lived branch. Create `release/X.Y.x` from the released tag only when a fix
has to ship without everything that landed on `main` since; run the release workflow from that
branch and merge the fix back into `main`.
