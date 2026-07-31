---
title: "TrafficLight"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / TrafficLight"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/TrafficLight.html"
---
# TrafficLight

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/TrafficLight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.TrafficLight

`class TrafficLight implements Serializable`

A traffic light object.

## Summary

### Constructors

**Signature and Description**

```java
TrafficLight(@NonNull PolylinePosition position)
```

```java
TrafficLight()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>The position of the traffic light. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TrafficLight

```java
TrafficLight(@NonNull PolylinePosition position)
```

### TrafficLight

```java
TrafficLight()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of the traffic light.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
