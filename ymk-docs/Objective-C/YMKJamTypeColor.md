---
title: "YMKJamTypeColor"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKJamTypeColor"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamTypeColor.html"
---
# YMKJamTypeColor

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamTypeColor.html)

```objectivec
@interface YMKJamTypeColor : NSObject
```

Color for specific level of traffic intensity.

## Summary

### Class methods

```objectivec
+ (nonnull YMKJamTypeColor *)jamTypeColorWithJamType:( YMKJamType)jamType
                                            jamColor:(nonnull UIColor *)jamColor;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKJamType jamType;
```

The type of the traffic jam

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *jamColor;
```

Traffic jam color

## Class methods

### jamTypeColorWithJamType:jamColor:

```objectivec
+ (nonnull YMKJamTypeColor *)jamTypeColorWithJamType:( YMKJamType)jamType
                                            jamColor:(nonnull UIColor *)jamColor;
```

## Properties

### jamType

```objectivec
@property (nonatomic, readonly) YMKJamType jamType;
```

The type of the traffic jam.

### jamColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *jamColor;
```

Traffic jam color.
