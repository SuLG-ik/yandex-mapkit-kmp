# Быстрый старт

## 1. Задайте API-ключ

Ключ задаётся один раз, до того как что-либо ещё коснётся MapKit. Получить его можно по
[официальной инструкции](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started#key).

=== "Kotlin (commonMain)"

    ```kotlin
    fun initMapKit() {
        MapKit.setApiKey("<API_KEY>")
    }
    ```

!!! tip "Как не держать ключ в исходниках"
    [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) генерирует его в общий код на этапе
    сборки; так сделано в [примере](../sample.md).

Вызовите эту функцию из точки входа каждой платформы.

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

Подойдёт и любая другая точка входа — см. официальные руководства для
[Android](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started) и
[iOS](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started).

## 2. Инициализируйте MapKit

На Android MapKit нужен `Context`, и ему нужно сообщать, когда приложение выходит на передний план;
на iOS не требуется ни то, ни другое. Устроить это можно тремя способами, и их можно смешивать —
главное не делать одно и то же дважды.

### Из Android-исходников

`MapKit.initialize(Context)` существует только в `androidMain`. Вызовы жизненного цикла идут рядом.

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

### Из общего кода, через Compose

!!! info "Требуется `yandex-mapkit-kmp-compose`"

`rememberAndInitializeMapKit()` выполняет инициализацию, нужную только на Android, и возвращает
экземпляр; `bindToLifecycleOwner()` сам зовёт `onStart()` и `onStop()`, а также `onStop()` ещё раз,
когда composable покидает композицию.

=== "Kotlin"

    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner()
        /* ... */
    }
    ```

!!! warning "Инициализируйте один раз"
    `rememberAndInitializeMapKit()` инициализирует MapKit при первой композиции. Если это уже сделано
    где-то ещё — например, через `MapKit.initialize(Context)` в `Activity` — используйте
    `rememberMapKit()`, который только возвращает экземпляр.

    И учтите: уничтожение композиции, которой принадлежит `bindToLifecycleOwner()`, останавливает
    MapKit.

### Вокруг уже существующей View

У каждого обёрнутого нативного типа есть расширение `toCommon()` в платформенных исходниках,
поэтому `MapView`, созданный так же, как это делает официальный SDK, можно передать в общий код:
`MapView.toCommon()` / `YMKMapView.toCommon()`, `MapWindow.toCommon()` / `YMKMapWindow.toCommon()`,
`Map.toCommon()` / `YMKMap.toCommon()`. Обратное направление — `toNative()`, тоже только на
платформе.

Этот путь описан в [Обзоре обёртки](../wrapper/overview.md).

## 3. Покажите карту

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

=== "Платформенные View"

    В `commonMain`:

    ```kotlin
    fun setupMap(map: Map) {
        map.move(
            CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f),
        )
    }
    ```

    В `androidMain`:

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

## 4. Добавьте метку

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

=== "Обёртка"

    ```kotlin
    fun setupMap(map: Map, icon: ImageProvider) {
        map.mapObjects.addPlacemark().apply {
            geometry = Point(55.751225, 37.629540)
            setIcon(icon)
        }
    }
    ```

    `ImageProvider` собирается в платформенном коде — см. [Изображения](../wrapper/image-resources.md).

## 5. Реагируйте на события

MapKit не удерживает слушателей, поэтому каждая подписка в этой обёртке принимает
`WeakRef<Listener>`, а сильную ссылку держит вызывающий код.

=== "Compose Multiplatform"

    ```kotlin
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapListeners(
            onMapTap = { point -> println("tap at $point") },
            onMapLoaded = { statistics -> println("loaded in ${statistics.fullyLoaded}") },
        )
    }
    ```

=== "Обёртка"

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

    Хранить `inputListener` в поле — часть паттерна: слушатель, на который ссылается только
    подписка, будет собран сборщиком мусора, и подписка молча перестанет срабатывать. См.
    [Слушатели и `WeakRef`](../wrapper/overview.md#слушатели-и-weakref).

## Куда дальше

- [Миграция с MapKit](migration.md) — как перенести существующий Android-код карты.
- [Карта и камера](../wrapper/map.md) — камера, жесты, стили, экранные координаты.
- [Объекты карты](../wrapper/mapobjects.md) — метки, геометрия, кластеризация.
- [Обзор Compose](../compose/overview.md) — composable-API целиком.
