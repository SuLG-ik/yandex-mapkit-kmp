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

Every pull request runs three jobs, and you can reproduce all of them locally:

=== "Formatting"
    ```
    ./gradlew spotlessApply
    ```

=== "Android and JVM"
    ```
    ./gradlew :yandex-mapkit-kmp:check :yandex-mapkit-kmp-compose:check :yandex-mapkit-kmp-moko:check :yandex-mapkit-kmp-moko-compose:check -PskipIosTarget=true -x checkKotlinAbi
    ```

=== "iOS and public API"
    ```
    ./gradlew :yandex-mapkit-kmp:check :yandex-mapkit-kmp-compose:check :yandex-mapkit-kmp-moko:check :yandex-mapkit-kmp-moko-compose:check :yandex-mapkit-kmp:compileKotlinIosArm64 :yandex-mapkit-kmp-compose:compileKotlinIosArm64 :yandex-mapkit-kmp-moko:compileKotlinIosArm64 :yandex-mapkit-kmp-moko-compose:compileKotlinIosArm64
    ```

The last command needs Cocoapods: it compiles both iOS targets, runs `iosSimulatorArm64Test` and
checks the public API against the dumps. The Android job skips `checkKotlinAbi` because a dump made
without the iOS targets is incomplete.

## Public API

The four published modules keep a dump of their public API in `<module>/api`. Any change to a public
declaration makes `checkKotlinAbi` fail until the dump is refreshed:

```
./gradlew updateKotlinAbi
```

Run it on macOS — a dump generated without the iOS targets is incomplete — and commit the result
together with the change. Reviewing that diff is the easiest way to see whether a pull request
changes the API on purpose.

The dumps are klib ones, covering `commonMain` and `iosMain`. Declarations that exist only in
`androidMain` are not part of them: the Kotlin ABI validator does not pick up the Android target of
`com.android.kotlin.multiplatform.library`.

## Releases

Releases are described in [RELEASING.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/RELEASING.md).
Notable changes go into the `Unreleased` section of
[CHANGELOG.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/CHANGELOG.md) in the same pull
request that makes them.
