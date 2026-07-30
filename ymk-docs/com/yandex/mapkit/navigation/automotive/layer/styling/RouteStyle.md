---
title: "RouteStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / RouteStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RouteStyle.html"
---
# RouteStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RouteStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface RouteStyle`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setShowRoute(boolean showRoute)`<br>Show or hide route. |
| `void` | `setShowJams(boolean showJams)`<br>Enable or disable traffic jams along route. |
| `void` | `setShowBalloons(boolean showBalloons)`<br>Show balloons related to the route. |
| `void` | `setShowRoadEvents(boolean showRoadEvents)`<br>Enable or disable road events on the route. |
| `void` | `setShowTrafficLights(boolean showTrafficLights)`<br>Show traffic lights along the route. |
| `void` | `setShowCheckpoints(boolean showCheckpoints)`<br>Show checkpoints along the route. |
| `void` | `setShowRailwayCrossings(boolean showRailwayCrossings)`<br>Show railway crossings along the route. |
| `void` | `setShowSpeedBumps(boolean showSpeedBumps)`<br>Show railway crossings along the route. |
| `void` | `setShowRoadsInPoorCondition(boolean showRoadsInPoorCondition)`<br>Show roads in poor condition along the route. |
| `void` | `setShowManoeuvres(boolean showManoeuvres)`<br>Show manoeuvre arrows along the route. |
| `void` | `setShowTollRoads(boolean showTollRoads)`<br>Show toll roads along the route. |
| `void` | `setShowRestrictedEntries(boolean showRestrictedEntries)`<br>Show restricted entries along the route. |
| `void` | `setMinZoomForTransparentRoutes(float zoom)`<br>Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc. |
| `boolean` | `isValid()`<br>Tells if this **RouteStyle** is valid or not. |

## Methods

### setShowRoute

```java
void setShowRoute(boolean showRoute)
```

Show or hide route.

Enabled by default. Setting it to false will not hide balloons, road events, traffic lights. Hide it manually if needed.

### setShowJams

```java
void setShowJams(boolean showJams)
```

Enable or disable traffic jams along route.

Enabled by default. Unless this is disabled, MapKit forces palette and colors values in routePolyline to draw jams on route. When disabled, you are free to change the routes' colors.

### setShowBalloons

```java
void setShowBalloons(boolean showBalloons)
```

Show balloons related to the route.

Enabled by default.

### setShowRoadEvents

```java
void setShowRoadEvents(boolean showRoadEvents)
```

Enable or disable road events on the route.

Disabled by default.

### setShowTrafficLights

```java
void setShowTrafficLights(boolean showTrafficLights)
```

Show traffic lights along the route.

Disabled by default.

### setShowCheckpoints

```java
void setShowCheckpoints(boolean showCheckpoints)
```

Show checkpoints along the route.

Disabled by default.

### setShowRailwayCrossings

```java
void setShowRailwayCrossings(boolean showRailwayCrossings)
```

Show railway crossings along the route.

Disabled by default.

### setShowSpeedBumps

```java
void setShowSpeedBumps(boolean showSpeedBumps)
```

Show railway crossings along the route.

Disabled by default.

### setShowRoadsInPoorCondition

```java
void setShowRoadsInPoorCondition(boolean showRoadsInPoorCondition)
```

Show roads in poor condition along the route.

Disabled by default.

### setShowManoeuvres

```java
void setShowManoeuvres(boolean showManoeuvres)
```

Show manoeuvre arrows along the route.

Disabled by default.

### setShowTollRoads

```java
void setShowTollRoads(boolean showTollRoads)
```

Show toll roads along the route.

Disabled by default.

### setShowRestrictedEntries

```java
void setShowRestrictedEntries(boolean showRestrictedEntries)
```

Show restricted entries along the route.

Disabled by default.

### setMinZoomForTransparentRoutes

```java
void setMinZoomForTransparentRoutes(float zoom)
```

Set the minimum zoom value, where transparency gets applied to the route in certain places, meaning it gets drawn as if it goes under brigdes, in tunnels, etc.

This only works when the hd mode is enabled and the map is in driving mode.

Default value is 17.

### isValid

```java
boolean isValid()
```

Tells if this **RouteStyle** is valid or not.

Any other method (except for this one) called on an invalid **RouteStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
