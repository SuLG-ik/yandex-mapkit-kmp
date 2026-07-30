---
title: "YMKMapObjectVisitor"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapObjectVisitor"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectVisitor.html"
---
# YMKMapObjectVisitor

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectVisitor.html)

```swift
protocol YMKMapObjectVisitor : NSObjectProtocol
```

Used to traverse over the children of the MapObjectCollection.

## Summary

### Instance methods

```swift
func onPlacemarkVisited(withPlacemark placemark: YMKPlacemarkMapObject)
```

Called when a placemark is visited

```swift
func onPolylineVisited(withPolyline polyline: YMKPolylineMapObject)
```

Called when a polyline is visited

```swift
func onPolygonVisited(withPolygon polygon: YMKPolygonMapObject)
```

Called when a polygon is visited

```swift
func onCircleVisited(withCircle circle: YMKCircleMapObject)
```

Called when a circle is visited

```swift
func onCollectionVisitStart(with collection: YMKMapObjectCollection) -> Bool
```

Called for every child collection

```swift
func onCollectionVisitEnd(with collection: YMKMapObjectCollection)
```

Called for visited collections only

```swift
func onClusterizedCollectionVisitStart(with collection: YMKClusterizedPlacemarkCollection) -> Bool
```

Called for clusterized placemark collection

```swift
func onClusterizedCollectionVisitEnd(with collection: YMKClusterizedPlacemarkCollection)
```

Called for visited clusterized placemark collections only

## Instance methods

### onPlacemarkVisited(withPlacemark:)

```swift
func onPlacemarkVisited(withPlacemark placemark: YMKPlacemarkMapObject)
```

Called when a placemark is visited.

### onPolylineVisited(withPolyline:)

```swift
func onPolylineVisited(withPolyline polyline: YMKPolylineMapObject)
```

Called when a polyline is visited.

### onPolygonVisited(withPolygon:)

```swift
func onPolygonVisited(withPolygon polygon: YMKPolygonMapObject)
```

Called when a polygon is visited.

### onCircleVisited(withCircle:)

```swift
func onCircleVisited(withCircle circle: YMKCircleMapObject)
```

Called when a circle is visited.

### onCollectionVisitStart(with:)

```swift
func onCollectionVisitStart(with collection: YMKMapObjectCollection) -> Bool
```

Called for every child collection. The collection is ignored if this method returns false.

### onCollectionVisitEnd(with:)

```swift
func onCollectionVisitEnd(with collection: YMKMapObjectCollection)
```

Called for visited collections only. If an exception occurred during the visit, the method might be skipped.

### onClusterizedCollectionVisitStart(with:)

```swift
func onClusterizedCollectionVisitStart(with collection: YMKClusterizedPlacemarkCollection) -> Bool
```

Called for clusterized placemark collection. The collection is ignored if this method returns false.

### onClusterizedCollectionVisitEnd(with:)

```swift
func onClusterizedCollectionVisitEnd(with collection: YMKClusterizedPlacemarkCollection)
```

Called for visited clusterized placemark collections only. If an exception occurred during the visit, the method might be skipped.
