---
title: "YMKOfflineCacheRegionState"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKOfflineCacheRegionState"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegionState.html"
---
# YMKOfflineCacheRegionState

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegionState.html)

```objectivec
enum YMKOfflineCacheRegionState : NSUInteger {}
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

The state of the region.

## Summary

### Enum cases

```objectivec
YMKOfflineCacheRegionStateAvailable
```

Available for download on the server

```objectivec
YMKOfflineCacheRegionStateDownloading
```

Download in progress

```objectivec
YMKOfflineCacheRegionStatePaused
```

Download is paused

```objectivec
YMKOfflineCacheRegionStateCompleted
```

Cache data installation is finished

```objectivec
YMKOfflineCacheRegionStateOutdated
```

The region was completed but there is a newer version on the server

```objectivec
YMKOfflineCacheRegionStateUnsupported
```

The region was removed from regions list and will never be updated

```objectivec
YMKOfflineCacheRegionStateNeedUpdate
```

The region is significantly outdated or it contains invalid data

## Enum cases

### YMKOfflineCacheRegionStateAvailable

```objectivec
YMKOfflineCacheRegionStateAvailable
```

Available for download on the server.

### YMKOfflineCacheRegionStateDownloading

```objectivec
YMKOfflineCacheRegionStateDownloading
```

Download in progress.

### YMKOfflineCacheRegionStatePaused

```objectivec
YMKOfflineCacheRegionStatePaused
```

Download is paused.

### YMKOfflineCacheRegionStateCompleted

```objectivec
YMKOfflineCacheRegionStateCompleted
```

Cache data installation is finished.

### YMKOfflineCacheRegionStateOutdated

```objectivec
YMKOfflineCacheRegionStateOutdated
```

The region was completed but there is a newer version on the server.

### YMKOfflineCacheRegionStateUnsupported

```objectivec
YMKOfflineCacheRegionStateUnsupported
```

The region was removed from regions list and will never be updated

### YMKOfflineCacheRegionStateNeedUpdate

```objectivec
YMKOfflineCacheRegionStateNeedUpdate
```

The region is significantly outdated or it contains invalid data. OCM will redownload it automatically if autoupdate enabled.
