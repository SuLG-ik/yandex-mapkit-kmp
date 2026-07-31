---
title: "YMKOfflineCacheManagerErrorListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKOfflineCacheManagerErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheManagerErrorListener.html"
---
# YMKOfflineCacheManagerErrorListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheManagerErrorListener.html)

```objectivec
@protocol YMKOfflineCacheManagerErrorListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onErrorWithError:(nonnull NSError *)error;
```

```objectivec
- (void)onRegionErrorWithError:(nonnull NSError *)error
                      regionId:(NSUInteger)regionId;
```

## Instance methods

### onErrorWithError:

```objectivec
- (void)onErrorWithError:(nonnull NSError *)error;
```

| Parameters |   |
| --- | --- |
| error | Error has occurred in offline cache manager. Expected error types: 1. YRTRemoteError 2. YRTLocalError |

### onRegionErrorWithError:regionId:

```objectivec
- (void)onRegionErrorWithError:(nonnull NSError *)error
                      regionId:(NSUInteger)regionId;
```

| Parameters |   |
| --- | --- |
| error | Error has occurred in specific region. Expected error types: 1. YRTRemoteError 2. YRTLocalError |
