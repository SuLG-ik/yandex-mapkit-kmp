# Yandex MapKit KMP SDK

[![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.7.0-blue)](https://github.com/JetBrains/compose-multiplatform)
[![Maven Central](https://img.shields.io/maven-central/v/ru.sulgik.mapkit/yandex-mapkit-kmp?color=blue)](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)
[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/LICENSE)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat&color=blue)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat&color=blue)

Kotlin-first SDK for Yandex MapKit. It's API is similar to the Yandex MapKit SDK but also supports
multiplatform projects and compose multiplaform, enabling you to use MapKit directly from your
common source targeting iOS or Android.

**_NOTE:_ It is not Yandex's project. Author has no connection with original SDK, it is wrapper
above official Yandex MapKit SDK**

# Available libraries

The following libraries are available. It
uses [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/) version *4.8.1-lite*

| Module	                                        | Gradle Dependency                                                                                                                            | Description                                                                                                                                              |
|------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Core](yandex-mapkit-kmp)                      | [`ru.sulgik.mapkit:yandex-mapkit-kmp:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)                           | Features of original Yandex MapKit SDK                                                                                                                   |
| [Compose](yandex-mapkit-kmp-compose)           | [`ru.sulgik.mapkit:yandex-mapkit-kmp-compose:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-compose)           | Component to draw map and [compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html) usage as map images |
| [Moko](yandex-mapkit-kmp-moko)                 | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko)                 | Use [moko-resources](https://github.com/icerockdev/moko-resources) as map images. Requires native initialization                                         |
| [Moko Compose](yandex-mapkit-kmp-moko-compose) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko-compose) | Use [moko-resources](https://github.com/icerockdev/moko-resources) as image provider. Not require native initialization                                  |

## Installation

The minimum supported Android SDK is 24 (Android 7.0).

All modules are available for use in common code, but native API available only in native code.

On iOS the
official [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started) in
not linked as a transtive dependency. Therefore, any project using this SDK needs to link the same
Yandex MapKit SDK as well. This can be done through your preferred installation
method ([Cocoapods](https://kotlinlang.org/docs/native-cocoapods.html)/[SPM](https://kotlinlang.org/docs/native-spm.html#project-configuration-options)).

```kotlin
kotlin {
  cocoapods {
    pod("YandexMapsMobile") {
      version = "<mapkit-version>"
    }
  }
  sourceSets {
    commonMain.dependencies {
      implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:<version>") // main module
      implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose:<version>") // optional compose support
      implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko:<version>") // optional: moko support
      implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:<version>") // optional: moko compose resources support
    }
  }
}
```

```kotlin
cocoapods {
    pod("YandexMapsMobile") {
        version = "<version>"
    }
}
```

## Documentation

Full documentation on [page](https://ymk-kmp.sulgik.ru)