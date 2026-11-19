# Regression test coverage

This inventory uses the [public ABI dumps][abi] and test sources at [`c6049906`][snapshot].
The CI jobs below describe that baseline. The tables also link later [standalone consumer checks][consumer],
native gesture checks on [Android][a-map-taps-ci] and [iOS][i-map-taps-ci], and [listener lifecycle tests][71]. SDK surface and platform exclusions are listed in
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
| [`MapKit`, `MapView` and `MapWindow`](map.md) | Live windows expose size, focus, scale and projection. Screen and world conversion round-trips in [LiveMapWindowTest · Android][a-window] and [LiveMapWindowTest · iOS][i-window]. [NativeYandexMapLifecycleTest · Android Activity teardown][a-lifecycle] exercises the native view through Compose. [MapLifecycleTest · Android][a-host-lifecycle] covers stop/start, Activity recreation and native window invalidation. | See the Compose tests below for multiple live maps and modal input. |
| [`Map.move`, `CameraPosition`, gesture flags and `CameraListener`](map.md) | Programmatic moves update position and gesture flags round-trip in [LiveMapTest · Android][a-map] and [LiveMapTest · iOS][i-map]. [LiveCameraListenerDeliveryTest · iOS camera delivery][i-camera] observes a callback after a move. | Android camera callback delivery, gestures, animation interruption and Compose camera lifecycle [#69][69]. |
| [`InputListener`, `GeoObjectTapListener`, `MapLoadedListener` and map metadata](geoobjects.md) | Listener registration, removal or clearing in [Android][a-map] and [iOS][i-map]. [NativeBackedConverterTest · Android][a-native] and [NativeBackedConverterTest · iOS][i-native] pin representative attribution, image, tile and text conversions. Native input tests on [Android][a-map-taps] and [iOS][i-map-taps] verify tap and long-press delivery and coordinates through Compose. [LayerServiceAdapterTest · Android][a-layer-service-adapter] checks identity and both consumption results with an injected native POI event. | Trusted viewport checks with actual base-map POI taps on iOS, ready events and metadata mapping [#82][82]. |
| [`MapObjectCollection`, `PlacemarkMapObject` and other shapes](mapobjects.md) | Add, traverse, clear, callbacks, concrete subtypes and cluster collection creation in [LiveMapObjectCollectionTest · Android][a-collection] and [LiveMapObjectCollectionTest · iOS][i-collection]. Placemark geometry, styling, visibility and native identity in [LivePlacemarkMapObjectTest · Android][a-pin] and [LivePlacemarkMapObjectTest · iOS][i-pin]. | Object drag gestures. |
| [`ImageProvider` and `AnimatedImageProvider`](image-resources.md) | [LivePlacemarkMapObjectTest · Android][a-pin] and [LivePlacemarkMapObjectTest · iOS][i-pin] check that `useIcon()`, `useModel()` and `useAnimation()` return valid native handles. | Decode an icon through a platform factory and apply it to a live object. Exercise `AnimatedImageProvider.fromByteArray`, `fromFile` and `fromAnimatedImage`, playback on a placemark and animated polygon patterns [#84][84]. |
| [`toNative()`, `toCommon()`, `WeakRef` and listener factories](overview.md) | Stable native adapter identity and weak unwrapping in [LiveListenerIdentityTest · Android][a-listener] and [LiveListenerIdentityTest · iOS][i-listener]. Handle equality in [HandleIdentityTest · Android host][a-identity] and [HandleIdentityTest · iOS][i-identity]. [ListenerOwnershipTest · Android emulator][a-listener-ownership] and [MapInteractionTests · iOS simulator][i-listener-ownership] check delivery after a GC probe, unsubscribe with the retired listener held alive, and cancellation of callback work across a fresh map mount [#71][71]. | — |
| `Point`, `Polyline`, `IconStyle`, durations, structs and enums | Field order, units and enum mappings in [Android host][a-converters] and [iOS][i-converters]. Native geometry and nullable style fields have additional checks in [PolylineConverterTest · Android][a-geometry]/[IconStyleConverterTest · style][a-style] and [GeometryConverterTest · iOS][i-geometry]/[IconStyleConverterTest · style][i-style]. | Extend round-trip checks alongside new entry points [#86][86] and track edition-specific parity [#81][81]. |
| [`MapKit.createUserLocationLayer`, `LocationManager` and location simulation](location.md) | Visibility, heading, anchors, listener adapters and no-fix camera state in [LiveUserLocationLayerTest · Android][a-location] and [LiveUserLocationLayerTest · iOS][i-location]. | Injected location delivery, rotation and moving a single Compose map to a known fix [#69][69]. |
| [`Map.addTileLayer`, `addMapObjectLayer`, `Logo`, indoor state and overlays](layers.md) | An independent object collection, map styles, indoor flags and reachable logo/projection handles in [Android][a-map] and [iOS][i-map]. [LiveTileLayerTest · Android][a-layer-tile-live] and [iOS][i-layer-tile-live] exercise native layer activation, style and removal. [TileLayerContractTest · Android][a-layer-tile-contract] and [iOS][i-layer-tile-contract] exercise local PNG bytes, request metadata, cache directives and tile states. The Android test injects data-source and loaded callbacks after listener replacement. The live iOS layer installs, replaces and clears both listener adapters. | Renderer-driven iOS callback delivery and disposal with an in-flight tile request [#85][85]. Indoor transitions and rendered overlays [#83][83]. |
| [`TrafficLayer`, `StorageManager` and `OfflineCacheManager`](offline.md) | `TrafficColor` and `RegionState` convert in both directions in [EnumConverterTest · Android host][a-enums] and [EnumConverterTest · iOS][i-enums]. [LayerServiceAdapterTest · Android][a-layer-service-adapter] and [iOS][i-layer-service-adapter] exercise traffic loading, unknown data and expiration, and forward region state and progress. [StorageManagerContractTest · Android][a-storage-contract] checks deferred results, 64-bit and nullable sizes, and typed errors with a recording endpoint. [StorageManagerContractTest · iOS][i-storage-contract] checks the real byte-count callback and error-listener registration. Cache clearing and limit changes use the Android recording endpoint. | Real traffic, licensed region downloads and actual disk faults in trusted scheduled runs [#82][82]. Cold and warm cache timings [#74][74]. |
| [`Logging`, `I18nManager` and runtime failures](runtime.md) | Log level, filtering, delivery and unsubscribe in [LiveLoggingTest · Android][a-logs] and [LiveLoggingTest · iOS][i-logs]. Locale preferences and enum conversion in [Android host][a-converters] and [iOS][i-converters]. | Real formatting output and runtime error callbacks from controlled providers [#85][85]. |

## Compose and resources

| Public entry point | Verified behavior, tests and platforms | Follow-up |
| --- | --- | --- |
| [`YandexMap(controller = …)`, `YandexMapController` and `MapControllerEffect`](../compose/overview.md) | [NativeYandexMapLifecycleTest · Android emulator][a-lifecycle] mounts the controller overload, asserts that `controller.mapWindow` becomes available and finishes the Activity with the map still in composition. [MapInteractionTest · Android][a-reopen] and [MapInteractionTests · iOS][i-reopen] exercise real taps after mounting and reopening the map [#66][66]. [Android][a-reopen-ci] and [iOS][i-reopen-ci] passed. [MapLifecycleTest · Android][a-host-lifecycle] and [MapLifecycleTests · iOS][i-host-lifecycle] cover overlay input, foreground transitions, repeated removal during camera animation, and camera and selection restoration when the host is recreated. Both assert the exact attachment and input trace. [Android emulator][a-host-ci] · [iOS simulator][i-host-ci]. [Nav3MapTest · Android][a-nav3] and [Nav3MapTests · iOS][i-nav3] verify native taps through navigation, independent camera and selection state across two stacks, and reset after an entry is popped [#72][72]. Android covers system Back and Activity recreation. iOS covers cancelled and completed back gestures. [Android emulator][a-nav3-ci] · [iOS simulator][i-nav3-ci]. The Decompose device tests `DecomposeStackTest` (Android) and `DecomposeStackTests` (iOS) compare native camera and marker restoration and verify input ownership while both map windows remain attached [#73][73]. | — |
| [Controller-backed maps under a modal sheet and in a split layout](../compose/overview.md) | [MapPanesTest · Android][a-panes] and [MapInteractionTests · iOS][i-panes] check modal input routing, the untouched pane's camera after each move, and callback identity against the originating native map. They check the resized projection with padding and a focus rectangle, then tap the surviving pane after removing its neighbor. [Android emulator][a-panes-ci] · [iOS simulator][i-panes-ci]. | — |
| [Declarative `YandexMap`, `MapEffect`, `MapConfig` and `MapListeners`](../compose/overview.md) | The [Android][a-consumer] and [iOS][i-consumer] consumer apps mount declarative `YandexMap` and create a valid native placemark in `MapEffect`. The core [Android][a-map] and [iOS][i-map] tests exercise native settings and listener adapters. [MapInteractionTest · Android emulator][a-map-taps] checks listener registration on recomposition, replacement, removal and reattachment. [MapInteractionTests · iOS XCTest][i-map-taps] checks the same callbacks. The [Android][a-map-taps-ci] and [iOS][i-map-taps-ci] runs passed [#67][67]. | Check config and effect updates and cancellation [#69][69]. |
| [`Placemark`, `Polyline`, `Polygon`, `Circle`, `MapObjectCollection` and `Clustering`](../compose/mapobjects.md) | [MapNodeInsertOrderTest · Node insert order][map-order] is checked in the Android host, Android emulator and iOS simulator suites. [MapObjectStatesRestorationTest · Android state restoration][a-savers] exercises save/restore; [MapObjectStateSaversTest · iOS saver tests][i-savers] exercise round-trips for shapes and camera state. [Android native input][a-map-taps] verifies hit order for an overlapping placemark and polygon, visibility changes and propagation through their parent collection. [MapObjectMembershipTest · Android emulator][a-membership] and [MapObjectMembershipTests · iOS XCTest][i-membership] add cases for keyed geometry, visibility, partial removal after reordering and cluster taps across zoom and data changes. Device results are pending [#68][68]. | Restore live objects and camera state when returning to a map screen [#75][75]. |
| [`YandexMap` with `UserLocationState`, `TrafficLayer`, `TileLayer` and `MapObjectLayer`](../compose/overview.md) | Closest runtime evidence comes from the core layer and location tests above. Compose updates and disposal remain gaps. | Simulated location plus camera [#69][69], layer replacement and callbacks [#85][85]. |
| [`ImageBitmap.toImageProvider()` and `imageProvider { … }`](../compose/image-resources.md) | [ComposeMapObjectRendererTest · Compose renderer][renderer] runs on the Android emulator and iOS simulator, covering a rendered frame and rerender on state change. [ComposeMapObjectRendererIosTest · iOS renderer sizing][i-renderer] checks intrinsic size and scale. [ColorConvertionTest · Color conversion][color] checks ARGB in the shared test suites. | Real marker/cluster installation, anchors, replacements and cancellation [#84][84]. |
| [`imageProvider(DrawableResource)`](../compose/image-resources.md#compose-multiplatform-resources) in `-compose-resources` | The [public ABI][api] includes the optional entry point. The [#61 merge][split] moves the resource dependency to that module. The [Android][a-consumer] and [iOS][i-consumer] standalone apps load a PNG through the optional module and set it on a valid native placemark. | Check rendering, anchor behavior, replacement and cluster images [#84][84]. |
| [`MOKOImageLoader.fromResource` and `rememberMOKOImageLoader`](image-resources.md) in `-moko` and `-moko-compose` | The [public ABI][api] covers both modules. Dedicated runtime tests for decoding a Moko asset, the cache flag and retaining the Compose loader remain gaps. | Optional image integrations [#84][84]. |
| [Installing the published modules](../getting-started/installation.md) | The [#76 fixture][consumer] resolves candidate artifacts from a temporary Maven repository in an isolated [Android][a-consumer] and [iOS][i-consumer] app. The jobs check the selected Lite SDK, build and launch the apps, and wait for a native map and placemark. | Release and OS matrix [#82][82]. |

The [Return to map sample](../sample.md#return-to-map) has a dedicated Android
[ReturnMapRoutesTest][a-return-routes] for opening details, switching tabs, save/restore, final
route removal and marker edits. It substitutes a small UI for the native map. Device runs of the
sample and same-viewport timings are tracked in [#75][75] and [#74][74].

## Reported regressions

| Report | Verified behavior and evidence | Next coverage |
| --- | --- | --- |
| [#20][20] User taps the map | Core listener registration and removal in [Android][a-map] and [iOS][i-map]. The [Android][a-map-taps] and [iOS][i-map-taps] native-input tests inject a tap and a long press and check their callbacks and coordinates. | Base-map POI events [#85][85]. |
| [#32][32] Move to the user's location on one map | [Sample][location-sample] animates the same map; core layer tests exercise the no-fix state. | Inject a location and assert the camera completes its move [#69][69]. |
| [#33][33] iOS cinterop fails in a consumer | [Installation guide](../getting-started/installation.md) describes CocoaPods and linker setup. The [iOS consumer][i-consumer] installs the Lite pod, runs cinterop, links the app and launches it with candidate Maven artifacts. | Run the consumer across the release and OS matrix [#82][82]. |
| [#34][34] Missing iOS camera callback | [LiveCameraListenerDeliveryTest][i-camera] uses a live map and a retained listener to observe the effect of `move`. | Gesture and Compose delivery [#69][69]. |
| [#42][42] Base Compose module pulls in Compose Resources | [#61][split] moves the overload to the optional module and the [ABI check][api] covers the exposed overload. The [Android][a-consumer] and [iOS][i-consumer] consumers resolve the optional artifact and set a PNG on a placemark. | Cover rendering and updates on markers and clusters [#84][84]. |
| [#55][55] Crash when closing a Compose map | [NativeYandexMapLifecycleTest][a-lifecycle] initializes MapKit, creates the map and finishes the Activity. The [Android][a-host-lifecycle] and [iOS][i-host-lifecycle] lifecycle scenarios remove the map repeatedly during an animation and require one detach per old attachment. Android also verifies that released windows are invalid. | Navigation back-stack transitions [#72][72], [#73][73]. |

## Full search

[Android and iOS adapter tests](full-text-search.md#regression-checks) cover request options,
named coordinates, an empty result, a native error and callbacks after cancellation.
The Full consumer instantiates the native manager as part of the edition checks in [#77][77].

[SuggestAdapterTest · Android host][a-suggest] and [SuggestAdapterTest · iOS simulator][i-suggest]
cover [suggestions and reset](full-text-search.md#suggestions-while-typing), including options,
result fields, request replacement, reset through a native alias and late responses. The Full
consumer creates and resets a native suggestion session. [#82][82] tracks live response checks.

The remaining Full surface is tracked in [#81][81]. Use the [regression workflow](../getting-started/contributing.md#regressions)
when adding evidence or reporting a remaining gap.

[a-map-taps]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/a4cad8e0063f4ac78f945c4c626346e6fb0ead2d/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapInteractionTest.kt#L72
[i-map-taps]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/b8a9958310dd34265f11312c87031ab221a79498/tests/map-interaction/iosApp/MapInteractionTests.swift#L29
[a-map-taps-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44435197621/job/135262196868
[a-layer-tile-live]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/LiveTileLayerTest.kt
[i-layer-tile-live]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/LiveTileLayerTest.kt
[a-layer-tile-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/TileLayerContractTest.kt
[i-layer-tile-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/TileLayerContractTest.kt
[a-layer-service-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/LayerServiceAdapterTest.kt
[i-layer-service-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/LayerServiceAdapterTest.kt
[a-storage-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/storage/StorageManagerContractTest.kt
[i-storage-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/storage/StorageManagerContractTest.kt
[a-enums]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit/EnumConverterTest.kt#L206-L238
[a-return-routes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/49449ba1394c264ca50748667faf7a95cc42e560/sample/composeApp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/sample/ReturnMapRoutesTest.kt#L28-L97
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
[a-panes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/89968e2ae59cf062389c850b4c0e52b8eb9a1950/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapPanesTest.kt
[i-panes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/89968e2ae59cf062389c850b4c0e52b8eb9a1950/tests/map-interaction/iosApp/MapInteractionTests.swift#L188
[a-panes-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44551345975/job/135655604518
[i-panes-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44551345975/job/135655604326
[a-reopen]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/2dd192398ebafa1bc02f98fb6649237ef09f6649/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapInteractionTest.kt#L25
[i-reopen]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/2dd192398ebafa1bc02f98fb6649237ef09f6649/tests/map-interaction/iosApp/MapInteractionTests.swift#L4
[a-reopen-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44429584892/job/135243201327
[i-reopen-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44429584892/job/135243201431
[i-map-taps-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44440201914/job/135278848866
[a-host-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/69960e03a1efc1a6762bdeede715efc7ec9d783a/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapLifecycleTest.kt
[i-host-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/69960e03a1efc1a6762bdeede715efc7ec9d783a/tests/map-interaction/iosApp/MapLifecycleTests.swift
[a-host-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44433760924/job/135257507625
[i-host-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44433760924/job/135257508055
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
[a-listener-ownership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/ListenerOwnershipTest.kt
[i-listener-ownership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/tests/map-interaction/iosApp/MapInteractionTests.swift
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
[a-membership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/ddd37f2fe7a0b210e98050393e474cf206eebbca/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapObjectMembershipTest.kt#L33
[i-membership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/ddd37f2fe7a0b210e98050393e474cf206eebbca/tests/map-interaction/iosApp/MapInteractionTests.swift#L141
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
[a-suggest]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidHostTest/kotlin/ru/sulgik/mapkit/search/SuggestAdapterTest.kt
[i-suggest]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/search/SuggestAdapterTest.kt

[a-nav3]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/4adbf6cc0e960b89767ca5cef163f28b0d305960/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/Nav3MapTest.kt
[i-nav3]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/4adbf6cc0e960b89767ca5cef163f28b0d305960/tests/map-interaction/iosApp/Nav3MapTests.swift
[a-nav3-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44542390742/job/135623893971
[i-nav3-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44542390742/job/135623894416
