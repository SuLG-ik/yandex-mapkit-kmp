---
title: "YMKOfflineCacheDataMoveListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKOfflineCacheDataMoveListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheDataMoveListener.html"
---
# YMKOfflineCacheDataMoveListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheDataMoveListener.html)

```swift
protocol YMKOfflineCacheDataMoveListener : NSObjectProtocol
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Listener for the information about operations.

## Summary

### Instance methods

```swift
func onDataMoveProgress(withPercent percent: Int)
```

Called when the operation makes progress

```swift
func onDataMoveCompleted()
```

Called when the request is completed

```swift
func onDataMoveErrorWithError(_ error: any Error)
```

Called when an error occurs

## Instance methods

### onDataMoveProgress(withPercent:)

```swift
func onDataMoveProgress(withPercent percent: Int)
```

Called when the operation makes progress. Percent is the rate of completion in the range of 0 to 100.

### onDataMoveCompleted()

```swift
func onDataMoveCompleted()
```

Called when the request is completed.

### onDataMoveErrorWithError(_:)

```swift
func onDataMoveErrorWithError(_ error: any Error)
```

Called when an error occurs.
