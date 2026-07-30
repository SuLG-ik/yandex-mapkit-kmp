---
title: "YMKMasstransitTrafficTypeSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTrafficTypeSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTrafficTypeSegment.html"
---
# YMKMasstransitTrafficTypeSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTrafficTypeSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTrafficTypeSegment : NSObject
```

Describes part of bicycle or scooter path with the same traffic type.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTrafficTypeSegment *)trafficTypeSegmentWithTrafficType:( YMKMasstransitTrafficTypeID)trafficType
                                                                    subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKMasstransitTrafficTypeID trafficType;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

## Class methods

### trafficTypeSegmentWithTrafficType:subpolyline:

```objectivec
+ (nonnull YMKMasstransitTrafficTypeSegment *)trafficTypeSegmentWithTrafficType:( YMKMasstransitTrafficTypeID)trafficType
                                                                    subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

## Properties

### trafficType

```objectivec
@property (nonatomic, readonly) YMKMasstransitTrafficTypeID trafficType;
```

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```
