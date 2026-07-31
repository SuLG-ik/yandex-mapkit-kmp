---
title: "YMKOfflineCacheManagerErrorListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKOfflineCacheManagerErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheManagerErrorListener.html"
---
# YMKOfflineCacheManagerErrorListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheManagerErrorListener.html)

```swift
protocol YMKOfflineCacheManagerErrorListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onErrorWithError(_ error: any Error)
```

```swift
func onRegionErrorWithError(_ error: any Error, regionId: UInt)
```

## Instance methods

### onErrorWithError(_:)

```swift
func onErrorWithError(_ error: any Error)
```

| Parameters |   |
| --- | --- |
| error | Error has occurred in offline cache manager. Expected error types: 1. YRTRemoteError 2. YRTLocalError |

### onRegionErrorWithError(_:regionId:)

```swift
func onRegionErrorWithError(_ error: any Error, regionId: UInt)
```

| Parameters |   |
| --- | --- |
| error | Error has occurred in specific region. Expected error types: 1. YRTRemoteError 2. YRTLocalError |
