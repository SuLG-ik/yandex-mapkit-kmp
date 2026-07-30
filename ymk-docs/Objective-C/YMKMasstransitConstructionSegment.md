---
title: "YMKMasstransitConstructionSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitConstructionSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConstructionSegment.html"
---
# YMKMasstransitConstructionSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConstructionSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitConstructionSegment : NSObject
```

Describes part of pedestrian or bicycle path with the same construction.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitConstructionSegment *)constructionSegmentWithSubpolyline:(nonnull YMKSubpolyline *)subpolyline
                                                                 constructionMask:(nonnull YMKMasstransitConstructionMask *)constructionMask;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitConstructionMask *constructionMask;
```

## Class methods

### constructionSegmentWithSubpolyline:constructionMask:

```objectivec
+ (nonnull YMKMasstransitConstructionSegment *)constructionSegmentWithSubpolyline:(nonnull YMKSubpolyline *)subpolyline
                                                                 constructionMask:(nonnull YMKMasstransitConstructionMask *)constructionMask;
```

## Properties

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

### constructionMask

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitConstructionMask *constructionMask;
```
