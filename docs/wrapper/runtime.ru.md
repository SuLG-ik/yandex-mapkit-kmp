# Runtime

`ru.sulgik.mapkit.runtime` повторяет `com.yandex.runtime`: ошибки, о которых сообщает MapKit, его
поток логов и форматирование с учётом локали.

## Ошибки

Любая ошибка, о которой сообщает слушатель или колбэк, — это `runtime.Error`. Это хендл, а не
исключение: вы ветвитесь по его типу.

```
Error
├── LocalError
│   ├── DiskCorruptError
│   │   └── DiskWriteAccessError
│   └── DiskFullError
├── NetworkError
└── RemoteError
    ├── BadRequestError
    ├── ForbiddenError
    ├── NotFoundError
    ├── RequestEntityTooLargeError
    └── UnauthorizedError
```

```kotlin
fun report(error: Error) {
    val message = when (error) {
        is DiskFullError -> "Недостаточно места"
        is DiskWriteAccessError -> "Хранилище недоступно для записи"
        is DiskCorruptError -> "Кеш повреждён"
        is NetworkError -> "Нет соединения"
        is UnauthorizedError -> "Проверьте API-ключ"
        is ForbiddenError -> "Этому ключу это не разрешено"
        is RemoteError -> "Яндекс вернул ошибку"
        else -> "Неизвестная ошибка"
    }
    show(message)
}
```

!!! info "`is` работает, потому что иерархия сохранена"
    Обёртка повторяет собственную иерархию классов MapKit на обеих платформах, поэтому
    `is NetworkError` в общем коде значит то же, что и в платформенном SDK. Ветка `else` всё равно
    нужна — MapKit добавляет типы ошибок в минорных релизах.

`DiskFullError` и `DiskWriteAccessError` приходят из `StorageManager`; `NetworkError` и семейство
`RemoteError` — из всего, что ходит в Яндекс, включая офлайн-кеш и тайловые слои.

## Логирование

`Logging` — потребительская сторона внутреннего потока логов MapKit. Это синглтон:

```kotlin
class LogController {

    private val logListener = LogListener { message ->
        println("[${message.level}] ${message.scope}: ${message.message}")
    }

    init {
        Logging.getLogging().subscribe(logListener.asWeakRef())
    }

    fun dispose() {
        Logging.getLogging().unsubscribe(logListener.asWeakRef())
    }
}
```

`LogMessage` — value-тип:

```kotlin
data class LogMessage(
    val time: Instant,
    val level: LogLevel,
    val scope: String,
    val message: String,
    val verboseInfo: String,
)
```

`LogLevel` — это `ERROR`, `WARNING`, `INFO` или `DEBUG`. `scope` — подсистема MapKit, из которой
пришло сообщение, а `verboseInfo` несёт файл и строку, когда MapKit их даёт.

!!! warning "В здоровой сессии логов почти нет"
    MapKit пишет в этот поток, только когда что-то идёт не так, и отбрасывает `INFO` и `DEBUG` ниже
    собственного порога. Пустой лог — норма, а не признак того, что подписка не сработала.

Подписка слабая, как и любая другая: держите слушателя в поле, иначе он будет собран, и лог
замолчит.

## Локализованное форматирование

`I18nManager` форматирует числа так же, как приложение Яндекс.Карт, для той локали, в которой
работает MapKit.

```kotlin
val i18n = I18nManager.getInstance()

val distance = i18n.localizeDistance(1500)
val duration = i18n.localizeDuration(3660)
val speed = i18n.localizeSpeed(16.7)
val size = i18n.localizeDataSize(52_428_800)
```

Каждый метод принимает ту единицу, которой пользуется сам MapKit, и возвращает готовую к показу
строку:

| Вызов | Единица на входе |
|---|---|
| `localizeDistance` | метры |
| `localizeDuration` | секунды |
| `localizeSpeed` | метры в секунду |
| `localizeDataSize` | байты |

Точная формулировка зависит от локали и системы измерения ниже.

Если значение вы хотите верстать сами, `canonicalSpeed` переводит его в предпочтительную для локали
единицу и возвращает обе части — `CanonicalUnit.value` и `CanonicalUnit.unit`:

```kotlin
val canonical: CanonicalUnit = i18n.canonicalSpeed(16.7)

val formatted = i18n.localizeCanonicalUnit(canonical)
```

### Настройки

```kotlin
i18n.som = SystemOfMeasurement.IMPERIAL
i18n.timeFormat = TimeFormat.H24

i18n.prefs = I18nPrefs(som = SystemOfMeasurement.METRIC, timeFormat = TimeFormat.DEFAULT)
```

`SystemOfMeasurement` — это `DEFAULT`, `METRIC` или `IMPERIAL`; `TimeFormat` — `DEFAULT`, `H24` или
`H12`. `DEFAULT` означает то, что подразумевает локаль.

### Локаль

```kotlin
val current = I18nManager.getLocale()

I18nManager.setLocale("ru_RU")
```

`setLocale(null)` возвращает системную локаль.

`MapKit.setLocale(locale)` задаёт локаль всего SDK, включая подписи на карте;
`I18nManager.setLocale` влияет только на форматирование.

## Версия и валидность

`MapKit.getInstance().version` — версия MapKit в рантайме, а `isValid` становится `false` после
вызова `onTerminate()`.

`isValid` есть у каждого хендла обёртки. После `MapKit.onTerminate()` всё, что отдал MapKit,
становится невалидным, и обращение к нему бросает исключение — кроме `equals` и `hashCode`, которые
остаются безопасными.
