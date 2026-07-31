---
title: "ManeuverStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ManeuverStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ManeuverStyle.html"
---
# ManeuverStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ManeuverStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ManeuverStyle

`class ManeuverStyle implements Serializable`

The style that is used to display maneuvers on the map.

## Summary

### Constructors

**Signature and Description**

```java
ManeuverStyle(@NonNull ArrowManeuverStyle arrow)
```

```java
ManeuverStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ArrowManeuverStyle` | `getArrow()`<br>Arrow maneuver style. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ManeuverStyle

```java
ManeuverStyle(@NonNull ArrowManeuverStyle arrow)
```

### ManeuverStyle

```java
ManeuverStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getArrow

```java
@NonNull
ArrowManeuverStyle getArrow()
```

Arrow maneuver style.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
