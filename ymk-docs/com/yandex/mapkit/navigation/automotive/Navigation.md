---
title: "Navigation"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / Navigation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Navigation.html"
---
# Navigation

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Navigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface Navigation`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `VehicleOptions` | `getVehicleOptions()`<br>Changing this option may trigger reroute. |
| `void` | `setVehicleOptions(@NonNull VehicleOptions vehicleOptions)` |
| `AvoidanceFlags` | `getAvoidanceFlags()`<br>The flags instruct the router to return routes that avoid roads with the specified properties when possible. |
| `void` | `setAvoidanceFlags(@NonNull AvoidanceFlags avoidanceFlags)` |
| `java.util.List<LinearRing>` | `getAvoidedZones()`<br>avoidedZones instructs the router to return routes that avoid provided polygons. |
| `void` | `setAvoidedZones(@NonNull java.util.List<LinearRing> avoidedZones)` |
| `AnnotationLanguage` | `getAnnotationLanguage()`<br>Set the annotation language. |
| `void` | `setAnnotationLanguage(@NonNull AnnotationLanguage annotationLanguage)` |
| `void` | `requestRoutes(@NonNull java.util.List<RequestPoint> points, @NonNull RouteOptions routeOptions)`<br>Request routes for further guidance. |
| `void` | `requestAlternatives()`<br>Request global alternatives for the current route. |
| `void` | `resolveUri(@NonNull java.lang.String uri)`<br>Resolve saved driving route URI for further guidance. |
| `void` | `matchRoute(@NonNull Polyline polyline)`<br>Building a route based on a custom route geometry. |
| `void` | `cancelRequest()`<br>Cancel active routing request. |
| `void` | `resetRoutes()`<br>Cancel active routing request and clear routes vector. |
| `java.util.List<DrivingRoute>` | `getRoutes()`<br>Resulting routes for the previous request. |
| `void` | `addListener(@NonNull NavigationListener navigationListener)`<br>The class does not retain the object in the 'navigationListener' parameter. |
| `void` | `removeListener(@NonNull NavigationListener navigationListener)` |
| `Guidance` | `getGuidance()` |
| `void` | `startGuidance(@Nullable DrivingRoute route)`<br>Start guidance with given route. |
| `void` | `stopGuidance()`<br>Stops current guidance session. |
| `void` | `suspend()`<br>Stop tracking user position, later it could be resumed without losing current route. |
| `void` | `resume()`<br>Resumes suspended guidance. |

## Methods

### getVehicleOptions

```java
@NonNull
VehicleOptions getVehicleOptions()
```

Changing this option may trigger reroute.

### setVehicleOptions

```java
void setVehicleOptions(@NonNull VehicleOptions vehicleOptions)
```

### getAvoidanceFlags

```java
@NonNull
AvoidanceFlags getAvoidanceFlags()
```

The flags instruct the router to return routes that avoid roads with the specified properties when possible.

Changing these flags may trigger reroute. All disabled by default.

### setAvoidanceFlags

```java
void setAvoidanceFlags(@NonNull AvoidanceFlags avoidanceFlags)
```

### getAvoidedZones

```java
@NonNull
java.util.List<LinearRing> getAvoidedZones()
```

avoidedZones instructs the router to return routes that avoid provided polygons.

If there are too many polygons or too complex polygon geometry, routes building may become impossible. In this case the error [mapkit.directions.driving.TooComplexAvoidedZonesError](../../directions/driving/TooComplexAvoidedZonesError.md) will be returned. Changing this option may trigger reroute.

### setAvoidedZones

```java
void setAvoidedZones(@NonNull java.util.List<LinearRing> avoidedZones)
```

### getAnnotationLanguage

```java
@NonNull
AnnotationLanguage getAnnotationLanguage()
```

Set the annotation language.

Changing this option may trigger reroute.

### setAnnotationLanguage

```java
void setAnnotationLanguage(@NonNull AnnotationLanguage annotationLanguage)
```

### requestRoutes

```java
void requestRoutes(@NonNull java.util.List<RequestPoint> points,
                   @NonNull RouteOptions routeOptions)
```

Request routes for further guidance.

If there was a pending routing request, it will be canceled.

### requestAlternatives

```java
void requestAlternatives()
```

Request global alternatives for the current route.

If there was a pending routing request, it will be canceled.

### resolveUri

```java
void resolveUri(@NonNull java.lang.String uri)
```

Resolve saved driving route URI for further guidance.

If there was a pending routing request, it will be canceled.

### matchRoute

```java
void matchRoute(@NonNull Polyline polyline)
```

Building a route based on a custom route geometry.

### cancelRequest

```java
void cancelRequest()
```

Cancel active routing request.

### resetRoutes

```java
void resetRoutes()
```

Cancel active routing request and clear routes vector.

### getRoutes

```java
@NonNull
java.util.List<DrivingRoute> getRoutes()
```

Resulting routes for the previous request.

For requestAlternatives() it will contain the current route and fastest alternative route (if available) along with the received alternatives. Current route always will be the first one and fastest alternative will be the second.

### addListener

```java
void addListener(@NonNull NavigationListener navigationListener)
```

The class does not retain the object in the 'navigationListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull NavigationListener navigationListener)
```

### getGuidance

```java
@NonNull
Guidance getGuidance()
```

### startGuidance

```java
void startGuidance(@Nullable DrivingRoute route)
```

Start guidance with given route.

This method will reset active current route if any. It only accepts either routes obtained from this `routes` field or `null`, which means freedrive session started.

### stopGuidance

```java
void stopGuidance()
```

Stops current guidance session.

Call this method only if guidance has completely ended. For example, if you need to start another type of guidance (pedestrian for example) stop this first and than start another one. In case of route finished but you still on the road you must use `startGuidance(null)` instead.

### suspend

```java
void suspend()
```

Stop tracking user position, later it could be resumed without losing current route.

Useful when user don't want guidance in background.

The method is idempotent.

In the suspended state, `startGuidance` can be called, but in fact there will be no guidance until `resume` is called.

### resume

```java
void resume()
```

Resumes suspended guidance.

Guide will continue to guide the previous route or rebuild it. Useful when user don't want guidance in background.

The method is idempotent.
