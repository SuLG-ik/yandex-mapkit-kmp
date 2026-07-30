---
title: "YMKDrivingPedestrianCrossing"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingPedestrianCrossing"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingPedestrianCrossing.html"
---
# YMKDrivingPedestrianCrossing

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingPedestrianCrossing.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingPedestrianCrossing : NSObject
```

A pedestrian crossing object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingPedestrianCrossing *)pedestrianCrossingWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of pedestrian crossing

## Class methods

### pedestrianCrossingWithPosition:

```objectivec
+ (nonnull YMKDrivingPedestrianCrossing *)pedestrianCrossingWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of pedestrian crossing.
