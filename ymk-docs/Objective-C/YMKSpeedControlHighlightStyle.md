---
title: "YMKSpeedControlHighlightStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpeedControlHighlightStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedControlHighlightStyle.html"
---
# YMKSpeedControlHighlightStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedControlHighlightStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKSpeedControlHighlightStyle : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKSpeedControlHighlightStyle *)speedControlHighlightStyleWithStrokeColor:(nonnull UIColor *)strokeColor
                                                                         strokeWidth:( float)strokeWidth
                                                                           fillColor:(nonnull UIColor *)fillColor
                                                                       maximumRadius:( float)maximumRadius
                                                                   animationDuration:( NSTimeInterval)animationDuration
                                                                     pulsationCenter:( CGPoint)pulsationCenter;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *strokeColor;
```

```objectivec
@property (nonatomic, readonly) float strokeWidth;
```

Sets the stroke width in units

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *fillColor;
```

```objectivec
@property (nonatomic, readonly) float maximumRadius;
```

Sets the maximum circle radius in units

```objectivec
@property (nonatomic, readonly) NSTimeInterval animationDuration;
```

Sets the time it takes for the circle to reach its maximum size

```objectivec
@property (nonatomic, readonly) CGPoint pulsationCenter;
```

Pulsation center on road event pin image

## Class methods

### speedControlHighlightStyleWithStrokeColor:strokeWidth:fillColor:maximumRadius:animationDuration:pulsationCenter:

```objectivec
+ (nonnull YMKSpeedControlHighlightStyle *)speedControlHighlightStyleWithStrokeColor:(nonnull UIColor *)strokeColor
                                                                         strokeWidth:( float)strokeWidth
                                                                           fillColor:(nonnull UIColor *)fillColor
                                                                       maximumRadius:( float)maximumRadius
                                                                   animationDuration:( NSTimeInterval)animationDuration
                                                                     pulsationCenter:( CGPoint)pulsationCenter;
```

## Properties

### strokeColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *strokeColor;
```

### strokeWidth

```objectivec
@property (nonatomic, readonly) float strokeWidth;
```

Sets the stroke width in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### fillColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *fillColor;
```

### maximumRadius

```objectivec
@property (nonatomic, readonly) float maximumRadius;
```

Sets the maximum circle radius in units.

### animationDuration

```objectivec
@property (nonatomic, readonly) NSTimeInterval animationDuration;
```

Sets the time it takes for the circle to reach its maximum size.

### pulsationCenter

```objectivec
@property (nonatomic, readonly) CGPoint pulsationCenter;
```

Pulsation center on road event pin image. (0, 0) is top left and (1.0, 1.0) is bottom right.
