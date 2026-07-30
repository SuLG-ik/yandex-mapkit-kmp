# Module map, Gradle wiring and known inconsistencies

## Repository layout

```
yandex-mapkit-kmp/              core wrapper (published)
yandex-mapkit-kmp-compose/      Compose Multiplatform support (published)
yandex-mapkit-kmp-moko/         moko-resources ImageProvider (published)
yandex-mapkit-kmp-moko-compose/ moko-resources + Compose (published)
sample/composeApp/              sample KMP app
sample/iosApp/                  Xcode project for the sample
convention-plugins/             convention.publication.gradle.kts
docs/                           mkdocs sources (wrapper/, compose/, getting-started/)
.github/workflows/              docs.yaml (main → gh-pages), publish.yaml (release/** → Central)
```

## Targets and native dependency

Both published Kotlin modules declare `androidTarget()` plus `iosX64()`, `iosArm64()`,
`iosSimulatorArm64()`, guarded by:

```kotlin
val supportIosTarget = project.property("skipIosTarget") != "true"
```

so `-PskipIosTarget=true` gives an Android-only build on machines without CocoaPods.

The iOS SDK arrives through CocoaPods with a fixed package name, which is why iOS sources import
`YandexMapKit.YMK*`:

```kotlin
cocoapods {
    ios.deploymentTarget = "15.0"
    framework { baseName = "YandexMapKitKMP" }
    noPodspec()
    pod("YandexMapsMobile") {
        version = libs.versions.yandex.mapkit.get()
        packageName = "YandexMapKit"
    }
}
```

On Android the native SDK is an `api` dependency (`libs.yandex.mapkit`), so consumers see MapKit
types. On iOS it is deliberately **not** transitive — consumers link `YandexMapsMobile` themselves,
as documented in the README.

Compose module dependencies worth remembering: `api(project(":yandex-mapkit-kmp"))`, compose runtime
/ foundation / ui / components.resources, lifecycle (`api` on `lifecycle-runtime`), `atomicfu` (used
by `MapWindowOwner`'s reentrant lock) and `kotlinx-collections-immutable` (`api`, because
`Clustering` takes `ImmutableList`).

## Versions and publication

- `library_version` in `gradle.properties` drives every module's `version`; the publishing block is
  skipped when it resolves to `"null"`.
- `gradle/libs.versions.toml` holds Kotlin, AGP, Compose, MapKit (`yandex-mapkit`) and library
  versions. Bumping MapKit means bumping it there and in the README sentence that names the version.
- Publication is `com.vanniktech.maven.publish` to Central Portal with signing, `JavadocJar.Empty()`
  and `androidVariantsToPublish = listOf("release")`. The POM block (name, description, license,
  developer, scm) is duplicated per module — copy it verbatim for a new module and change only
  `name` / `description`.
- KDoc site: root `build.gradle.kts` registers modules in `dokkaModules` and Dokka outputs into
  `docs/kdoc`, which `mkdocs.yml` links as "API docs".

## Documentation surface

| Change | Update |
|---|---|
| New/changed common wrapper API | `docs/wrapper/overview.md` or `docs/wrapper/image-resources.md` |
| New/changed Compose API | `docs/compose/overview.md`, `compose/mapobjects.md`, `compose/image-resources.md` |
| New docs page | add it to `nav:` in `mkdocs.yml` |
| New module | `settings.gradle.kts`, `dokkaModules`, README module table |
| MapKit version bump | `libs.versions.toml`, README |

Docs style: Material tabs `=== "Kotlin"`, admonitions `!!! info` / `!!! warning`, snippets that
compile mentally — they are the first thing users copy.

## Known inconsistencies

These exist in the tree today. Do not treat them as patterns, and do not go on a cleanup spree either
unless asked — just avoid reproducing them.

- **Misnamed platform files**: `geometry/PolylinePosition.andoird.kt`; `location/
  SubscriptionSettings.android.kt` and `location/UseInBackground.android.kt` live in **iosMain**;
  `map/MapWindow.kt` in iosMain lacks the `.ios` suffix.
- **Name drift between common and platform files**: `logo/LogoAlignment.kt` is completed by
  `logo/Alignment.android.kt` / `Alignment.ios.kt` (same for `Padding`, `HorizontalAlignment`,
  `VerticalAlignment`).
- **`LocationManager.ios.kt`** exposes a public constructor while every comparable handle type uses
  `internal constructor`.
- **`InputListener.ios.kt`** maps `onMapLongTapWithMap` to `onMapTap` and vice versa — the two
  callbacks are swapped relative to the Android actual.
- **`Color.ios.kt`** reads `CIColor.red` etc. without an import of `CIColor` visible in the file.
- **minSdk drift**: modules set `minSdk = 24`, `libs.versions.toml` says `android-minSdk = "26"`, and
  the README documents 26.
- **Test file naming**: `ColorConvertionTest` (missing "s"), and
  `MapObjectStatesRestorationTest.kt` is entirely commented out.

If a task takes you into one of these files anyway, fixing the local issue is welcome — mention it in
the commit message rather than in a code comment.
