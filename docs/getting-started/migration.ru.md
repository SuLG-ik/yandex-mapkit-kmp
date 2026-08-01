# Миграция с MapKit

Перенос существующего Android-кода карты — это в основном смена префикса пакета. Здесь перечислено
то, где это не так.

## 1. Смените префикс пакета

Пакеты повторяют пакеты MapKit, только `com.yandex.mapkit` заменён на `ru.sulgik.mapkit`.

| MapKit | Обёртка |
|---|---|
| `com.yandex.mapkit.geometry` | `ru.sulgik.mapkit.geometry` |
| `com.yandex.mapkit.map` | `ru.sulgik.mapkit.map` |
| `com.yandex.mapkit.mapview` | `ru.sulgik.mapkit.mapview` |
| `com.yandex.mapkit.location` | `ru.sulgik.mapkit.location` |
| `com.yandex.mapkit.user_location` | `ru.sulgik.mapkit.user_location` |
| `com.yandex.mapkit.layers` | `ru.sulgik.mapkit.layers` |
| `com.yandex.mapkit.logo` | `ru.sulgik.mapkit.logo` |
| `com.yandex.mapkit.indoor` | `ru.sulgik.mapkit.indoor` |
| `com.yandex.mapkit.traffic` | `ru.sulgik.mapkit.traffic` |
| `com.yandex.mapkit.offline_cache` | `ru.sulgik.mapkit.offline_cache` |
| `com.yandex.mapkit.storage` | `ru.sulgik.mapkit.storage` |
| `com.yandex.mapkit.uri` | `ru.sulgik.mapkit.uri` |
| `com.yandex.runtime` | `ru.sulgik.mapkit.runtime` |
| `com.yandex.mapkit.MapKitFactory` | `ru.sulgik.mapkit.MapKit` |

!!! info "Пример"
    === "Было"

        ```kotlin
        val startPosition = com.yandex.mapkit.map.CameraPosition(/* ... */)

        fun setupMap(map: com.yandex.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```

    === "Стало"

        ```kotlin
        val startPosition = ru.sulgik.mapkit.map.CameraPosition(/* ... */)

        fun setupMap(map: ru.sulgik.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```

## 2. Перенесите код в `commonMain`

Логика карты уезжает в общий код; на платформе остаётся только создание view и преобразование.

=== "Kotlin (androidMain)"

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

=== "Kotlin (iosMain)"

    ```kotlin
    fun setupMap(mapView: YMKMapView) {
        setupMap(mapView.mapWindow.toCommon().map)
    }
    ```

`toCommon()` и `toNative()` есть у каждого обёрнутого типа и живут только в платформенных
исходниках — `commonMain` вообще не знает, что нативный тип существует.

## 3. Оберните слушателей в `WeakRef`

MapKit хранит слушателей слабо и удаляет их по идентичности. В обёртке это написано прямо в
сигнатуре: подписки принимают `WeakRef<Listener>`.

=== "Было"

    ```kotlin
    map.addInputListener(inputListener)
    ```

=== "Стало"

    ```kotlin
    map.addInputListener(inputListener.asWeakRef())
    ```

Слушателя должно держать что-то ещё — поле того объекта, которому принадлежит подписка, — иначе он
будет собран, и подписка молча перестанет срабатывать. В MapKit это было так же, обёртка лишь
делает это видимым.

Слушатели теперь ещё и лямбды. У каждого типа слушателя есть фабричная функция с тем же именем:

```kotlin
private val inputListener = InputListener(
    onMapTap = { _, point -> println("tap at $point") },
    onMapLongTap = { _, point -> println("long tap at $point") },
)

private val tapListener = MapObjectTapListener { mapObject, _ ->
    mapObject.userData != null
}
```

## 4. Kotlin-типы вместо голых чисел

| MapKit | Обёртка |
|---|---|
| `Animation(SMOOTH, 0.3f)` | `Animation(Animation.Type.SMOOTH, 300.milliseconds)` |
| `long`-таймстемпы | `kotlin.time.Instant` |
| `int`-цвета (`0xFF0000FF`) | `Color`, создаётся через `Color.fromArgb(argb)`, читается через `toArgb()` |
| `Point(lat, lon)` из голых `Double` | `Point(lat, lon)` поверх value-классов `Latitude` и `Longitude` |
| значения-заглушки для «не задано» | nullable-типы — `poiLimit: Int?`, `focusRect: ScreenRect?` |

В Compose-модуле вместо этого используется `androidx.compose.ui.graphics.Color`, и преобразование
делается за вас.

## 5. Что переименовалось

- `MapKitFactory` стал `MapKit`: `MapKitFactory.getInstance()` → `MapKit.getInstance()`,
  `MapKitFactory.setApiKey(key)` → `MapKit.setApiKey(key)`. `MapKit.initialize(Context)` есть только
  в `androidMain`, как и в самом MapKit.
- `MapObjectCollection.addPlacemark(point, icon)` и его перегрузок больше нет: MapKit объявил их
  устаревшими в пользу `addPlacemark()` с последующим присваиванием свойств:

    ```kotlin
    mapObjects.addPlacemark().apply {
        geometry = point
        setIcon(icon)
    }
    ```

- `PolylineMapObject.setStrokeColors` принимает **индексы палитры**, а не цвета — как и в MapKit.
  Сначала задайте палитру через `setPaletteColor(index, color)`. См.
  [Объекты карты](../wrapper/mapobjects.md#ломаная).
- `Logging.subscribe`, как и любая другая подписка, принимает `WeakRef`.
- Геттеры и сеттеры стали свойствами: `map.isNightModeEnabled = true`, `mapObject.userData = data`.

## 6. Чего ждать от равенства

Типы, стоящие за живым объектом MapKit — `Map`, `MapWindow`, иерархия `MapObject`, менеджеры,
слои — это **хендлы**. Новая обёртка создаётся каждый раз, когда такой объект пересекает границу,
поэтому метка, которую вам отдал слушатель нажатия, — не тот же экземпляр обёртки, который вы
добавляли.

Они сравниваются по объекту за ними, так что это работает:

```kotlin
val placemark = collection.addPlacemark()

val tapListener = MapObjectTapListener { tapped, _ -> tapped == placemark }
```

Подробности, включая единственный тип, который сравнивается по значению, — в разделе
[Идентичность хендлов](../wrapper/overview.md#идентичность-хендлов).

## 7. Чего нет

Всего, чего нет в сборке **lite** — поиска, маршрутизации, панорам, дорожных событий,
персонализации. Остальное перечислено в разделе
[Что не обёрнуто](../wrapper/coverage.md#что-не-обёрнуто).
