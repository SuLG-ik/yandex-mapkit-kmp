# Runtime

`ru.sulgik.mapkit.runtime` mirrors `com.yandex.runtime`: the failures MapKit reports, its log stream
and its locale-aware formatting.

## Errors

Every failure a listener or a callback reports is a `runtime.Error`. It is a handle, not an
exception — you branch on its type:

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
        is DiskFullError -> "Not enough space"
        is DiskWriteAccessError -> "Storage is not writable"
        is DiskCorruptError -> "The cache is damaged"
        is NetworkError -> "No connection"
        is UnauthorizedError -> "Check the API key"
        is ForbiddenError -> "This key is not allowed to do that"
        is RemoteError -> "Yandex returned an error"
        else -> "Unknown error"
    }
    show(message)
}
```

!!! info "`is` works because the hierarchy is preserved"
    The wrapper mirrors MapKit's own class hierarchy on both platforms, so `is NetworkError` means
    the same thing in common code as it does in the platform SDK. `else` is still needed — MapKit
    adds error types in minor releases.

`DiskFullError` and `DiskWriteAccessError` come from `StorageManager`;
`NetworkError` and the `RemoteError` family come from anything that talks to Yandex, including the
offline cache and the tile layers.

## Logging

`Logging` is the consumer side of MapKit's internal log stream. It is a singleton:

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

`LogMessage` is a value type:

```kotlin
data class LogMessage(
    val time: Instant,
    val level: LogLevel,
    val scope: String,
    val message: String,
    val verboseInfo: String,
)
```

`LogLevel` is `ERROR`, `WARNING`, `INFO` or `DEBUG`. `scope` is the MapKit subsystem the message
came from, and `verboseInfo` carries the file and line when MapKit provides them.

!!! warning "A healthy session logs almost nothing"
    MapKit publishes to this stream only when something goes wrong, and it drops `INFO` and `DEBUG`
    below its own threshold. An empty log is the normal case, not a sign that the subscription
    failed.

The subscription is weak, like every other one: hold the listener in a field, or it is collected and
the log goes quiet.

## Localized formatting

`I18nManager` formats numbers the way the Yandex map application does, for the locale MapKit is
running in.

```kotlin
val i18n = I18nManager.getInstance()

val distance = i18n.localizeDistance(1500)
val duration = i18n.localizeDuration(3660)
val speed = i18n.localizeSpeed(16.7)
val size = i18n.localizeDataSize(52_428_800)
```

Each takes the unit MapKit itself uses and returns a string ready to be shown:

| Call | Input unit |
|---|---|
| `localizeDistance` | metres |
| `localizeDuration` | seconds |
| `localizeSpeed` | metres per second |
| `localizeDataSize` | bytes |

The exact wording follows the locale and the system of measurement below.

For a value you want to lay out yourself, `canonicalSpeed` converts into the unit the locale prefers
and hands back both parts — `CanonicalUnit.value` and `CanonicalUnit.unit`:

```kotlin
val canonical: CanonicalUnit = i18n.canonicalSpeed(16.7)

val formatted = i18n.localizeCanonicalUnit(canonical)
```

### Preferences

```kotlin
i18n.som = SystemOfMeasurement.IMPERIAL
i18n.timeFormat = TimeFormat.H24

i18n.prefs = I18nPrefs(som = SystemOfMeasurement.METRIC, timeFormat = TimeFormat.DEFAULT)
```

`SystemOfMeasurement` is `DEFAULT`, `METRIC` or `IMPERIAL`; `TimeFormat` is `DEFAULT`, `H24` or
`H12`. `DEFAULT` means whatever the locale implies.

### Locale

```kotlin
val current = I18nManager.getLocale()

I18nManager.setLocale("ru_RU")
```

`setLocale(null)` goes back to the system locale.

`MapKit.setLocale(locale)` sets the locale of the whole SDK, including the map labels;
`I18nManager.setLocale` only affects formatting.

## Version and validity

`MapKit.getInstance().version` is the MapKit version at runtime, and `isValid` is `false` once
`onTerminate()` has been called.

`isValid` exists on every handle in the wrapper. After `MapKit.onTerminate()` everything MapKit
handed out is invalid, and touching it throws — except `equals` and `hashCode`, which stay safe.
