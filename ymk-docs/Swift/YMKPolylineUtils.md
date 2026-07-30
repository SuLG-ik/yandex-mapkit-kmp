---
title: "YMKPolylineUtils"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolylineUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineUtils.html"
---
# YMKPolylineUtils

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineUtils.html)

```swift
class YMKPolylineUtils : NSObject
```

## Summary

### Class methods

```swift
class func positionsOfFork(withFirstPolyline firstPolyline: YMKPolyline,
                                     firstPolylinePosition: YMKPolylinePosition,
                                            secondPolyline: YMKPolyline,
                                    secondPolylinePosition: YMKPolylinePosition) -> [YMKPolylinePosition]
```

The position of the fork on the road

```swift
class func advancePolylinePosition(with polyline: YMKPolyline,
                                        position: YMKPolylinePosition,
                                        distance: Double) -> YMKPolylinePosition
```

Advance the polyline position by a specified distance in meters

```swift
class func pointByPolylinePosition(withGeometry geometry: YMKPolyline,
                                                position: YMKPolylinePosition) -> YMKPoint
```

The point in the polyline

```swift
class func distanceBetweenPolylinePositions(with polyline: YMKPolyline,
                                                     from: YMKPolylinePosition,
                                                       to: YMKPolylinePosition) -> Double
```

```swift
class func createPolylineIndex(with polyline: YMKPolyline) -> YMKPolylineIndex
```

Creates PolylineIndex for polyline

## Class methods

### positionsOfFork(withFirstPolyline:firstPolylinePosition:secondPolyline:secondPolylinePosition:)

```swift
class func positionsOfFork(withFirstPolyline firstPolyline: YMKPolyline,
                                     firstPolylinePosition: YMKPolylinePosition,
                                            secondPolyline: YMKPolyline,
                                    secondPolylinePosition: YMKPolylinePosition) -> [YMKPolylinePosition]
```

The position of the fork on the road.

| Parameters |   |
| --- | --- |
| firstPolyline | The first path of the fork. |
| firstPolylinePosition | The position of the first path. |
| secondPolyline | The second path of the fork. |
| secondPolylinePosition | The position of the second path. |

### advancePolylinePosition(with:position:distance:)

```swift
class func advancePolylinePosition(with polyline: YMKPolyline,
                                        position: YMKPolylinePosition,
                                        distance: Double) -> YMKPolylinePosition
```

Advance the polyline position by a specified distance in meters.

| Parameters |   |
| --- | --- |
| polyline | The polyline. |
| position | The polyline position. |
| distance | Distance. |

### pointByPolylinePosition(withGeometry:position:)

```swift
class func pointByPolylinePosition(withGeometry geometry: YMKPolyline,
                                                position: YMKPolylinePosition) -> YMKPoint
```

The point in the polyline.

| Parameters |   |
| --- | --- |
| geometry | The polyline. |
| position | The polyline position. |

### distanceBetweenPolylinePositions(with:from:to:)

```swift
class func distanceBetweenPolylinePositions(with polyline: YMKPolyline,
                                                     from: YMKPolylinePosition,
                                                       to: YMKPolylinePosition) -> Double
```

### createPolylineIndex(with:)

```swift
class func createPolylineIndex(with polyline: YMKPolyline) -> YMKPolylineIndex
```

Creates PolylineIndex for polyline. See YMKPolylineIndex for details.
