---
title: "YMKArrow"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKArrow"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrow.html"
---
# YMKArrow

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrow.html)

```objectivec
@interface YMKArrow : NSObject
```

The arrow element.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Arrow center

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *fillColor;
```

Arrow fill color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *outlineColor;
```

Color of the arrow's outline

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

The width of the outline in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float length;
```

The overall length of the arrow (including the tip) in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Arrow visibility

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float triangleHeight;
```

Describes height of the arrowhead in units

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Arrow center.

### fillColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *fillColor;
```

Arrow fill color.

### outlineColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *outlineColor;
```

Color of the arrow's outline. Default: white.

### outlineWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

The width of the outline in units. Default: 2.

### length

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float length;
```

The overall length of the arrow (including the tip) in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera tilt is equal to 0 and the scale factor is equal to 1.

### visible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Arrow visibility. Default: true.

### triangleHeight

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float triangleHeight;
```

Describes height of the arrowhead in units. Default: 0.2 * length.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
