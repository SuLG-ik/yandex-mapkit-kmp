---
title: "YMKMasstransitTransportContourStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportContourStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportContourStyle.html"
---
# YMKMasstransitTransportContourStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportContourStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportContourStyle : NSObject
```

Describes the style of transport contour objects

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportContourStyle *)styleWithMainColor:(nullable NSNumber *)mainColor
                                                     mainColorNight:(nullable NSNumber *)mainColorNight;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *mainColor;
```

Describes the main color of transport contour

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *mainColorNight;
```

Optional field, can be nil

## Class methods

### styleWithMainColor:mainColorNight:

```objectivec
+ (nonnull YMKMasstransitTransportContourStyle *)styleWithMainColor:(nullable NSNumber *)mainColor
                                                     mainColorNight:(nullable NSNumber *)mainColorNight;
```

## Properties

### mainColor

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *mainColor;
```

Describes the main color of transport contour. Main color is used to identify the object among others. For example, the color of MCD line icon meant to be the main color of the contour. Presented in versions for light and dark themes.

Optional field, can be nil.

### mainColorNight

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *mainColorNight;
```

Optional field, can be nil.
