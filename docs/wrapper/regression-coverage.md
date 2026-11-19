# Regression test coverage

This inventory uses the [public ABI dumps][abi] and test sources at [`c6049906`][snapshot].
The CI jobs below describe that baseline. Later [standalone consumer coverage][consumer] is
linked separately in the tables. SDK surface and platform exclusions are listed in
[What is wrapped](coverage.md).

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
| [`ImageProvider` and `AnimatedImageProvider`](image-resources.md) | [LivePlacemarkMapObjectTest · Android][a-pin] and [LivePlacemarkMapObjectTest · iOS][i-pin] check that `useIcon()`, `useModel()` and `useAnimation()` return valid native handles. | Decode an icon through a platform factory and apply it to a live object. Exercise `AnimatedImageProvider.fromByteArray`, `fromFile` and `fromAnimatedImage`, playback on a placemark and animated polygon patterns [#84][84]. |
| [`toNative()`, `toCommon()`, `WeakRef` and listener factories](overview.md) | Stable native adapter identity and weak unwrapping in [LiveListenerIdentityTest · Android][a-listener] and [LiveListenerIdentityTest · iOS][i-listener]. Handle equality in [HandleIdentityTest · Android host][a-identity] and [HandleIdentityTest · iOS][i-identity]. | Listener retention, release and cancellation across map remounts [#71][71]. |
| `Point`, `Polyline`, `IconStyle`, durations, structs and enums | Field order, units and enum mappings in [Android host][a-converters] and [iOS][i-converters]. Native geometry and nullable style fields have additional checks in [PolylineConverterTest · Android][a-geometry]/[IconStyleConverterTest · style][a-style] and [GeometryConverterTest · iOS][i-geometry]/[IconStyleConverterTest · style][i-style]. | Extend round-trip checks alongside new entry points [#86][86] and track edition-specific parity [#81][81]. |
| [`MapKit.createUserLocationLayer`, `LocationManager` and location simulation](location.md) | Visibility, heading, anchors, listener adapters and no-fix camera state in [LiveUserLocationLayerTest · Android][a-location] and [LiveUserLocationLayerTest · iOS][i-location]. | Injected location delivery, rotation and moving a single Compose map to a known fix [#69][69]. |
| [`Map.addTileLayer`, `addMapObjectLayer`, `Logo`, indoor state and overlays](layers.md) | An independent object collection, map styles, indoor flags and reachable logo/projection handles in [Android][a-map] and [iOS][i-map]. | Controlled tile providers, style and loaded callbacks, indoor state transitions and rendered overlays [#85][85], [#83][83]. |
| [`TrafficLayer`, `StorageManager` and `OfflineCacheManager`](offline.md) | `TrafficColor` and `RegionState` convert in both directions in [EnumConverterTest · Android host][a-enums] and [EnumConverterTest · iOS][i-enums]. Service requests and storage lifecycle remain gaps. | Traffic, region lifecycle and cache errors [#85][85]. Cold/warm cache and isolated release scenarios [#74][74], [#82][82]. |
| [`Logging`, `I18nManager` and runtime failures](runtime.md) | Log level, filtering, delivery and unsubscribe in [LiveLoggingTest · Android][a-logs] and [LiveLoggingTest · iOS][i-logs]. Locale preferences and enum conversion in [Android host][a-converters] and [iOS][i-converters]. | Real formatting output and runtime error callbacks from controlled providers [#85][85]. |

## Compose and resources

| Public entry point | Verified behavior, tests and platforms | Follow-up |
| --- | --- | --- |
| [`YandexMap(controller = …)`, `YandexMapController` and `MapControllerEffect`](../compose/overview.md) | [NativeYandexMapLifecycleTest · Android emulator][a-lifecycle] mounts the controller overload, asserts that `controller.mapWindow` becomes available and finishes the Activity with the map still in composition. | Native taps on a reopened controller-backed map [#66][66]. Effect start once a window is available, cancellation on disposal, and clearing the window on detach [#70][70]. |
| [Declarative `YandexMap`, `MapEffect`, `MapConfig` and `MapListeners`](../compose/overview.md) | The [Android][a-consumer] and [iOS][i-consumer] consumer apps mount declarative `YandexMap` and create a valid native placemark in `MapEffect`. The core [Android][a-map] and [iOS][i-map] tests exercise native settings and listener adapters. | Check config and effect updates and cancellation in a declarative map [#69][69], [#70][70]. Route real taps through Compose [#67][67] and exercise back-stack transitions [#72][72], [#73][73]. |
| [`Placemark`, `Polyline`, `Polygon`, `Circle`, `MapObjectCollection` and `Clustering`](../compose/mapobjects.md) | [MapNodeInsertOrderTest · Node insert order][map-order] is checked in the Android host, Android emulator and iOS simulator suites. [MapObjectStatesRestorationTest · Android state restoration][a-savers] exercises save/restore; [MapObjectStateSaversTest · iOS saver tests][i-savers] exercise round-trips for shapes and camera state. | Native object membership, visibility and handler replacement [#68][68]. State preservation after returning to a map [#75][75]. |
| [`YandexMap` with `UserLocationState`, `TrafficLayer`, `TileLayer` and `MapObjectLayer`](../compose/overview.md) | Closest runtime evidence comes from the core layer and location tests above. Compose updates and disposal remain gaps. | Simulated location plus camera [#69][69], layer replacement and callbacks [#85][85]. |
| [`ImageBitmap.toImageProvider()` and `imageProvider { … }`](../compose/image-resources.md) | [ComposeMapObjectRendererTest · Compose renderer][renderer] covers frames and updates. [ComposeMapObjectRendererIosTest · iOS renderer sizing][i-renderer] checks intrinsic size and scale. [ColorConvertionTest · Color conversion][color] checks ARGB. [MapIconRenderingTest · Android][a-icon-rendering] and [MapIconRenderingTests · iOS][i-icon-rendering] sample rendered icons on a placemark and a cluster. They check both anchor axes, transparency, density and content size independently, visibility, and late Coil results. | Platform file factories and native animated images remain separate tests. |
| [`imageProvider(DrawableResource)`](../compose/image-resources.md#compose-multiplatform-resources) in `-compose-resources` | The [public ABI][api] includes the optional entry point. The [#61 merge][split] moves the resource dependency to that module. The [Android][a-consumer] and [iOS][i-consumer] standalone apps load a PNG through the optional module and set it on a valid native placemark. | Monitor the packaged consumer on the release and OS matrix [#82][82]. |
| [`MOKOImageLoader.fromResource` and `rememberMOKOImageLoader`](image-resources.md) in `-moko` and `-moko-compose` | The [public ABI][api] covers both modules. Dedicated runtime tests for decoding a Moko asset, the cache flag and retaining the Compose loader remain gaps. | Optional image integrations [#84][84]. |
| [Installing the published modules](../getting-started/installation.md) | The [#76 fixture][consumer] resolves candidate artifacts from a temporary Maven repository in an isolated [Android][a-consumer] and [iOS][i-consumer] app. The jobs check the selected Lite SDK, build and launch the apps, and wait for a native map and placemark. | Release and OS matrix [#82][82]. |

## Reported regressions

| Report | Verified behavior and evidence | Next coverage |
| --- | --- | --- |
| [#19][19] An asynchronously loaded Coil image fails to appear | The [Android][a-icon-rendering] and [iOS][i-icon-rendering] tests restart the same model after a controlled failure and wait for Coil's terminal callbacks before checking late results on the map. | HTTP, decoding and the app’s own cache policy remain separate. |
| [#20][20] User taps the map | Core listener registration and removal in [Android][a-map] and [iOS][i-map]. | Inject real touch into a mounted map [#66][66], [#67][67]. |
| [#32][32] Move to the user's location on one map | [Sample][location-sample] animates the same map; core layer tests exercise the no-fix state. | Inject a location and assert the camera completes its move [#69][69]. |
| [#33][33] iOS cinterop fails in a consumer | [Installation guide](../getting-started/installation.md) describes CocoaPods and linker setup. The [iOS consumer][i-consumer] installs the Lite pod, runs cinterop, links the app and launches it with candidate Maven artifacts. | Run the consumer across the release and OS matrix [#82][82]. |
| [#34][34] Missing iOS camera callback | [LiveCameraListenerDeliveryTest][i-camera] uses a live map and a retained listener to observe the effect of `move`. | Gesture and Compose delivery [#69][69]. |
| [#42][42] Base Compose module pulls in Compose Resources | [#61][split] moves the overload to the optional module and the [ABI check][api] covers the exposed overload. The [Android][a-consumer] and [iOS][i-consumer] consumers resolve the optional artifact and set a PNG on a placemark. | Cover rendering and updates on markers and clusters [#84][84]. |
| [#55][55] Crash when closing a Compose map | [NativeYandexMapLifecycleTest][a-lifecycle] initializes MapKit, creates the map and finishes the Activity. | Hide/show, recreation and repeated teardown [#70][70]. |

The [API exclusions](coverage.md) also apply to the test matrix. Search, routing and other Full-only
families have no Lite runtime contract. Separate edition resolution is tracked in [#77][77], and the
remaining Full surface in [#81][81]. Use the [regression workflow](../getting-started/contributing.md#regressions)
when adding evidence or reporting a remaining gap.

[a-enums]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit/EnumConverterTest.kt#L206-L238
[i-enums]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/EnumConverterTest.kt#L194-L226
[consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/pull/88
[a-consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44408195495/job/135169172609
[i-consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44408195495/job/135169172544
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
[a-icon-rendering]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/23278703bace568eca5e63007f081e7686484c93/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapIconRenderingTest.kt
[i-icon-rendering]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/23278703bace568eca5e63007f081e7686484c93/tests/map-interaction/iosApp/MapIconRenderingTests.swift
[color]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/ColorConvertionTest.kt
[19]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/19
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
[77]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/77
[81]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/81
[82]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/82
[83]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/83
[84]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/84
[85]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/85
[86]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/86
