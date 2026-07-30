---
title: "YMKBicycleTrafficTypeSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleTrafficTypeSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleTrafficTypeSegment.html"
---
# YMKBicycleTrafficTypeSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleTrafficTypeSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleTrafficTypeSegment : NSObject
```

Describes part of bicycle path with the same traffic type.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleTrafficTypeSegment *)trafficTypeSegmentWithTrafficType:( YMKBicycleTrafficTypeID)trafficType
                                                                subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKBicycleTrafficTypeID trafficType;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

## Class methods

### trafficTypeSegmentWithTrafficType:subpolyline:

```objectivec
+ (nonnull YMKBicycleTrafficTypeSegment *)trafficTypeSegmentWithTrafficType:( YMKBicycleTrafficTypeID)trafficType
                                                                subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

## Properties

### trafficType

```objectivec
@property (nonatomic, readonly) YMKBicycleTrafficTypeID trafficType;
```

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```
