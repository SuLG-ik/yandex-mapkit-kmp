---
title: "YMKMapObjectVisitor"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapObjectVisitor"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectVisitor.html"
---
# YMKMapObjectVisitor

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectVisitor.html)

```objectivec
@protocol YMKMapObjectVisitor <NSObject>
```

Used to traverse over the children of the MapObjectCollection.

## Summary

### Instance methods

```objectivec
- (void)onPlacemarkVisitedWithPlacemark:
    (nonnull YMKPlacemarkMapObject *)placemark;
```

Called when a placemark is visited

```objectivec
- (void)onPolylineVisitedWithPolyline:(nonnull YMKPolylineMapObject *)polyline;
```

Called when a polyline is visited

```objectivec
- (void)onPolygonVisitedWithPolygon:(nonnull YMKPolygonMapObject *)polygon;
```

Called when a polygon is visited

```objectivec
- (void)onCircleVisitedWithCircle:(nonnull YMKCircleMapObject *)circle;
```

Called when a circle is visited

```objectivec
- (BOOL)onCollectionVisitStartWithCollection:
    (nonnull YMKMapObjectCollection *)collection;
```

Called for every child collection

```objectivec
- (void)onCollectionVisitEndWithCollection:
    (nonnull YMKMapObjectCollection *)collection;
```

Called for visited collections only

```objectivec
- (BOOL)onClusterizedCollectionVisitStartWithCollection:
    (nonnull YMKClusterizedPlacemarkCollection *)collection;
```

Called for clusterized placemark collection

```objectivec
- (void)onClusterizedCollectionVisitEndWithCollection:
    (nonnull YMKClusterizedPlacemarkCollection *)collection;
```

Called for visited clusterized placemark collections only

## Instance methods

### onPlacemarkVisitedWithPlacemark:

```objectivec
- (void)onPlacemarkVisitedWithPlacemark:
    (nonnull YMKPlacemarkMapObject *)placemark;
```

Called when a placemark is visited.

### onPolylineVisitedWithPolyline:

```objectivec
- (void)onPolylineVisitedWithPolyline:(nonnull YMKPolylineMapObject *)polyline;
```

Called when a polyline is visited.

### onPolygonVisitedWithPolygon:

```objectivec
- (void)onPolygonVisitedWithPolygon:(nonnull YMKPolygonMapObject *)polygon;
```

Called when a polygon is visited.

### onCircleVisitedWithCircle:

```objectivec
- (void)onCircleVisitedWithCircle:(nonnull YMKCircleMapObject *)circle;
```

Called when a circle is visited.

### onCollectionVisitStartWithCollection:

```objectivec
- (BOOL)onCollectionVisitStartWithCollection:
    (nonnull YMKMapObjectCollection *)collection;
```

Called for every child collection. The collection is ignored if this method returns false.

### onCollectionVisitEndWithCollection:

```objectivec
- (void)onCollectionVisitEndWithCollection:
    (nonnull YMKMapObjectCollection *)collection;
```

Called for visited collections only. If an exception occurred during the visit, the method might be skipped.

### onClusterizedCollectionVisitStartWithCollection:

```objectivec
- (BOOL)onClusterizedCollectionVisitStartWithCollection:
    (nonnull YMKClusterizedPlacemarkCollection *)collection;
```

Called for clusterized placemark collection. The collection is ignored if this method returns false.

### onClusterizedCollectionVisitEndWithCollection:

```objectivec
- (void)onClusterizedCollectionVisitEndWithCollection:
    (nonnull YMKClusterizedPlacemarkCollection *)collection;
```

Called for visited clusterized placemark collections only. If an exception occurred during the visit, the method might be skipped.
