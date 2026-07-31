---
title: "YMKMapLoadStatistics"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapLoadStatistics"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapLoadStatistics.html"
---
# YMKMapLoadStatistics

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapLoadStatistics.html)

```swift
class YMKMapLoadStatistics : NSObject
```

The time it took to load map elements.

## Summary

### Class methods

```swift
 init(curZoomGeometryLoaded: TimeInterval,
    curZoomPlacemarksLoaded: TimeInterval,
        curZoomLabelsLoaded: TimeInterval,
      delayedGeometryLoaded: TimeInterval,
        curZoomModelsLoaded: TimeInterval,
                fullyLoaded: TimeInterval,
              fullyAppeared: TimeInterval,
          renderObjectCount: Int,
            tileMemoryUsage: UInt)
```

### Properties

```swift
var curZoomGeometryLoaded: TimeInterval { get }
```

```swift
var curZoomPlacemarksLoaded: TimeInterval { get }
```

```swift
var curZoomLabelsLoaded: TimeInterval { get }
```

```swift
var delayedGeometryLoaded: TimeInterval { get }
```

The time it took to load delayed geometry

```swift
var curZoomModelsLoaded: TimeInterval { get }
```

The time it took to load models

```swift
var fullyLoaded: TimeInterval { get }
```

The time it took to load all map objects

```swift
var fullyAppeared: TimeInterval { get }
```

The time it took for all map objects to appear

```swift
var renderObjectCount: Int { get }
```

```swift
var tileMemoryUsage: UInt { get }
```

Tile memory usage in bytes

## Class methods

### init(curZoomGeometryLoaded:curZoomPlacemarksLoaded:curZoomLabelsLoaded:delayedGeometryLoaded:curZoomModelsLoaded:fullyLoaded:fullyAppeared:renderObjectCount:tileMemoryUsage:)

```swift
 init(curZoomGeometryLoaded: TimeInterval,
    curZoomPlacemarksLoaded: TimeInterval,
        curZoomLabelsLoaded: TimeInterval,
      delayedGeometryLoaded: TimeInterval,
        curZoomModelsLoaded: TimeInterval,
                fullyLoaded: TimeInterval,
              fullyAppeared: TimeInterval,
          renderObjectCount: Int,
            tileMemoryUsage: UInt)
```

## Properties

### curZoomGeometryLoaded

```swift
var curZoomGeometryLoaded: TimeInterval { get }
```

### curZoomPlacemarksLoaded

```swift
var curZoomPlacemarksLoaded: TimeInterval { get }
```

### curZoomLabelsLoaded

```swift
var curZoomLabelsLoaded: TimeInterval { get }
```

### delayedGeometryLoaded

```swift
var delayedGeometryLoaded: TimeInterval { get }
```

The time it took to load delayed geometry.

### curZoomModelsLoaded

```swift
var curZoomModelsLoaded: TimeInterval { get }
```

The time it took to load models.

### fullyLoaded

```swift
var fullyLoaded: TimeInterval { get }
```

The time it took to load all map objects.

### fullyAppeared

```swift
var fullyAppeared: TimeInterval { get }
```

The time it took for all map objects to appear.

### renderObjectCount

```swift
var renderObjectCount: Int { get }
```

### tileMemoryUsage

```swift
var tileMemoryUsage: UInt { get }
```

Tile memory usage in bytes
