---
title: "YMKStylingBilinearFunctionMatrix"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKStylingBilinearFunctionMatrix"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStylingBilinearFunctionMatrix.html"
---
# YMKStylingBilinearFunctionMatrix

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStylingBilinearFunctionMatrix.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKStylingBilinearFunctionMatrix : NSObject
```

defines function `func(zoom, tilt)` as `func(zooms[x], tilts[y]) == points[x][y]` for all x in [0, zooms.size()), y in [0, tilts.size()) https://en.wikipedia.org/wiki/Bilinear_interpolation

## Summary

### Class methods

```swift
 init(zooms: [NSNumber], tilts: [NSNumber], points: [[NSNumber]])
```

### Properties

```swift
var zooms: [NSNumber] { get }
```

```swift
var tilts: [NSNumber] { get }
```

```swift
var points: [[NSNumber]] { get }
```

requires: points

## Class methods

### init(zooms:tilts:points:)

```swift
 init(zooms: [NSNumber], tilts: [NSNumber], points: [[NSNumber]])
```

## Properties

### zooms

```swift
var zooms: [NSNumber] { get }
```

### tilts

```swift
var tilts: [NSNumber] { get }
```

### points

```swift
var points: [[NSNumber]] { get }
```

requires: points.size() == zooms.size() subpoints.size() == tilts.size() for all subpoints in points
