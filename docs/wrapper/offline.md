# Offline maps and storage

Both managers hang off `MapKit`:

```kotlin
val storageManager = MapKit.getInstance().storageManager
val offlineCacheManager = MapKit.getInstance().offlineCacheManager
```

## Storage

`StorageManager` reports and caps what MapKit keeps on disk — its tile cache and everything else it
downloads. Every method is asynchronous and answers through a callback.

```kotlin
storageManager.computeSize { bytes, error ->
    when {
        error != null -> showError(error)
        bytes != null -> show("${bytes / 1024 / 1024} MB")
    }
}
```

The callback gets one or the other: a size, or the `runtime.Error` that explains why there is none.

```kotlin
storageManager.maxTileStorageSize { bytes, _ -> println("limit: $bytes") }

storageManager.setMaxTileStorageSize(200L * 1024 * 1024) { bytes, error ->
    if (error == null) println("limit is now $bytes")
}

storageManager.resetMaxTileStorageSize { _, _ -> }

storageManager.clear { println("cache cleared") }
```

!!! warning "`clear()` is not undoable"
    It drops the tile cache, and the map redownloads everything the next time it is shown.

Errors that MapKit hits by itself, outside any call of yours, arrive through a listener:

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

## Offline maps

`OfflineCacheManager` downloads whole regions so the map keeps working without a network.

### Finding a region

```kotlin
val regions: List<Region> = offlineCacheManager.regions()

val moscow = regions.firstOrNull { it.name == "Москва" }
```

`Region` is a value type:

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

`size` is a `LocalizedValue` — the number plus the string MapKit already formatted for the current
locale, so `size.text` is what you show and `size.value` is what you compare.

The list is filled asynchronously; subscribe before reading it if you show it at startup:

```kotlin
private val listUpdatesListener = RegionListUpdatesListener { show(offlineCacheManager.regions()) }

offlineCacheManager.addRegionListUpdatesListener(listUpdatesListener.asWeakRef())
```

Regions covering a point, without going through the whole list:

```kotlin
offlineCacheManager.requestRegionsAtPoint(point) { regionIds, error ->
    if (error != null) report(error.description) else show(regionIds.orEmpty())
}
```

The callback gets region **ids**; `regions()` maps them back to the full `Region`.

### Downloading

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

`getProgress(regionId)` is `0f..1f`. `getState(regionId)` is one of:

| State | Meaning |
|---|---|
| `AVAILABLE` | can be downloaded |
| `DOWNLOADING` | in progress |
| `PAUSED` | paused, resumable with `startDownload` |
| `COMPLETED` | downloaded and current |
| `OUTDATED` | downloaded, a newer release exists |
| `NEED_UPDATE` | must be updated before it can be used |
| `UNSUPPORTED` | this MapKit version cannot use it |

`getDownloadedReleaseTime(regionId)` returns when the downloaded copy was released, or `null` if
there is none. `getCities(regionId)` lists the cities a region covers — what you show under its
name.

`stopDownload` cancels and discards what was downloaded; `pauseDownload` keeps it.

!!! danger "`drop` and `clear` delete data"
    `drop(regionId)` deletes one downloaded region, `clear { }` deletes everything the offline cache
    holds. Neither asks for confirmation.

### Network and updates

```kotlin
offlineCacheManager.allowUseCellularNetwork(false)
offlineCacheManager.enableAutoUpdate(true)
```

### Where the cache lives

```kotlin
offlineCacheManager.requestPath { path -> println("cache is at $path") }

offlineCacheManager.computeCacheSize { size -> println("$size bytes") }
```

Moving it — to an SD card, for example — reports progress and can fail:

```kotlin
private val dataMoveListener = DataMoveListener(
    onDataMoveCompleted = { println("moved") },
    onDataMoveError = { error -> report(error.description) },
    onDataMoveProgress = { percent -> showProgress(percent) },
)

offlineCacheManager.moveData(newPath, dataMoveListener.asWeakRef())
```

`setCachePath` points MapKit at a different folder without moving anything:

```kotlin
offlineCacheManager.setCachePath(newPath) { error ->
    if (error != null) report(error.description)
}
```

`isLegacyPath(regionId)` reports whether a region still sits in the layout an older MapKit used.

### `OfflineCacheError`

`description` is a `String?` with what MapKit says went wrong; `error` is the typed
`runtime.Error?` cause when there is one.

!!! note "It compares by value on iOS"
    `OfflineCacheError` wraps an `NSError` on iOS, and `NSError` implements `isEqual:` with value
    semantics. Two distinct failures with the same domain, code and `userInfo` therefore compare
    equal on iOS and unequal on Android. Treat equality as "the same failure", not "the same
    object" — see [Handle identity](overview.md#handle-identity).
