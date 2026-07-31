---
title: "YMKMasstransitIndoorSegmentIndoorData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitIndoorSegmentIndoorData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorSegmentIndoorData.html"
---
# YMKMasstransitIndoorSegmentIndoorData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorSegmentIndoorData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitIndoorSegmentIndoorData : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorDataWithIndoorLevel:(nonnull YMKMasstransitIndoorLevel *)indoorLevel;
```

```objectivec
+ (nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorDataWithConnector:(nonnull YMKMasstransitConnector *)connector;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *indoorLevel
```

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitConnector *connector
```

## Class methods

### indoorDataWithIndoorLevel:

```objectivec
+ (nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorDataWithIndoorLevel:(nonnull YMKMasstransitIndoorLevel *)indoorLevel;
```

### indoorDataWithConnector:

```objectivec
+ (nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorDataWithConnector:(nonnull YMKMasstransitConnector *)connector;
```

## Properties

### indoorLevel

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *indoorLevel
```

### connector

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitConnector *connector
```
