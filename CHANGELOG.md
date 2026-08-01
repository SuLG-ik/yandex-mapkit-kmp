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
- `RootMapObjectCollection` and `ConflictResolutionMode`, so the priority of overlapping labels in
  the map's own object collection can be configured.
- `Map.isTransparentBackgroundEnabled` and `Map.isBuildingsAboveIndoorEnabled`.
- `isValid` on `MapKit`, `Arrow`, `CameraBounds`, `Cluster` and `ObjectEvent`.
- `LocationSimulator.asLocationManager()`, the `LocationManager` MapKit derives the simulator from.
  It carries `subscribeForLocationUpdates`, `requestSingleUpdate`, `unsubscribe`, `suspend` and
  `resume`, which common code could not reach before: a simulator is created suspended and
  `startSimulation` does not resume it, so `isActive` could never become true.
- `DummyLocationManager.asLocationManager()`, the same for the manager MapKit also derives from
  `LocationManager`. Without it the wrapper exposed only `setLocation`, so nothing could subscribe
  to the positions pushed in, and a dummy manager could not be handed to
  `MapKit.setLocationManager()` or `toLocationViewSource()`.
- Compose: `MapConfig` covers the rest of `Map` and `MapWindow` — `mode`, `mapStyle`,
  `isHdModeEnabled`, `isIndoorEnabled`, `isAwesomeModelsEnabled`, `isTransparentBackgroundEnabled`,
  `isBuildingsAboveIndoorEnabled`, `focusRect`, `focusPoint`, `gestureFocusPoint`,
  `gestureFocusPointMode`, `pointOfView`, `scaleFactor` and a `MapCameraBoundsConfig`.
- An ABI dump of the Android target in `<module>/api/<module>.android.api`, checked by
  `libraryApiCheck`; the Kotlin ABI validator covers klib targets only.
- The rest of the lite MapKit API. `docs/wrapper/coverage.md` maps it out; by package:
    - `map` — `PlacemarkPresentation`, `Icon`, `CompositeIcon`, `PlacemarkText`,
      `PlacemarkAnimation`, `Model`, `ModelStyle`, `AnimatedImage`, `AnimatedImageProvider`,
      `Frame`, `DataProviderWithId`, `BaseMetadata`, `GeoObjectSelectionMetadata`, `GeoObjectTags`,
      `GeoObjectInspectionMetadata`, `MapLoadStatistics`, `MapLoadedListener`,
      `TileDataSourceBuilder`, `VisibleRegion.toPolygon()` / `getBounds()`, and the matching
      `PlacemarkMapObject.setIconStyle` / `setScaleFunction` / `useIcon` / `useCompositeIcon` /
      `useModel` / `useAnimation` / `text`, `PolygonMapObject.setPattern(AnimatedImageProvider)`,
      `MapObject.setVisible(Boolean, Animation, Callback)`
    - `Map` — `addTapListener` / `removeTapListener` for geo objects, `selectGeoObject`,
      `deselectGeoObject`, `setMapLoadedListener`, `addMapObjectLayer`, `addTileLayer`, `projection`
    - root — `GeoObject`, `GeoObjectCollection`, `GeoObjectCollectionItem`, `Attribution`, `Image`,
      `SpannableString`, `LocalizedValue`, `Time`, `UserData`, `Size2u`, `TileId`, `ZoomRange`,
      `Version`, `RawTile`
    - `layers` — `GeoObjectTapEvent`, `GeoObjectTapListener`, `Layer`, `LayerOptions`,
      `DataSourceLayer`, `BaseDataSource`, `DataSource`, `TileDataSource`, `DataSourceListener`,
      `LayerLoadedListener`, `OverzoomMode`, `TileFormat`
    - `tiles` — `TileProvider`, `UrlProvider`
    - `traffic` — `TrafficLayer`, `TrafficListener`, `TrafficLevel`, `TrafficColor`
    - `storage` — `StorageManager`, `StorageErrorListener`
    - `offline_cache` — `OfflineCacheManager`, `Region`, `RegionState`, `RegionListener`,
      `RegionListUpdatesListener`, `ErrorListener`, `DataMoveListener`, `OfflineCacheError`
    - `location` — `LocationSettings`, `LocationError`, `Range`, `TimeInterval`, `ViewArea`,
      `SimulationSettings`, `LocationSimulator`, `LocationSimulatorListener`, `DummyLocationManager`,
      `DummyLocationQuality`, `LocationUnavailableError`, `lastKnownLocation()`
    - `geometry` — `Direction`, `Span`, `PolylineBuilder`, `getBounds()`, `subpolyline()`;
      `geometry.geo` — `Projection`, `Projections`, `XYPoint`, `PolylineIndex`, `PolylineUtils`,
      `Priority`
    - `runtime` — the `Error` hierarchy including `runtime.network`, `runtime.logging`,
      `runtime.i18n`
    - `ui` — `Overlay` plus `MapWindow.addRasterScreenOverlay`
    - `uri` — `Uri`, `UriObjectMetadata`; `personalized_poi` — `PersonalizedPoiExtraMetadata`
    - `MapKit` — `onTerminate`, `createTrafficLayer`, `storageManager`, `offlineCacheManager`,
      `createLocationSimulator`, `createDummyLocationManager`; `MapView.destroy`
