---
title: "YMKOfflineCacheManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKOfflineCacheManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheManager.html"
---
# YMKOfflineCacheManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheManager.html)

```objectivec
@interface YMKOfflineCacheManager : NSObject
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Offline cache manager.

## Summary

### Instance methods

```objectivec
- (nonnull NSArray<YMKOfflineCacheRegion *> *)regions;
```

Copying a list of regions from memory

```objectivec
- (void)allowUseCellularNetworkWithUseCellular:(BOOL)useCellular;
```

Indicates whether to allow downloading using cellular networks (3G, LTE, and other)

```objectivec
- (void)addRegionListUpdatesListenerWithRegionListUpdatesListener:
    (nonnull id<YMKOfflineMapRegionListUpdatesListener>)
        regionListUpdatesListener;
```

Subscribe on update of region list

The class does not retain the object in the 'regionListUpdatesListener' parameter

```objectivec
- (void)removeRegionListUpdatesListenerWithRegionListUpdatesListener:
    (nonnull id<YMKOfflineMapRegionListUpdatesListener>)
        regionListUpdatesListener;
```

Unsubscribe from region list update

```objectivec
- (void)addErrorListenerWithErrorListener:
    (nonnull id<YMKOfflineCacheManagerErrorListener>)errorListener;
```

Subscribe on errors

The class does not retain the object in the 'errorListener' parameter

```objectivec
- (void)removeErrorListenerWithErrorListener:
    (nonnull id<YMKOfflineCacheManagerErrorListener>)errorListener;
```

Unsubscribe from errors

```objectivec
- (void)addRegionListenerWithRegionListener:
    (nonnull id<YMKOfflineCacheRegionListener>)regionListener;
```

Subscribe on status events

The class does not retain the object in the 'regionListener' parameter

```objectivec
- (void)removeRegionListenerWithRegionListener:
    (nonnull id<YMKOfflineCacheRegionListener>)regionListener;
```

Unsubscribe from status events

```objectivec
- (nonnull NSArray<NSString *> *)getCitiesWithRegionId:(NSUInteger)regionId;
```

Returns a list of cities

```objectivec
- (YMKOfflineCacheRegionState)getStateWithRegionId:(NSUInteger)regionId;
```

Current region state

```objectivec
- (nullable NSDate *)getDownloadedReleaseTimeWithRegionId:(NSUInteger)regionId;
```

Release time of downloaded region files

```objectivec
- (float)getProgressWithRegionId:(NSUInteger)regionId;
```

Current region progress [0,1]

```objectivec
- (void)startDownloadWithRegionId:(NSUInteger)regionId;
```

Start to download new offline cache for the region or update if region has been downloaded

```objectivec
- (void)stopDownloadWithRegionId:(NSUInteger)regionId;
```

Stop downloading of region

```objectivec
- (void)pauseDownloadWithRegionId:(NSUInteger)regionId;
```

Pause downloading of region

```objectivec
- (void)dropWithRegionId:(NSUInteger)regionId;
```

Drop region data from the device

```objectivec
- (BOOL)mayBeOutOfAvailableSpaceWithRegionId:(NSUInteger)regionId;
```

Returns true if available disk space might not be enough for installation of the region data

```objectivec
- (BOOL)isLegacyPathWithRegionId:(NSUInteger)regionId;
```

Returns true if region has files with legacy localized path

```objectivec
- (void)computeCacheSizeWithSizeCallback:
    (nonnull YMKOfflineCacheManagerSizeCallback)sizeCallback;
```

Calculates the full cache size in bytes

```objectivec
- (void)requestPathWithPathGetterListener:
    (nonnull YMKOfflineCacheManagerPathGetterListener)pathGetterListener;
```

Provides the data path for offline cache files

```objectivec
- (void)moveDataWithNewPath:(nonnull NSString *)newPath
           dataMoveListener:
               (nonnull id<YMKOfflineCacheDataMoveListener>)dataMoveListener;
```

Moves offline caches to the specified folder

```objectivec
- (void)setCachePathWithPath:(nonnull NSString *)path
          pathSetterListener:(nonnull YMKOfflineCacheManagerPathSetterListener)
                                 pathSetterListener;
```

Sets a new path for caches

```objectivec
- (void)enableAutoUpdateWithEnable:(BOOL)enable;
```

Enables autoupdating downloaded caches when they become outdated

```objectivec
- (void)clearWithClearCallback:
    (nonnull YMKOfflineCacheManagerClearCallback)clearCallback;
```

Erases all data for downloads and regions and wipes the cache

```objectivec
- (void)requestRegionsAtPointWithPoint:(nonnull YMKPoint *)point
                regionsAtPointCallback:
                    (nonnull YMKRegionsAtPointCallback)regionsAtPointCallback;
```

Provides ids of regions containing specified point

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### regions

```objectivec
- (nonnull NSArray<YMKOfflineCacheRegion *> *)regions;
```

Copying a list of regions from memory. All changes of regions won't affected on on the collection.

### allowUseCellularNetworkWithUseCellular:

```objectivec
- (void)allowUseCellularNetworkWithUseCellular:(BOOL)useCellular;
```

Indicates whether to allow downloading using cellular networks (3G, LTE, and other). Disallowed by default.

### addRegionListUpdatesListenerWithRegionListUpdatesListener:

```objectivec
- (void)addRegionListUpdatesListenerWithRegionListUpdatesListener:
    (nonnull id<YMKOfflineMapRegionListUpdatesListener>)
        regionListUpdatesListener;
