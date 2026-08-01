# Обзор обёртки

`yandex-mapkit-kmp` — модуль, который делает MapKit доступным из общего кода. Он повторяет пакеты,
типы и члены MapKit, поэтому
[официальная документация](https://yandex.ru/dev/mapkit/doc/ru/) по-прежнему описывает, что делает
конкретный член; эта страница — про то, что обёртка добавляет сверху.

## Она ничего не рисует

Модуль оборачивает API, а не view. `MapView` вы создаёте на платформе ровно так, как требует
официальный SDK, преобразуете его и передаёте в общий код.

!!! info "Пример"
    === "Kotlin (commonMain)"

        ```kotlin
        fun setupMap(map: Map) {
            map.move(
                CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f),
            )
        }
        ```

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

Чтобы саму view создавать из общего кода, подключите
[`yandex-mapkit-kmp-compose`](../compose/overview.md).

## Пересечение границы

Переход между общим и нативным записывается ровно двумя именами, и оба живут только в платформенных
исходниках:

```kotlin
public fun NativePoint.toCommon(): Point
public fun Point.toNative(): NativePoint
```

`commonMain` никогда не видит нативный тип — именно поэтому один и тот же общий код компилируется
под обе платформы. У всего, что отдаёт MapKit, есть `toCommon()`, а у всего, что держит обёртка, —
`toNative()`, поэтому спуститься к платформенному SDK за тем, чего обёртка не покрывает, можно
всегда.

## Три вида типов

Понимание того, что именно вы держите в руках, объясняет поведение.

**Value-типы** — неизменяемые данные: `Point`, `CameraPosition`, `IconStyle`, `Animation`,
`Location`, `LogMessage`. В общем коде это `data class`, сравниваются по полям.

**Хендлы** стоят за живым объектом MapKit, которым вы управляете: `Map`, `MapWindow`,
`PlacemarkMapObject`, `LocationManager`, `TrafficLayer`, `Icon`. Они держат нативный объект и
переадресуют ему каждый вызов.

**Слушатели** — абстрактные классы с фабричной лямбдой того же имени:

```kotlin
val tapListener = MapObjectTapListener { mapObject, point -> true }

val inputListener = InputListener(
    onMapTap = { _, point -> println("tap at $point") },
    onMapLongTap = { _, point -> println("long tap at $point") },
)
```

## Слушатели и `WeakRef`

MapKit не удерживает слушателей: он держит их в слабой коллекции и удаляет по идентичности. Поэтому
каждая подписка в обёртке принимает `WeakRef<Listener>`, а сильную ссылку держит вызывающий код.

```kotlin
class MapController(private val map: Map) {

    private val inputListener = InputListener(
        onMapTap = { _, point -> onTap(point) },
        onMapLongTap = { _, _ -> },
    )

    init {
        map.addInputListener(inputListener.asWeakRef())
    }

    fun dispose() {
        map.removeInputListener(inputListener.asWeakRef())
    }
}
```

!!! warning "Держите слушателя сами"
    `map.addInputListener(InputListener { /* ... */ }.asWeakRef())` скомпилируется и никогда не
    сработает: слушателя никто не держит, и он будет собран. Положите его в поле того, кому
    принадлежит подписка, — контроллера, Compose-узла, модели экрана.

Отписаться можно новым `WeakRef` вокруг того же слушателя: `toNative()` в обёртке всю жизнь
возвращает один и тот же нативный экземпляр, а MapKit сравнивает именно по нему.

У `WeakRef` также есть `get(): T?` и `withValue { }`, чтобы прочитать значение обратно.

## Идентичность хендлов

Новая обёртка создаётся каждый раз, когда нативный объект пересекает границу, поэтому метка, которую
вам отдал слушатель нажатия, — никогда не тот же экземпляр обёртки, который вы добавляли.

Поэтому хендлы сравниваются по объекту за ними: **два хендла равны, когда у них одинаковый тип и они
оборачивают один и тот же нативный объект**, а `hashCode()` — это хеш обёрнутого объекта, так что
хендл годится в качестве ключа `Map` или элемента `Set`.

!!! info "Пример"
    === "Kotlin"

        ```kotlin
        val placemark = collection.addPlacemark()

        val tapListener = MapObjectTapListener { tapped, _ ->
            tapped == placemark
        }
        ```

Тип участвует в сравнении намеренно. `MapObject.toCommon()` откатывается к базовой обёртке для
неизвестного обёртке подтипа, так что простой `MapObject` и `PlacemarkMapObject` могут стоять за
одним и тем же объектом; сделать их равными означало бы сломать симметричность `equals`.

Оба члена безопасны на невалидном хендле (`isValid == false`), где любой другой член бросает
исключение: они сравнивают ссылки и никогда не заходят в MapKit.

Value-типы — `Point`, `CameraPosition`, `IconStyle` и остальные `data class` — по-прежнему
сравниваются по полям.

!!! note "`OfflineCacheError` на iOS сравнивается по значению"
    Обёртывание одного и того же нативного объекта всегда делает хендлы равными, но у одного типа
    это не единственный способ оказаться равными. `offline_cache.OfflineCacheError` оборачивает
    `NSError` на iOS и `runtime.Error` на Android, а `NSError` переопределяет `isEqual:` и `hash` со
    значимой семантикой. Две разные ошибки с одинаковыми domain, code и `userInfo` поэтому окажутся
    равны на iOS и не равны на Android. `NSError` неизменяем, так что его хеш не «уплывает»;
    считайте равенство `OfflineCacheError` признаком «та же самая ошибка», а не «тот же объект».

## Время жизни и `isValid`

MapKit инвалидирует свои объекты, когда исчезает то, чему они принадлежат: объект карты, удалённый
из коллекции; слой, снятый с карты; вообще всё после `MapKit.onTerminate()`. Обращение к невалидному
объекту бросает исключение.

Хендлы выставляют это как `isValid`, и проверку стоит делать везде, где объект может пережить карту:

```kotlin
if (placemark.isValid) {
    placemark.geometry = point
}
```

Исключение — `equals` и `hashCode`: они не заходят в MapKit и остаются пригодными.

## Kotlin вместо голых значений

- `kotlin.time.Duration` для длительностей, `kotlin.time.Instant` для моментов времени.
- Nullable-типы вместо значений-заглушек: `poiLimit: Int?`, `focusRect: ScreenRect?`,
  `lastKnownLocation(): Location?`.
- `Color` — value-класс поверх ARGB, создаётся через `Color.fromArgb(argb)`, читается через
  `toArgb()`. Compose-модуль принимает `androidx.compose.ui.graphics.Color` и конвертирует сам.
- Value-классы `Latitude` и `Longitude` за `Point`, чтобы порядок аргументов нельзя было молча
  перепутать.
- Перечисления вместо целочисленных констант, и без ветки по умолчанию: неизвестное нативное
  значение бросает исключение, а не превращается молча во что-то правдоподобное.

## Потоки

MapKit вызывает колбэки на главном потоке и ожидает, что им управляют оттуда же. Обёртка не
добавляет своей многопоточности: колбэк приходит на том потоке, который выбрал MapKit, а вызов
уходит напрямую. Считайте любой объект обёртки предназначенным только для главного потока, если
MapKit не говорит иного.

## Что дальше

- [Что обёрнуто](coverage.md) — покрытие по пакетам.
- [Карта и камера](map.md), [Объекты карты](mapobjects.md),
  [Объекты базовой карты](geoobjects.md).
- [Геолокация](location.md), [Слои и тайлы](layers.md),
  [Офлайн-карты и хранилище](offline.md), [Runtime](runtime.md).
