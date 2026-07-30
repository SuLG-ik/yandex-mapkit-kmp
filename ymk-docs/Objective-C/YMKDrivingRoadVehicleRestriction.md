---
title: "YMKDrivingRoadVehicleRestriction"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRoadVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoadVehicleRestriction.html"
---
# YMKDrivingRoadVehicleRestriction

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoadVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRoadVehicleRestriction : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRoadVehicleRestriction *)roadVehicleRestrictionWithVehicleRestriction:(nonnull YMKDrivingVehicleRestriction *)vehicleRestriction
                                                                                  position:(nonnull YMKSubpolyline *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleRestriction *vehicleRestriction;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *position;
```

## Class methods

### roadVehicleRestrictionWithVehicleRestriction:position:

```objectivec
+ (nonnull YMKDrivingRoadVehicleRestriction *)roadVehicleRestrictionWithVehicleRestriction:(nonnull YMKDrivingVehicleRestriction *)vehicleRestriction
                                                                                  position:(nonnull YMKSubpolyline *)position;
```

## Properties

### vehicleRestriction

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleRestriction *vehicleRestriction;
```

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *position;
```
