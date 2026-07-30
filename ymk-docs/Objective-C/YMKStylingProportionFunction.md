---
title: "YMKStylingProportionFunction"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKStylingProportionFunction"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStylingProportionFunction.html"
---
# YMKStylingProportionFunction

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStylingProportionFunction.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKStylingProportionFunction : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithConstantFunction:(nonnull YMKStylingConstantFunctionPoints *)constantFunction;
```

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithZoomFunction:(nonnull YMKStylingLinearZoomFunctionPoints *)zoomFunction;
```

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithTiltFunction:(nonnull YMKStylingLinearTiltFunctionPoints *)tiltFunction;
```

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithZoomTiltFunction:(nonnull YMKStylingBilinearFunctionMatrix *)zoomTiltFunction;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingConstantFunctionPoints *constantFunction
```

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingLinearZoomFunctionPoints *zoomFunction
```

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingLinearTiltFunctionPoints *tiltFunction
```

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingBilinearFunctionMatrix *zoomTiltFunction
```

## Class methods

### proportionFunctionWithConstantFunction:

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithConstantFunction:(nonnull YMKStylingConstantFunctionPoints *)constantFunction;
```

### proportionFunctionWithZoomFunction:

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithZoomFunction:(nonnull YMKStylingLinearZoomFunctionPoints *)zoomFunction;
```

### proportionFunctionWithTiltFunction:

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithTiltFunction:(nonnull YMKStylingLinearTiltFunctionPoints *)tiltFunction;
```

### proportionFunctionWithZoomTiltFunction:

```objectivec
+ (nonnull YMKStylingProportionFunction *)proportionFunctionWithZoomTiltFunction:(nonnull YMKStylingBilinearFunctionMatrix *)zoomTiltFunction;
```

## Properties

### constantFunction

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingConstantFunctionPoints *constantFunction
```

### zoomFunction

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingLinearZoomFunctionPoints *zoomFunction
```

### tiltFunction

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingLinearTiltFunctionPoints *tiltFunction
```

### zoomTiltFunction

```objectivec
@property (nonatomic, readonly, nullable) YMKStylingBilinearFunctionMatrix *zoomTiltFunction
```
