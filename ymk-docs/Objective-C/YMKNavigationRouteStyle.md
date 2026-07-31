---
title: "YMKNavigationRouteStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationRouteStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRouteStyle.html"
---
# YMKNavigationRouteStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRouteStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationRouteStyle : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setShowRouteWithShowRoute:(BOOL)showRoute;
```

Show or hide route

```objectivec
- (void)setShowJamsWithShowJams:(BOOL)showJams;
```

Enable or disable traffic jams along route

```objectivec
- (void)setShowBalloonsWithShowBalloons:(BOOL)showBalloons;
```

Show balloons related to the route

```objectivec
- (void)setShowRoadEventsWithShowRoadEvents:(BOOL)showRoadEvents;
```

Enable or disable road events on the route

```objectivec
- (void)setShowTrafficLightsWithShowTrafficLights:(BOOL)showTrafficLights;
```

Show traffic lights along the route

```objectivec
- (void)setShowCheckpointsWithShowCheckpoints:(BOOL)showCheckpoints;
```

Show checkpoints along the route

```objectivec
- (void)setShowRailwayCrossingsWithShowRailwayCrossings:
    (BOOL)showRailwayCrossings;
```

Show railway crossings along the route

```objectivec
- (void)setShowSpeedBumpsWithShowSpeedBumps:(BOOL)showSpeedBumps;
```

Show railway crossings along the route

```objectivec
- (void)setShowRoadsInPoorConditionWithShowRoadsInPoorCondition:
    (BOOL)showRoadsInPoorCondition;
```

Show roads in poor condition along the route

```objectivec
- (void)setShowManoeuvresWithShowManoeuvres:(BOOL)showManoeuvres;
```

Show manoeuvre arrows along the route

```objectivec
- (void)setShowTollRoadsWithShowTollRoads:(BOOL)showTollRoads;
```

Show toll roads along the route

```objectivec
- (void)setShowRestrictedEntriesWithShowRestrictedEntries:
    (BOOL)showRestrictedEntries;
```

Show restricted entries along the route

```objectivec
- (void)setMinZoomForTransparentRoutesWithZoom:(float)zoom;
```

Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setShowRouteWithShowRoute:

```objectivec
- (void)setShowRouteWithShowRoute:(BOOL)showRoute;
```

Show or hide route. Enabled by default. Setting it to false will not hide balloons, road events, traffic lights. Hide it manually if needed.

### setShowJamsWithShowJams:

```objectivec
- (void)setShowJamsWithShowJams:(BOOL)showJams;
```

Enable or disable traffic jams along route. Enabled by default. Unless this is disabled, MapKit forces palette and colors values in routePolyline to draw jams on route. When disabled, you are free to change the routes' colors.

### setShowBalloonsWithShowBalloons:

```objectivec
- (void)setShowBalloonsWithShowBalloons:(BOOL)showBalloons;
```

Show balloons related to the route. Enabled by default.

### setShowRoadEventsWithShowRoadEvents:

```objectivec
- (void)setShowRoadEventsWithShowRoadEvents:(BOOL)showRoadEvents;
```

Enable or disable road events on the route. Disabled by default.

### setShowTrafficLightsWithShowTrafficLights:

```objectivec
- (void)setShowTrafficLightsWithShowTrafficLights:(BOOL)showTrafficLights;
```

Show traffic lights along the route. Disabled by default.

### setShowCheckpointsWithShowCheckpoints:

```objectivec
- (void)setShowCheckpointsWithShowCheckpoints:(BOOL)showCheckpoints;
```

Show checkpoints along the route. Disabled by default.

### setShowRailwayCrossingsWithShowRailwayCrossings:

```objectivec
- (void)setShowRailwayCrossingsWithShowRailwayCrossings:
    (BOOL)showRailwayCrossings;
```

Show railway crossings along the route. Disabled by default.

### setShowSpeedBumpsWithShowSpeedBumps:

```objectivec
- (void)setShowSpeedBumpsWithShowSpeedBumps:(BOOL)showSpeedBumps;
```

Show railway crossings along the route. Disabled by default.

### setShowRoadsInPoorConditionWithShowRoadsInPoorCondition:

```objectivec
- (void)setShowRoadsInPoorConditionWithShowRoadsInPoorCondition:
    (BOOL)showRoadsInPoorCondition;
```

Show roads in poor condition along the route. Disabled by default.

### setShowManoeuvresWithShowManoeuvres:

```objectivec
- (void)setShowManoeuvresWithShowManoeuvres:(BOOL)showManoeuvres;
```

Show manoeuvre arrows along the route. Disabled by default.

### setShowTollRoadsWithShowTollRoads:

```objectivec
- (void)setShowTollRoadsWithShowTollRoads:(BOOL)showTollRoads;
```

Show toll roads along the route. Disabled by default.

### setShowRestrictedEntriesWithShowRestrictedEntries:

```objectivec
- (void)setShowRestrictedEntriesWithShowRestrictedEntries:
    (BOOL)showRestrictedEntries;
```

Show restricted entries along the route. Disabled by default.

### setMinZoomForTransparentRoutesWithZoom:

```objectivec
- (void)setMinZoomForTransparentRoutesWithZoom:(float)zoom;
```

Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc. This only works when the hd mode is enabled and the map is in driving mode.

Default value is 17.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
