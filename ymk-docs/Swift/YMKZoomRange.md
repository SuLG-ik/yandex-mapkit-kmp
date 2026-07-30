---
title: "YMKZoomRange"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKZoomRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKZoomRange.html"
---
# YMKZoomRange

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKZoomRange.html)

```swift
class YMKZoomRange : NSObject
```

Describes the range of zoom levels. Zooming is allowed between zMin and zMax values.

## Summary

### Class methods

```swift
 init(zMin: UInt, zMax: UInt)
```

### Properties

```swift
var zMin: UInt { get }
```

Lower limit of zoom range, inclusive

```swift
var zMax: UInt { get }
```

Upper limit of zoom range, exclusive

## Class methods

### init(zMin:zMax:)

```swift
 init(zMin: UInt, zMax: UInt)
```

## Properties

### zMin

```swift
var zMin: UInt { get }
```

Lower limit of zoom range, inclusive.

### zMax

```swift
var zMax: UInt { get }
```

Upper limit of zoom range, exclusive.
