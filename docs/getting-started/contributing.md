# Contributing

## Required

- macOS
- Cocoapods
- Android studio

## Sample

To run sample you should provide your API key using `local.properties`

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