- Compose: `MapListeners` for map taps, geo object taps, indoor state, map size and the map loaded
  event, a `TrafficLayer` composable, and a `userData` parameter on every map object composable.
- Compose: `MapObjectCollection` groups its content into a nested collection that can be hidden,
  z-ordered and removed as a whole, and `MapObjectCollectionState` reaches the `PlacemarksStyler`
  shared by the group and `traverse`.
- Compose: `TileLayer` renders a custom tile layer and `MapObjectLayer` puts map objects on a layer
  of their own, on top of `Map.addTileLayer` and `Map.addMapObjectLayer`.
- Compose: `MapObjectState`, the common base of the map object states, adds
  `setVisible(visible, animation, onFinished)` and `isValid` to all of them. `PlacemarkState` gained
  `setScaleFunction`, `useIcon`, `useCompositeIcon`, `useModel`, `useAnimation` and `text`;
  `PolygonState` gained `setPattern(AnimatedImageProvider, scale)` and `resetPattern`.
- `MAPKIT_BACKLOG.md` listing MapKit 4.25–4.42 API that is not wrapped yet.
- The documentation site is bilingual: English keeps the existing URLs, Russian is served under
  `/ru/`. Nine pages are new — migration from MapKit, the map and the camera, map objects, base map
  objects, geolocation, layers and tiles, offline maps and storage, runtime — and every page carries
  runnable examples instead of prose.
- Versions in the documentation are substituted at build time from `gradle.properties` and the
  version catalog by `docs_hooks/versions.py`, and the ones in `README.md` are rewritten by
  `updateDocumentedVersions` and guarded by `checkDocumentedVersions` in the `lint` job.

### Changed

- **Breaking.** Every listener subscription takes a `WeakRef<Listener>`: MapKit no longer retains
  listeners itself (Android holds a `WeakReference`, iOS a `__weak` pointer). This includes
  `runtime.logging.Logging.subscribe` / `unsubscribe`, whose MapKit signatures take the listener
  directly and store it in a `WeakHashMap` all the same, so the hazard and the API are the same as
  everywhere else.
- **Breaking.** `Cluster` moved from `ru.sulgik.mapkit.geometry` to `ru.sulgik.mapkit.map`, matching
  `com.yandex.mapkit.map.Cluster`.
- **Breaking.** `Map.mapObjects` is a `RootMapObjectCollection` instead of a `MapObjectCollection`.
- **Breaking.** Members renamed to the names MapKit itself uses, so that swapping the import prefix
  keeps working: `MapWindow.setMapFps` → `setMaxFps`, `MapWindow.addSizeChangeListener` /
  `removeSizeChangeListener` → `addSizeChangedListener` / `removeSizeChangedListener`,
  `MapWindow.convertWorldToScreen` / `convertScreenToWorld` → `worldToScreen` / `screenToWorld`,
  `Map.calculateCameraPosition` → `cameraPosition`, `Map.calculateVisibleRegion` → `visibleRegion`,
  `Map.getLogo()` → `val logo`, `Polygon.innerRing` → `innerRings`, `LogoAlignment.horizontal` /
  `vertical` → `horizontalAlignment` / `verticalAlignment`, `MapView.setNonInteractive` →
  `setNoninteractive`, `PolylineState.arrows()` → `val arrows`.
- **Breaking.** `MapWindow.setMaxFps` takes an `Int` instead of a `Float`.
- **Breaking.** `PolylineMapObject.setStrokeColors` takes `List<Int>` and
  `PolylineMapObject.getStrokeColor` returns an `Int`; `PolylineState` follows. These carry indexes
  into the polyline's colour palette, not colours — MapKit's own signatures are `List<Integer>` /
  `int` and `NSArray<NSNumber *> *` / `NSUInteger`. Typed as `Color`, they handed MapKit an ARGB
  value such as `0xFFFF0000` where a small palette index was expected and read a palette index back
  as ARGB, so a multi-coloured polyline could not be expressed at all; the readback only looked
  right because the same wrong integer round-tripped. Define the palette with
  `setPaletteColor(colorIndex, color)`, then assign an index per segment with
  `setStrokeColors(paletteIndices)`. `setStrokeColor`, `setPaletteColor` and `getPaletteColor`
  are colours and are unchanged.
- **Breaking.** `Map.cameraPosition` is a single function whose `focusRect`, `azimuth` and `tilt`
  are optional, as in MapKit, instead of three overloads with required arguments.
- **Breaking.** `IndoorPlan` is a wrapper class instead of an interface, so it is no longer
  implementable from outside the library.
