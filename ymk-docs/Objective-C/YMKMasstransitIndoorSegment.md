---
title: "YMKMasstransitIndoorSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitIndoorSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorSegment.html"
---
# YMKMasstransitIndoorSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitIndoorSegment : NSObject
```

Indoor segment of the fitness section.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitIndoorSegment *)indoorSegmentWithIndoorData:(nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorData
                                                         subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitIndoorSegmentIndoorData *indoorData;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

A span of this level on the route geometry

## Class methods

### indoorSegmentWithIndoorData:subpolyline:

```objectivec
+ (nonnull YMKMasstransitIndoorSegment *)indoorSegmentWithIndoorData:(nonnull YMKMasstransitIndoorSegmentIndoorData *)indoorData
                                                         subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

## Properties

### indoorData

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitIndoorSegmentIndoorData *indoorData;
```

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

A span of this level on the route geometry.
