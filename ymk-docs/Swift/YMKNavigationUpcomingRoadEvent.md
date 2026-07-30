---
title: "YMKNavigationUpcomingRoadEvent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationUpcomingRoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationUpcomingRoadEvent.html"
---
# YMKNavigationUpcomingRoadEvent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationUpcomingRoadEvent.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationUpcomingRoadEvent : NSObject
```

## Summary

### Properties

```swift
var event: YMKDrivingEvent { get }
```

```swift
var speedLimitStatus: NSNumber? { get }
```

Optional property, can be nil

```swift
var effectiveSpeedLimit: NSNumber? { get }
```

Effective speed limit

```swift
var position: YMKRoutePosition { get }
```

## Properties

### event

```swift
var event: YMKDrivingEvent { get }
```

### speedLimitStatus

```swift
var speedLimitStatus: NSNumber? { get }
```

Optional property, can be nil.

### effectiveSpeedLimit

```swift
var effectiveSpeedLimit: NSNumber? { get }
```

Effective speed limit. Non-empty only for speed control camera events. If a camera has no speed limit then some standard urban speed limit will be used.

Optional property, can be nil.

### position

```swift
var position: YMKRoutePosition { get }
```
