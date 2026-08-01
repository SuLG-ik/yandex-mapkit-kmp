---
name: ymk-architecture
description: >-
  Map of the yandex-mapkit-kmp repository — module layout, package structure, source-set and
  file naming, and the house Kotlin style (explicit API strict, toNative()/toCommon() converter
  vocabulary, Native* import aliases, KDoc policy, no inline comments). Use this whenever you
  touch Kotlin in this repository and need to know where code belongs, how to name a file or
  package, or what the project conventions are — including questions phrased as "как устроен
  проект", "где лежит X", "куда положить новый тип", "какие правила именования", "почему тут
  toCommon". Read it before writing the first line of code here; it also points to the
  task-specific skills for the wrapper and Compose modules.
---

# yandex-mapkit-kmp architecture

This repository is a **Kotlin-first multiplatform wrapper over the official Yandex MapKit SDK**
(Android `com.yandex.mapkit`, iOS `YandexMapKit`/`YMK*` via CocoaPods). Everything in the codebase
follows from one goal: *a caller writing common Kotlin should see an API that reads exactly like the
original MapKit, but is platform-independent, null-safe and Kotlin-idiomatic.*

Knowing that goal explains most conventions below — when a rule looks arbitrary, ask "does this keep
the common API looking like MapKit while hiding the native type?" and the answer is usually yes.

## Modules

| Module | Package root | Android namespace | Purpose |
|---|---|---|---|
| `yandex-mapkit-kmp` | `ru.sulgik.mapkit` | `ru.sulgik.mapkit` | The wrapper itself: every MapKit type usable from common code |
| `yandex-mapkit-kmp-compose` | `ru.sulgik.mapkit.compose` | `ru.sulgik.mapkit.compose` | Compose Multiplatform map rendering, states and node composition |
| `yandex-mapkit-kmp-moko` | `ru.sulgik.mapkit.moko` | — | `moko-resources` images as `ImageProvider` |
| `yandex-mapkit-kmp-moko-compose` | `ru.sulgik.mapkit.moko.compose` | — | `rememberMOKOImageLoader()` for the Compose case |
| `sample:composeApp` | — | — | Sample app, needs `MAPKIT_API_KEY` in `local.properties` |

Publication coordinates are `ru.sulgik.mapkit:<module>`, version comes from the `library_version`
property in [gradle.properties](gradle.properties). MapKit's own version lives in
[gradle/libs.versions.toml](gradle/libs.versions.toml) as `yandex-mapkit`.

All four published modules compile with `-Xexplicit-api=strict`, so every public declaration spells
its visibility and its return type.

## Package layout mirrors MapKit

Packages are the MapKit packages with `com.yandex.mapkit` swapped for `ru.sulgik.mapkit`. That is a
documented migration promise (see [docs/wrapper/overview.md](docs/wrapper/overview.md)): users change
the import prefix and their map logic keeps compiling.

```
ru.sulgik.mapkit            MapKit, Animation, Color, PointF, ScreenPoint, ScreenRect
ru.sulgik.mapkit.geometry   Point, Latitude, Longitude, Polyline, Polygon, BoundingBox, Cluster, …
ru.sulgik.mapkit.map        Map, MapWindow, CameraPosition, MapObject*, listeners, styles
ru.sulgik.mapkit.mapview    MapView
ru.sulgik.mapkit.location   LocationManager, Location, SubscriptionSettings, …
ru.sulgik.mapkit.logo       Logo, LogoAlignment, LogoPadding, …
ru.sulgik.mapkit.indoor     IndoorPlan, IndoorLevel, IndoorStateListener
ru.sulgik.mapkit.layers     ObjectEvent
ru.sulgik.mapkit.user_location  UserLocationLayer, UserLocationView, …
```

`user_location` keeps MapKit's snake_case name on purpose — do not "correct" it to `userlocation`.

Compose adds `ru.sulgik.mapkit.compose` plus `compose.composition` (applier/updater internals),
`compose.user_location` and `compose.utils` (colors, lifecycle helpers).

New type in a package MapKit already has? Use that package. New type with no MapKit counterpart
(e.g. `AndroidImageProvider`)? Put it in the package of the type it serves.

## Source sets and file naming

One public type per file, file named after the type:

```
commonMain/kotlin/ru/sulgik/mapkit/geometry/Point.kt          common declaration
androidMain/kotlin/ru/sulgik/mapkit/geometry/Point.android.kt  actual + converters
iosMain/kotlin/ru/sulgik/mapkit/geometry/Point.ios.kt          actual + converters
```

The `.android.kt` / `.ios.kt` suffix is mandatory for platform files that complete a common
declaration. Platform-only types that have no common counterpart drop the suffix, because there is
nothing to disambiguate: `map/AndroidImageProvider.kt`, `map/UIImageImageProvider.kt`.

Check the two cheap failure modes before you commit a new platform file: a `.android.kt` name under
`iosMain` (or the reverse) compiles happily because the suffix is not semantic, and a file whose
name has drifted from the type it completes is invisible to everyone grepping for that type.

```bash
find */src/androidMain */src/iosMain -name '*.kt' ! -name '*.android.kt' ! -name '*.ios.kt'
find . -path '*/iosMain/*' -name '*.android.kt' -o -path '*/androidMain/*' -name '*.ios.kt'
```

