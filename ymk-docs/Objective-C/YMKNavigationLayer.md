---
title: "YMKNavigationLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationLayer.html"
---
# YMKNavigationLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationLayer.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationLayer : NSObject
```

## Summary

### Instance methods

```objectivec
- (nullable YMKRouteView *)getViewWithRoute:(nonnull YMKDrivingRoute *)route;
```

Find appearance of route

```objectivec
- (void)selectRouteWithRoute:(nullable YMKRouteView *)route;
```

NavigationLayer will try to show as much info as possible about selected route

```objectivec
- (nullable YMKRouteView *)selectedRoute;
```

```objectivec
- (void)addRouteViewListenerWithRouteViewListener:
    (nonnull id<YMKRouteViewListener>)routeViewListener;
```

Add this listener if you wish to handle taps on routes

```objectivec
- (void)removeRouteViewListenerWithRouteViewListener:
    (nonnull id<YMKRouteViewListener>)routeViewListener;
```

```objectivec
- (void)selectRoadEventWithEventId:(nonnull NSString *)eventId;
```

```objectivec
- (void)deselectRoadEvent;
```

```objectivec
- (void)selectRequestPointWithRequestPointIndex:(NSUInteger)requestPointIndex;
```

Selects a request point with specified index

```objectivec
- (void)deselectRequestPoint;
```

Deselects selected request point if any

```objectivec
- (void)addRequestPointListenerWithRequestPointListener:
    (nonnull id<YMKRequestPointListener>)requestPointListener;
```

Add this listener if you wish to handle taps on request points

```objectivec
- (void)removeRequestPointListenerWithRequestPointListener:
    (nonnull id<YMKRequestPointListener>)requestPointListener;
```

```objectivec
- (void)addBalloonViewListenerWithBalloonListener:
    (nonnull id<YMKBalloonViewListener>)balloonListener;
```

The class does not retain the object in the 'balloonListener' parameter

```objectivec
- (void)removeBalloonViewListenerWithBalloonListener:
    (nonnull id<YMKBalloonViewListener>)balloonListener;
```

```objectivec
- (void)addListenerWithNavigationLayerListener:
    (nonnull id<YMKNavigationLayerListener>)navigationLayerListener;
```

The class does not retain the object in the 'navigationLayerListener' parameter

```objectivec
- (void)removeListenerWithNavigationLayerListener:
    (nonnull id<YMKNavigationLayerListener>)navigationLayerListener;
```

```objectivec
- (void)addPlacemarkTapListenerWithRoadEventsListener:
    (nonnull id<YMKNavigationLayerPlacemarkTapListener>)roadEventsListener;
```

The class does not retain the object in the 'roadEventsListener' parameter

```objectivec
- (void)removePlacemarkTapListenerWithRoaadEventsListener:
    (nonnull id<YMKNavigationLayerPlacemarkTapListener>)roaadEventsListener;
```

The class does not retain the object in the 'roaadEventsListener' parameter

```objectivec
- (void)setRoadEventVisibleOnRouteWithTag:(YMKRoadEventsEventTag)tag
                                       on:(BOOL)on;
```

Sets road events on route tag visibility

```objectivec
- (void)removeFromMap;
```

Removes layer from map

```objectivec
- (void)setShowBalloonsGeometryWithEnabled:(BOOL)enabled;
```

for debug usage only

```objectivec
- (void)refreshStyle;
```

Force refresh style for all navigation layer objects

```objectivec
- (BOOL)is2DMode;
```

When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled

Disabled by default

```objectivec
- (void)set2DModeWithEnabled:(BOOL)enabled;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigation *navigation;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKCamera *camera;
```

```objectivec
@property (nonatomic, readonly) YMKNavigationLayerMode mode;
```

Current view mode

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRouteView *> *routes;
```

Routes representation on the map

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isShowRequestPoints) BOOL showRequestPoints;
```

Enabled by default

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isIsVisible)
    BOOL isVisible;
```

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### getViewWithRoute:

```objectivec
- (nullable YMKRouteView *)getViewWithRoute:(nonnull YMKDrivingRoute *)route;
```

Find appearance of route.

### selectRouteWithRoute:

```objectivec
- (void)selectRouteWithRoute:(nullable YMKRouteView *)route;
```

NavigationLayer will try to show as much info as possible about selected route. For example if road event placemarks from different routes overlap, road event from selected route will be displayed, conflict will be hidden. None or one route can be selected at the same time. Pass nil/null to unselect route. Can be used only if mode() == NavigationLayerMode.RouteSelection

### selectedRoute

```objectivec
- (nullable YMKRouteView *)selectedRoute;
```

### addRouteViewListenerWithRouteViewListener:

