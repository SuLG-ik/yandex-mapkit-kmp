---
title: "YMKJamSegment"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKJamSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKJamSegment.html"
---
# YMKJamSegment

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKJamSegment.html)

```swift
class YMKJamSegment : NSObject
```

A segment of a traffic jam that has specific traffic conditions.

## Summary

### Class methods

```swift
 init(jamType: YMKJamType, speed: Double)
```

### Properties

```swift
var jamType: YMKJamType { get }
```

The type of the traffic jam

```swift
var speed: Double { get }
```

The speed at which traffic is moving

## Class methods

### init(jamType:speed:)

```swift
 init(jamType: YMKJamType, speed: Double)
```

## Properties

### jamType

```swift
var jamType: YMKJamType { get }
```

The type of the traffic jam.

### speed

```swift
var speed: Double { get }
```

The speed at which traffic is moving.
