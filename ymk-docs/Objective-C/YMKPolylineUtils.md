---
title: "YMKPolylineUtils"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylineUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineUtils.html"
---
# YMKPolylineUtils

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineUtils.html)

```objectivec
@interface YMKPolylineUtils : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull NSArray<YMKPolylinePosition *> *)
    positionsOfForkWithFirstPolyline:(nonnull YMKPolyline *)firstPolyline
               firstPolylinePosition:
                   (nonnull YMKPolylinePosition *)firstPolylinePosition
                      secondPolyline:(nonnull YMKPolyline *)secondPolyline
              secondPolylinePosition:
                  (nonnull YMKPolylinePosition *)secondPolylinePosition;
```

The position of the fork on the road

```objectivec
+ (nonnull YMKPolylinePosition *)
    advancePolylinePositionWithPolyline:(nonnull YMKPolyline *)polyline
                               position:(nonnull YMKPolylinePosition *)position
                               distance:(double)distance;
```

Advance the polyline position by a specified distance in meters

```objectivec
+ (nonnull YMKPoint *)
    pointByPolylinePositionWithGeometry:(nonnull YMKPolyline *)geometry
                               position:(nonnull YMKPolylinePosition *)position;
```

The point in the polyline

```objectivec
+ (double)
    distanceBetweenPolylinePositionsWithPolyline:(nonnull YMKPolyline *)polyline
                                            from:(nonnull YMKPolylinePosition *)
                                                     from
                                              to:(nonnull YMKPolylinePosition *)
                                                     to;
```

```objectivec
+ (nonnull YMKPolylineIndex *)createPolylineIndexWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Creates PolylineIndex for polyline

## Class methods

### positionsOfForkWithFirstPolyline:firstPolylinePosition:secondPolyline:secondPolylinePosition:

```objectivec
+ (nonnull NSArray<YMKPolylinePosition *> *)
    positionsOfForkWithFirstPolyline:(nonnull YMKPolyline *)firstPolyline
               firstPolylinePosition:
                   (nonnull YMKPolylinePosition *)firstPolylinePosition
                      secondPolyline:(nonnull YMKPolyline *)secondPolyline
              secondPolylinePosition:
                  (nonnull YMKPolylinePosition *)secondPolylinePosition;
```

The position of the fork on the road.

| Parameters |   |
| --- | --- |
| firstPolyline | The first path of the fork. |
| firstPolylinePosition | The position of the first path. |
| secondPolyline | The second path of the fork. |
| secondPolylinePosition | The position of the second path. |

### advancePolylinePositionWithPolyline:position:distance:

```objectivec
+ (nonnull YMKPolylinePosition *)
    advancePolylinePositionWithPolyline:(nonnull YMKPolyline *)polyline
                               position:(nonnull YMKPolylinePosition *)position
                               distance:(double)distance;
```

Advance the polyline position by a specified distance in meters.

| Parameters |   |
| --- | --- |
| polyline | The polyline. |
| position | The polyline position. |
| distance | Distance. |

### pointByPolylinePositionWithGeometry:position:

```objectivec
+ (nonnull YMKPoint *)
    pointByPolylinePositionWithGeometry:(nonnull YMKPolyline *)geometry
                               position:(nonnull YMKPolylinePosition *)position;
```

The point in the polyline.

| Parameters |   |
| --- | --- |
| geometry | The polyline. |
| position | The polyline position. |

### distanceBetweenPolylinePositionsWithPolyline:from:to:

```objectivec
+ (double)
    distanceBetweenPolylinePositionsWithPolyline:(nonnull YMKPolyline *)polyline
                                            from:(nonnull YMKPolylinePosition *)
                                                     from
                                              to:(nonnull YMKPolylinePosition *)
                                                     to;
```

### createPolylineIndexWithPolyline:

```objectivec
+ (nonnull YMKPolylineIndex *)createPolylineIndexWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Creates PolylineIndex for polyline. See YMKPolylineIndex for details.
