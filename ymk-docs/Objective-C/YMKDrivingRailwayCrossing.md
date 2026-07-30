---
title: "YMKDrivingRailwayCrossing"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRailwayCrossing"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRailwayCrossing.html"
---
# YMKDrivingRailwayCrossing

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRailwayCrossing.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRailwayCrossing : NSObject
```

A railway crossing object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRailwayCrossing *)railwayCrossingWithType:( YMKDrivingRailwayCrossingType)type
                                                      position:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKDrivingRailwayCrossingType type;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of railway crossing

## Class methods

### railwayCrossingWithType:position:

```objectivec
+ (nonnull YMKDrivingRailwayCrossing *)railwayCrossingWithType:( YMKDrivingRailwayCrossingType)type
                                                      position:(nonnull YMKPolylinePosition *)position;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKDrivingRailwayCrossingType type;
```

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of railway crossing.
