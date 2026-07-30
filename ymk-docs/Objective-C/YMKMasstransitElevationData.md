---
title: "YMKMasstransitElevationData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitElevationData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitElevationData.html"
---
# YMKMasstransitElevationData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitElevationData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitElevationData : NSObject
```

Information of elevation gain in loss in a fitness section

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitElevationData *)elevationDataWithTotalAscent:(nonnull YMKLocalizedValue *)totalAscent
                                                         totalDescent:(nonnull YMKLocalizedValue *)totalDescent
                                                                steps:(nullable YMKLocalizedValue *)steps
                                                         kilocalories:(nonnull YMKLocalizedValue *)kilocalories
                                                      inclineSections:(nonnull NSArray<YMKMasstransitInclineSection *> *)inclineSections
                                                    elevationSegments:(nonnull NSArray<YMKMasstransitElevationPoint *> *)elevationSegments;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *totalAscent;
```

Total ascent in meters

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *totalDescent;
```

Total descent in meters

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *steps;
```

The number of steps required to cover the distance for an average person

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *kilocalories;
```

The number of kilocalories consumed by an average person to cover the distance

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitInclineSection *> *inclineSections;
```

List of sections with notable incline

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitElevationPoint *> *elevationSegments;
```

List of elevation for each point of the section polyline

## Class methods

### elevationDataWithTotalAscent:totalDescent:steps:kilocalories:inclineSections:elevationSegments:

```objectivec
+ (nonnull YMKMasstransitElevationData *)elevationDataWithTotalAscent:(nonnull YMKLocalizedValue *)totalAscent
                                                         totalDescent:(nonnull YMKLocalizedValue *)totalDescent
                                                                steps:(nullable YMKLocalizedValue *)steps
                                                         kilocalories:(nonnull YMKLocalizedValue *)kilocalories
                                                      inclineSections:(nonnull NSArray<YMKMasstransitInclineSection *> *)inclineSections
                                                    elevationSegments:(nonnull NSArray<YMKMasstransitElevationPoint *> *)elevationSegments;
```

## Properties

### totalAscent

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *totalAscent;
```

Total ascent in meters

### totalDescent

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *totalDescent;
```

Total descent in meters

### steps

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *steps;
```

The number of steps required to cover the distance for an average person

Optional field, can be nil.

### kilocalories

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *kilocalories;
```

The number of kilocalories consumed by an average person to cover the distance

### inclineSections

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitInclineSection *> *inclineSections;
```

List of sections with notable incline

### elevationSegments

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitElevationPoint *> *elevationSegments;
```

List of elevation for each point of the section polyline
