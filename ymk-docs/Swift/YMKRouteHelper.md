---
title: "YMKRouteHelper"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRouteHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteHelper.html"
---
# YMKRouteHelper

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteHelper.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKRouteHelper : NSObject
```

## Summary

### Class methods

```swift
class func createDefaultJamStyle() -> YMKJamStyle
```

Creates a default traffic style

```swift
class func createDisabledJamStyle() -> YMKJamStyle
```

Creates a disabled traffic jams style

```swift
class func createDefaultManeuverStyle() -> YMKManeuverStyle
```

Creates a default maneuver style

```swift
class func updatePolyline(withPolyline polyline: YMKPolylineMapObject,
                                          route: YMKDrivingRoute,
                                          style: YMKJamStyle,
                                 updateGeometry: Bool)
```

Sets a new geometry and colors for a polyline

```swift
class func addManeuvers(withPolyline polyline: YMKPolylineMapObject,
                                        route: YMKDrivingRoute)
```

Add maneuvers from provided route as arrows Behaviour is undefined if route

```swift
class func addJams(withPolyline polyline: YMKPolylineMapObject,
                                   route: YMKDrivingRoute)
```

Add jams from provided route as stroke colors Behaviour is undefined if route

```swift
class func applyJamStyle(withPolyline polyline: YMKPolylineMapObject,
                                         style: YMKJamStyle)
```

Applies the traffic jam style

```swift
class func applyManeuverStyle(withPolyline polyline: YMKPolylineMapObject,
                                              style: YMKManeuverStyle)
```

Applies a maneuver style

## Class methods

### createDefaultJamStyle()

```swift
class func createDefaultJamStyle() -> YMKJamStyle
```

Creates a default traffic style. Default values: colors : Blocked : 0x000000ff, Free : 0x00ff00ff, Hard : 0xff0000ff, Light : 0xffff00ff, Unknown : 0x909090ff, VeryHard : 0xa00000ff

### createDisabledJamStyle()

```swift
class func createDisabledJamStyle() -> YMKJamStyle
```

Creates a disabled traffic jams style. Colors : Blocked : 0x909090ff, Free : 0x909090ff, Hard : 0x909090ff, Light : 0x909090ff, Unknown : 0x909090ff, VeryHard : 0x909090ff

### createDefaultManeuverStyle()

```swift
class func createDefaultManeuverStyle() -> YMKManeuverStyle
```

Creates a default maneuver style.

Default values for ArrowManeuverStyle: fillColor : 0x000000ff outlineColor : 0xffffffff outlineWidth : 2.f length : 80 triangleHeight : 16 enabled : false

### updatePolyline(withPolyline:route:style:updateGeometry:)

```swift
class func updatePolyline(withPolyline polyline: YMKPolylineMapObject,
                                          route: YMKDrivingRoute,
                                          style: YMKJamStyle,
                                 updateGeometry: Bool)
```

Sets a new geometry and colors for a polyline. If style.enabled = false, the polyline is drawn using the color for the Unknown traffic jam type. If updateGeometry = false, but route geometry differs from polyline geometry, then behaviour is undefined.

### addManeuvers(withPolyline:route:)

```swift
class func addManeuvers(withPolyline polyline: YMKPolylineMapObject,
                                        route: YMKDrivingRoute)
```

Add maneuvers from provided route as arrows Behaviour is undefined if route.geometry does not equals polyline.geometry.

### addJams(withPolyline:route:)

```swift
class func addJams(withPolyline polyline: YMKPolylineMapObject,
                                   route: YMKDrivingRoute)
```

Add jams from provided route as stroke colors Behaviour is undefined if route.geometry does not equals polyline.geometry.

### applyJamStyle(withPolyline:style:)

```swift
class func applyJamStyle(withPolyline polyline: YMKPolylineMapObject,
                                         style: YMKJamStyle)
```

Applies the traffic jam style. Updates colors for traffic jam types provided in the style parameter.

### applyManeuverStyle(withPolyline:style:)

```swift
class func applyManeuverStyle(withPolyline polyline: YMKPolylineMapObject,
                                              style: YMKManeuverStyle)
```

Applies a maneuver style. This method should be called every time after updatePolyline with updateGeometry == true occurs; otherwise, the default maneuver style is applied.
