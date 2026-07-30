---
title: "RouteHelper"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RouteHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RouteHelper.html"
---
# RouteHelper

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RouteHelper.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RouteHelper

`class RouteHelper`

## Summary

### Constructors

**Signature and Description**

```java
RouteHelper()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native JamStyle` | `createDefaultJamStyle()`<br>Creates a default traffic style. |
| `static native JamStyle` | `createDisabledJamStyle()`<br>Creates a disabled traffic jams style. |
| `static native ManeuverStyle` | `createDefaultManeuverStyle()`<br>Creates a default maneuver style. |
| `static native void` | `updatePolyline(@NonNull PolylineMapObject polyline, @NonNull DrivingRoute route, @NonNull JamStyle style, boolean updateGeometry)`<br>Sets a new geometry and colors for a polyline. |
| `static native void` | `addManeuvers(@NonNull PolylineMapObject polyline, @NonNull DrivingRoute route)`<br>Add maneuvers from provided route as arrows Behaviour is undefined if route.geometry does not equals polyline.geometry. |
| `static native void` | `addJams(@NonNull PolylineMapObject polyline, @NonNull DrivingRoute route)`<br>Add jams from provided route as stroke colors Behaviour is undefined if route.geometry does not equals polyline.geometry. |
| `static native void` | `applyJamStyle(@NonNull PolylineMapObject polyline, @NonNull JamStyle style)`<br>Applies the traffic jam style. |
| `static native void` | `applyManeuverStyle(@NonNull PolylineMapObject polyline, @NonNull ManeuverStyle style)`<br>Applies a maneuver style. |

## Constuctors

### RouteHelper

```java
RouteHelper()
```

## Methods

### createDefaultJamStyle

```java
@NonNull
JamStyle createDefaultJamStyle()
```

Creates a default traffic style.

Default values: colors : Blocked  : 0x000000ff, Free     : 0x00ff00ff, Hard     : 0xff0000ff, Light    : 0xffff00ff, Unknown  : 0x909090ff, VeryHard : 0xa00000ff

### createDisabledJamStyle

```java
@NonNull
JamStyle createDisabledJamStyle()
```

Creates a disabled traffic jams style.

Colors : Blocked  : 0x909090ff, Free     : 0x909090ff, Hard     : 0x909090ff, Light    : 0x909090ff, Unknown  : 0x909090ff, VeryHard : 0x909090ff

### createDefaultManeuverStyle

```java
@NonNull
ManeuverStyle createDefaultManeuverStyle()
```

Creates a default maneuver style.

Default values for ArrowManeuverStyle: fillColor      : 0x000000ff outlineColor   : 0xffffffff outlineWidth   : 2.f length         : 80 triangleHeight : 16 enabled        : false

### updatePolyline

```java
void updatePolyline(@NonNull PolylineMapObject polyline,
                    @NonNull DrivingRoute route,
                    @NonNull JamStyle style,
                    boolean updateGeometry)
```

Sets a new geometry and colors for a polyline.

If style.enabled = false, the polyline is drawn using the color for the Unknown traffic jam type. If updateGeometry = false, but route geometry differs from polyline geometry, then behaviour is undefined.

### addManeuvers

```java
void addManeuvers(@NonNull PolylineMapObject polyline,
                  @NonNull DrivingRoute route)
```

Add maneuvers from provided route as arrows Behaviour is undefined if route.geometry does not equals polyline.geometry.

### addJams

```java
void addJams(@NonNull PolylineMapObject polyline,
             @NonNull DrivingRoute route)
```

Add jams from provided route as stroke colors Behaviour is undefined if route.geometry does not equals polyline.geometry.

### applyJamStyle

```java
void applyJamStyle(@NonNull PolylineMapObject polyline,
                   @NonNull JamStyle style)
```

Applies the traffic jam style.

Updates colors for traffic jam types provided in the style parameter.

### applyManeuverStyle

```java
void applyManeuverStyle(@NonNull PolylineMapObject polyline,
                        @NonNull ManeuverStyle style)
```

Applies a maneuver style.

This method should be called every time after updatePolyline with updateGeometry == true occurs; otherwise, the default maneuver style is applied.
