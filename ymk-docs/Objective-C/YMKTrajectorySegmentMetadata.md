---
title: "YMKTrajectorySegmentMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTrajectorySegmentMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrajectorySegmentMetadata.html"
---
# YMKTrajectorySegmentMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrajectorySegmentMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTrajectorySegmentMetadata : NSObject <YMKBaseMetadata>
```

This struct is here to automatically generate protobuf parsing functions It is not to be used in platform code

## Summary

### Class methods

```objectivec
+ (nonnull YMKTrajectorySegmentMetadata *)trajectorySegmentMetadataWithTime:( long long)time
                                                                   duration:( NSUInteger)duration;
```

### Properties

```objectivec
@property (nonatomic, readonly) long long time;
```

```objectivec
@property (nonatomic, readonly) NSUInteger duration;
```

## Class methods

### trajectorySegmentMetadataWithTime:duration:

```objectivec
+ (nonnull YMKTrajectorySegmentMetadata *)trajectorySegmentMetadataWithTime:( long long)time
                                                                   duration:( NSUInteger)duration;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly) long long time;
```

### duration

```objectivec
@property (nonatomic, readonly) NSUInteger duration;
```
