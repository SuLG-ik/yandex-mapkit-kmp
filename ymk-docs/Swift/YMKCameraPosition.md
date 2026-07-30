---
title: "YMKCameraPosition"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCameraPosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraPosition.html"
---
# YMKCameraPosition

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraPosition.html)

```swift
class YMKCameraPosition : NSObject
```

The position of the camera.

## Summary

### Class methods

```swift
 init(target: YMKPoint, zoom: Float, azimuth: Float, tilt: Float)
```

### Properties

```swift
var target: YMKPoint { get }
```

The point the camera is looking at

```swift
var zoom: Float { get }
```

Zoom level

```swift
var azimuth: Float { get }
```

Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360)

```swift
var tilt: Float { get }
```

Camera tilt in degrees

## Class methods

### init(target:zoom:azimuth:tilt:)

```swift
 init(target: YMKPoint, zoom: Float, azimuth: Float, tilt: Float)
```

## Properties

### target

```swift
var target: YMKPoint { get }
```

The point the camera is looking at.

### zoom

```swift
var zoom: Float { get }
```

Zoom level. 0 corresponds to the whole world displayed in a single tile.

### azimuth

```swift
var azimuth: Float { get }
```

Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360).

### tilt

```swift
var tilt: Float { get }
```

Camera tilt in degrees. 0 means vertical downward.
