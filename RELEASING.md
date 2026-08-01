# Releasing

Releases are cut from `main`. The tag and the GitHub release are created by CI **after** the
artifacts reach Maven Central, so a tag always points at a version that is actually published.

## 1. Prepare the release commit

Open a PR that contains only the release bookkeeping:

- bump `library_version` in [gradle.properties](gradle.properties);
- move the `Unreleased` entries of [CHANGELOG.md](CHANGELOG.md) into a `## [X.Y.Z] - YYYY-MM-DD`
  section and add the compare link at the bottom of the file;
- run `./gradlew updateDocumentedVersions` and commit the [README.md](README.md) it rewrites.

The documentation site needs no edit: `docs_hooks/versions.py` substitutes `library_version` and the
version catalog into the pages while MkDocs builds them, and the site is deployed after the version
is already bumped. `checkDocumentedVersions` runs in the `lint` job and fails if the README was not
regenerated.

The usual CI checks run on that PR. Merge it once they are green.

## 2. Run the release workflow

Actions → **Release** → *Run workflow*, with `version` set to `X.Y.Z` (no `v` prefix).

Set `dry_run` to `true` first if you want a rehearsal: everything runs except publishing, tagging and
the GitHub release.

The workflow refuses to start when

- `version` is not `X.Y.Z`,
- it differs from `library_version` in `gradle.properties`,
- the tag `vX.Y.Z` already exists,
- `CHANGELOG.md` has no `## [X.Y.Z]` section.

Then it runs the instrumented tests on an emulator, and after that, on `macos-26`, `spotlessCheck`
plus `libraryCompileIosArm64 libraryTests libraryApiCheck` — iOS compilation, unit tests and the
public API check. Only afterwards:

1. `./gradlew publishAndReleaseToMavenCentral`,
2. `git tag -a vX.Y.Z` and push,
3. a GitHub release whose body is the CHANGELOG section,
4. the documentation deploy (KDoc + MkDocs to GitHub Pages).

## 3. If something fails

- **A check failed.** Nothing was published. Fix it on `main` and run the workflow again with the
  same version.
- **Publishing failed.** No tag and no release were created. Look at the deployment in the
  [Central Portal](https://central.sonatype.com/publishing/deployments); if the version was never
  validated, you can re-run the workflow with the same version. If it did reach `PUBLISHED`, the
  version is burned — Maven Central never accepts the same coordinates twice — so bump to the next
  patch version and start over from step 1.
- **Publishing succeeded but tagging failed.** Create the tag and the release by hand:
  `git tag -a vX.Y.Z -m "Release X.Y.Z" && git push origin refs/tags/vX.Y.Z`.

## Backports

`main` is the only long-lived branch. Create `release/X.Y.x` from the released tag only when a fix
has to ship without everything that landed on `main` since; run the release workflow from that
branch and merge the fix back into `main`.