The first command should only list platform-only types; the second should list nothing.

## The converter vocabulary: exactly two names

Every crossing of the common/native boundary is spelled `toNative()` or `toCommon()`. There are ~72
`toNative` and ~133 `toCommon` declarations and no synonyms — no `asNative`, no `convert`, no
`fromNative`. Keeping this vocabulary is what makes the wrapper predictable to read.

```kotlin
public fun Point.toNative(): NativePoint
public fun NativePoint.toCommon(): Point
```

Two rules that follow from it:

- **Converters never live in `commonMain`.** `commonMain` has no idea a native type exists. If you
  are tempted to declare `toNative()` in an `expect` class, stop — the wrapper classes declare it in
  each `actual` only, with the platform return type.
- **The native counterpart of the file's common type is imported under a `Native<CommonName>`
  alias**, and alias imports sit at the bottom of the import block:

```kotlin
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKCameraPosition as NativeCameraPosition
```

The alias is named after the **common** type (`NativeCameraPosition`, not `NativeYMKCameraPosition`),
so the same code shape reads identically on both platforms. Helper native types used only for a cast
or a protocol signature may keep their own name (`YMKPoint` in `LinearRing.ios.kt`). A few files skip
the alias for their main type too (`IconStyle.ios.kt`, `MapObjectVisitor.ios.kt`) — that is drift,
not a second convention.

Domain-level conversions that are not the native boundary use their own verbs and are fine:
`Point.toGeometry()`, `Bitmap.toImageProvider()`, `ComposeColor.toMapkitColor()`, `Color.toArgb()`.

## Which pattern for a new type

Three shapes cover the whole wrapper. Pick by asking *"does this thing hold native state?"*

1. **Value type** — immutable data carried across the boundary (`Point`, `CameraPosition`,
   `IconStyle`, `Animation`, `Location`). A plain `data class` (or `@JvmInline value class` for a
   single scalar) in `commonMain`, converters in each platform set.
2. **Handle type** — a live native object the caller drives (`Map`, `MapWindow`,
   `PlacemarkMapObject`, `LocationManager`). `expect class` in common, `actual class X internal
   constructor(private val nativeX: NativeX)` per platform, with `toNative()` as a member and
   `NativeX.toCommon()` as a top-level function.
3. **Listener / callback** — `expect abstract class X()` plus an inline `X(crossinline …)` factory
   in common, and an `actual` implementing `NativeConvertible<NativeX>` around a single
   `nativeListener` field. Subscriptions take `WeakRef<X>`, never the listener itself.

MapKit does not retain listeners, so every subscription method in this wrapper takes
`WeakRef<Listener>` and the caller keeps the strong reference:

```kotlin
private val tapListener = MapObjectTapListener { _, _ -> true }

mapObject.addTapListener(tapListener.asWeakRef())
```

A listener that is only referenced by the subscription is collected immediately and the subscription
silently stops firing — storing it in a field of the node, state or screen that owns it is part of
the pattern, not an optimization.

Full templates with the reasoning behind each line: **use the `ymk-wrapper-api` skill**.
Adding a Compose composable, state or map node: **use the `ymk-compose-api` skill**.
Checking existing or generated code against these rules: **use the `ymk-conventions-review` skill**.

## Kotlin style in this repo

Read [references/kotlin-style.md](references/kotlin-style.md) for the full list. The essentials:

- Explicit `public` and explicit return types on every public declaration (explicit API strict).
- Function bodies use a block with `return`, not expression bodies — the codebase is uniform on this.
- KDoc on public API, copied from the official MapKit docs, and repeated on the `actual` members so
  both IDE navigation targets show it. `-Xexport-kdoc` forwards it into the generated ObjC headers.
- **No explanatory comments in code.** The wrapper is intentionally comment-free; if something needs
  explaining, KDoc it or name it better.
- Trailing commas, named arguments in multi-argument converters, `?.toCommon()` for nullable natives.
- `kotlin.time.Duration` / `Instant` instead of raw millis in the common API — converting to the
  native representation is the converter's job (see `Animation.android.kt`).

## Build, docs and release touch points

- New module → add to [settings.gradle.kts](settings.gradle.kts), to `dokkaModules` in
  [build.gradle.kts](build.gradle.kts), and to the module table in [README.md](README.md).
- User-facing API change → update the matching page under `docs/` and, if it is a new page, the `nav`
  section of [mkdocs.yml](mkdocs.yml). Docs use Material tabs (`=== "Kotlin"`) and admonitions
  (`!!! info`, `!!! warning`).
- iOS targets can be skipped locally with the `skipIosTarget` property; CI publishes from
  `release/**` branches and deploys docs from `main`.
- Android modules use the AGP KMP plugin (`com.android.kotlin.multiplatform.library`), so the Android
  config lives in `kotlin { android { … } }` and the task names differ from AGP's classic ones:
  `compileAndroidMain`, `testAndroidHostTest`, `connectedAndroidDeviceTest`.

Details on modules, Gradle wiring and known inconsistencies:
[references/module-map.md](references/module-map.md).
