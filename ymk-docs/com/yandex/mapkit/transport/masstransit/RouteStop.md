---
title: "RouteStop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteStop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteStop.html"
---
# RouteStop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RouteStop

`class RouteStop implements Serializable`

Describes a [mapkit.transport.masstransit.Stop](Stop.md) on a [mapkit.transport.masstransit.Route](Route.md).

## Summary

### Constructors

**Signature and Description**

```java
RouteStop()
```

Use constructor with parameters in your code.

```java
RouteStop(@NonNull RouteStopMetadata metadata,
          @NonNull Point position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized RouteStopMetadata` | `getMetadata()`<br>General information about a stop on a route and optionally about its exit |
| `synchronized Point` | `getPosition()`<br>Coordinates of the stop. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RouteStop

```java
RouteStop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RouteStop

```java
RouteStop(@NonNull RouteStopMetadata metadata,
          @NonNull Point position)
```

## Methods

### getMetadata

```java
@NonNull
RouteStopMetadata getMetadata()
```

General information about a stop on a route and optionally about its exit

### getPosition

```java
@NonNull
Point getPosition()
```

Coordinates of the stop.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
