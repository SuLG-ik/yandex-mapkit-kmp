---
title: "YMKNavigationLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationLayer.html"
---
# YMKNavigationLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationLayer.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationLayer : NSObject
```

## Summary

### Instance methods

```swift
func getViewWith(_ route: YMKDrivingRoute) -> YMKRouteView?
```

Find appearance of route

```swift
func selectRoute(withRoute route: YMKRouteView?)
```

NavigationLayer will try to show as much info as possible about selected route

```swift
func selectedRoute() -> YMKRouteView?
```

```swift
func addRouteViewListener(with routeViewListener: any YMKRouteViewListener)
```

Add this listener if you wish to handle taps on routes

```swift
func removeRouteViewListener(with routeViewListener: any YMKRouteViewListener)
```

```swift
func selectRoadEvent(withEventId eventId: String)
```

```swift
func deselectRoadEvent()
```

```swift
func selectRequestPoint(withRequestPointIndex requestPointIndex: UInt)
```

Selects a request point with specified index

```swift
func deselectRequestPoint()
```

Deselects selected request point if any

```swift
func addRequestPointListener(with requestPointListener: any YMKRequestPointListener)
```

Add this listener if you wish to handle taps on request points

```swift
func removeRequestPointListener(with requestPointListener: any YMKRequestPointListener)
```

```swift
func addBalloonViewListener(withBalloonListener balloonListener: any YMKBalloonViewListener)
```

The class does not retain the object in the 'balloonListener' parameter

```swift
func removeBalloonViewListener(withBalloonListener balloonListener: any YMKBalloonViewListener)
```

```swift
func addListener(with navigationLayerListener: any YMKNavigationLayerListener)
```

The class does not retain the object in the 'navigationLayerListener' parameter

```swift
func removeListener(with navigationLayerListener: any YMKNavigationLayerListener)
```

```swift
func addPlacemarkTapListener(withRoadEventsListener roadEventsListener: any YMKNavigationLayerPlacemarkTapListener)
```

The class does not retain the object in the 'roadEventsListener' parameter

```swift
func removePlacemarkTapListener(withRoaadEventsListener roaadEventsListener: any YMKNavigationLayerPlacemarkTapListener)
```

The class does not retain the object in the 'roaadEventsListener' parameter

```swift
func setRoadEventVisibleOnRouteWith(_ tag: YMKRoadEventsEventTag, on: Bool)
```

Sets road events on route tag visibility

```swift
func removeFromMap()
```

Removes layer from map

```swift
func setShowBalloonsGeometryWithEnabled(_ enabled: Bool)
```

for debug usage only

```swift
func refreshStyle()
```

Force refresh style for all navigation layer objects

```swift
func is2DMode() -> Bool
```

When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled

Disabled by default

```swift
func set2DMode(withEnabled enabled: Bool)
```

### Properties

```swift
var navigation: YMKNavigation { get }
```

```swift
var camera: YMKCamera { get }
```

```swift
var mode: YMKNavigationLayerMode { get }
```

Current view mode

```swift
var routes: [YMKRouteView] { get }
```

Routes representation on the map

```swift
var isShowRequestPoints: Bool { get set }
```

Enabled by default

```swift
var isIsVisible: Bool { get set }
```

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### getViewWith(_:)

```swift
func getViewWith(_ route: YMKDrivingRoute) -> YMKRouteView?
```

Find appearance of route.

### selectRoute(withRoute:)

```swift
func selectRoute(withRoute route: YMKRouteView?)
```

NavigationLayer will try to show as much info as possible about selected route. For example if road event placemarks from different routes overlap, road event from selected route will be displayed, conflict will be hidden. None or one route can be selected at the same time. Pass nil/null to unselect route. Can be used only if mode() == NavigationLayerMode.RouteSelection

### selectedRoute()

```swift
func selectedRoute() -> YMKRouteView?
```

### addRouteViewListener(with:)

```swift
func addRouteViewListener(with routeViewListener: any YMKRouteViewListener)
```

Add this listener if you wish to handle taps on routes.

The class does not retain the object in the 'routeViewListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRouteViewListener(with:)

```swift
func removeRouteViewListener(with routeViewListener: any YMKRouteViewListener)
```

### selectRoadEvent(withEventId:)

```swift
func selectRoadEvent(withEventId eventId: String)
```

### deselectRoadEvent()

```swift
func deselectRoadEvent()
```

### selectRequestPoint(withRequestPointIndex:)

```swift
func selectRequestPoint(withRequestPointIndex requestPointIndex: UInt)
```

Selects a request point with specified index. Only one point can be selected at a time. If some other point is selected already, it will be deselected.

### deselectRequestPoint()

```swift
func deselectRequestPoint()
```

Deselects selected request point if any.

### addRequestPointListener(with:)

```swift
func addRequestPointListener(with requestPointListener: any YMKRequestPointListener)
```

Add this listener if you wish to handle taps on request points.

The class does not retain the object in the 'requestPointListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRequestPointListener(with:)

```swift
func removeRequestPointListener(with requestPointListener: any YMKRequestPointListener)
```

### addBalloonViewListener(withBalloonListener:)

```swift
func addBalloonViewListener(withBalloonListener balloonListener: any YMKBalloonViewListener)
```

The class does not retain the object in the 'balloonListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeBalloonViewListener(withBalloonListener:)

```swift
func removeBalloonViewListener(withBalloonListener balloonListener: any YMKBalloonViewListener)
```

### addListener(with:)

```swift
func addListener(with navigationLayerListener: any YMKNavigationLayerListener)
```

The class does not retain the object in the 'navigationLayerListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with navigationLayerListener: any YMKNavigationLayerListener)
```

### addPlacemarkTapListener(withRoadEventsListener:)

```swift
func addPlacemarkTapListener(withRoadEventsListener roadEventsListener: any YMKNavigationLayerPlacemarkTapListener)
```

The class does not retain the object in the 'roadEventsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removePlacemarkTapListener(withRoaadEventsListener:)

```swift
func removePlacemarkTapListener(withRoaadEventsListener roaadEventsListener: any YMKNavigationLayerPlacemarkTapListener)
```

The class does not retain the object in the 'roaadEventsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setRoadEventVisibleOnRouteWith(_:on:)

```swift
func setRoadEventVisibleOnRouteWith(_ tag: YMKRoadEventsEventTag, on: Bool)
```

Sets road events on route tag visibility. Setting local chats visibility will also set visibility for ordinary chats and vice versa. None are visible by default.

### removeFromMap()

```swift
func removeFromMap()
```

Removes layer from map. No further operations with layer should be performed.

### setShowBalloonsGeometryWithEnabled(_:)

```swift
func setShowBalloonsGeometryWithEnabled(_ enabled: Bool)
```

for debug usage only

### refreshStyle()

```swift
func refreshStyle()
```

Force refresh style for all navigation layer objects.

### is2DMode()

```swift
func is2DMode() -> Bool
```

When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled

Disabled by default

### set2DMode(withEnabled:)

```swift
func set2DMode(withEnabled enabled: Bool)
```

## Properties

### navigation

```swift
var navigation: YMKNavigation { get }
```

### camera

```swift
var camera: YMKCamera { get }
```

### mode

```swift
var mode: YMKNavigationLayerMode { get }
```

Current view mode

### routes

```swift
var routes: [YMKRouteView] { get }
```

Routes representation on the map.

### isShowRequestPoints

```swift
var isShowRequestPoints: Bool { get set }
```

Enabled by default.

### isIsVisible

```swift
var isIsVisible: Bool { get set }
```

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
