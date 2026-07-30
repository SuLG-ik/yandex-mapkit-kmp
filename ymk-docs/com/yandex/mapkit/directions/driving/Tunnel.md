---
title: "Tunnel"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Tunnel"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Tunnel.html"
---
# Tunnel

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Tunnel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Tunnel

`class Tunnel implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Tunnel(@NonNull Subpolyline position)
```

```java
Tunnel()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Subpolyline` | `getPosition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Tunnel

```java
Tunnel(@NonNull Subpolyline position)
```

### Tunnel

```java
Tunnel()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
Subpolyline getPosition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
