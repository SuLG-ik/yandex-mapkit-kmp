---
title: "YMKPolylineBuilder"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylineBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineBuilder.html"
---
# YMKPolylineBuilder

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineBuilder.html)

```objectivec
@interface YMKPolylineBuilder : NSObject
```

A builder class for polyline elements.

## Summary

### Instance methods

```objectivec
- (void)appendWithPolyline:(nonnull YMKPolyline *)polyline;
```

Appends a polyline

```objectivec
- (void)appendWithPoint:(nonnull YMKPoint *)point;
```

Appends a point

```objectivec
- (nonnull YMKPolyline *)build;
```

Builds a polyline

## Instance methods

### appendWithPolyline:

```objectivec
- (void)appendWithPolyline:(nonnull YMKPolyline *)polyline;
```

Appends a polyline.

### appendWithPoint:

```objectivec
- (void)appendWithPoint:(nonnull YMKPoint *)point;
```

Appends a point.

### build

```objectivec
- (nonnull YMKPolyline *)build;
```

Builds a polyline.
