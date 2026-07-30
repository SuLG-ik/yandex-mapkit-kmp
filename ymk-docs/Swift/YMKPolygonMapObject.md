---
title: "YMKPolygonMapObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolygonMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolygonMapObject.html"
---
# YMKPolygonMapObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolygonMapObject.html)

```swift
class YMKPolygonMapObject : YMKMapObject
```

A polygon displayed on the map.

## Summary

### Instance methods

```swift
func setPatternWithAnimatedImage(_ animatedImage: any YRTAnimatedImageProvider,
                                           scale: Float)
```

Sets pattern to fill polygon

```swift
func setPatternWith(_ image: UIImage, scale: Float)
```

Sets pattern to fill polygon

```swift
func resetPattern()
```

Removes pattern

### Properties

```swift
var geometry: YMKPolygon { get set }
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

The object geometry can be interpreted in two different ways: <ul><li>If the object mode is 'geodesic', the object geometry is defined on a sphere

## Instance methods

### setPatternWithAnimatedImage(_:scale:)

```swift
func setPatternWithAnimatedImage(_ animatedImage: any YRTAnimatedImageProvider,
                                           scale: Float)
```

> [!NOTE] Примечание
> Original linear sizes of pattern should be equal to power of 2.

Sets pattern to fill polygon.  @attention Fill color is ignored if a pattern is set.

### setPatternWith(_:scale:)

```swift
func setPatternWith(_ image: UIImage, scale: Float)
```

> [!NOTE] Примечание
> Original linear sizes of pattern should be equal to power of 2.

Sets pattern to fill polygon.  @attention Fill color is ignored if pattern is set.

### resetPattern()

```swift
func resetPattern()
```

Removes pattern.

## Properties

### geometry

```swift
var geometry: YMKPolygon { get set }
```

### strokeColor

```swift
var strokeColor: UIColor { get set }
```

Sets the stroke color. Default: hexademical RGBA code 0x0066FFFF. Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke.

### strokeWidth

```swift
var strokeWidth: Float { get set }
```

Sets the stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### fillColor

```swift
var fillColor: UIColor { get set }
```

> [!NOTE] Примечание
> Fill color is ignored if a pattern is set.

Sets the fill color. Default: hexademical RGBA code 0x0066FF99.

### isGeodesic

```swift
var isGeodesic: Bool { get set }
```

The object geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object geometry is defined on a sphere.
- Otherwise, the object geometry is defined in projected space.

Default: false.
