---
title: "YMKArrowManeuverStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKArrowManeuverStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrowManeuverStyle.html"
---
# YMKArrowManeuverStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKArrowManeuverStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKArrowManeuverStyle : NSObject
```

The style that is used to display arrow maneuvers on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKArrowManeuverStyle *)arrowManeuverStyleWithFillColor:(nonnull UIColor *)fillColor
                                                      outlineColor:(nonnull UIColor *)outlineColor
                                                      outlineWidth:( float)outlineWidth
                                                            length:( float)length
                                                    triangleHeight:( float)triangleHeight
                                                           enabled:( BOOL)enabled;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *fillColor;
```

Fill color of the arrow

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *outlineColor;
```

Color of the arrow's outline

```objectivec
@property (nonatomic, readonly) float outlineWidth;
```

Width of the arrow's outline in units

```objectivec
@property (nonatomic, readonly) float length;
```

Overall length of the arrow (including the tip) in units

```objectivec
@property (nonatomic, readonly) float triangleHeight;
```

Height of the arrow tip in units

```objectivec
@property (nonatomic, readonly) BOOL enabled;
```

Enables/disables arrow maneuvers

## Class methods

### arrowManeuverStyleWithFillColor:outlineColor:outlineWidth:length:triangleHeight:enabled:

```objectivec
+ (nonnull YMKArrowManeuverStyle *)arrowManeuverStyleWithFillColor:(nonnull UIColor *)fillColor
                                                      outlineColor:(nonnull UIColor *)outlineColor
                                                      outlineWidth:( float)outlineWidth
                                                            length:( float)length
                                                    triangleHeight:( float)triangleHeight
                                                           enabled:( BOOL)enabled;
```

## Properties

### fillColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *fillColor;
```

Fill color of the arrow.

### outlineColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *outlineColor;
```

Color of the arrow's outline.

### outlineWidth

```objectivec
@property (nonatomic, readonly) float outlineWidth;
```

Width of the arrow's outline in units.

### length

```objectivec
@property (nonatomic, readonly) float length;
```

Overall length of the arrow (including the tip) in units.

### triangleHeight

```objectivec
@property (nonatomic, readonly) float triangleHeight;
```

Height of the arrow tip in units.

### enabled

```objectivec
@property (nonatomic, readonly) BOOL enabled;
```

Enables/disables arrow maneuvers.
