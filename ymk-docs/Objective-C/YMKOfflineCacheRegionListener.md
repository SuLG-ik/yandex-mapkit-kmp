---
title: "YMKOfflineCacheRegionListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKOfflineCacheRegionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegionListener.html"
---
# YMKOfflineCacheRegionListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegionListener.html)

```objectivec
@protocol YMKOfflineCacheRegionListener <NSObject>
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Listener to handle region information.

## Summary

### Instance methods

```objectivec
- (void)onRegionStateChangedWithRegionId:(NSUInteger)regionId;
```

Region state was changed

```objectivec
- (void)onRegionProgressWithRegionId:(NSUInteger)regionId;
```

Progress of specific region download was updated

## Instance methods

### onRegionStateChangedWithRegionId:

```objectivec
- (void)onRegionStateChangedWithRegionId:(NSUInteger)regionId;
```

Region state was changed.

### onRegionProgressWithRegionId:

```objectivec
- (void)onRegionProgressWithRegionId:(NSUInteger)regionId;
```

Progress of specific region download was updated.
