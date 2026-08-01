# Overview

[![Kotlin](https://img.shields.io/badge/kotlin-{{ kotlin_version }}-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v{{ compose_version }}-blue)](https://github.com/JetBrains/compose-multiplatform)
[![Maven Central](https://img.shields.io/maven-central/v/ru.sulgik.mapkit/yandex-mapkit-kmp?color=blue)](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)
[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/LICENSE)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat&color=blue)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat&color=blue)

A Kotlin-first SDK for Yandex MapKit. The API reads like MapKit's own, but lives in common code, so
one implementation of your map logic serves both Android and iOS — with optional rendering through
Compose Multiplatform.

!!! info "This is not a Yandex project"
    The author has no connection with the original SDK; this is a wrapper over the official
    [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/). Yandex's own documentation stays useful
    here, because the wrapper keeps MapKit's package, type and member names.

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f)
    }
    YandexMap(cameraPositionState = cameraPositionState, modifier = Modifier.fillMaxSize()) {
        Placemark(
            state = rememberPlacemarkState(Point(55.751225, 37.629540)),
            icon = imageProvider(Res.drawable.pin_red),
        )
    }
}
```

## What is covered

The wrapper targets the **lite** build of MapKit `{{ mapkit_version }}`, and everything the lite
build exposes on both platforms is reachable from common code:

- the map itself — `MapKit`, `MapView`, `MapWindow`, `Map`, `CameraPosition`, `VisibleRegion`,
  `CameraBounds`, `Logo`, map styles, indoor plans;
- map objects — placemarks, polylines, polygons, circles, collections, clustering, and the
  presentation objects (`Icon`, `CompositeIcon`, `Model`, `PlacemarkAnimation`, `PlacemarkText`);
- base map objects — `GeoObject` and its metadata, behind a tap on a POI, a building or a toponym;
- geolocation — `LocationManager`, `UserLocationLayer`, the location simulator and the dummy manager;
- layers — custom tile layers, map object layers, traffic;
- storage and offline maps — `StorageManager`, `OfflineCacheManager`;
- runtime — the `Error` hierarchy, logging and `I18nManager`;
- `ImageProvider` and `AnimatedImageProvider`, with adapters for Compose Multiplatform resources and
  [moko-resources](https://github.com/icerockdev/moko-resources).

[What is wrapped](wrapper/coverage.md) maps every package out, including the handful of members
deliberately left out.

The **full** build of MapKit — search, routing, panoramas, road events, personalization — is not
wrapped, because those types do not exist in the lite SDK.

## Two ways to draw a map

=== "Compose Multiplatform"

    `yandex-mapkit-kmp-compose` renders the map and its objects from common code. Map objects are a
    composition of their own, so `Placemark`, `Polyline`, `Polygon`, `Circle`, `Clustering`,
    `TileLayer` and `TrafficLayer` are composables that add themselves to the map and remove
    themselves when they leave the composition.

    [Compose overview](compose/overview.md)

=== "Platform views"

    `yandex-mapkit-kmp` alone draws nothing. Create a `MapView` the way the official SDK does it,
    convert it with `toCommon()` and hand the result to common code, which then drives the map
    through the wrapper API.

    [Wrapper overview](wrapper/overview.md)

## Mission

- Write map logic once, in common code.
- Keep the original API. `com.yandex.mapkit.map.Map` becomes `ru.sulgik.mapkit.map.Map`, and the
  [official documentation](https://yandex.ru/dev/mapkit/doc/) keeps applying.
- Make it Kotlin: `Duration` and `Instant` instead of raw numbers, nullability instead of sentinel
  values, `data class`es for value types, lambdas for listeners.
- Support multiplatform resources — Compose Multiplatform resources and
  [moko-resources](https://github.com/icerockdev/moko-resources).

!!! warning "Before 1.0.0"
    This is one author's library, published for the community rather than backed by a team. The API
    is still being shaped and can change between minor versions; see
    [Compatibility](getting-started/contributing.md#compatibility) for what is and is not promised.

## Author

- [@SuLG-ik](https://github.com/SuLG-ik) — main developer. Telegram:
  [@vollllodya](https://t.me/vollllodya)
