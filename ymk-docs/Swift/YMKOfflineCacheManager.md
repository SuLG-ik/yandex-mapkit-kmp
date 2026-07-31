---
title: "YMKOfflineCacheManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKOfflineCacheManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheManager.html"
---
# YMKOfflineCacheManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheManager.html)

```swift
class YMKOfflineCacheManager : NSObject
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Offline cache manager.

## Summary

### Instance methods

```swift
func regions() -> [YMKOfflineCacheRegion]
```

Copying a list of regions from memory

```swift
func allowUseCellularNetwork(withUseCellular useCellular: Bool)
```

Indicates whether to allow downloading using cellular networks (3G, LTE, and other)

```swift
func addRegionListUpdatesListener(with regionListUpdatesListener: any YMKOfflineMapRegionListUpdatesListener)
```

Subscribe on update of region list

The class does not retain the object in the 'regionListUpdatesListener' parameter

```swift
func removeRegionListUpdatesListener(with regionListUpdatesListener: any YMKOfflineMapRegionListUpdatesListener)
```

Unsubscribe from region list update

```swift
func addErrorListenerWith(_ errorListener: any YMKOfflineCacheManagerErrorListener)
```

Subscribe on errors

The class does not retain the object in the 'errorListener' parameter

```swift
func removeErrorListenerWith(_ errorListener: any YMKOfflineCacheManagerErrorListener)
```

Unsubscribe from errors

```swift
func addRegionListener(with regionListener: any YMKOfflineCacheRegionListener)
```

Subscribe on status events

The class does not retain the object in the 'regionListener' parameter

```swift
func removeRegionListener(with regionListener: any YMKOfflineCacheRegionListener)
```

Unsubscribe from status events

```swift
func getCitiesWithRegionId(_ regionId: UInt) -> [String]
```

Returns a list of cities

```swift
func getStateWithRegionId(_ regionId: UInt) -> YMKOfflineCacheRegionState
```

Current region state

```swift
func getDownloadedReleaseTime(withRegionId regionId: UInt) -> Date?
```

Release time of downloaded region files

```swift
func getProgressWithRegionId(_ regionId: UInt) -> Float
```

Current region progress [0,1]

```swift
func startDownload(withRegionId regionId: UInt)
```

Start to download new offline cache for the region or update if region has been downloaded

```swift
func stopDownload(withRegionId regionId: UInt)
```

Stop downloading of region

```swift
func pauseDownload(withRegionId regionId: UInt)
```

Pause downloading of region

```swift
func drop(withRegionId regionId: UInt)
```

Drop region data from the device

```swift
func mayBeOutOfAvailableSpace(withRegionId regionId: UInt) -> Bool
```

Returns true if available disk space might not be enough for installation of the region data

```swift
func isLegacyPath(withRegionId regionId: UInt) -> Bool
```

Returns true if region has files with legacy localized path

```swift
func computeCacheSize(sizeCallback: @escaping YMKOfflineCacheManagerSizeCallback)
```

Calculates the full cache size in bytes

```swift
func requestPath(pathGetterListener: @escaping YMKOfflineCacheManagerPathGetterListener)
```

Provides the data path for offline cache files

```swift
func moveData(withNewPath newPath: String,
                 dataMoveListener: any YMKOfflineCacheDataMoveListener)
```

Moves offline caches to the specified folder

```swift
func setCachePathWithPath(_ path: String,
              pathSetterListener: @escaping YMKOfflineCacheManagerPathSetterListener)
```

Sets a new path for caches

```swift
func enableAutoUpdate(withEnable enable: Bool)
```

Enables autoupdating downloaded caches when they become outdated

```swift
func clear(clearCallback: @escaping YMKOfflineCacheManagerClearCallback)
```

Erases all data for downloads and regions and wipes the cache

```swift
func requestRegionsAtPoint(with point: YMKPoint,
               regionsAtPointCallback: @escaping YMKRegionsAtPointCallback)
