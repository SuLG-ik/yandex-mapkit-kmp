---
title: "SimulationSettings"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / SimulationSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/SimulationSettings.html"
---
# SimulationSettings

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/SimulationSettings.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.SimulationSettings

`class SimulationSettings implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
SimulationSettings()
```

Use constructor with parameters in your code.

```java
SimulationSettings(@NonNull Polyline geometry,
                   @NonNull LocationSettings locationSettings)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Polyline` | `getGeometry()` |
| `synchronized LocationSettings` | `getLocationSettings()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SimulationSettings

```java
SimulationSettings()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SimulationSettings

```java
SimulationSettings(@NonNull Polyline geometry,
                   @NonNull LocationSettings locationSettings)
```

## Methods

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

### getLocationSettings

```java
@NonNull
LocationSettings getLocationSettings()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
