---
title: "YMKNavigation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigation.html"
---
# YMKNavigation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigation : NSObject
```

## Summary

### Instance methods

```swift
func requestRoutes(with points: [YMKRequestPoint],
                  routeOptions: YMKAutomotiveRouteOptions)
```

Request routes for further guidance

```swift
func requestAlternatives()
```

Request global alternatives for the current route

```swift
func resolveUri(withUri uri: String)
```

Resolve saved driving route URI for further guidance

```swift
func matchRoute(with polyline: YMKPolyline)
```

Building a route based on a custom route geometry

```swift
func cancelRequest()
```

Cancel active routing request

```swift
func resetRoutes()
```

Cancel active routing request and clear routes vector

```swift
func addListener(with navigationListener: any YMKNavigationListener)
```

The class does not retain the object in the 'navigationListener' parameter

```swift
func removeListener(with navigationListener: any YMKNavigationListener)
```

```swift
func startGuidance(with route: YMKDrivingRoute?)
```

Start guidance with given route

```swift
func stopGuidance()
```

Stops current guidance session

```swift
func suspend()
```

Stop tracking user position, later it could be resumed without losing current route

```swift
func resume()
```

Resumes suspended guidance

### Properties

```swift
var vehicleOptions: YMKDrivingVehicleOptions { get set }
```

Changing this option may trigger reroute

```swift
var avoidanceFlags: YMKDrivingAvoidanceFlags { get set }
```

The flags instruct the router to return routes that avoid roads with the specified properties when possible

```swift
var avoidedZones: [YMKLinearRing] { get set }
```

avoidedZones instructs the router to return routes that avoid provided polygons

```swift
var annotationLanguage: YMKAnnotationLanguage { get set }
```

Set the annotation language

```swift
var routes: [YMKDrivingRoute] { get }
```

Resulting routes for the previous request

```swift
var guidance: YMKGuidance { get }
```

## Instance methods

### requestRoutes(with:routeOptions:)

```swift
func requestRoutes(with points: [YMKRequestPoint],
                  routeOptions: YMKAutomotiveRouteOptions)
```

Request routes for further guidance. If there was a pending routing request, it will be canceled.

### requestAlternatives()

```swift
func requestAlternatives()
```

Request global alternatives for the current route. If there was a pending routing request, it will be canceled.

### resolveUri(withUri:)

```swift
func resolveUri(withUri uri: String)
```

Resolve saved driving route URI for further guidance. If there was a pending routing request, it will be canceled.

### matchRoute(with:)

```swift
func matchRoute(with polyline: YMKPolyline)
```

Building a route based on a custom route geometry.

### cancelRequest()

```swift
func cancelRequest()
```

Cancel active routing request.

### resetRoutes()

```swift
func resetRoutes()
```

Cancel active routing request and clear routes vector.

### addListener(with:)

```swift
func addListener(with navigationListener: any YMKNavigationListener)
```

The class does not retain the object in the 'navigationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with navigationListener: any YMKNavigationListener)
```

### startGuidance(with:)

```swift
func startGuidance(with route: YMKDrivingRoute?)
```

Start guidance with given route. This method will reset active current route if any. It only accepts either routes obtained from this `routes` field or `null`, which means freedrive session started.

### stopGuidance()

```swift
func stopGuidance()
```

Stops current guidance session. Call this method only if guidance has completely ended. For example, if you need to start another type of guidance (pedestrian for example) stop this first and than start another one. In case of route finished but you still on the road you must use `startGuidance(null)` instead.

### suspend()

```swift
func suspend()
```

Stop tracking user position, later it could be resumed without losing current route. Useful when user don't want guidance in background.

The method is idempotent.

In the suspended state, `startGuidance` can be called, but in fact there will be no guidance until `resume` is called.

### resume()

```swift
func resume()
```

Resumes suspended guidance. Guide will continue to guide the previous route or rebuild it. Useful when user don't want guidance in background.

The method is idempotent.

## Properties

### vehicleOptions

```swift
var vehicleOptions: YMKDrivingVehicleOptions { get set }
```

Changing this option may trigger reroute.

### avoidanceFlags

```swift
var avoidanceFlags: YMKDrivingAvoidanceFlags { get set }
```

The flags instruct the router to return routes that avoid roads with the specified properties when possible. Changing these flags may trigger reroute. All disabled by default.

### avoidedZones

```swift
var avoidedZones: [YMKLinearRing] { get set }
```

avoidedZones instructs the router to return routes that avoid provided polygons. If there are too many polygons or too complex polygon geometry, routes building may become impossible. In this case the error YMKDrivingTooComplexAvoidedZonesError will be returned. Changing this option may trigger reroute.

### annotationLanguage

```swift
var annotationLanguage: YMKAnnotationLanguage { get set }
```

Set the annotation language. Changing this option may trigger reroute.

### routes

```swift
var routes: [YMKDrivingRoute] { get }
```

Resulting routes for the previous request. For requestAlternatives() it will contain the current route and fastest alternative route (if available) along with the received alternatives. Current route always will be the first one and fastest alternative will be the second.

### guidance

```swift
var guidance: YMKGuidance { get }
```
