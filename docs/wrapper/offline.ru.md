# Офлайн-карты и хранилище

Оба менеджера висят на `MapKit`:

```kotlin
val storageManager = MapKit.getInstance().storageManager
val offlineCacheManager = MapKit.getInstance().offlineCacheManager
```

## Хранилище

`StorageManager` сообщает и ограничивает то, что MapKit держит на диске: кеш тайлов и всё остальное,
что он скачивает. Все методы асинхронные и отвечают через колбэк.

```kotlin
storageManager.computeSize { bytes, error ->
    when {
        error != null -> showError(error)
        bytes != null -> show("${bytes / 1024 / 1024} MB")
    }
}
```

Колбэк получает одно из двух: размер или `runtime.Error`, объясняющую, почему размера нет.

```kotlin
storageManager.maxTileStorageSize { bytes, _ -> println("limit: $bytes") }

storageManager.setMaxTileStorageSize(200L * 1024 * 1024) { bytes, error ->
    if (error == null) println("limit is now $bytes")
}

storageManager.resetMaxTileStorageSize { _, _ -> }

storageManager.clear { println("cache cleared") }
```

!!! warning "`clear()` необратим"
    Он сбрасывает кеш тайлов, и карта скачает всё заново при следующем показе.

Об ошибках, на которые MapKit наткнулся сам, вне ваших вызовов, сообщает слушатель:

```kotlin
private val storageErrorListener = StorageErrorListener { error ->
    when (error) {
        is DiskFullError -> askToFreeSpace()
        is DiskWriteAccessError -> reportUnwritableStorage()
        is DiskCorruptError -> offerToClearCache()
        else -> report(error)
    }
}

storageManager.addStorageErrorListener(storageErrorListener.asWeakRef())
```

## Офлайн-карты

`OfflineCacheManager` скачивает регионы целиком, чтобы карта работала без сети.

### Найти регион

```kotlin
val regions: List<Region> = offlineCacheManager.regions()

val moscow = regions.firstOrNull { it.name == "Москва" }
```

`Region` — value-тип:

```kotlin
data class Region(
    val id: Int,
    val name: String,
    val country: String,
    val center: Point,
    val size: LocalizedValue,
    val releaseTime: Instant,
    val parentId: Int?,
)
```

`size` — это `LocalizedValue`: число плюс строка, которую MapKit уже отформатировал для текущей
локали, так что `size.text` — то, что показывают, а `size.value` — то, что сравнивают.

Список заполняется асинхронно; если вы показываете его при запуске, подпишитесь до чтения:

```kotlin
private val listUpdatesListener = RegionListUpdatesListener { show(offlineCacheManager.regions()) }

offlineCacheManager.addRegionListUpdatesListener(listUpdatesListener.asWeakRef())
```

Регионы, покрывающие точку, без перебора всего списка:

```kotlin
offlineCacheManager.requestRegionsAtPoint(point) { regionIds, error ->
    if (error != null) report(error.description) else show(regionIds.orEmpty())
}
```

Колбэк получает **идентификаторы** регионов; сопоставить их с полными `Region` помогает `regions()`.

### Скачивание

```kotlin
class OfflineController(private val manager: OfflineCacheManager) {

    private val regionListener = RegionListener(
        onRegionStateChanged = { regionId -> show(regionId, manager.getState(regionId)) },
        onRegionProgress = { regionId -> showProgress(regionId, manager.getProgress(regionId)) },
    )

    private val errorListener = ErrorListener(
        onError = { report(it) },
        onRegionError = { error, regionId -> report(regionId, error) },
    )

    init {
        manager.addRegionListener(regionListener.asWeakRef())
        manager.addErrorListener(errorListener.asWeakRef())
    }

    fun download(regionId: Int) {
        if (manager.mayBeOutOfAvailableSpace(regionId)) {
            warnAboutSpace()
            return
        }
        manager.startDownload(regionId)
    }

    fun pause(regionId: Int) = manager.pauseDownload(regionId)

    fun stop(regionId: Int) = manager.stopDownload(regionId)

    fun delete(regionId: Int) = manager.drop(regionId)
}
```

`getProgress(regionId)` — это `0f..1f`. `getState(regionId)` — одно из:

| Состояние | Что означает |
|---|---|
| `AVAILABLE` | можно скачать |
| `DOWNLOADING` | скачивается |
| `PAUSED` | приостановлено, продолжается через `startDownload` |
| `COMPLETED` | скачано и актуально |
| `OUTDATED` | скачано, но вышла новая версия |
| `NEED_UPDATE` | нужно обновить, прежде чем использовать |
| `UNSUPPORTED` | эта версия MapKit не умеет им пользоваться |

`getDownloadedReleaseTime(regionId)` возвращает дату выпуска скачанной копии или `null`, если её
нет. `getCities(regionId)` перечисляет города региона — то, что показывают под его названием.

`stopDownload` отменяет и выбрасывает скачанное; `pauseDownload` его сохраняет.

!!! danger "`drop` и `clear` удаляют данные"
    `drop(regionId)` удаляет один скачанный регион, `clear { }` — всё, что держит офлайн-кеш. Ни то,
    ни другое не спрашивает подтверждения.

### Сеть и обновления

```kotlin
offlineCacheManager.allowUseCellularNetwork(false)
offlineCacheManager.enableAutoUpdate(true)
```

### Где лежит кеш

```kotlin
offlineCacheManager.requestPath { path -> println("cache is at $path") }

offlineCacheManager.computeCacheSize { size -> println("$size bytes") }
```

Перенос — например, на SD-карту — сообщает прогресс и может завершиться ошибкой:

```kotlin
private val dataMoveListener = DataMoveListener(
    onDataMoveCompleted = { println("moved") },
    onDataMoveError = { error -> report(error.description) },
    onDataMoveProgress = { percent -> showProgress(percent) },
)

offlineCacheManager.moveData(newPath, dataMoveListener.asWeakRef())
```

`setCachePath` направляет MapKit в другую папку, ничего не перенося:

```kotlin
offlineCacheManager.setCachePath(newPath) { error ->
    if (error != null) report(error.description)
}
```

`isLegacyPath(regionId)` сообщает, лежит ли регион ещё в раскладке, которой пользовалась более
старая версия MapKit.

### `OfflineCacheError`

`description` — это `String?` с тем, что MapKit говорит о произошедшем; `error` — типизированная
причина `runtime.Error?`, когда она есть.

!!! note "На iOS сравнивается по значению"
    `OfflineCacheError` оборачивает `NSError` на iOS, а `NSError` реализует `isEqual:` со значимой
    семантикой. Две разные ошибки с одинаковыми domain, code и `userInfo` поэтому окажутся равны на
    iOS и не равны на Android. Считайте равенство признаком «та же самая ошибка», а не «тот же
    объект» — см. [Идентичность хендлов](overview.md#идентичность-хендлов).
