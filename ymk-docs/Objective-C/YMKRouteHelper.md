---
title: "YMKRouteHelper"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRouteHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteHelper.html"
---
# YMKRouteHelper

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteHelper.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRouteHelper : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKJamStyle *)createDefaultJamStyle;
```

Creates a default traffic style

```objectivec
+ (nonnull YMKJamStyle *)createDisabledJamStyle;
```

Creates a disabled traffic jams style

```objectivec
+ (nonnull YMKManeuverStyle *)createDefaultManeuverStyle;
```

Creates a default maneuver style

```objectivec
+ (void)updatePolylineWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                             route:(nonnull YMKDrivingRoute *)route
                             style:(nonnull YMKJamStyle *)style
                    updateGeometry:(BOOL)updateGeometry;
```

Sets a new geometry and colors for a polyline

```objectivec
+ (void)addManeuversWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                           route:(nonnull YMKDrivingRoute *)route;
```

Add maneuvers from provided route as arrows Behaviour is undefined if route

```objectivec
+ (void)addJamsWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                      route:(nonnull YMKDrivingRoute *)route;
```

Add jams from provided route as stroke colors Behaviour is undefined if route

```objectivec
+ (void)applyJamStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                            style:(nonnull YMKJamStyle *)style;
```

Applies the traffic jam style

```objectivec
+ (void)applyManeuverStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                                 style:(nonnull YMKManeuverStyle *)style;
```

Applies a maneuver style

## Class methods

### createDefaultJamStyle

```objectivec
+ (nonnull YMKJamStyle *)createDefaultJamStyle;
```

Creates a default traffic style. Default values: colors : Blocked : 0x000000ff, Free : 0x00ff00ff, Hard : 0xff0000ff, Light : 0xffff00ff, Unknown : 0x909090ff, VeryHard : 0xa00000ff

### createDisabledJamStyle

```objectivec
+ (nonnull YMKJamStyle *)createDisabledJamStyle;
```

Creates a disabled traffic jams style. Colors : Blocked : 0x909090ff, Free : 0x909090ff, Hard : 0x909090ff, Light : 0x909090ff, Unknown : 0x909090ff, VeryHard : 0x909090ff

### createDefaultManeuverStyle

```objectivec
+ (nonnull YMKManeuverStyle *)createDefaultManeuverStyle;
```

Creates a default maneuver style.

Default values for ArrowManeuverStyle: fillColor : 0x000000ff outlineColor : 0xffffffff outlineWidth : 2.f length : 80 triangleHeight : 16 enabled : false

### updatePolylineWithPolyline:route:style:updateGeometry:

```objectivec
+ (void)updatePolylineWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                             route:(nonnull YMKDrivingRoute *)route
                             style:(nonnull YMKJamStyle *)style
                    updateGeometry:(BOOL)updateGeometry;
```

Sets a new geometry and colors for a polyline. If style.enabled = false, the polyline is drawn using the color for the Unknown traffic jam type. If updateGeometry = false, but route geometry differs from polyline geometry, then behaviour is undefined.

### addManeuversWithPolyline:route:

```objectivec
+ (void)addManeuversWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                           route:(nonnull YMKDrivingRoute *)route;
```

Add maneuvers from provided route as arrows Behaviour is undefined if route.geometry does not equals polyline.geometry.

### addJamsWithPolyline:route:

```objectivec
+ (void)addJamsWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                      route:(nonnull YMKDrivingRoute *)route;
```

Add jams from provided route as stroke colors Behaviour is undefined if route.geometry does not equals polyline.geometry.

### applyJamStyleWithPolyline:style:

```objectivec
+ (void)applyJamStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                            style:(nonnull YMKJamStyle *)style;
```

Applies the traffic jam style. Updates colors for traffic jam types provided in the style parameter.

### applyManeuverStyleWithPolyline:style:

```objectivec
+ (void)applyManeuverStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                                 style:(nonnull YMKManeuverStyle *)style;
```

Applies a maneuver style. This method should be called every time after updatePolyline with updateGeometry == true occurs; otherwise, the default maneuver style is applied.
