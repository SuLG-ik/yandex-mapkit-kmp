---
title: "YMKMasstransitRouteStop"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouteStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteStop.html"
---
# YMKMasstransitRouteStop

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouteStop : NSObject
```

Describes a YMKMasstransitStop on a YMKMasstransitRoute.

## Summary

### Class methods

```swift
 init(metadata: YMKMasstransitRouteStopMetadata, position: YMKPoint)
```

### Properties

```swift
var metadata: YMKMasstransitRouteStopMetadata { get }
```

General information about a stop on a route and optionally about its exit

```swift
var position: YMKPoint { get }
```

Coordinates of the stop

## Class methods

### init(metadata:position:)

```swift
 init(metadata: YMKMasstransitRouteStopMetadata, position: YMKPoint)
```

## Properties

### metadata

```swift
var metadata: YMKMasstransitRouteStopMetadata { get }
```

General information about a stop on a route and optionally about its exit

### position

```swift
var position: YMKPoint { get }
```

Coordinates of the stop.
