---
title: "YMKNavigation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigation.html"
---
# YMKNavigation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigation : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                   routeOptions:
                       (nonnull YMKAutomotiveRouteOptions *)routeOptions;
```

Request routes for further guidance

```objectivec
- (void)requestAlternatives;
```

Request global alternatives for the current route

```objectivec
- (void)resolveUriWithUri:(nonnull NSString *)uri;
```

Resolve saved driving route URI for further guidance

```objectivec
- (void)matchRouteWithPolyline:(nonnull YMKPolyline *)polyline;
```

Building a route based on a custom route geometry

```objectivec
- (void)cancelRequest;
```

Cancel active routing request

```objectivec
- (void)resetRoutes;
```

Cancel active routing request and clear routes vector

```objectivec
- (void)addListenerWithNavigationListener:
    (nonnull id<YMKNavigationListener>)navigationListener;
```

The class does not retain the object in the 'navigationListener' parameter

```objectivec
- (void)removeListenerWithNavigationListener:
    (nonnull id<YMKNavigationListener>)navigationListener;
```

```objectivec
- (void)startGuidanceWithRoute:(nullable YMKDrivingRoute *)route;
```

Start guidance with given route

```objectivec
- (void)stopGuidance;
```

Stops current guidance session

```objectivec
- (void)suspend;
```

Stop tracking user position, later it could be resumed without losing current route

```objectivec
- (void)resume;
```

Resumes suspended guidance

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKDrivingVehicleOptions *vehicleOptions;
```

Changing this option may trigger reroute

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKDrivingAvoidanceFlags *avoidanceFlags;
```

The flags instruct the router to return routes that avoid roads with the specified properties when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<YMKLinearRing *> *avoidedZones;
```

avoidedZones instructs the router to return routes that avoid provided polygons

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotationLanguage annotationLanguage;
```

Set the annotation language

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingRoute *> *routes;
```

Resulting routes for the previous request

```objectivec
@property (nonatomic, readonly, nonnull) YMKGuidance *guidance;
```

## Instance methods

### requestRoutesWithPoints:routeOptions:

```objectivec
- (void)requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                   routeOptions:
                       (nonnull YMKAutomotiveRouteOptions *)routeOptions;
```

Request routes for further guidance. If there was a pending routing request, it will be canceled.

### requestAlternatives

```objectivec
- (void)requestAlternatives;
```

Request global alternatives for the current route. If there was a pending routing request, it will be canceled.

### resolveUriWithUri:

```objectivec
- (void)resolveUriWithUri:(nonnull NSString *)uri;
```

Resolve saved driving route URI for further guidance. If there was a pending routing request, it will be canceled.

### matchRouteWithPolyline:

```objectivec
- (void)matchRouteWithPolyline:(nonnull YMKPolyline *)polyline;
```

Building a route based on a custom route geometry.

### cancelRequest

```objectivec
- (void)cancelRequest;
```

Cancel active routing request.

### resetRoutes

```objectivec
- (void)resetRoutes;
```

Cancel active routing request and clear routes vector.

### addListenerWithNavigationListener:

```objectivec
- (void)addListenerWithNavigationListener:
    (nonnull id<YMKNavigationListener>)navigationListener;
```

The class does not retain the object in the 'navigationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithNavigationListener:

```objectivec
- (void)removeListenerWithNavigationListener:
    (nonnull id<YMKNavigationListener>)navigationListener;
```

### startGuidanceWithRoute:

```objectivec
- (void)startGuidanceWithRoute:(nullable YMKDrivingRoute *)route;
```

Start guidance with given route. This method will reset active current route if any. It only accepts either routes obtained from this `routes` field or `null`, which means freedrive session started.

### stopGuidance

```objectivec
- (void)stopGuidance;
```

Stops current guidance session. Call this method only if guidance has completely ended. For example, if you need to start another type of guidance (pedestrian for example) stop this first and than start another one. In case of route finished but you still on the road you must use `startGuidance(null)` instead.

### suspend

```objectivec
- (void)suspend;
```

Stop tracking user position, later it could be resumed without losing current route. Useful when user don't want guidance in background.

The method is idempotent.

In the suspended state, `startGuidance` can be called, but in fact there will be no guidance until `resume` is called.

### resume

```objectivec
- (void)resume;
```

Resumes suspended guidance. Guide will continue to guide the previous route or rebuild it. Useful when user don't want guidance in background.

The method is idempotent.

## Properties

### vehicleOptions

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKDrivingVehicleOptions *vehicleOptions;
```

Changing this option may trigger reroute.

### avoidanceFlags

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKDrivingAvoidanceFlags *avoidanceFlags;
```

The flags instruct the router to return routes that avoid roads with the specified properties when possible. Changing these flags may trigger reroute. All disabled by default.

### avoidedZones

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<YMKLinearRing *> *avoidedZones;
```

avoidedZones instructs the router to return routes that avoid provided polygons. If there are too many polygons or too complex polygon geometry, routes building may become impossible. In this case the error YMKDrivingTooComplexAvoidedZonesError will be returned. Changing this option may trigger reroute.

### annotationLanguage

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotationLanguage annotationLanguage;
```

Set the annotation language. Changing this option may trigger reroute.

### routes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingRoute *> *routes;
```

Resulting routes for the previous request. For requestAlternatives() it will contain the current route and fastest alternative route (if available) along with the received alternatives. Current route always will be the first one and fastest alternative will be the second.

### guidance

```objectivec
@property (nonatomic, readonly, nonnull) YMKGuidance *guidance;
```
