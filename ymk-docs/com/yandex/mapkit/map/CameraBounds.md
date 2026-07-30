---
title: "CameraBounds"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CameraBounds"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraBounds.html"
---
# CameraBounds

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraBounds.html)

**Package** com.yandex.mapkit.map

`interface CameraBounds`

The object that is used to interact with the map bounds.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getMinZoom()`<br>Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference. |
| `float` | `getMaxZoom()`<br>Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference |
| `void` | `setMinZoomPreference(float zoom)`<br>Set minimum available zoom level hint. |
| `void` | `setMaxZoomPreference(float zoom)`<br>Set maximum available zoom level hint. |
| `void` | `resetMinMaxZoomPreference()`<br>Reset minimum and maximum available zoom level hints. |
| `BoundingBox` | `getLatLngBounds()`<br>Latitudes should be in range [-89.3, 89.3]. |
| `void` | `setLatLngBounds(@Nullable BoundingBox latLngBounds)` |
| `boolean` | `isValid()`<br>Tells if this **CameraBounds** is valid or not. |

## Methods

### getMinZoom

```java
float getMinZoom()
```

Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.

### getMaxZoom

```java
float getMaxZoom()
```

Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference

### setMinZoomPreference

```java
void setMinZoomPreference(float zoom)
```

Set minimum available zoom level hint.

### setMaxZoomPreference

```java
void setMaxZoomPreference(float zoom)
```

Set maximum available zoom level hint.

### resetMinMaxZoomPreference

```java
void resetMinMaxZoomPreference()
```

Reset minimum and maximum available zoom level hints.

### getLatLngBounds

```java
@Nullable
BoundingBox getLatLngBounds()
```

Latitudes should be in range [-89.3, 89.3].

Longitudes should be in range [-180, 180).

Optional property, can be null.

### setLatLngBounds

```java
void setLatLngBounds(@Nullable BoundingBox latLngBounds)
```

### isValid

```java
boolean isValid()
```

Tells if this **CameraBounds** is valid or not.

Any other method (except for this one) called on an invalid **CameraBounds** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
