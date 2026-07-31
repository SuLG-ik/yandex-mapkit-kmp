---
title: "YMKDrivingExitMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingExitMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingExitMetadata.html"
---
# YMKDrivingExitMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingExitMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingExitMetadata : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingExitMetadata *)exitMetadataWithSequentialNumber:(nullable NSNumber *)sequentialNumber
                                             numerationProximityMask:(nullable NSNumber *)numerationProximityMask;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *sequentialNumber;
```

The number in the sequence of consecutive exits

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *numerationProximityMask;
```

Determines whether it is necessary to annotate the exit number in the imm stage

## Class methods

### exitMetadataWithSequentialNumber:numerationProximityMask:

```objectivec
+ (nonnull YMKDrivingExitMetadata *)exitMetadataWithSequentialNumber:(nullable NSNumber *)sequentialNumber
                                             numerationProximityMask:(nullable NSNumber *)numerationProximityMask;
```

## Properties

### sequentialNumber

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *sequentialNumber;
```

The number in the sequence of consecutive exits.

Optional field, can be nil.

### numerationProximityMask

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *numerationProximityMask;
```

Determines whether it is necessary to annotate the exit number in the imm stage.

Optional field, can be nil.
