---
title: "YMKDrivingTrafficLight"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingTrafficLight"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingTrafficLight.html"
---
# YMKDrivingTrafficLight

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingTrafficLight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingTrafficLight : NSObject
```

A traffic light object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingTrafficLight *)trafficLightWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the traffic light

## Class methods

### trafficLightWithPosition:

```objectivec
+ (nonnull YMKDrivingTrafficLight *)trafficLightWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the traffic light.
