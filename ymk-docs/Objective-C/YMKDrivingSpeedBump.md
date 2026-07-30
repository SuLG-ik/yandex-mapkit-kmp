---
title: "YMKDrivingSpeedBump"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSpeedBump"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSpeedBump.html"
---
# YMKDrivingSpeedBump

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSpeedBump.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSpeedBump : NSObject
```

A speed bump object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingSpeedBump *)speedBumpWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of speed bump

## Class methods

### speedBumpWithPosition:

```objectivec
+ (nonnull YMKDrivingSpeedBump *)speedBumpWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of speed bump.
