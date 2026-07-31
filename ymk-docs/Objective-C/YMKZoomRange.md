---
title: "YMKZoomRange"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKZoomRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKZoomRange.html"
---
# YMKZoomRange

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKZoomRange.html)

```objectivec
@interface YMKZoomRange : NSObject
```

Describes the range of zoom levels. Zooming is allowed between zMin and zMax values.

## Summary

### Class methods

```objectivec
+ (nonnull YMKZoomRange *)zoomRangeWithZMin:( NSUInteger)zMin
                                       zMax:( NSUInteger)zMax;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger zMin;
```

Lower limit of zoom range, inclusive

```objectivec
@property (nonatomic, readonly) NSUInteger zMax;
```

Upper limit of zoom range, exclusive

## Class methods

### zoomRangeWithZMin:zMax:

```objectivec
+ (nonnull YMKZoomRange *)zoomRangeWithZMin:( NSUInteger)zMin
                                       zMax:( NSUInteger)zMax;
```

## Properties

### zMin

```objectivec
@property (nonatomic, readonly) NSUInteger zMin;
```

Lower limit of zoom range, inclusive.

### zMax

```objectivec
@property (nonatomic, readonly) NSUInteger zMax;
```

Upper limit of zoom range, exclusive.
