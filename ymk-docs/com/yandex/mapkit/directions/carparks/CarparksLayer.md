---
title: "CarparksLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.carparks"
section: "Android / Справочник / com.yandex.mapkit.directions.carparks / CarparksLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/carparks/CarparksLayer.html"
---
# CarparksLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/carparks/CarparksLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.carparks

`interface CarparksLayer`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isVisible()`<br>Indicates whether the layer is displayed on a map. |
| `void` | `setVisible(boolean on)`<br>Display or hide the layer on a map. |
| `boolean` | `setCarparksStyle(@NonNull java.lang.String style)`<br>Applies JSON style transformations to the carparks layer. |
| `boolean` | `setCarparksStyle(int id, @NonNull java.lang.String style)`<br>Applies JSON style transformations to the carparks layer. |
| `void` | `resetCarparksStyles()`<br>Resets all JSON style transformations applied to the carparks layer. |
| `boolean` | `isValid()`<br>Tells if this **CarparksLayer** is valid or not. |

## Methods

### isVisible

```java
boolean isVisible()
```

Indicates whether the layer is displayed on a map.

### setVisible

```java
void setVisible(boolean on)
```

Display or hide the layer on a map.

### setCarparksStyle

```java
boolean setCarparksStyle(@NonNull java.lang.String style)
```

Applies JSON style transformations to the carparks layer.

Same as setCarparksStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### setCarparksStyle

```java
boolean setCarparksStyle(int id,
                         @NonNull java.lang.String style)
```

Applies JSON style transformations to the carparks layer.

Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### resetCarparksStyles

```java
void resetCarparksStyles()
```

Resets all JSON style transformations applied to the carparks layer.

### isValid

```java
boolean isValid()
```

Tells if this **CarparksLayer** is valid or not.

Any other method (except for this one) called on an invalid **CarparksLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
