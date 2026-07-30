---
title: "YMKPlacemarksStyler"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarksStyler"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarksStyler.html"
---
# YMKPlacemarksStyler

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarksStyler.html)

```objectivec
@interface YMKPlacemarksStyler : NSObject
```

Represents a styler for all placemarks in the map object collection, including placemarks in child collections. When a new placemark is added to a collection, the placemark tries to get style properties from the collection where it has been added. If this collection doesn't have a style property, the placemark tries to get it from the closest parent collection. If none of these collections have a specific style property, the placemark sets the default value for this property.

## Summary

### Instance methods

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Sets piecewise linear scale, depending on the zoom

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setScaleFunctionWithPoints:

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Sets piecewise linear scale, depending on the zoom. The 'points' must be sorted by x; x coordinates must be unique. If zoom < minZoom(points) or zoom > maxZoom(points), it is set within the defined bounds before applying the function. By default, the scale function is defined by a single point (1, 1). If points is null or points.empty(), it resets the function to the default. If points.size() == 1, the scale is constant and equals point.y.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
