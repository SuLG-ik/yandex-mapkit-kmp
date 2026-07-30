---
title: "YMKOfflineCacheDataMoveListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKOfflineCacheDataMoveListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheDataMoveListener.html"
---
# YMKOfflineCacheDataMoveListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheDataMoveListener.html)

```objectivec
@protocol YMKOfflineCacheDataMoveListener <NSObject>
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Listener for the information about operations.

## Summary

### Instance methods

```objectivec
- (void)onDataMoveProgressWithPercent:(NSInteger)percent;
```

Called when the operation makes progress

```objectivec
- (void)onDataMoveCompleted;
```

Called when the request is completed

```objectivec
- (void)onDataMoveErrorWithError:(nonnull NSError *)error;
```

Called when an error occurs

## Instance methods

### onDataMoveProgressWithPercent:

```objectivec
- (void)onDataMoveProgressWithPercent:(NSInteger)percent;
```

Called when the operation makes progress. Percent is the rate of completion in the range of 0 to 100.

### onDataMoveCompleted

```objectivec
- (void)onDataMoveCompleted;
```

Called when the request is completed.

### onDataMoveErrorWithError:

```objectivec
- (void)onDataMoveErrorWithError:(nonnull NSError *)error;
```

Called when an error occurs.
