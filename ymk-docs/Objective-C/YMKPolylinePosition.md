---
title: "YMKPolylinePosition"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylinePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylinePosition.html"
---
# YMKPolylinePosition

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylinePosition.html)

```objectivec
@interface YMKPolylinePosition : NSObject
```

The position on a polyline.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPolylinePosition *)polylinePositionWithSegmentIndex:( NSUInteger)segmentIndex
                                                  segmentPosition:( double)segmentPosition;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger segmentIndex;
```

Zero-based index of the polyline segment

```objectivec
@property (nonatomic, readonly) double segmentPosition;
```

Position in the specified segment

## Class methods

### polylinePositionWithSegmentIndex:segmentPosition:

```objectivec
+ (nonnull YMKPolylinePosition *)polylinePositionWithSegmentIndex:( NSUInteger)segmentIndex
                                                  segmentPosition:( double)segmentPosition;
```

## Properties

### segmentIndex

```objectivec
@property (nonatomic, readonly) NSUInteger segmentIndex;
```

Zero-based index of the polyline segment.

### segmentPosition

```objectivec
@property (nonatomic, readonly) double segmentPosition;
```

Position in the specified segment. Possible values: from 0 to 1, where 0 is the start of the segment and 1 is the end of it.
