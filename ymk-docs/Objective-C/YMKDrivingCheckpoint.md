---
title: "YMKDrivingCheckpoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingCheckpoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingCheckpoint.html"
---
# YMKDrivingCheckpoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingCheckpoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingCheckpoint : NSObject
```

A checkpoint object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingCheckpoint *)checkpointWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the checkpoint

## Class methods

### checkpointWithPosition:

```objectivec
+ (nonnull YMKDrivingCheckpoint *)checkpointWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the checkpoint.
