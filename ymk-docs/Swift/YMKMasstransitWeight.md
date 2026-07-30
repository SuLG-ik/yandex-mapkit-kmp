---
title: "YMKMasstransitWeight"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitWeight"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitWeight.html"
---
# YMKMasstransitWeight

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitWeight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitWeight : NSObject
```

Numeric characteristics of a route or a route section.

## Summary

### Class methods

```swift
 init(time: YMKLocalizedValue,
 walkingDistance: YMKLocalizedValue,
 transfersCount: UInt)
```

### Properties

```swift
var time: YMKLocalizedValue { get }
```

Travel time for a route or a route section

```swift
var walkingDistance: YMKLocalizedValue { get }
```

Distance of the pedestrian part of the route or a route section

```swift
var transfersCount: UInt { get }
```

The number of transfers for a route or a route section

## Class methods

### init(time:walkingDistance:transfersCount:)

```swift
 init(time: YMKLocalizedValue,
 walkingDistance: YMKLocalizedValue,
 transfersCount: UInt)
```

## Properties

### time

```swift
var time: YMKLocalizedValue { get }
```

Travel time for a route or a route section.

### walkingDistance

```swift
var walkingDistance: YMKLocalizedValue { get }
```

Distance of the pedestrian part of the route or a route section.

### transfersCount

```swift
var transfersCount: UInt { get }
```

The number of transfers for a route or a route section.
