---
title: "YMKXYPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKXYPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKXYPoint.html"
---
# YMKXYPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKXYPoint.html)

```objectivec
@interface YMKXYPoint : NSObject
```

World coordinates.

## Summary

### Class methods

```objectivec
+ (nonnull YMKXYPoint *)xYPointWithX:( double)x
                                   y:( double)y;
```

### Properties

```objectivec
@property (nonatomic, readonly) double x;
```

The horizontal position of the point

```objectivec
@property (nonatomic, readonly) double y;
```

The vertical position of the point

## Class methods

### xYPointWithX:y:

```objectivec
+ (nonnull YMKXYPoint *)xYPointWithX:( double)x
                                   y:( double)y;
```

## Properties

### x

```objectivec
@property (nonatomic, readonly) double x;
```

The horizontal position of the point.

### y

```objectivec
@property (nonatomic, readonly) double y;
```

The vertical position of the point.
