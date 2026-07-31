---
title: "YMKNavigationJamStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationJamStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationJamStyle.html"
---
# YMKNavigationJamStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationJamStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationJamStyle : NSObject
```

The style that is used to display traffic intensity.

## Summary

### Instance methods

```objectivec
- (void)setColorsWithColors:(nonnull NSArray<YMKJamTypeColor *> *)colors;
```

Collection of colors for traffic intensity

```objectivec
- (void)setGradientLengthWithGradientLength:(float)gradientLength;
```

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setColorsWithColors:

```objectivec
- (void)setColorsWithColors:(nonnull NSArray<YMKJamTypeColor *> *)colors;
```

Collection of colors for traffic intensity.

### setGradientLengthWithGradientLength:

```objectivec
- (void)setGradientLengthWithGradientLength:(float)gradientLength;
```

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
