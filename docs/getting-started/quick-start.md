# Quick start

## Setup API key

Add initializing MapKit with API key in common module. Follow 
[official documentation]((https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started#key)) 
to get API key.

=== "Kotlin"
    ```kotlin
    // In common module
    fun initMapKit() {
        MapKit.setApiKey("<API_KEY>")
    }
    ```
!!! info "Suggestion"
    You can use [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) to provide API key during app
    building.

And call this function from entry point of your platform.

**Android sources**

=== "Kotlin"
    ```kotlin
    class MyApplication : Application {
        override fun onCreate() {
            super.onCreate()
            initMapKit()
        }
    }
    ```
or other entry point,
see [Android MapKit official documentation](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started)

**IOS sources**

=== "Swift"
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
see [iOS MapKit official documentation](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started)

## Initialization

MapKit, by and large, must be initialized via native library loading and lifecycle binding. There
three ways to initialize. You can mix methods, but be careful to not repeat completed actions.

### 1. In native android sources

Call `MapKit.initialize(Context)` in your activity in android module and bind lifecycle. 
Additional configuration for iOS is not required.

=== "Kotlin"
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

### 2. In common code

!!! info "Requires `yandex-mapkit-kmp-compose`"

Call 'rememberAndInitializeMapKit()' and call `MapKit.bindToLifecycleOwner()` in your compose
screen.

!!! danger "Important"
    `MapKit.rememberAndInitializeMapKit()` is difficult operation,
    use `MapKit.rememberMapKit()` if you
    already initialize MapKit via other method or early
    
    call `MapKit.bindToLifecycleOwner()` in composition context, which disposing means to stop
    MapKit*
    **

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner()
        /* ... */
    }
    ```


### 3. In common code

All supported native types have extension functions (`<NativeType>.toCommon(): <CommonType>`), use
it to pass exists native MapView to common code like: 
`MapWindow.toCommon()`/`YMKMapWindow.toCommon()`, `Map.toCommon()`/`YMKMap.toCommon()` and
etc. Follow [official documentation](https://yandex.ru/dev/mapkit/doc/ru/) to setup native view.

Also there are methods to convert `<CommonType>` to `<NativeType>` that available in 
platform-specific source code (`<CommonType>.toNative(): <NativeType>`):
`MapWindow.toNative()`, `Map.toNative()` and etc.

## Add map using Compose Multiplatform

!!! info "Requires `yandex-mapkit-kmp-compose`"

There are two compose API to control `Map`. Most simple and useful in most cases, but with 
less performance using composable composition and states:

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner() // if is not called earlier
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize()
        )
    }
    ```