```

Provides ids of regions containing specified point

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### regions()

```swift
func regions() -> [YMKOfflineCacheRegion]
```

Copying a list of regions from memory. All changes of regions won't affected on on the collection.

### allowUseCellularNetwork(withUseCellular:)

```swift
func allowUseCellularNetwork(withUseCellular useCellular: Bool)
```

Indicates whether to allow downloading using cellular networks (3G, LTE, and other). Disallowed by default.

### addRegionListUpdatesListener(with:)

```swift
func addRegionListUpdatesListener(with regionListUpdatesListener: any YMKOfflineMapRegionListUpdatesListener)
```

Subscribe on update of region list

The class does not retain the object in the 'regionListUpdatesListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListUpdatesListener(with:)

```swift
func removeRegionListUpdatesListener(with regionListUpdatesListener: any YMKOfflineMapRegionListUpdatesListener)
```

Unsubscribe from region list update

### addErrorListenerWith(_:)

```swift
func addErrorListenerWith(_ errorListener: any YMKOfflineCacheManagerErrorListener)
```

Subscribe on errors

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeErrorListenerWith(_:)

```swift
func removeErrorListenerWith(_ errorListener: any YMKOfflineCacheManagerErrorListener)
```

Unsubscribe from errors

### addRegionListener(with:)

```swift
func addRegionListener(with regionListener: any YMKOfflineCacheRegionListener)
```

Subscribe on status events

The class does not retain the object in the 'regionListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListener(with:)

```swift
func removeRegionListener(with regionListener: any YMKOfflineCacheRegionListener)
```

Unsubscribe from status events

### getCitiesWithRegionId(_:)

```swift
func getCitiesWithRegionId(_ regionId: UInt) -> [String]
```

Returns a list of cities.

### getStateWithRegionId(_:)

```swift
func getStateWithRegionId(_ regionId: UInt) -> YMKOfflineCacheRegionState
```

Current region state

### getDownloadedReleaseTime(withRegionId:)

```swift
func getDownloadedReleaseTime(withRegionId regionId: UInt) -> Date?
```

Release time of downloaded region files

### getProgressWithRegionId(_:)

```swift
func getProgressWithRegionId(_ regionId: UInt) -> Float
```

Current region progress [0,1]. For downloaded files returns 1; If we haven't start download yet, returns 0;

### startDownload(withRegionId:)

```swift
func startDownload(withRegionId regionId: UInt)
```

Start to download new offline cache for the region or update if region has been downloaded

### stopDownload(withRegionId:)

```swift
func stopDownload(withRegionId regionId: UInt)
```

Stop downloading of region

### pauseDownload(withRegionId:)

```swift
func pauseDownload(withRegionId regionId: UInt)
```

Pause downloading of region

### drop(withRegionId:)

```swift
func drop(withRegionId regionId: UInt)
```

Drop region data from the device. If data is being downloaded then downloading is cancelled.

### mayBeOutOfAvailableSpace(withRegionId:)

```swift
func mayBeOutOfAvailableSpace(withRegionId regionId: UInt) -> Bool
```

Returns true if available disk space might not be enough for installation of the region data.

### isLegacyPath(withRegionId:)

```swift
func isLegacyPath(withRegionId regionId: UInt) -> Bool
```

Returns true if region has files with legacy localized path. If region in downloading state result may be incorrect.

### computeCacheSize(sizeCallback:)

```swift
func computeCacheSize(sizeCallback: @escaping YMKOfflineCacheManagerSizeCallback)
```

Calculates the full cache size in bytes.

### requestPath(pathGetterListener:)

```swift
func requestPath(pathGetterListener: @escaping YMKOfflineCacheManagerPathGetterListener)
```

Provides the data path for offline cache files.

### moveData(withNewPath:dataMoveListener:)

```swift
func moveData(withNewPath newPath: String,
                 dataMoveListener: any YMKOfflineCacheDataMoveListener)
```

Moves offline caches to the specified folder. This operation is non-cancellable. If there is already a pending operation to set the cache path, it throws an error (Android). If the application exits before the operation is completed, it does not take effect, but garbage will not be cleared.

The class does not retain the object in the 'dataMoveListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| newPath | New path to store data. |
| dataMoveListener | It will be unsubscribed automatically when the operation is completed or fails with an error. |

### setCachePathWithPath(_:pathSetterListener:)

```swift
func setCachePathWithPath(_ path: String,
              pathSetterListener: @escaping YMKOfflineCacheManagerPathSetterListener)
```

Sets a new path for caches. If the specified path contains an existing cache, this cache will be used; otherwise, a new cache will be initialized.

### enableAutoUpdate(withEnable:)

```swift
func enableAutoUpdate(withEnable enable: Bool)
```

Enables autoupdating downloaded caches when they become outdated.

### clear(clearCallback:)

```swift
func clear(clearCallback: @escaping YMKOfflineCacheManagerClearCallback)
```

Erases all data for downloads and regions and wipes the cache. Forces reloading the list from the remote source

### requestRegionsAtPoint(with:regionsAtPointCallback:)

```swift
func requestRegionsAtPoint(with point: YMKPoint,
               regionsAtPointCallback: @escaping YMKRegionsAtPointCallback)
```

Provides ids of regions containing specified point. Some of the returned regions may not be available in current regions list.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