```

Subscribe on update of region list

The class does not retain the object in the 'regionListUpdatesListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListUpdatesListenerWithRegionListUpdatesListener:

```objectivec
- (void)removeRegionListUpdatesListenerWithRegionListUpdatesListener:
    (nonnull id<YMKOfflineMapRegionListUpdatesListener>)
        regionListUpdatesListener;
```

Unsubscribe from region list update

### addErrorListenerWithErrorListener:

```objectivec
- (void)addErrorListenerWithErrorListener:
    (nonnull id<YMKOfflineCacheManagerErrorListener>)errorListener;
```

Subscribe on errors

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeErrorListenerWithErrorListener:

```objectivec
- (void)removeErrorListenerWithErrorListener:
    (nonnull id<YMKOfflineCacheManagerErrorListener>)errorListener;
```

Unsubscribe from errors

### addRegionListenerWithRegionListener:

```objectivec
- (void)addRegionListenerWithRegionListener:
    (nonnull id<YMKOfflineCacheRegionListener>)regionListener;
```

Subscribe on status events

The class does not retain the object in the 'regionListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRegionListenerWithRegionListener:

```objectivec
- (void)removeRegionListenerWithRegionListener:
    (nonnull id<YMKOfflineCacheRegionListener>)regionListener;
```

Unsubscribe from status events

### getCitiesWithRegionId:

```objectivec
- (nonnull NSArray<NSString *> *)getCitiesWithRegionId:(NSUInteger)regionId;
```

Returns a list of cities.

### getStateWithRegionId:

```objectivec
- (YMKOfflineCacheRegionState)getStateWithRegionId:(NSUInteger)regionId;
```

Current region state

### getDownloadedReleaseTimeWithRegionId:

```objectivec
- (nullable NSDate *)getDownloadedReleaseTimeWithRegionId:(NSUInteger)regionId;
```

Release time of downloaded region files

### getProgressWithRegionId:

```objectivec
- (float)getProgressWithRegionId:(NSUInteger)regionId;
```

Current region progress [0,1]. For downloaded files returns 1; If we haven't start download yet, returns 0;

### startDownloadWithRegionId:

```objectivec
- (void)startDownloadWithRegionId:(NSUInteger)regionId;
```

Start to download new offline cache for the region or update if region has been downloaded

### stopDownloadWithRegionId:

```objectivec
- (void)stopDownloadWithRegionId:(NSUInteger)regionId;
```

Stop downloading of region

### pauseDownloadWithRegionId:

```objectivec
- (void)pauseDownloadWithRegionId:(NSUInteger)regionId;
```

Pause downloading of region

### dropWithRegionId:

```objectivec
- (void)dropWithRegionId:(NSUInteger)regionId;
```

Drop region data from the device. If data is being downloaded then downloading is cancelled.

### mayBeOutOfAvailableSpaceWithRegionId:

```objectivec
- (BOOL)mayBeOutOfAvailableSpaceWithRegionId:(NSUInteger)regionId;
```

Returns true if available disk space might not be enough for installation of the region data.

### isLegacyPathWithRegionId:

```objectivec
- (BOOL)isLegacyPathWithRegionId:(NSUInteger)regionId;
```

Returns true if region has files with legacy localized path. If region in downloading state result may be incorrect.

### computeCacheSizeWithSizeCallback:

```objectivec
- (void)computeCacheSizeWithSizeCallback:
    (nonnull YMKOfflineCacheManagerSizeCallback)sizeCallback;
```

Calculates the full cache size in bytes.

### requestPathWithPathGetterListener:

```objectivec
- (void)requestPathWithPathGetterListener:
    (nonnull YMKOfflineCacheManagerPathGetterListener)pathGetterListener;
```

Provides the data path for offline cache files.

### moveDataWithNewPath:dataMoveListener:

```objectivec
- (void)moveDataWithNewPath:(nonnull NSString *)newPath
           dataMoveListener:
               (nonnull id<YMKOfflineCacheDataMoveListener>)dataMoveListener;
```

Moves offline caches to the specified folder. This operation is non-cancellable. If there is already a pending operation to set the cache path, it throws an error (Android). If the application exits before the operation is completed, it does not take effect, but garbage will not be cleared.

The class does not retain the object in the 'dataMoveListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| newPath | New path to store data. |
| dataMoveListener | It will be unsubscribed automatically when the operation is completed or fails with an error. |

### setCachePathWithPath:pathSetterListener:

```objectivec
- (void)setCachePathWithPath:(nonnull NSString *)path
          pathSetterListener:(nonnull YMKOfflineCacheManagerPathSetterListener)
                                 pathSetterListener;
```

Sets a new path for caches. If the specified path contains an existing cache, this cache will be used; otherwise, a new cache will be initialized.

### enableAutoUpdateWithEnable:

```objectivec
- (void)enableAutoUpdateWithEnable:(BOOL)enable;
```

Enables autoupdating downloaded caches when they become outdated.

### clearWithClearCallback:

```objectivec
- (void)clearWithClearCallback:
    (nonnull YMKOfflineCacheManagerClearCallback)clearCallback;
```

Erases all data for downloads and regions and wipes the cache. Forces reloading the list from the remote source

### requestRegionsAtPointWithPoint:regionsAtPointCallback:

```objectivec
- (void)requestRegionsAtPointWithPoint:(nonnull YMKPoint *)point
                regionsAtPointCallback:
                    (nonnull YMKRegionsAtPointCallback)regionsAtPointCallback;
```

Provides ids of regions containing specified point. Some of the returned regions may not be available in current regions list.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
