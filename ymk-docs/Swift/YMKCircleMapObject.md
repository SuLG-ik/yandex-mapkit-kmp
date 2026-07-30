---
title: "YMKCircleMapObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCircleMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCircleMapObject.html"
---
# YMKCircleMapObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCircleMapObject.html)

```swift
class YMKCircleMapObject : YMKMapObject
```

The circle element.

## Summary

### Properties

```swift
var geometry: YMKCircle { get set }
```

```swift
var strokeColor: UIColor { get set }
```

Sets the stroke color

```swift
var strokeWidth: Float { get set }
```

Sets the stroke width in units

```swift
var fillColor: UIColor { get set }
```

Sets the fill color

```swift
var isGeodesic: Bool { get set }
```

The object's geometry can be interpreted in two different ways: <ul><li>If the object mode is 'geodesic', the object's geometry is defined on a sphere

## Properties

### geometry

```swift
var geometry: YMKCircle { get set }
```

### strokeColor

```swift
var strokeColor: UIColor { get set }
```

Sets the stroke color. Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke. default: 0x0066FFFF

### strokeWidth

```swift
var strokeWidth: Float { get set }
```

Sets the stroke width in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1. default: 5

### fillColor

```swift
var fillColor: UIColor { get set }
```

Sets the fill color. default: 0x0066FF99

### isGeodesic

```swift
var isGeodesic: Bool { get set }
```

The object's geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object's geometry is defined on a sphere.
- Otherwise, the object's geometry is defined in projected space.

Default: false.
