---
title: "YMKPolyline"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolyline"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolyline.html"
---
# YMKPolyline

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolyline.html)

```objectivec
@interface YMKPolyline : NSObject
```

A polyline between a number of points. A polyline is drawn between consecutive points.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPolyline *)polylineWithPoints:(nonnull NSArray<YMKPoint *> *)points;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPoint *> *points;
```

The list of points to connect

## Class methods

### polylineWithPoints:

```objectivec
+ (nonnull YMKPolyline *)polylineWithPoints:(nonnull NSArray<YMKPoint *> *)points;
```

## Properties

### points

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPoint *> *points;
```

The list of points to connect.
