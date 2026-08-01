# Contributing

## Required

- macOS
- CocoaPods
- Android Studio
- Python 3 with `lxml`, for the MapKit reference

## MapKit reference

`ymk-docs/` holds an offline copy of the Yandex MapKit reference — the source of truth for every
signature the wrapper mirrors. It is generated, not stored in the repository, so build it once after
cloning:

```bash
python3 ymk-docs/_tools/bootstrap.py
```

It fetches around 2000 pages from `yandex.ru/maps-api/docs/mapkit` and converts them to Markdown;
expect a couple of minutes. The script is idempotent — it does nothing when the copy is already
there. Add `--validate` to run the coverage and link checks, `--force` to rebuild, `--refresh` to
re-download instead of reusing the cache in `ymk-docs/_tools/cache/`.

Rebuilding under a new MapKit release is described in `ymk-docs/_tools/README.md`.

## Sample

The sample needs your API key in `local.properties`:

=== "local.properties"
    ```
    MAPKIT_API_KEY=<API-KEY>
    ```

## Branches

`main` is the only long-lived branch. Branch off it, open a pull request back into it, and let the
checks run. `release/X.Y.x` branches exist only when a fix has to ship without everything else that
already landed on `main`.

## Checks

Every pull request runs four jobs in parallel — `lint`, `test-android`, `test-ios` and `api-check` —
and you can reproduce all of them locally:

=== "Formatting"
    ```
    ./gradlew spotlessApply
    ```

=== "Android"
    ```
    ./gradlew libraryAssemble libraryTests -PskipIosTarget=true
    ```

=== "iOS"
    ```
    ./gradlew libraryCompileIosArm64 libraryIosTests
    ```

=== "Public API"
    ```
    ./gradlew libraryApiCheck
    ```

The `library*` tasks fan out over the four published modules. The iOS ones need Cocoapods, and so
does `libraryApiCheck` — the dumps cover the iOS targets, so it only runs on macOS.

Compose rendering tests wait for a real frame (`GraphicsLayer` → `ImageBitmap`), which the JVM does
not produce, so they are excluded from the Android host run and covered by the iOS simulator plus an
emulator job. That emulator job runs on pushes to `main` and again before every release:

```
./gradlew :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest
```

## Public API

The four published modules keep two dumps of their public API in `<module>/api`. Any change to a
public declaration makes `libraryApiCheck` fail until both are refreshed:

```
./gradlew libraryApiDump
```

Run it on macOS — a dump generated without the iOS targets is incomplete — and commit the result
together with the change. Reviewing that diff is the easiest way to see whether a pull request
changes the API on purpose.

`<module>.klib.api` is the Kotlin ABI validator's klib dump and covers `commonMain` and `iosMain`.
The validator does not pick up the Android target of `com.android.kotlin.multiplatform.library`, so
`<module>.android.api` is produced separately by `dumpAndroidAbi`: it runs `javap -public` over the
classes of the Android main compilation and is what guards `androidMain`-only declarations such as
`MapKit.initialize(Context)` and the `ImageProvider` factories. Being a `javap` dump it is sensitive
to the JDK it was generated with — use the same JDK version as CI.

## Documentation

The site is MkDocs Material. It is built from `docs/` and deployed by CI together with the KDoc that
Dokka renders into `docs/kdoc`.

```bash
pip install -r docs/requirements.txt
```

```bash
mkdocs serve
```

```bash
./gradlew :dokkaGenerate
```

### Two languages

Every page exists twice, in the [suffix layout](https://ultrabug.github.io/mkdocs-static-i18n/) of
`mkdocs-static-i18n`: `wrapper/overview.md` is English and `wrapper/overview.ru.md` is Russian.
English is the default language and keeps the bare URLs; Russian is served under `/ru/`.

A page without its `.ru.md` twin falls back to the English text rather than 404ing, so a new page can
land in one language and be translated later — but a pull request that adds one should add both.
Section titles in the `nav` are translated in `mkdocs.yml` under `nav_translations`; a new nav entry
needs its line there too.

### Versions are substituted, not typed

Never write a version number into a page. `docs_hooks/versions.py` reads `gradle.properties` and
`gradle/libs.versions.toml` at build time and replaces these placeholders:

| Placeholder | Source |
|---|---|
| `\{{ version }}` | `library_version` in `gradle.properties` |
| `\{{ mapkit_version }}` | `yandex-mapkit` in the version catalog |
| `\{{ kotlin_version }}` | `kotlin` in the version catalog |
| `\{{ compose_version }}` | `compose-plugin` in the version catalog |
| `\{{ min_sdk }}` | `android-minSdk` in the version catalog |

An unknown placeholder is left alone, so `\{{ something }}` in a code sample survives untouched; a
known one can be escaped with a leading backslash, which is how this table is written.

The README is not built by MkDocs, so its versions are kept in sync by Gradle instead:

```bash
./gradlew updateDocumentedVersions
```

```bash
./gradlew checkDocumentedVersions
```

The check runs in the `lint` job, so a bumped `library_version` with a stale README fails CI.

## Compatibility

Within `1.x` the modules guarantee **source** compatibility, not binary compatibility.

The wrapper follows MapKit, and MapKit adds fields to its structures and constants to its enums in
minor releases. The wrapper mirrors those structures as `data class`es, so a new field changes
`componentN` and `copy$default`, and a new enum constant makes an exhaustive `when` over it stop
compiling. Both are binary-breaking, and refusing them would mean freezing the wrapper on the MapKit
version 1.0.0 shipped with.

In practice this means: recompile against the version you depend on, do not mix wrapper versions in
one dependency graph, and expect a `when` over a wrapper enum to need a new branch after an update.
Renames, removals and signature changes are still reserved for a major release.

## Releases

Releases are described in [RELEASING.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/RELEASING.md).
Notable changes go into the `Unreleased` section of
[CHANGELOG.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/CHANGELOG.md) in the same pull
request that makes them.
