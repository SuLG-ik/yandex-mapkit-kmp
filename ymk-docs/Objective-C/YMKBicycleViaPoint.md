---
title: "YMKBicycleViaPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleViaPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleViaPoint.html"
---
# YMKBicycleViaPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleViaPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleViaPoint : NSObject
```

Via points (throughpoints) are key points on the route geometry that the route passes through. Via points are taken from the request.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleViaPoint *)viaPointWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Via point position on the route geometry

## Class methods

### viaPointWithPosition:

```objectivec
+ (nonnull YMKBicycleViaPoint *)viaPointWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Via point position on the route geometry.
