---
title: "NavigationLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / NavigationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.html"
---
# NavigationLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

`interface NavigationLayer`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Navigation` | `getNavigation()` |
| `Camera` | `getCamera()` |
| `NavigationLayerMode` | `getMode()`<br>Current view mode |
| `java.util.List<RouteView>` | `getRoutes()`<br>Routes representation on the map. |
| `RouteView` | `getView(@NonNull DrivingRoute route)`<br>Find appearance of route. |
| `void` | `selectRoute(@Nullable RouteView route)`<br>NavigationLayer will try to show as much info as possible about selected route. |
| `RouteView` | `selectedRoute()` |
| `void` | `addRouteViewListener(@NonNull RouteViewListener routeViewListener)`<br>Add this listener if you wish to handle taps on routes. |
| `void` | `removeRouteViewListener(@NonNull RouteViewListener routeViewListener)` |
| `boolean` | `isShowRequestPoints()`<br>Enabled by default. |
| `void` | `setShowRequestPoints(boolean showRequestPoints)` |
| `void` | `selectRoadEvent(@NonNull java.lang.String eventId)` |
| `void` | `deselectRoadEvent()` |
| `void` | `selectRequestPoint(int requestPointIndex)`<br>Selects a request point with specified index. |
| `void` | `deselectRequestPoint()`<br>Deselects selected request point if any. |
| `void` | `addRequestPointListener(@NonNull RequestPointListener requestPointListener)`<br>Add this listener if you wish to handle taps on request points. |
| `void` | `removeRequestPointListener(@NonNull RequestPointListener requestPointListener)` |
| `void` | `addBalloonViewListener(@NonNull BalloonViewListener balloonListener)`<br>The class does not retain the object in the 'balloonListener' parameter. |
| `void` | `removeBalloonViewListener(@NonNull BalloonViewListener balloonListener)` |
| `void` | `addListener(@NonNull NavigationLayerListener navigationLayerListener)`<br>The class does not retain the object in the 'navigationLayerListener' parameter. |
| `void` | `removeListener(@NonNull NavigationLayerListener navigationLayerListener)` |
| `boolean` | `isIsVisible()` |
| `void` | `setIsVisible(boolean isVisible)` |
| `void` | `addPlacemarkTapListener(@NonNull NavigationLayerPlacemarkTapListener roadEventsListener)`<br>The class does not retain the object in the 'roadEventsListener' parameter. |
| `void` | `removePlacemarkTapListener(@NonNull NavigationLayerPlacemarkTapListener roaadEventsListener)`<br>The class does not retain the object in the 'roaadEventsListener' parameter. |
| `void` | `setRoadEventVisibleOnRoute(@NonNull EventTag tag, boolean on)`<br>Sets road events on route tag visibility. |
| `void` | `removeFromMap()`<br>Removes layer from map. |
| `void` | `setShowBalloonsGeometry(boolean enabled)`<br>for debug usage only |
| `void` | `refreshStyle()`<br>Force refresh style for all navigation layer objects. |
| `boolean` | `is2DMode()`<br>When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled<br>Disabled by default |
| `void` | `set2DMode(boolean enabled)` |
| `boolean` | `isValid()`<br>Tells if this **NavigationLayer** is valid or not. |

## Methods

### getNavigation

```java
@NonNull
Navigation getNavigation()
```

### getCamera

```java
@NonNull
Camera getCamera()
```

### getMode

```java
@NonNull
NavigationLayerMode getMode()
```

Current view mode

### getRoutes

```java
@NonNull
java.util.List<RouteView> getRoutes()
```

Routes representation on the map.

### getView

```java
@Nullable
RouteView getView(@NonNull DrivingRoute route)
```

Find appearance of route.

### selectRoute

```java
void selectRoute(@Nullable RouteView route)
```

NavigationLayer will try to show as much info as possible about selected route.

For example if road event placemarks from different routes overlap, road event from selected route will be displayed, conflict will be hidden. None or one route can be selected at the same time. Pass nil/null to unselect route. Can be used only if mode() == NavigationLayerMode.RouteSelection

### selectedRoute

```java
@Nullable
RouteView selectedRoute()
```

### addRouteViewListener

```java
void addRouteViewListener(@NonNull RouteViewListener routeViewListener)
```

Add this listener if you wish to handle taps on routes.

The class does not retain the object in the 'routeViewListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRouteViewListener

```java
void removeRouteViewListener(@NonNull RouteViewListener routeViewListener)
```

### isShowRequestPoints

```java
boolean isShowRequestPoints()
```

Enabled by default.

### setShowRequestPoints

```java
void setShowRequestPoints(boolean showRequestPoints)
```

### selectRoadEvent

```java
void selectRoadEvent(@NonNull java.lang.String eventId)
```

### deselectRoadEvent

```java
void deselectRoadEvent()
```

### selectRequestPoint

```java
void selectRequestPoint(int requestPointIndex)
```

Selects a request point with specified index.

Only one point can be selected at a time. If some other point is selected already, it will be deselected.

### deselectRequestPoint

```java
void deselectRequestPoint()
```

Deselects selected request point if any.

### addRequestPointListener

```java
void addRequestPointListener(@NonNull RequestPointListener requestPointListener)
```

Add this listener if you wish to handle taps on request points.

The class does not retain the object in the 'requestPointListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRequestPointListener

```java
void removeRequestPointListener(@NonNull RequestPointListener requestPointListener)
```

### addBalloonViewListener

```java
void addBalloonViewListener(@NonNull BalloonViewListener balloonListener)
```

The class does not retain the object in the 'balloonListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeBalloonViewListener

```java
void removeBalloonViewListener(@NonNull BalloonViewListener balloonListener)
```

### addListener

```java
void addListener(@NonNull NavigationLayerListener navigationLayerListener)
```

The class does not retain the object in the 'navigationLayerListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull NavigationLayerListener navigationLayerListener)
```

### isIsVisible

```java
boolean isIsVisible()
```

### setIsVisible

```java
void setIsVisible(boolean isVisible)
```

### addPlacemarkTapListener

```java
void addPlacemarkTapListener(@NonNull NavigationLayerPlacemarkTapListener roadEventsListener)
```

The class does not retain the object in the 'roadEventsListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removePlacemarkTapListener

```java
void removePlacemarkTapListener(@NonNull NavigationLayerPlacemarkTapListener roaadEventsListener)
```

The class does not retain the object in the 'roaadEventsListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setRoadEventVisibleOnRoute

```java
void setRoadEventVisibleOnRoute(@NonNull EventTag tag,
                                boolean on)
```

Sets road events on route tag visibility.

Setting local chats visibility will also set visibility for ordinary chats and vice versa. None are visible by default.

### removeFromMap

```java
void removeFromMap()
```

Removes layer from map.

No further operations with layer should be performed.

### setShowBalloonsGeometry

```java
void setShowBalloonsGeometry(boolean enabled)
```

for debug usage only

### refreshStyle

```java
void refreshStyle()
```

Force refresh style for all navigation layer objects.

### is2DMode

```java
boolean is2DMode()
```

When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled

Disabled by default

### set2DMode

```java
void set2DMode(boolean enabled)
```

### isValid

```java
boolean isValid()
```

Tells if this **NavigationLayer** is valid or not.

Any other method (except for this one) called on an invalid **NavigationLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
