---
title: "YMKPanoramaPosition"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaPosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaPosition.html"
---
# YMKPanoramaPosition

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaPosition.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaPosition : NSObject
```

Position struct

## Summary

### Class methods

```swift
 init(point: YMKPoint, altitude: Double)
```

### Properties

```swift
var point: YMKPoint { get }
```

Longitude and latitude, degrees

```swift
var altitude: Double { get }
```

Altitude, meters

## Class methods

### init(point:altitude:)

```swift
 init(point: YMKPoint, altitude: Double)
```

## Properties

### point

```swift
var point: YMKPoint { get }
```

Longitude and latitude, degrees.

### altitude

```swift
var altitude: Double { get }
```

Altitude, meters. Positive is above sea-level
