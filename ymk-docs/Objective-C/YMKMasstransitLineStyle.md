---
title: "YMKMasstransitLineStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitLineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitLineStyle.html"
---
# YMKMasstransitLineStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitLineStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitLineStyle : NSObject
```

Describes the style of line.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitLineStyle *)styleWithColor:(nullable NSNumber *)color;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *color;
```

Line color in #RRGGBB format

## Class methods

### styleWithColor:

```objectivec
+ (nonnull YMKMasstransitLineStyle *)styleWithColor:(nullable NSNumber *)color;
```

## Properties

### color

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *color;
```

Line color in #RRGGBB format.

Optional field, can be nil.
