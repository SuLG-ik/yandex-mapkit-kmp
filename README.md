# Yandex MapKit KMP SDK

[![Kotlin](https://img.shields.io/badge/kotlin-2.0.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.6.11-blue)](https://github.com/JetBrains/compose-multiplatform)
[![Maven Central](https://img.shields.io/maven-central/v/ru.sulgik.mapkit/yandex-mapkit-kmp?color=blue)](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)
[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/LICENSE)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat&color=blue)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat&color=blue)

Kotlin-first SDK for Yandex MapKit. It's API is similar to the Yandex MapKit SDK but also supports multiplatform projects and compose multiplaform, enabling you to use MapKit directly from your common source targeting iOS or Android.

# Features

The following libraries are available for the various Firebase products.


## Installation

The minimum supported Android SDK is 24 (Android 7.0).

All modules are available for use in common code, but native API available only in native code.
```kotlin
//Core module
implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:<version>")

// Optional modules
implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-<module>:<version>")
```

## Sample app

The [sample project](sample) is a app that show some library usage flow. It is rewritten [official yandex mapkit example](https://github.com/yandex/mapkit-android-demo). It has Android and IOS build, but all code is in common code.
## Authors

- [@SuLG-ik](https://github.com/SuLG-ik) – main developer. telegram: [@vollllodya](https://t.me/vollllodya)
