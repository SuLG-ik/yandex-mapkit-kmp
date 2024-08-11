# Yandex MapKit KMP SDK

[![Kotlin](https://img.shields.io/badge/kotlin-2.0.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.6.11-blue)](https://github.com/JetBrains/compose-multiplatform)
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
uses [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/) version *4.6.1-lite*

| Module	                                        | Gradle Dependency                                                                                                                            | Description                                                                                                                                              |
|------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Core](yandex-mapkit-kmp)                      | [`ru.sulgik.mapkit:yandex-mapkit-kmp:0.0.2`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)                           | Features of original Yandex MapKit SDK                                                                                                                   |
| [Compose](yandex-mapkit-kmp-compose)           | [`ru.sulgik.mapkit:yandex-mapkit-kmp-compose:0.0.2`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-compose)           | Component to draw map and [compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html) usage as map images |
| [Moko](yandex-mapkit-kmp-moko)                 | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko:0.0.2`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko)                 | Use [moko-resources](https://github.com/icerockdev/moko-resources) as map images. Requires native initialization                                         |
| [Moko Compose](yandex-mapkit-kmp-moko-compose) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:0.0.2`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko-compose) | Use [moko-resources](https://github.com/icerockdev/moko-resources) as image provider. Not require native initialization                                  |

## Installation

The minimum supported Android SDK is 24 (Android 7.0).

All modules are available for use in common code, but native API available only in native code.

```kotlin
commonMain.dependencies {
    //Core module
    implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:<version>")

    // Optional modules
    implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-<module>:<version>")
}
```

On iOS the
official [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started) in
not linked as a transtive dependency. Therefore, any project using this SDK needs to link the same
Yandex MapKit SDK as well. This can be done through your preferred installation
method ([Cocoapods](https://kotlinlang.org/docs/native-cocoapods.html)/[SPM](https://kotlinlang.org/docs/native-spm.html#project-configuration-options)).

Similarly, tests require linking as well. Make sure to add the required frameworks to the search
path of your test targets. This can be done by specifying a `cocoapods` block in your `build.gradle`
[See actual version](#available-libraries)

```kotlin
cocoapods {
    pod("YandexMapsMobile") {
        version = "<version>"
    }
}
```

## Setup MapKit

Add initializing MapKit with API key in common module. You can
use [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) to provide API key during building

```kotlin
// In common module
fun initMapKit() {
    MapKit.setApiKey("<API_KEY>")
}
```

And call this function from entry point of your platform.

#### Android module:

```kotlin
class MyApplication : Application {
    override fun onCreate() {
        super.onCreate()
        initMapKit()
    }
}
```

or other entry point,
see [MapKit official documentation](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started)

#### IOS module:

```swift
@main
struct iOSApp: App {
    init() {
        AppKt.doInitMapKit()
    }
    // Your code here   
}
```

or other entry point,
see [MapKit official documentation](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started)

## Initialize MapKit

MapKit, by and large, must be initialized via native library loading and lifecycle binding. There
two ways to initialize. You can mix methods, but be careful to not repeat completed actions.

### First method: in native android module

Call `MapKit.initialize(Context)` in your activity in android module and bind lifecycle.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKit.initialize(this)
        /* ... */
    }

    override fun onStart() {
        super.onStart()
        MapKit.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKit.getInstance().onStop()
    }

}
```

### Second method: in common code, requires [compose module](#available-libraries)

Call 'rememberAndInitializeMapKit()' and call `MapKit.bindToLifecycleOwner()` in your compose
screen.

**_IMPORTANT:_ `MapKit.rememberAndInitializeMapKit()` is difficult operation,
use `MapKit.rememberMapKit()` if you
already initialize MapKit via other method or early**

**_NOTE:_ call `MapKit.bindToLifecycleOwner()` in composition context, which disposing means to stop
MapKit**

```kotlin
@Composable
fun MyMap() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    /* ... */
}
```

## Setup view

To show map in app you can
use [compose multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) or platform native
view and convert it available in common module type.

### With [compose module](#available-libraries)

Create YandexMapController and pass it into YandexMap. Don't save instance of YandexMapController
anywhere that has longer lifecycle than YandexMap, it contains native realization of view creating.

```kotlin
@Composable
fun MyMap() {
    val mapController = rememberMapControoller() // use to get MapWindow instance
    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

### Without [compose module](#available-libraries)

All supported native types have extension functions (`<NativeType>.toCommon(): <CommonType>`), use
it to pass exists native MapView to common
code like: `MapWindow.toCommon()`/`YMKWindow.toCommon()`, `Map.toCommon()`/`YMKMap.toCommon()` and
etc. Follow [official documentation](https://yandex.ru/dev/mapkit/doc/ru/) to setup native view.

## Usage

Current API naming has same functions and types names as official API
from [Android Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started)
but with different package. Example `com.yandex.mapkit.MapKit` -> `ru.sulgik.mapkit.MapKit`,
and `com.yandex.mapkit.map.Map` -> `ru.sulgik.mapkit.map.Map`.

### Use with [compose module](#available-libraries)

MapView with some random generated placemarks. For more info about image provider follow [here]()

```kotlin
fun MyMap() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val mapController = rememberYandexMapController()
    val map = mapController.mapWindow.map
    val placemarks = remember { randomPlacemarks() }

    val clusterImage = TODO("Your image loaded via provider")
    val pinRedImage = TODO("Your image loaded via provider")
    val pinGreenImage = TODO("Your image loaded via provider")
    val pinYellowImage = TODO("Your image loaded via provider")

    val clusterListener = remember(clusterImage) {
        ClusterListener { cluster ->
            cluster.appearance.setIcon(clusterImage)
            cluster.appearance.zIndex = 100f
        }
    }


    LaunchedEffect(map) {
        map.move(startPosition)
    }

    LaunchedEffect(map) {
        val typeToImageMap = mapOf(
            PlacemarkType.YELLOW to pinYellowImage,
            PlacemarkType.RED to pinRedImage,
            PlacemarkType.GREEN to pinGreenImage
        )
        val cluster =
            map.mapObjects.addClusterizedPlacemarkCollection(clusterListener)

        placemarks.forEach { (point, data) ->
            cluster.addPlacemark().apply {
                geometry = point
                setIcon(typeToImageMap[data.type]!!)
            }
        }
        cluster.clusterPlacemarks(60.0, 15)
    }
    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

## Image providing

Native API to set images for Android and iOS is different, library commonize this api with 4
variants of provide image.

**_NOTE:_ Use only raster images. SVG or XML vector are not supported by Yandex MapKit SDK**

### With core module

Use native image for
Android `Bitmap.toImageProvider()`, `ImageProvider.fromAsset()`, `ImageProvider.fromResource()`, `ImageProvider.fromFile()`
and iOS `UIImage.toImageProvider()` and convert it to `ImageProvder` which available in common
module.

### With compose module

It
supports [compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html)
to get `ImageProvider`.

```kotlin
// Common module:
fun MyMap() {
    val clusterImage = imageProvider(Res.drawable.cluster)
    val pinRedImage = imageProvider(Res.drawable.pin_red)
    val pinGreenImage = imageProvider(Res.drawable.pin_green)
    val pinYellowImage = imageProvider(Res.drawable.pin_yellow)
    /* Your MapView setup */
    /* ... */
}
```

### With moko module

It does not depend on compose and supports convert ImageResource to ImageProvider, but you should
have implementation of `MOKOImageLoader` created in platform
module `AndroidMOKOImageLoader(context)` and `IOSMOKOImageLoader()`

```kotlin
val imageLoader: ImageLoader = TODO("Your image loader implementation")
val image = imageLoader.fromResource(MR.images.your_image)
```

### With moko compose module

It supports convert ImageResource to ImageProvider and provides `rememberMOKOImageLoader()`. You can
use it in common module to provide images.

```kotlin
@Composable
fun MyMap() {
    val imageLoader: ImageLoader = rememberMOKOImageLoader()
    val image = remember { imageLoader.fromResource(MR.images.your_image) }
    /* Your MapView setup */
    /* ... */
}
```

## Sample app

The [sample project](sample) is a app that show some library usage flow. It is
rewritten [official yandex mapkit example](https://github.com/yandex/mapkit-android-demo). It has
Android and IOS build, but all code is in common code.

## What's completed

**_NOTE:_ API marked as deprecated in official Yandex MapKit SDK does not supported**

- [x] Base map features
    - [x] Control map
    - [x] Map objects
    - [x] Image providing from
      common ([compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html), [moko-resources](https://github.com/icerockdev/moko-resources))
- [ ] User's location
- [ ] *Full* version of MapKit SDK

## Authors

- [@SuLG-ik](https://github.com/SuLG-ik) – main developer.
  telegram: [@vollllodya](https://t.me/vollllodya)
