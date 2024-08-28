# Overview

!!! warning "Experimental library"
    This library is author's development for usage in self projects that he published for open source 
    community. It is not production-ready solution. It is ready for your experiments and 
    contribution. Don't think that everything works fine, it was not tested as well

## What is Yandex MapKit KMP project?

[![Kotlin](https://img.shields.io/badge/kotlin-2.0.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.6.11-blue)](https://github.com/JetBrains/compose-multiplatform)
[![Maven Central](https://img.shields.io/maven-central/v/ru.sulgik.mapkit/yandex-mapkit-kmp?color=blue)](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)
[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/LICENSE)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat&color=blue)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat&color=blue)

Kotlin-first SDK for Yandex MapKit. It's API is similar to the Yandex MapKit SDK but also supports
multiplatform projects and compose multiplaform, enabling you to use MapKit directly from your
common source targeting iOS or Android.

!!! info
    It is not Yandex's project. Author has no connection with original SDK, it is wrapper
    above official Yandex MapKit SDK. Official YMK documentation page: https://yandex.ru/dev/mapkit/doc/

## API coverage ![60%](https://img.shields.io/badge/-60%25-green?style=flat-square)

- Yandex MapKit lite version
    - `MapKit`, `MapView`, `MapWindow`, `Map`, `MapObject`s, `Geometry`s, `Logo`, `CameraPosition` and etc
    - `LocationManager` and `UserLocationLayer`
    - Different event listeners and callbacks
    - `ImageProvider`
- Composable `YandexMap`
    - Drawing `MapView` using Compose Multiplatform
    - Control Camera Position
    - Compose nodes based drawing map objects like composable functions `Placemark`, `Circle`, `Polygon`, `Polyline`
    - Experimental compose content as `Placemark`'s image
- Not supported yet
    - Yandex MapKit full version
    - Custom layers
    - Map downloading
    - `GeoObject`s

!!! warning
    Library is under development and not all API is available.

## Mission of wrapper with KMP support

- Ability to write MapKit control in common sources
- Support for Compose UI with two variants of API
- Support for multiplatform resources
  via [moko-resources](https://github.com/icerockdev/moko-resources) and
  compose [multiplatform resource](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html).
- Not to rewrite official API. [Official docs](https://yandex.ru/dev/mapkit/doc/) is useful in most
  cases for `yandex-mapkit-kmp` module.
- Quick migration, just change package name from `com.yandex.mapkit` to `ru.sulgik.mapkit`.

## Author

- [@SuLG-ik](https://github.com/SuLG-ik) – main developer. Telegram: [@vollllodya](https://t.me/vollllodya)