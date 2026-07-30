---
title: "YMKNavigationRouteStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationRouteStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRouteStyle.html"
---
# YMKNavigationRouteStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRouteStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationRouteStyle : NSObject
```

## Summary

### Instance methods

```swift
func setShowRouteWithShowRoute(_ showRoute: Bool)
```

Show or hide route

```swift
func setShowJamsWithShowJams(_ showJams: Bool)
```

Enable or disable traffic jams along route

```swift
func setShowBalloonsWithShowBalloons(_ showBalloons: Bool)
```

Show balloons related to the route

```swift
func setShowRoadEventsWithShowRoadEvents(_ showRoadEvents: Bool)
```

Enable or disable road events on the route

```swift
func setShowTrafficLightsWithShowTrafficLights(_ showTrafficLights: Bool)
```

Show traffic lights along the route

```swift
func setShowCheckpointsWithShowCheckpoints(_ showCheckpoints: Bool)
```

Show checkpoints along the route

```swift
func setShowRailwayCrossingsWithShowRailwayCrossings(_ showRailwayCrossings: Bool)
```

Show railway crossings along the route

```swift
func setShowSpeedBumpsWithShowSpeedBumps(_ showSpeedBumps: Bool)
```

Show railway crossings along the route

```swift
func setShowRoadsInPoorConditionWithShowRoadsInPoorCondition(_ showRoadsInPoorCondition: Bool)
```

Show roads in poor condition along the route

```swift
func setShowManoeuvresWithShowManoeuvres(_ showManoeuvres: Bool)
```

Show manoeuvre arrows along the route

```swift
func setShowTollRoadsWithShowTollRoads(_ showTollRoads: Bool)
```

Show toll roads along the route

```swift
func setShowRestrictedEntriesWithShowRestrictedEntries(_ showRestrictedEntries: Bool)
```

Show restricted entries along the route

```swift
func setMinZoomForTransparentRoutesWithZoom(_ zoom: Float)
```

Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setShowRouteWithShowRoute(_:)

```swift
func setShowRouteWithShowRoute(_ showRoute: Bool)
```

Show or hide route. Enabled by default. Setting it to false will not hide balloons, road events, traffic lights. Hide it manually if needed.

### setShowJamsWithShowJams(_:)

```swift
func setShowJamsWithShowJams(_ showJams: Bool)
```

Enable or disable traffic jams along route. Enabled by default. Unless this is disabled, MapKit forces palette and colors values in routePolyline to draw jams on route. When disabled, you are free to change the routes' colors.

### setShowBalloonsWithShowBalloons(_:)

```swift
func setShowBalloonsWithShowBalloons(_ showBalloons: Bool)
```

Show balloons related to the route. Enabled by default.

### setShowRoadEventsWithShowRoadEvents(_:)

```swift
func setShowRoadEventsWithShowRoadEvents(_ showRoadEvents: Bool)
```

Enable or disable road events on the route. Disabled by default.

### setShowTrafficLightsWithShowTrafficLights(_:)

```swift
func setShowTrafficLightsWithShowTrafficLights(_ showTrafficLights: Bool)
```

Show traffic lights along the route. Disabled by default.

### setShowCheckpointsWithShowCheckpoints(_:)

```swift
func setShowCheckpointsWithShowCheckpoints(_ showCheckpoints: Bool)
```

Show checkpoints along the route. Disabled by default.

### setShowRailwayCrossingsWithShowRailwayCrossings(_:)

```swift
func setShowRailwayCrossingsWithShowRailwayCrossings(_ showRailwayCrossings: Bool)
```

Show railway crossings along the route. Disabled by default.

### setShowSpeedBumpsWithShowSpeedBumps(_:)

```swift
func setShowSpeedBumpsWithShowSpeedBumps(_ showSpeedBumps: Bool)
```

Show railway crossings along the route. Disabled by default.

### setShowRoadsInPoorConditionWithShowRoadsInPoorCondition(_:)

```swift
func setShowRoadsInPoorConditionWithShowRoadsInPoorCondition(_ showRoadsInPoorCondition: Bool)
```

Show roads in poor condition along the route. Disabled by default.

### setShowManoeuvresWithShowManoeuvres(_:)

```swift
func setShowManoeuvresWithShowManoeuvres(_ showManoeuvres: Bool)
```

Show manoeuvre arrows along the route. Disabled by default.

### setShowTollRoadsWithShowTollRoads(_:)

```swift
func setShowTollRoadsWithShowTollRoads(_ showTollRoads: Bool)
```

Show toll roads along the route. Disabled by default.

### setShowRestrictedEntriesWithShowRestrictedEntries(_:)

```swift
func setShowRestrictedEntriesWithShowRestrictedEntries(_ showRestrictedEntries: Bool)
```

Show restricted entries along the route. Disabled by default.

### setMinZoomForTransparentRoutesWithZoom(_:)

```swift
func setMinZoomForTransparentRoutesWithZoom(_ zoom: Float)
```

Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc. This only works when the hd mode is enabled and the map is in driving mode.

Default value is 17.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
