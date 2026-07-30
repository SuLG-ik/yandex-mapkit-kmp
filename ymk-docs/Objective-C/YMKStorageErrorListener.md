---
title: "YMKStorageErrorListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKStorageErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStorageErrorListener.html"
---
# YMKStorageErrorListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStorageErrorListener.html)

```objectivec
@protocol YMKStorageErrorListener <NSObject>
```

Storage error listener. This is a listener to subscribe to storage errors in managers that control some type of storage.

## Summary

### Instance methods

```objectivec
- (void)onStorageErrorWithError:(nonnull YRTLocalError *)error;
```

Possible error types: - YRTDiskCorruptError: Called if local storage is corrupted

## Instance methods

### onStorageErrorWithError:

```objectivec
- (void)onStorageErrorWithError:(nonnull YRTLocalError *)error;
```

Possible error types: - YRTDiskCorruptError: Called if local storage is corrupted. - YRTDiskFullError: Called if local storage is full. - YRTDiskWriteAccessError: Called if the application cannot get write access to local storage.
