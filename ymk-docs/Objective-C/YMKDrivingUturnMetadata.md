---
title: "YMKDrivingUturnMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingUturnMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingUturnMetadata.html"
---
# YMKDrivingUturnMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingUturnMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingUturnMetadata : NSObject
```

The length of the U-turn.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingUturnMetadata *)uturnMetadataWithLength:( double)length;
```

### Properties

```objectivec
@property (nonatomic, readonly) double length;
```

The length of the turn

## Class methods

### uturnMetadataWithLength:

```objectivec
+ (nonnull YMKDrivingUturnMetadata *)uturnMetadataWithLength:( double)length;
```

## Properties

### length

```objectivec
@property (nonatomic, readonly) double length;
```

The length of the turn.
