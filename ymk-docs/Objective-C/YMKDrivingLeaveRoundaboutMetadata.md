---
title: "YMKDrivingLeaveRoundaboutMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingLeaveRoundaboutMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLeaveRoundaboutMetadata.html"
---
# YMKDrivingLeaveRoundaboutMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLeaveRoundaboutMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingLeaveRoundaboutMetadata : NSObject
```

The number of the exit for leaving the roundabout.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingLeaveRoundaboutMetadata *)leaveRoundaboutMetadataWithExitNumber:( NSUInteger)exitNumber;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger exitNumber;
```

The exit number

## Class methods

### leaveRoundaboutMetadataWithExitNumber:

```objectivec
+ (nonnull YMKDrivingLeaveRoundaboutMetadata *)leaveRoundaboutMetadataWithExitNumber:( NSUInteger)exitNumber;
```

## Properties

### exitNumber

```objectivec
@property (nonatomic, readonly) NSUInteger exitNumber;
```

The exit number.
