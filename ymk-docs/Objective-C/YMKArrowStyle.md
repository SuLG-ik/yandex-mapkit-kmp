---
title: "YMKArrowStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKArrowStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrowStyle.html"
---
# YMKArrowStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrowStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKArrowStyle : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setOutlineWidthWithOutlineWidth:
    (nonnull YMKStylingProportionFunction *)outlineWidth;
```

Width of the arrow's outline in units

```objectivec
- (void)setLengthWithLength:(nonnull YMKStylingProportionFunction *)length;
```

Overall length of the arrow (including the tip) in units

```objectivec
- (void)setTriangleHeightWithTriangleHeight:
    (nonnull YMKStylingProportionFunction *)triangleHeight;
```

Height of the arrow tip in units

```objectivec
- (void)setFillColorWithFillColor:(nonnull UIColor *)fillColor;
```

Fill color of the arrow

```objectivec
- (void)setOutlineColorWithOutlineColor:(nonnull UIColor *)outlineColor;
```

Color of the arrow's outline

```objectivec
- (void)setMinZoomVisibleWithMinZoom:(nullable NSNumber *)minZoom;
```

Minimal zoom for maneuvers to be visible

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setOutlineWidthWithOutlineWidth:

```objectivec
- (void)setOutlineWidthWithOutlineWidth:
    (nonnull YMKStylingProportionFunction *)outlineWidth;
```

Width of the arrow's outline in units. Default: 0

### setLengthWithLength:

```objectivec
- (void)setLengthWithLength:(nonnull YMKStylingProportionFunction *)length;
```

Overall length of the arrow (including the tip) in units. Default: constantValue: 90

### setTriangleHeightWithTriangleHeight:

```objectivec
- (void)setTriangleHeightWithTriangleHeight:
    (nonnull YMKStylingProportionFunction *)triangleHeight;
```

Height of the arrow tip in units. Default: constantValue: 24

### setFillColorWithFillColor:

```objectivec
- (void)setFillColorWithFillColor:(nonnull UIColor *)fillColor;
```

Fill color of the arrow. Default: RGBA 0xFFFFFFFF.

### setOutlineColorWithOutlineColor:

```objectivec
- (void)setOutlineColorWithOutlineColor:(nonnull UIColor *)outlineColor;
```

Color of the arrow's outline. Default: RGBA 0x000000FF.

### setMinZoomVisibleWithMinZoom:

```objectivec
- (void)setMinZoomVisibleWithMinZoom:(nullable NSNumber *)minZoom;
```

Minimal zoom for maneuvers to be visible. Default: null

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
