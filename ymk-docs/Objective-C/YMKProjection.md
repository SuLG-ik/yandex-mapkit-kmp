---
title: "YMKProjection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKProjection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKProjection.html"
---
# YMKProjection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKProjection.html)

```objectivec
@interface YMKProjection : NSObject
```

Makes two conversions: world->XY and XY->world, where XY are tile indexes. There are two main derived classes: spherical mercator (google, osm) and wgs84 mercator (yandex).

## Summary

### Instance methods

```objectivec
- (nonnull YMKXYPoint *)worldToXYWithGeoPoint:(nonnull YMKPoint *)geoPoint
                                         zoom:(NSInteger)zoom;
```

Converts the world coordinates to a flat world position

```objectivec
- (nonnull YMKPoint *)xyToWorldWithXyPoint:(nonnull YMKXYPoint *)xyPoint
                                      zoom:(NSInteger)zoom;
```

Converts the flat world position to world coordinates

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### worldToXYWithGeoPoint:zoom:

```objectivec
- (nonnull YMKXYPoint *)worldToXYWithGeoPoint:(nonnull YMKPoint *)geoPoint
                                         zoom:(NSInteger)zoom;
```

Converts the world coordinates to a flat world position.

### xyToWorldWithXyPoint:zoom:

```objectivec
- (nonnull YMKPoint *)xyToWorldWithXyPoint:(nonnull YMKXYPoint *)xyPoint
                                      zoom:(NSInteger)zoom;
```

Converts the flat world position to world coordinates.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
