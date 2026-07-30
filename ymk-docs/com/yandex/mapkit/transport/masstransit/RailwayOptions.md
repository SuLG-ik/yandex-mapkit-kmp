---
title: "RailwayOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RailwayOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RailwayOptions.html"
---
# RailwayOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RailwayOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RailwayOptions

`class RailwayOptions implements Serializable`

Contains information about boarding to or dropOff from trains.

## Summary

### Constructors

**Signature and Description**

```java
RailwayOptions()
```

Use constructor with parameters in your code.

```java
RailwayOptions(@Nullable java.lang.String tracks,
               @Nullable java.lang.String platforms,
               boolean uncertain)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getTracks()`<br>Departure track annotation, e.g. |
| `synchronized java.lang.String` | `getPlatforms()`<br>Departure platform annotation, e.g. |
| `synchronized boolean` | `getUncertain()`<br>Flag of track/platform selection uncertainty to suggest user double-check it in the station. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RailwayOptions

```java
RailwayOptions()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RailwayOptions

```java
RailwayOptions(@Nullable java.lang.String tracks,
               @Nullable java.lang.String platforms,
               boolean uncertain)
```

## Methods

### getTracks

```java
@Nullable
java.lang.String getTracks()
```

Departure track annotation, e.g.

"3 or 4 track".

Optional field, can be null.

### getPlatforms

```java
@Nullable
java.lang.String getPlatforms()
```

Departure platform annotation, e.g.

"2 platform".

Optional field, can be null.

### getUncertain

```java
boolean getUncertain()
```

Flag of track/platform selection uncertainty to suggest user double-check it in the station.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
