---
title: "YMKDrivingOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingOptions.html"
---
# YMKDrivingOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingOptions : NSObject
```

Driving options.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingOptions *)drivingOptionsWithInitialAzimuth:(nullable NSNumber *)initialAzimuth
                                                    routesCount:(nullable NSNumber *)routesCount
                                                  departureTime:(nullable NSDate *)departureTime
                                             annotationLanguage:(nullable NSNumber *)annotationLanguage
                                                 avoidanceFlags:(nullable YMKDrivingAvoidanceFlags *)avoidanceFlags;
```

### Properties

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *initialAzimuth;
```

Starting location azimuth

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *routesCount;
```

The number of alternatives

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *departureTime;
```

Optional field, can be nil

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *annotationLanguage;
```

A method to set the annotation language

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKDrivingAvoidanceFlags *avoidanceFlags;
```

The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible

## Class methods

### drivingOptionsWithInitialAzimuth:routesCount:departureTime:annotationLanguage:avoidanceFlags:

```objectivec
+ (nonnull YMKDrivingOptions *)drivingOptionsWithInitialAzimuth:(nullable NSNumber *)initialAzimuth
                                                    routesCount:(nullable NSNumber *)routesCount
                                                  departureTime:(nullable NSDate *)departureTime
                                             annotationLanguage:(nullable NSNumber *)annotationLanguage
                                                 avoidanceFlags:(nullable YMKDrivingAvoidanceFlags *)avoidanceFlags;
```

## Properties

### initialAzimuth

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *initialAzimuth;
```

Starting location azimuth.

Optional field, can be nil.

### routesCount

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *routesCount;
```

The number of alternatives.

Optional field, can be nil.

### departureTime

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *departureTime;
```

Optional field, can be nil.

### annotationLanguage

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *annotationLanguage;
```

A method to set the annotation language. lang The annotation language.

Optional field, can be nil.

### avoidanceFlags

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKDrivingAvoidanceFlags *avoidanceFlags;
```

The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible.

Optional field, can be nil.
