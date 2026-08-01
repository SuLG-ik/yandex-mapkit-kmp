# Quick start

## 1. Set the API key

The key is set once, before anything else touches MapKit. Get it from the
[official documentation](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started#key).

=== "Kotlin (commonMain)"

    ```kotlin
    fun initMapKit() {
        MapKit.setApiKey("<API_KEY>")
    }
    ```

!!! tip "Keeping the key out of the sources"
    [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) generates it into common code at build
    time; this is what the [sample](../sample.md) does.

Call it from the entry point of each platform.

=== "Android"

    ```kotlin
    class MyApplication : Application() {
        override fun onCreate() {
            super.onCreate()
            initMapKit()
        }
    }
    ```

=== "iOS"

    ```swift
    @main
    struct iOSApp: App {
        init() {
            AppKt.doInitMapKit()
        }

        var body: some Scene {
            WindowGroup { ContentView() }
        }
    }
    ```

Any other entry point works too — see the official
[Android](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started) and
[iOS](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started) guides.

## 2. Initialize MapKit

On Android MapKit needs a `Context` and has to be told when the application comes to the foreground;
on iOS neither is required. There are three ways to arrange that, and they can be mixed as long as
nothing is done twice.

### From Android sources

`MapKit.initialize(Context)` exists in `androidMain` only. The lifecycle calls go with it.

=== "Kotlin (androidMain)"

    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            MapKit.initialize(this)
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

### From common code, with Compose

!!! info "Requires `yandex-mapkit-kmp-compose`"

`rememberAndInitializeMapKit()` does the Android-only initialization and returns the instance;
`bindToLifecycleOwner()` calls `onStart()` and `onStop()` for you, and `onStop()` again when the
composable leaves the composition.

=== "Kotlin"

    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner()
        /* ... */
    }
    ```

!!! warning "Initialize once"
    `rememberAndInitializeMapKit()` initializes MapKit on the first composition. If something
    already did that — `MapKit.initialize(Context)` in an `Activity`, for example — use
    `rememberMapKit()` instead, which only returns the instance.

    Note also that disposing the composition that owns `bindToLifecycleOwner()` stops MapKit.

### Around a view you already have

Every wrapped native type has a `toCommon()` extension in the platform source set, so a `MapView`
created the way the official SDK does it can be handed to common code:
`MapView.toCommon()` / `YMKMapView.toCommon()`, `MapWindow.toCommon()` / `YMKMapWindow.toCommon()`,
`Map.toCommon()` / `YMKMap.toCommon()`. The opposite direction is `toNative()`, also platform-only.

This is the path described in [Wrapper overview](../wrapper/overview.md).

## 3. Show a map

=== "Compose Multiplatform"

    ```kotlin
    private val moscow = CameraPosition(
        target = Point(55.751225, 37.629540),
        zoom = 15f,
        azimuth = 0f,
        tilt = 0f,
    )

    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner()
        val cameraPositionState = rememberCameraPositionState { position = moscow }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```

=== "Platform views"

    In `commonMain`:

    ```kotlin
    fun setupMap(map: Map) {
        map.move(
            CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f),
        )
    }
    ```

    In `androidMain`:

    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            MapKit.initialize(this)
            setContentView(R.layout.activity_main)
            val mapView = findViewById<com.yandex.mapkit.mapview.MapView>(R.id.map)
            setupMap(mapView.mapWindow.map.toCommon())
        }
    }
    ```

## 4. Add a placemark

=== "Compose Multiplatform"

    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner()
        val cameraPositionState = rememberCameraPositionState { position = moscow }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Placemark(
                state = rememberPlacemarkState(Point(55.751225, 37.629540)),
                icon = imageProvider(Res.drawable.pin_red),
                onTap = { point ->
                    println("tapped at $point")
                    true
                },
            )
        }
    }
    ```

=== "Wrapper"

    ```kotlin
    fun setupMap(map: Map, icon: ImageProvider) {
        map.mapObjects.addPlacemark().apply {
            geometry = Point(55.751225, 37.629540)
            setIcon(icon)
        }
    }
    ```

    `ImageProvider` is built in platform code — see [Image resources](../wrapper/image-resources.md).

## 5. React to events

Listeners are not retained by MapKit, so every subscription in this wrapper takes a
`WeakRef<Listener>` and the caller keeps the strong reference.

=== "Compose Multiplatform"

    ```kotlin
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapListeners(
            onMapTap = { point -> println("tap at $point") },
            onMapLoaded = { statistics -> println("loaded in ${statistics.fullyLoaded}") },
        )
    }
    ```

=== "Wrapper"

    ```kotlin
    class MapController(private val map: Map) {

        private val inputListener = InputListener(
            onMapTap = { _, point -> println("tap at $point") },
            onMapLongTap = { _, point -> println("long tap at $point") },
        )

        init {
            map.addInputListener(inputListener.asWeakRef())
        }
    }
    ```

    Storing `inputListener` in a field is part of the pattern: a listener referenced only by the
    subscription is collected, and the subscription silently stops firing. See
    [Wrapper overview](../wrapper/overview.md#listeners-and-weakref).

## Where to go next

- [Migration from MapKit](migration.md) — porting existing Android map code.
- [Map and camera](../wrapper/map.md) — the camera, gestures, styles, screen coordinates.
- [Map objects](../wrapper/mapobjects.md) — placemarks, geometry, clustering.
- [Compose overview](../compose/overview.md) — the composable API in full.
