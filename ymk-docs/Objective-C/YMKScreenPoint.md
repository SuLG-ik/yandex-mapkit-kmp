---
title: "YMKScreenPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKScreenPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKScreenPoint.html"
---
# YMKScreenPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKScreenPoint.html)

```objectivec
@interface YMKScreenPoint : NSObject
```

A point on the device screen.

## Summary

### Class methods

```objectivec
+ (nonnull YMKScreenPoint *)screenPointWithX:( float)x
                                           y:( float)y;
```

### Properties

```objectivec
@property (nonatomic, readonly) float x;
```

The horizontal position of the point in pixels from the left screen border

```objectivec
@property (nonatomic, readonly) float y;
```

The vertical position of the point in pixels from the top screen border

## Class methods

### screenPointWithX:y:

```objectivec
+ (nonnull YMKScreenPoint *)screenPointWithX:( float)x
                                           y:( float)y;
```

## Properties

### x

```objectivec
@property (nonatomic, readonly) float x;
```

The horizontal position of the point in pixels from the left screen border.

### y

```objectivec
@property (nonatomic, readonly) float y;
```

The vertical position of the point in pixels from the top screen border.
