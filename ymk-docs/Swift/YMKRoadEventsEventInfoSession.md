---
title: "YMKRoadEventsEventInfoSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoadEventsEventInfoSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsEventInfoSession.html"
---
# YMKRoadEventsEventInfoSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsEventInfoSession.html)

```swift
class YMKRoadEventsEventInfoSession : NSObject
```

Session for requesting road event info.

## Summary

### Instance methods

```swift
func retry(responseHandler: @escaping YMKRoadEventsEventInfoSessionResponseHandler)
```

One of the following errors can happen: YRTNotFoundError, YRTNetworkError, YRTRemoteError

```swift
func cancel()
```

## Instance methods

### retry(responseHandler:)

```swift
func retry(responseHandler: @escaping YMKRoadEventsEventInfoSessionResponseHandler)
```

One of the following errors can happen: YRTNotFoundError, YRTNetworkError, YRTRemoteError.

### cancel()

```swift
func cancel()
```
