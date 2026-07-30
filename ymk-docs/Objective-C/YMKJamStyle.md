---
title: "YMKJamStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKJamStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamStyle.html"
---
# YMKJamStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamStyle.html)

```objectivec
@interface YMKJamStyle : NSObject
```

The style that is used to display traffic intensity.

## Summary

### Class methods

```objectivec
+ (nonnull YMKJamStyle *)jamStyleWithColors:(nonnull NSArray<YMKJamTypeColor *> *)colors;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamTypeColor *> *colors;
```

Collection of colors for traffic intensity

## Class methods

### jamStyleWithColors:

```objectivec
+ (nonnull YMKJamStyle *)jamStyleWithColors:(nonnull NSArray<YMKJamTypeColor *> *)colors;
```

## Properties

### colors

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamTypeColor *> *colors;
```

Collection of colors for traffic intensity.
