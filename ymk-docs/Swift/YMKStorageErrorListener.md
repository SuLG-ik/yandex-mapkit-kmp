---
title: "YMKStorageErrorListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKStorageErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStorageErrorListener.html"
---
# YMKStorageErrorListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStorageErrorListener.html)

```swift
protocol YMKStorageErrorListener : NSObjectProtocol
```

Storage error listener. This is a listener to subscribe to storage errors in managers that control some type of storage.

## Summary

### Instance methods

```swift
func onStorageErrorWithError(_ error: YRTLocalError)
```

Possible error types: - YRTDiskCorruptError: Called if local storage is corrupted

## Instance methods

### onStorageErrorWithError(_:)

```swift
func onStorageErrorWithError(_ error: YRTLocalError)
```

Possible error types: - YRTDiskCorruptError: Called if local storage is corrupted. - YRTDiskFullError: Called if local storage is full. - YRTDiskWriteAccessError: Called if the application cannot get write access to local storage.
