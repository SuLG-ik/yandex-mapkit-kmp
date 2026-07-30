---
title: "OfflineCacheManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / OfflineCacheManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/OfflineCacheManager.html"
---
# OfflineCacheManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/OfflineCacheManager.html)

**Package** com.yandex.mapkit.offline_cache

`interface OfflineCacheManager`

Offline cache manager.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<Region>` | `regions()`<br>Copying a list of regions from memory. |
| `void` | `allowUseCellularNetwork(boolean useCellular)`<br>Indicates whether to allow downloading using cellular networks (3G, LTE, and other). |
| `void` | `addRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)`<br>Subscribe on update of region list<br>The class does not retain the object in the 'regionListUpdatesListener' parameter. |
| `void` | `removeRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)`<br>Unsubscribe from region list update |
| `void` | `addErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)`<br>Subscribe on errors<br>The class does not retain the object in the 'errorListener' parameter. |
| `void` | `removeErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)`<br>Unsubscribe from errors |
| `void` | `addRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)`<br>Subscribe on status events<br>The class does not retain the object in the 'regionListener' parameter. |
| `void` | `removeRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)`<br>Unsubscribe from status events |
| `java.util.List<java.lang.String>` | `getCities(int regionId)`<br>Returns a list of cities. |
| `RegionState` | `getState(int regionId)`<br>Current region state |
| `java.lang.Long` | `getDownloadedReleaseTime(int regionId)`<br>Release time of downloaded region files |
| `float` | `getProgress(int regionId)`<br>Current region progress [0,1]. |
| `void` | `startDownload(int regionId)`<br>Start to download new offline cache for the region or update if region has been downloaded |
| `void` | `stopDownload(int regionId)`<br>Stop downloading of region |
| `void` | `pauseDownload(int regionId)`<br>Pause downloading of region |
| `void` | `drop(int regionId)`<br>Drop region data from the device. |
| `boolean` | `mayBeOutOfAvailableSpace(int regionId)`<br>Returns true if available disk space might not be enough for installation of the region data. |
| `boolean` | `isLegacyPath(int regionId)`<br>Returns true if region has files with legacy localized path. |
| `void` | `computeCacheSize(@NonNull SizeListener callback)`<br>Calculates the full cache size in bytes. |
| `void` | `requestPath(@NonNull PathGetterListener callback)`<br>Provides the data path for offline cache files. |
| `void` | `moveData(@NonNull java.lang.String newPath, @NonNull java.lang.ref.WeakReference<DataMoveListener> dataMoveListener)`<br>Moves offline caches to the specified folder. |
| `void` | `setCachePath(@NonNull java.lang.String path, @NonNull PathSetterListener pathSetterListener)`<br>Sets a new path for caches. |
| `void` | `enableAutoUpdate(boolean enable)`<br>Enables autoupdating downloaded caches when they become outdated. |
| `void` | `clear(@NonNull ClearListener callback)`<br>Erases all data for downloads and regions and wipes the cache. |
| `void` | `requestRegionsAtPoint(@NonNull Point point, @NonNull RegionsAtPointListener callback)`<br>Provides ids of regions containing specified point. |
| `boolean` | `isValid()`<br>Tells if this **OfflineCacheManager** is valid or not. |

## Methods

### regions

```java
@NonNull
java.util.List<Region> regions()
```

Copying a list of regions from memory.

All changes of regions won't affected on on the collection.

### allowUseCellularNetwork

```java
void allowUseCellularNetwork(boolean useCellular)
```

Indicates whether to allow downloading using cellular networks (3G, LTE, and other).

Disallowed by default.

### addRegionListUpdatesListener

```java
void addRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)
```

Subscribe on update of region list

The class does not retain the object in the 'regionListUpdatesListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListUpdatesListener

```java
void removeRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)
```

Unsubscribe from region list update

### addErrorListener

```java
void addErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)
```

Subscribe on errors

The class does not retain the object in the 'errorListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeErrorListener

```java
void removeErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)
```

Unsubscribe from errors

### addRegionListener

```java
void addRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)
```

Subscribe on status events

The class does not retain the object in the 'regionListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListener

```java
void removeRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)
```

Unsubscribe from status events

### getCities

```java
@NonNull
java.util.List<java.lang.String> getCities(int regionId)
```

Returns a list of cities.

### getState

```java
@NonNull
RegionState getState(int regionId)
```

Current region state

### getDownloadedReleaseTime

```java
@Nullable
java.lang.Long getDownloadedReleaseTime(int regionId)
```

Release time of downloaded region files

### getProgress

```java
float getProgress(int regionId)
```

Current region progress [0,1].

For downloaded files returns 1; If we haven't start download yet, returns 0;

### startDownload

```java
void startDownload(int regionId)
```

Start to download new offline cache for the region or update if region has been downloaded

### stopDownload

```java
void stopDownload(int regionId)
```

Stop downloading of region

### pauseDownload

```java
void pauseDownload(int regionId)
```

Pause downloading of region

### drop

```java
void drop(int regionId)
```

Drop region data from the device.

If data is being downloaded then downloading is cancelled.

### mayBeOutOfAvailableSpace

```java
boolean mayBeOutOfAvailableSpace(int regionId)
```

Returns true if available disk space might not be enough for installation of the region data.

### isLegacyPath

```java
boolean isLegacyPath(int regionId)
```

Returns true if region has files with legacy localized path.

If region in downloading state result may be incorrect.

### computeCacheSize

```java
void computeCacheSize(@NonNull SizeListener callback)
```

Calculates the full cache size in bytes.

### requestPath

```java
void requestPath(@NonNull PathGetterListener callback)
```

Provides the data path for offline cache files.

### moveData

```java
void moveData(@NonNull java.lang.String newPath,
              @NonNull java.lang.ref.WeakReference<DataMoveListener> dataMoveListener)
```

Moves offline caches to the specified folder.

This operation is non-cancellable. If there is already a pending operation to set the cache path, it throws an error (Android). If the application exits before the operation is completed, it does not take effect, but garbage will not be cleared.

The class does not retain the object in the 'dataMoveListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `newPath` | New path to store data. |
| `dataMoveListener` | It will be unsubscribed automatically when the operation is completed or fails with an error. |

### setCachePath

```java
void setCachePath(@NonNull java.lang.String path,
                  @NonNull PathSetterListener pathSetterListener)
```

Sets a new path for caches.

If the specified path contains an existing cache, this cache will be used; otherwise, a new cache will be initialized.

### enableAutoUpdate

```java
void enableAutoUpdate(boolean enable)
```

Enables autoupdating downloaded caches when they become outdated.

### clear

```java
void clear(@NonNull ClearListener callback)
```

Erases all data for downloads and regions and wipes the cache.

Forces reloading the list from the remote source

### requestRegionsAtPoint

```java
void requestRegionsAtPoint(@NonNull Point point,
                           @NonNull RegionsAtPointListener callback)
```

Provides ids of regions containing specified point.

Some of the returned regions may not be available in current regions list.

### isValid

```java
boolean isValid()
```

Tells if this **OfflineCacheManager** is valid or not.

Any other method (except for this one) called on an invalid **OfflineCacheManager** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
