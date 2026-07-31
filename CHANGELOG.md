# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project
adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

Releases before `0.5.0` were described in
[GitHub Releases](https://github.com/SuLG-ik/yandex-mapkit-kmp/releases) only; the sections below
summarise them.

## [Unreleased]

Uses Yandex MapKit 4.42.0-lite. Set this version in your `Podfile` or `podspec`.

### Added

- `WeakRef<T>` with `asWeakRef()` and `withValue()`, mirroring how MapKit 4.41 keeps listeners.
- `IconStyle.opacity`, `MapMode.HYBRID`, `LocationPurpose.STATIC_DISPLAY_LOCATION`.
- `MAPKIT_BACKLOG.md` listing MapKit 4.25–4.42 API that is not wrapped yet.

### Changed

- **Breaking.** Every listener subscription takes a `WeakRef<Listener>`: MapKit no longer retains
  listeners itself (Android holds a `WeakReference`, iOS a `__weak` pointer).
- **Breaking.** `MapWindow.setMapFps` takes an `Int` instead of a `Float`.
- **Breaking.** `Map.calculateCameraPosition` takes `focusRect` before `azimuth` and `tilt`.
- Library modules build with `com.android.kotlin.multiplatform.library`; the sample Android app moved
  to `sample:androidApp` while `sample:composeApp` became a KMP library.
- Toolchain: Gradle 9.6.1, AGP 9.3.1, Kotlin 2.4.10, Compose Multiplatform 1.11.1, compileSdk 37,
  JVM target 11.

### Removed

- **Breaking.** The `iosX64` target: Compose Multiplatform no longer publishes for it.
- **Breaking.** `SizeChangeListener`, deprecated since 0.1.1 in favour of `SizeChangedListener`.
- The atomicfu Gradle plugin; only its locks runtime API was used.

### Fixed

- The cluster listener is retained by `ClusterNode` instead of being a factory local, so clustering
  keeps working after the factory is collected.
- Linking an Objective-C framework no longer crashes the Kotlin 2.4 compiler with a
  `NullPointerException` in `ObjCExportCodeGenerator`. The bounds of `WeakRef<T>.toNative()` are
  spelled without an explicit `T : Any`, which is what the compiler trips over; the signature is
  unchanged for callers. CI now links the frameworks so this cannot regress unnoticed.
- `yandex-mapkit-kmp-moko-compose` declares `compose.foundation`, which pinned it to the 1.7.0
  artifact pulled in by moko-resources and failed to build a Kotlin/Native cache.

## [0.4.1] - 2025-10-17

Uses Yandex MapKit 4.24.0-lite, with [16 KB page size](https://developer.android.com/guide/practices/page-sizes)
support on 64-bit devices.

## [0.4.0] - 2025-10-05

Uses Yandex MapKit 4.23.0-lite.

### Added

- `isValid` properties on map objects.

### Changed

- Kotlin 2.2.20, Compose Multiplatform 1.9.0, Android target 36.

## [0.3.1] - 2025-07-16

### Fixed

- Colors of images created on iOS (BGRA to RGBA conversion).

## [0.3.0] - 2025-07-14

Uses Yandex MapKit 4.17.0-lite.

### Added

- Indoor map support with a state listener and level management.
- `Map.setMapStyle`.

## [0.2.0] - 2025-03-01

Uses Yandex MapKit 4.11.0-lite.

### Added

- `Geo` on both platforms, `MapWindow.setMaxFps` and `MapConfig.fps` in the Compose module.
- `SubscriptionSettings`, `UseInBackground`, `Location.indoorLevelId`, navigation-related
  `LocationPurpose` values.

### Changed

- **Breaking.** `TextStyle.color` and `TextStyle.outlineColor` are non-null and default to
  `DEFAULT_COLOR` / `DEFAULT_OUTLINE_COLOR`.

### Removed

- **Breaking.** `FilteringMode` and its converters, replaced by `UseInBackground` in
  `SubscriptionSettings`; `advancePolylinePosition` in `Geo`.

## [0.1.1] - 2024-10-19

Uses Yandex MapKit 4.8.1-lite.

### Added

- `setNonInteractive`, KDoc rendered with Dokka.

### Changed

- `Color` became a value class.
- `SizeChangeListener` renamed to `SizeChangedListener`; the old name is deprecated.

## [0.1.0] - 2024-08-28

Uses Yandex MapKit 4.7.0-lite.

### Added

- The states-based Compose API and `PointF` support.
- Documentation site built with MkDocs.

### Changed

- **Breaking.** The map instance is created by the `YandexMap` composable and the controller property
  is nullable now.

## [0.0.2] - 2024-06-26

## [0.0.1] - 2024-06-22

The first published version.

[Unreleased]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.4.1...HEAD
[0.4.1]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.4.0...0.4.1
[0.4.0]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.3.1...0.4.0
[0.3.1]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.3.0...0.3.1
[0.3.0]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.2.0...0.3.0
[0.2.0]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.1.1...0.2.0
[0.1.1]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.1.0...0.1.1
[0.1.0]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.0.2...0.1.0
[0.0.2]: https://github.com/SuLG-ik/yandex-mapkit-kmp/compare/0.0.1...0.0.2
[0.0.1]: https://github.com/SuLG-ik/yandex-mapkit-kmp/releases/tag/0.0.1
