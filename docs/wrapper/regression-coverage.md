# Regression test coverage

This inventory uses the [public ABI dumps][abi] and test sources at [`c6049906`][snapshot].
It records the observable behavior each test exercises. SDK surface and platform exclusions are
listed in [What is wrapped](coverage.md).

| Platform | CI job and task |
| --- | --- |
| **Android host** | [Tests (Android)][android-host] runs `libraryAssemble libraryTests -PskipIosTarget=true`, including JVM converter and Compose unit tests. |
| **Android emulator** | [Tests (Android emulator)][android-device] runs core and Compose `connectedAndroidDeviceTest` on API 30. |
| **iOS simulator** | [Tests (iOS)][ios] runs `libraryIosTests` on the arm64 simulator. The same job compiles the iOS device target and links its Objective-C frameworks. |
| **Public ABI** | [Public API][api] runs `libraryApiCheck` against the Android and Kotlin ABI dumps of all five published modules. |

## Core wrapper

| Public entry point | Verified behavior, tests and platforms | Follow-up |
| --- | --- | --- |
| [`MapKit`, `MapView` and `MapWindow`](map.md) | Live windows expose size, focus, scale and projection. Screen and world conversion round-trips in [LiveMapWindowTest · Android][a-window] and [LiveMapWindowTest · iOS][i-window]. [NativeYandexMapLifecycleTest · Android Activity teardown][a-lifecycle] exercises the native view through Compose. | MapKit lifecycle through host recreation and repeated stop/start [#70][70]. Multiple live maps and overlay layout [#83][83]. |
| [`Map.move`, `CameraPosition`, gesture flags and `CameraListener`](map.md) | Programmatic moves update position and gesture flags round-trip in [LiveMapTest · Android][a-map] and [LiveMapTest · iOS][i-map]. [LiveCameraListenerDeliveryTest · iOS camera delivery][i-camera] observes a callback after a move. | Android camera callback delivery, gestures, animation interruption and Compose camera lifecycle [#69][69]. |
| [`InputListener`, `GeoObjectTapListener`, `MapLoadedListener` and map metadata](geoobjects.md) | Listener registration, removal or clearing in [Android][a-map] and [iOS][i-map]. [NativeBackedConverterTest · Android][a-native] and [NativeBackedConverterTest · iOS][i-native] pin representative attribution, image, tile and text conversions. | Native touch and hit testing [#66][66], [#67][67]. Base-map POI events, map-ready delivery and metadata mapping with controlled inputs [#85][85]. |
| [`MapObjectCollection`, `PlacemarkMapObject` and other shapes](mapobjects.md) | Add, traverse, clear, callbacks, concrete subtypes and cluster collection creation in [LiveMapObjectCollectionTest · Android][a-collection] and [LiveMapObjectCollectionTest · iOS][i-collection]. Placemark geometry, styling, visibility and native identity in [LivePlacemarkMapObjectTest · Android][a-pin] and [LivePlacemarkMapObjectTest · iOS][i-pin]. | Object and cluster updates, visibility, drag and hit testing [#67][67], [#68][68]. |
| [`toNative()`, `toCommon()`, `WeakRef` and listener factories](overview.md) | Stable native adapter identity and weak unwrapping in [LiveListenerIdentityTest · Android][a-listener] and [LiveListenerIdentityTest · iOS][i-listener]. Handle equality in [HandleIdentityTest · Android host][a-identity] and [HandleIdentityTest · iOS][i-identity]. | Listener retention, release and cancellation across map remounts [#71][71]. |
| `Point`, `Polyline`, `IconStyle`, durations, structs and enums | Field order, units and enum mappings in [Android host][a-converters] and [iOS][i-converters]. Native geometry and nullable style fields have additional checks in [PolylineConverterTest · Android][a-geometry]/[IconStyleConverterTest · style][a-style] and [GeometryConverterTest · iOS][i-geometry]/[IconStyleConverterTest · style][i-style]. | Extend round-trip checks alongside new entry points [#86][86] and track edition-specific parity [#81][81]. |
| [`MapKit.createUserLocationLayer`, `LocationManager` and location simulation](location.md) | Visibility, heading, anchors, listener adapters and no-fix camera state in [LiveUserLocationLayerTest · Android][a-location] and [LiveUserLocationLayerTest · iOS][i-location]. | Injected location delivery, rotation and moving a single Compose map to a known fix [#69][69]. |
| [`Map.addTileLayer`, `addMapObjectLayer`, `Logo`, indoor state and overlays](layers.md) | An independent object collection, map styles, indoor flags and reachable logo/projection handles in [Android][a-map] and [iOS][i-map]. | Controlled tile providers, style and loaded callbacks, indoor state transitions and rendered overlays [#85][85], [#83][83]. |
| [`TrafficLayer`, `StorageManager` and `OfflineCacheManager`](offline.md) | Traffic and region enums in representative [Android host][a-converters] and [iOS][i-converters] converter tests. Service requests and storage lifecycle remain gaps. | Traffic, region lifecycle and cache errors [#85][85]. Cold/warm cache and isolated release scenarios [#74][74], [#82][82]. |
| [`Logging`, `I18nManager` and runtime failures](runtime.md) | Log level, filtering, delivery and unsubscribe in [LiveLoggingTest · Android][a-logs] and [LiveLoggingTest · iOS][i-logs]. Locale preferences and enum conversion in [Android host][a-converters] and [iOS][i-converters]. | Real formatting output and runtime error callbacks from controlled providers [#85][85]. |

## Compose and resources

| Public entry point | Verified behavior, tests and platforms | Follow-up |
| --- | --- | --- |
| [`YandexMap`, `MapEffect`, `MapConfig` and `MapListeners`](../compose/overview.md) | [Android emulator][a-lifecycle] finishes an Activity with `YandexMap` in composition. The core [Android][a-map] and [iOS][i-map] tests cover the underlying settings and listener adapters. | Mounted native tap and reopen on both platforms [#66][66]. Compose routing of real taps [#67][67], teardown and remount [#70][70], back-stack transitions [#72][72], [#73][73]. |
| [`Placemark`, `Polyline`, `Polygon`, `Circle`, `MapObjectCollection` and `Clustering`](../compose/mapobjects.md) | [MapNodeInsertOrderTest · Node insert order][map-order] is checked in the Android host, Android emulator and iOS simulator suites. [MapObjectStatesRestorationTest · Android state restoration][a-savers] exercises save/restore; [MapObjectStateSaversTest · iOS saver tests][i-savers] exercise round-trips for shapes and camera state. | Native object membership, visibility and handler replacement [#68][68]. State preservation after returning to a map [#75][75]. |
| [`YandexMap` with `UserLocationState`, `TrafficLayer`, `TileLayer` and `MapObjectLayer`](../compose/overview.md) | Closest runtime evidence comes from the core layer and location tests above. Compose updates and disposal remain gaps. | Simulated location plus camera [#69][69], layer replacement and callbacks [#85][85]. |
| [`ImageBitmap.toImageProvider()` and `imageProvider { … }`](../compose/image-resources.md) | [ComposeMapObjectRendererTest · Compose renderer][renderer] runs on the Android emulator and iOS simulator, covering a rendered frame and rerender on state change. [ComposeMapObjectRendererIosTest · iOS renderer sizing][i-renderer] checks intrinsic size and scale. [ColorConvertionTest · Color conversion][color] checks ARGB in the shared test suites. | Real marker/cluster installation, anchors, replacements and cancellation [#84][84]. |
| [`imageProvider(DrawableResource)`](../compose/image-resources.md#compose-multiplatform-resources) in `-compose-resources` | The [public ABI][api] includes the optional entry point. The [#61 merge][split] moves the resource dependency to that module. A dedicated CI test that decodes a drawable and assigns it to a live pin remains a follow-up. | Published Android and iOS resource consumer [#76][76] and image behavior [#84][84]. |
| [`MOKOImageLoader.fromResource` and `rememberMOKOImageLoader`](image-resources.md) in `-moko` and `-moko-compose` | The [public ABI][api] covers both modules. Dedicated runtime tests for decoding a Moko asset, the cache flag and retaining the Compose loader remain gaps. | Optional image integrations [#84][84]. |
| [Installing the published modules](../getting-started/installation.md) | [iOS][ios] compiles and links library frameworks. [Android host][android-host] assembles the libraries. Separate consumer installation is a follow-up. | Build and launch an isolated Maven consumer [#76][76]. Release and OS matrix [#82][82]. |

## Reported regressions

| Report | Closest evidence in the baseline | Next coverage |
| --- | --- | --- |
| [#20][20] User taps the map | Core listener registration and removal in [Android][a-map] and [iOS][i-map]. | Inject real touch into a mounted map [#66][66], [#67][67]. |
| [#32][32] Move to the user's location on one map | [Sample][location-sample] animates the same map; core layer tests exercise the no-fix state. | Inject a location and assert the camera completes its move [#69][69]. |
| [#33][33] iOS cinterop fails in a consumer | [Installation guide](../getting-started/installation.md) describes CocoaPods and linker setup. [iOS CI][ios] links the library's own framework. | Install, link and launch a separate application from Maven artifacts [#76][76]. |
| [#34][34] Missing iOS camera callback | [LiveCameraListenerDeliveryTest][i-camera] uses a live map and a retained listener to observe the effect of `move`. | Gesture and Compose delivery [#69][69]. |
| [#42][42] Base Compose module pulls in Compose Resources | [Optional module split][split] and [ABI check][api] cover the exposed overload. | Verify published dependency resolution and the drawable in an app [#76][76], [#84][84]. |
| [#55][55] Crash when closing a Compose map | [NativeYandexMapLifecycleTest][a-lifecycle] initializes MapKit, creates the map and finishes the Activity. | Hide/show, recreation and repeated teardown [#70][70]. |

The [API exclusions](coverage.md) also apply to the test matrix. Search, routing and other Full-only
families have no Lite runtime contract. Separate edition resolution is tracked in [#77][77], and the
remaining Full surface in [#81][81]. Use the [regression workflow](../getting-started/contributing.md#regressions)
when adding evidence or reporting a remaining gap.

[abi]: ../getting-started/contributing.md#public-api
[snapshot]: https://github.com/SuLG-ik/yandex-mapkit-kmp/commit/c60499064c8a42531a3fcf344d3c0a40a6a38cd6
[android-host]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693889
[android-device]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693535
[ios]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693602
[api]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693728
[a-converters]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit
[i-converters]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit
[split]: https://github.com/SuLG-ik/yandex-mapkit-kmp/pull/61
[location-sample]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/sample/composeApp/src/commonMain/kotlin/ru/sulgik/mapkit/sample/NewMap.kt#L148
[a-window]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapWindowTest.kt
[i-window]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapWindowTest.kt
[a-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/NativeYandexMapLifecycleTest.kt
[a-map]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapTest.kt
[i-map]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapTest.kt
[i-camera]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveCameraListenerDeliveryTest.kt
[a-native]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/NativeBackedConverterTest.kt
[i-native]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/NativeBackedConverterTest.kt
[a-collection]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapObjectCollectionTest.kt
[i-collection]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapObjectCollectionTest.kt
[a-pin]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LivePlacemarkMapObjectTest.kt
[i-pin]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LivePlacemarkMapObjectTest.kt
[a-listener]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/LiveListenerIdentityTest.kt
[i-listener]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/LiveListenerIdentityTest.kt
[a-identity]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit/HandleIdentityTest.kt
[i-identity]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/HandleIdentityTest.kt
[a-geometry]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/geometry/PolylineConverterTest.kt
[i-geometry]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/geometry/GeometryConverterTest.kt
[a-style]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/IconStyleConverterTest.kt
[i-style]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/IconStyleConverterTest.kt
[a-location]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/user_location/LiveUserLocationLayerTest.kt
[i-location]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/user_location/LiveUserLocationLayerTest.kt
[a-logs]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/runtime/logging/LiveLoggingTest.kt
[i-logs]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/runtime/logging/LiveLoggingTest.kt
[map-order]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/MapNodeInsertOrderTest.kt
[a-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/MapObjectStatesRestorationTest.kt
[i-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/MapObjectStateSaversTest.kt
[renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererTest.kt
[i-renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererIosTest.kt
[color]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/ColorConvertionTest.kt
[20]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/20
[32]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/32
[33]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/33
[34]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/34
[42]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/42
[55]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/55
[66]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/66
[67]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/67
[68]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/68
[69]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/69
[70]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/70
[71]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/71
[72]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/72
[73]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/73
[74]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74
[75]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/75
[76]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/76
[77]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/77
[81]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/81
[82]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/82
[83]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/83
[84]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/84
[85]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/85
[86]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/86
