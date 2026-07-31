---
title: "YMKPanoramaPosition"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaPosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaPosition.html"
---
# YMKPanoramaPosition

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaPosition.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaPosition : NSObject
```

Position struct

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaPosition *)positionWithPoint:(nonnull YMKPoint *)point
                                          altitude:( double)altitude;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Longitude and latitude, degrees

```objectivec
@property (nonatomic, readonly) double altitude;
```

Altitude, meters

## Class methods

### positionWithPoint:altitude:

```objectivec
+ (nonnull YMKPanoramaPosition *)positionWithPoint:(nonnull YMKPoint *)point
                                          altitude:( double)altitude;
```

## Properties

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Longitude and latitude, degrees.

### altitude

```objectivec
@property (nonatomic, readonly) double altitude;
```

Altitude, meters. Positive is above sea-level
