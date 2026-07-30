---
title: "YMKVisibleRegionUtils"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKVisibleRegionUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVisibleRegionUtils.html"
---
# YMKVisibleRegionUtils

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVisibleRegionUtils.html)

```objectivec
@interface YMKVisibleRegionUtils : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeometry *)toPolygonWithVisibleRegion:
    (nonnull YMKVisibleRegion *)visibleRegion;
```

Converts visible region to polygon geometry

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithVisibleRegion:
    (nonnull YMKVisibleRegion *)visibleRegion;
```

## Class methods

### toPolygonWithVisibleRegion:

```objectivec
+ (nonnull YMKGeometry *)toPolygonWithVisibleRegion:
    (nonnull YMKVisibleRegion *)visibleRegion;
```

Converts visible region to polygon geometry

### getBoundsWithVisibleRegion:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithVisibleRegion:
    (nonnull YMKVisibleRegion *)visibleRegion;
```

**Returns**

BoundingBox for provided YMKVisibleRegion
