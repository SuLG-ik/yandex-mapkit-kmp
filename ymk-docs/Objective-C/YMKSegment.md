---
title: "YMKSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSegment.html"
---
# YMKSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSegment.html)

```objectivec
@interface YMKSegment : NSObject
```

A line between two points.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSegment *)segmentWithStartPoint:(nonnull YMKPoint *)startPoint
                                     endPoint:(nonnull YMKPoint *)endPoint;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *startPoint;
```

Starting point of the segment

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *endPoint;
```

End point of the segment

## Class methods

### segmentWithStartPoint:endPoint:

```objectivec
+ (nonnull YMKSegment *)segmentWithStartPoint:(nonnull YMKPoint *)startPoint
                                     endPoint:(nonnull YMKPoint *)endPoint;
```

## Properties

### startPoint

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *startPoint;
```

Starting point of the segment.

### endPoint

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *endPoint;
```

End point of the segment.
