---
title: "YMKDirection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDirection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDirection.html"
---
# YMKDirection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDirection.html)

```objectivec
@interface YMKDirection : NSObject
```

Represents the panorama direction.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDirection *)directionWithAzimuth:( double)azimuth
                                          tilt:( double)tilt;
```

### Properties

```objectivec
@property (nonatomic, readonly) double azimuth;
```

Panorama azimuth

```objectivec
@property (nonatomic, readonly) double tilt;
```

Panorama tilt

## Class methods

### directionWithAzimuth:tilt:

```objectivec
+ (nonnull YMKDirection *)directionWithAzimuth:( double)azimuth
                                          tilt:( double)tilt;
```

## Properties

### azimuth

```objectivec
@property (nonatomic, readonly) double azimuth;
```

Panorama azimuth.

### tilt

```objectivec
@property (nonatomic, readonly) double tilt;
```

Panorama tilt.
