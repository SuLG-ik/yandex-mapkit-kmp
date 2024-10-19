# Installation

Yandex MapKit KMP provides a number of modules, they are all published to Maven Central Repository.

!!! info "Uses [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/) version *4.8.1-lite*"

| Module	                                                                                               | Gradle Dependency                                                                                                                            | Description                                                                                                                                              |
|-------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Wrapper](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp)                   | [`ru.sulgik.mapkit:yandex-mapkit-kmp:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)                           | Features of original Yandex MapKit SDK                                                                                                                   |
| [Compose](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-compose)           | [`ru.sulgik.mapkit:yandex-mapkit-kmp-compose:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-compose)           | Component to draw map and [compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html) usage as map images |
| [Moko](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-moko)                 | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko)                 | Use [moko-resources](https://github.com/icerockdev/moko-resources) as image provider. Requires native initialization                                     |
| [Moko Compose](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-moko-compose) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:0.1.1`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko-compose) | Use [moko-resources](https://github.com/icerockdev/moko-resources) as image provider in composable context. Not require native initialization            |

## Wrapper. The main module

`yandex-mapkit-kmp` module is wrapper for YandexMapKit compose that provides official Yandex MapKit
features to common sources.

It provides KMP Api for:

- `MapKit`, `MapView`, `MapWindow`, `Map`, `MapObject`s, `Geometry`s, `Logo`, `CameraPosition` and etc
- `LocationManager` and `UserLocationLayer`
- Different event listeners and callbacks
- Common `ImageProvider`

This module can be implemented as library for common sources set.

=== "Kotlin"
    ``` kotlin
    kotlin {
        cocoapods {
            pod("YandexMapsMobile") {
              version = "<mapkit-version>"
            }
        }
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:<version>")
            }
        }
    }
    ```

!!! warning
    On iOS the
    official [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started) in
    not linked as a transitive dependency. Therefore, any project using this SDK needs to link the same
    Yandex MapKit SDK as well. This can be done through your preferred installation
    method ([Cocoapods](https://kotlinlang.org/docs/native-cocoapods.html)/[SPM](https://kotlinlang.org/docs/native-spm.html#project-configuration-options)).

## Compose. MapView as composable content

`yandex-mapkit-kmp-compose` module that add support for using mapkit with Compose Multiplatform 
and Compose Multiplatform Resources.

Some supported features:

- `YandexMap` to draw `MapView` in composable context
- `Placemark`, `Circle`, `Polygon`, `Polyline` and rjelated states.
- `CameraPositionState` to control camera position
- Composable content as `ImageProvider` 
- `MapEffect` to access common `Map` instance used inside `YandexMap`.
- etc.

=== "Kotlin"
    ``` kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose:<version>")
            }
        }
    }
    ```

## Moko. Converter for moko-resources to ImageProvider

`yandex-mapkit-kmp-moko` module that add support for using image resources generated 
via [moko-resources](https://github.com/icerockdev/moko-resources) as ImageProvider.

Add `MOKOImageLoader` and platform-specific implementations (`AndroidMOKOImageLoader` 
and `IOSMOKOImageLoader`). Require additional configuration to provide implementations.

=== "Kotlin"
    ``` kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko:<version>")
            }
        }
    }
    ```

## Moko Compose. Converter for moko-resources to ImageProvider with compose supporting

`yandex-mapkit-kmp-moko-compose` module that add supporting for using image resources generated 
via [moko-resources](https://github.com/icerockdev/moko-resources) as ImageProvider 
with compose multiplatform integration.

Add `rememberMOKOImageLoader()` that provides platform-specific implementations for 
`MOKOImageLoader`. Does not require additional configuration.

=== "Kotlin"
    ``` kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:<version>")
            }
        }
    }
    ```