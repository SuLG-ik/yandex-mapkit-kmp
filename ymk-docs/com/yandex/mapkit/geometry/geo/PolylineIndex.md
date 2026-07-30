---
title: "PolylineIndex"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry.geo"
section: "Android / Справочник / com.yandex.mapkit.geometry.geo / PolylineIndex"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/PolylineIndex.html"
---
# PolylineIndex

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/PolylineIndex.html)

**Package** com.yandex.mapkit.geometry.geo

`interface PolylineIndex`

Provides methods for binding locations to a polyline

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Priority](Priority.md) |   |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `closestPolylinePosition(@NonNull Point point, @NonNull Priority priority, double maxLocationBias)`<br>Finds closest polyline position. |
| `PolylinePosition` | `closestPolylinePosition(@NonNull Point point, @NonNull PolylinePosition positionFrom, @NonNull PolylinePosition positionTo, double maxLocationBias)`<br>Finds the closest polyline position between the two positions. |

## Methods

### closestPolylinePosition

```java
@Nullable
PolylinePosition closestPolylinePosition(@NonNull Point point,
                                         @NonNull Priority priority,
                                         double maxLocationBias)
```

Finds closest polyline position.

Returns null if there is no position that satisfies the condition distance(point, position)  maxLocationBias.

Two modes are available: 1. Find the closest polyline position to a raw point [mapkit.geometry.geo.PolylineIndex.Priority#CLOSEST_TO_RAW_POINT](Priority.md#closest_to_raw_point) 2. Find the closest polyline position to the polyline start [mapkit.geometry.geo.PolylineIndex.Priority#CLOSEST_TO_START](Priority.md#closest_to_start).

### closestPolylinePosition

```java
@Nullable
PolylinePosition closestPolylinePosition(@NonNull Point point,
                                         @NonNull PolylinePosition positionFrom,
                                         @NonNull PolylinePosition positionTo,
                                         double maxLocationBias)
```

Finds the closest polyline position between the two positions.

Returns null if there is no position that satisfies the condition distance(point, position)  maxLocationBias.
