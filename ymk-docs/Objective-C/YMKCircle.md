---
title: "YMKCircle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCircle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCircle.html"
---
# YMKCircle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCircle.html)

```objectivec
@interface YMKCircle : NSObject
```

A circle around the specified point.

## Summary

### Class methods

```objectivec
+ (nonnull YMKCircle *)circleWithCenter:(nonnull YMKPoint *)center
                                 radius:( float)radius;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *center;
```

The coordinates of the center of the circle

```objectivec
@property (nonatomic, readonly) float radius;
```

The radius of the circle in meters

## Class methods

### circleWithCenter:radius:

```objectivec
+ (nonnull YMKCircle *)circleWithCenter:(nonnull YMKPoint *)center
                                 radius:( float)radius;
```

## Properties

### center

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *center;
```

The coordinates of the center of the circle.

### radius

```objectivec
@property (nonatomic, readonly) float radius;
```

The radius of the circle in meters.
