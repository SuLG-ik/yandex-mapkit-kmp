---
title: "YMKDrivingActionMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingActionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingActionMetadata.html"
---
# YMKDrivingActionMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingActionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingActionMetadata : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithUturnMetadata:(nonnull YMKDrivingUturnMetadata *)uturnMetadata;
```

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithLeaveRoundaboutMetadata:(nonnull YMKDrivingLeaveRoundaboutMetadata *)leaveRoundaboutMetadata;
```

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithTurnMetadata:(nonnull YMKDrivingTurnMetadata *)turnMetadata;
```

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithExitMetadata:(nonnull YMKDrivingExitMetadata *)exitMetadata;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingUturnMetadata *uturnMetadata
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingLeaveRoundaboutMetadata *leaveRoundaboutMetadata
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingTurnMetadata *turnMetadata
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingExitMetadata *exitMetadata
```

## Class methods

### actionMetadataWithUturnMetadata:

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithUturnMetadata:(nonnull YMKDrivingUturnMetadata *)uturnMetadata;
```

### actionMetadataWithLeaveRoundaboutMetadata:

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithLeaveRoundaboutMetadata:(nonnull YMKDrivingLeaveRoundaboutMetadata *)leaveRoundaboutMetadata;
```

### actionMetadataWithTurnMetadata:

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithTurnMetadata:(nonnull YMKDrivingTurnMetadata *)turnMetadata;
```

### actionMetadataWithExitMetadata:

```objectivec
+ (nonnull YMKDrivingActionMetadata *)actionMetadataWithExitMetadata:(nonnull YMKDrivingExitMetadata *)exitMetadata;
```

## Properties

### uturnMetadata

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingUturnMetadata *uturnMetadata
```

### leaveRoundaboutMetadata

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingLeaveRoundaboutMetadata *leaveRoundaboutMetadata
```

### turnMetadata

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingTurnMetadata *turnMetadata
```

### exitMetadata

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingExitMetadata *exitMetadata
```