```objectivec
- (void)addRouteViewListenerWithRouteViewListener:
    (nonnull id<YMKRouteViewListener>)routeViewListener;
```

Add this listener if you wish to handle taps on routes.

The class does not retain the object in the 'routeViewListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRouteViewListenerWithRouteViewListener:

```objectivec
- (void)removeRouteViewListenerWithRouteViewListener:
    (nonnull id<YMKRouteViewListener>)routeViewListener;
```

### selectRoadEventWithEventId:

```objectivec
- (void)selectRoadEventWithEventId:(nonnull NSString *)eventId;
```

### deselectRoadEvent

```objectivec
- (void)deselectRoadEvent;
```

### selectRequestPointWithRequestPointIndex:

```objectivec
- (void)selectRequestPointWithRequestPointIndex:(NSUInteger)requestPointIndex;
```

Selects a request point with specified index. Only one point can be selected at a time. If some other point is selected already, it will be deselected.

### deselectRequestPoint

```objectivec
- (void)deselectRequestPoint;
```

Deselects selected request point if any.

### addRequestPointListenerWithRequestPointListener:

```objectivec
- (void)addRequestPointListenerWithRequestPointListener:
    (nonnull id<YMKRequestPointListener>)requestPointListener;
```

Add this listener if you wish to handle taps on request points.

The class does not retain the object in the 'requestPointListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeRequestPointListenerWithRequestPointListener:

```objectivec
- (void)removeRequestPointListenerWithRequestPointListener:
    (nonnull id<YMKRequestPointListener>)requestPointListener;
```

### addBalloonViewListenerWithBalloonListener:

```objectivec
- (void)addBalloonViewListenerWithBalloonListener:
    (nonnull id<YMKBalloonViewListener>)balloonListener;
```

The class does not retain the object in the 'balloonListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeBalloonViewListenerWithBalloonListener:

```objectivec
- (void)removeBalloonViewListenerWithBalloonListener:
    (nonnull id<YMKBalloonViewListener>)balloonListener;
```

### addListenerWithNavigationLayerListener:

```objectivec
- (void)addListenerWithNavigationLayerListener:
    (nonnull id<YMKNavigationLayerListener>)navigationLayerListener;
```

The class does not retain the object in the 'navigationLayerListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithNavigationLayerListener:

```objectivec
- (void)removeListenerWithNavigationLayerListener:
    (nonnull id<YMKNavigationLayerListener>)navigationLayerListener;
```

### addPlacemarkTapListenerWithRoadEventsListener:

```objectivec
- (void)addPlacemarkTapListenerWithRoadEventsListener:
    (nonnull id<YMKNavigationLayerPlacemarkTapListener>)roadEventsListener;
```

The class does not retain the object in the 'roadEventsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removePlacemarkTapListenerWithRoaadEventsListener:

```objectivec
- (void)removePlacemarkTapListenerWithRoaadEventsListener:
    (nonnull id<YMKNavigationLayerPlacemarkTapListener>)roaadEventsListener;
```

The class does not retain the object in the 'roaadEventsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setRoadEventVisibleOnRouteWithTag:on:

```objectivec
- (void)setRoadEventVisibleOnRouteWithTag:(YMKRoadEventsEventTag)tag
                                       on:(BOOL)on;
```

Sets road events on route tag visibility. Setting local chats visibility will also set visibility for ordinary chats and vice versa. None are visible by default.

### removeFromMap

```objectivec
- (void)removeFromMap;
```

Removes layer from map. No further operations with layer should be performed.

### setShowBalloonsGeometryWithEnabled:

```objectivec
- (void)setShowBalloonsGeometryWithEnabled:(BOOL)enabled;
```

for debug usage only

### refreshStyle

```objectivec
- (void)refreshStyle;
```

Force refresh style for all navigation layer objects.

### is2DMode

```objectivec
- (BOOL)is2DMode;
```

When in 2D mode: - map is switched to 2D mode - 'Free' and 'Following' camera modes have zero tilt - tilt changing gestures are disabled

Disabled by default

### set2DModeWithEnabled:

```objectivec
- (void)set2DModeWithEnabled:(BOOL)enabled;
```

## Properties

### navigation

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigation *navigation;
```

### camera

```objectivec
@property (nonatomic, readonly, nonnull) YMKCamera *camera;
```

### mode

```objectivec
@property (nonatomic, readonly) YMKNavigationLayerMode mode;
```

Current view mode

### routes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRouteView *> *routes;
```

Routes representation on the map.

### showRequestPoints

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isShowRequestPoints) BOOL showRequestPoints;
```

Enabled by default.

### isVisible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isIsVisible)
    BOOL isVisible;
```

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
