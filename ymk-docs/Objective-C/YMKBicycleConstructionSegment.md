---
title: "YMKBicycleConstructionSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleConstructionSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleConstructionSegment.html"
---
# YMKBicycleConstructionSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleConstructionSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleConstructionSegment : NSObject
```

Describes part of bicycle path with the same construction.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleConstructionSegment *)constructionSegmentWithConstruction:( YMKBicycleConstructionID)construction
                                                                   subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKBicycleConstructionID construction;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

## Class methods

### constructionSegmentWithConstruction:subpolyline:

```objectivec
+ (nonnull YMKBicycleConstructionSegment *)constructionSegmentWithConstruction:( YMKBicycleConstructionID)construction
                                                                   subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

## Properties

### construction

```objectivec
@property (nonatomic, readonly) YMKBicycleConstructionID construction;
```

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```
