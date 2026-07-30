---
title: "YMKDrivingManoeuvreVehicleRestriction"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingManoeuvreVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingManoeuvreVehicleRestriction.html"
---
# YMKDrivingManoeuvreVehicleRestriction

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingManoeuvreVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingManoeuvreVehicleRestriction : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingManoeuvreVehicleRestriction *)manoeuvreVehicleRestrictionWithVehicleRestriction:(nonnull YMKDrivingVehicleRestriction *)vehicleRestriction
                                                                                            position:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleRestriction *vehicleRestriction;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

## Class methods

### manoeuvreVehicleRestrictionWithVehicleRestriction:position:

```objectivec
+ (nonnull YMKDrivingManoeuvreVehicleRestriction *)manoeuvreVehicleRestrictionWithVehicleRestriction:(nonnull YMKDrivingVehicleRestriction *)vehicleRestriction
                                                                                            position:(nonnull YMKPolylinePosition *)position;
```

## Properties

### vehicleRestriction

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleRestriction *vehicleRestriction;
```

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```