- **Breaking.** Compose: `UserLocationConfig` and the `YandexMap` overload that takes a
  `UserLocationState` are no longer `@YandexMapsComposeExperimentalApi`, and
  `UserLocationConfig.LocationAccuracy` holds `val`s instead of `var`s. Compose-rendered map object
  icons — `ComposeMapObjectRenderer`, `imageProvider`, `clusterImageProvider`, `ClusterImageProvider`
  and the `Placemark` / `Clustering` overloads that take composable content — stay experimental.
- The `-moko` and `-moko-compose` modules compile with `-Xexplicit-api=strict`, like the other two.
- **Breaking.** `Geometry.fromMultipolygon` is spelled `fromMultiPolygon`, as in MapKit.
- **Breaking.** `BoundingBox`, `ScreenRect` and `map.Rect` are `data class`es, like every other value
  type of the wrapper. They compared by identity, which among other things made an unchanged
  `MapConfig` holding a `focusRect` look different on every recomposition.
- **Breaking.** `Location.relativeTimestamp` is a `Duration` instead of an `Instant`: MapKit reports
  time passed on a steady clock, which is not a point in time.
- **Breaking.** `MapObjectVisitor.onCollectionVisitEnd` returns `Unit` instead of `Boolean`, as in
  MapKit; the returned value was discarded.
- Handle types — the wrappers around a live MapKit object, from `Map` and the `MapObject` hierarchy
  to the presentation objects, the managers, the layers and the `Error` hierarchy — compare by the
  object behind them: two handles are equal when they have the same type and wrap the same native
  object, and `hashCode()` is the wrapped object's. Every `toCommon()` builds a fresh wrapper, so
  the placemark a tap listener handed over could not be compared to the one that was added, nor be
  found with `contains` or used as a `Map` key.
- Library modules build with `com.android.kotlin.multiplatform.library`; the sample Android app moved
  to `sample:androidApp` while `sample:composeApp` became a KMP library.
- Toolchain: Gradle 9.6.1, AGP 9.3.1, Kotlin 2.4.10, Compose Multiplatform 1.11.1, compileSdk 37,
  JVM target 11.

### Deprecated

- `LocationSimulator.speed`, following MapKit, which deprecates it on both platforms. Set
  `LocationSettings.speed` together with `LocationSettings.provideSpeed` on every
  `SimulationSettings` instead.

### Removed

- **Breaking.** The `iosX64` target: Compose Multiplatform no longer publishes for it.
- **Breaking.** `SizeChangeListener`, deprecated since 0.1.1 in favour of `SizeChangedListener`.
- **Breaking.** The deprecated `PolylineMapObject` style properties (`strokeWidth`, `gradientLength`,
  `outlineWidth`, `outlineColor`, `isInnerOutlineEnabled`, `turnRadius`, `dashLength`, `gapLength`,
  `dashOffset`, `arcApproximationStep`), replaced by `style`.
- **Breaking.** `location.FilteringMode`: it had no MapKit counterpart, no converters and no uses.
- The atomicfu Gradle plugin; only its locks runtime API was used.

### Fixed

- **iOS.** `InputListener` delivered a tap to `onMapLongTap` and a long tap to `onMapTap`.
- Compose: `YandexMap` calls `MapView.destroy()` when it leaves the composition, so the native map
  releases its resources instead of waiting for the finalizer.
- The cluster listener is retained by `ClusterNode` instead of being a factory local, so clustering
  keeps working after the factory is collected.
- Compose: `PolylineState` was never bound to its `PolylineMapObject`, so `select`, `hide`,
  `setStrokeColors`, `setPaletteColor`, `addArrow` and `arrows` did nothing or threw. Every state is
  now bound while its composable is in the composition.
- Compose: `Polyline` ignored a changed `outlineWidth`, which was applied when the map object was
  created and never again.
- Compose: removing a map object whose collection was removed first no longer touches an invalidated
  MapKit object.
- Compose: `PolygonState.Saver` computed the wrong offset past a restored ring, so restoring any
  polygon threw a `ClassCastException` — a `rememberPolygonState` did not survive a configuration
  change.
- **iOS.** `UIColor.toCommon()` read the channels through `CIColor`, which Objective-C refuses for a
  colour built by `Color.toNative()`: reading a colour back from the map raised
  `-CIColor not defined for the UIColor UIExtendedSRGBColorSpace`. It goes through
  `getRed(red:green:blue:alpha:)` now.
- **iOS.** `IconStyle.toNative()` hardcoded `anchor` and `tappableArea` to `null` and
  `toCommon()` never read `tappableArea` back, so both were silently dropped while Android carried
  them. `rotationType` went through `ordinal`, tying the declaration order of the common enum to the
  native raw values; it has proper converters now.
- **iOS.** `LayerIds.mapLayerId` returned `mapObjectsLayerId()`, so two different layer ids were the
  same string.
- **iOS.** The `StorageManager` size callbacks dropped the native error, making a failure
  indistinguishable from an empty result.
- **Android.** The `MapWindow.scaleFactor` setter assigned its own getter instead of the new value,
  so writing it did nothing.
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
