---
title: "Transport"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Transport"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transport.html"
---
# Transport

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Transport

`class Transport implements Serializable`

Contains information about the mass transit ride section of a [mapkit.transport.masstransit.Route](Route.md) for a specific mass transit [mapkit.transport.masstransit.Line](Line.md).

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [TransportThread](Transport_TransportThread.md) | [mapkit.transport.masstransit.Thread](Thread.md) specific properties of a mass transit ride section of a [mapkit.transport.masstransit.Route](Route.md). |

## Summary

### Constructors

**Signature and Description**

```java
Transport()
```

Use constructor with parameters in your code.

```java
Transport(@NonNull Line line,
          @NonNull java.util.List<TransportThread> transports,
          @NonNull java.util.List<TransportContour> transportContours)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Line` | `getLine()`<br>Mass transit line. |
| `synchronized java.util.List<TransportThread>` | `getTransports()`<br>Collection of mass transit threads of the specified line suitable for the constructed route. |
| `synchronized java.util.List<TransportContour>` | `getTransportContours()`<br>Describes [mapkit.transport.masstransit.TransportContour](TransportContour.md) in borders of which this block is located |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Transport

```java
Transport()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Transport

```java
Transport(@NonNull Line line,
          @NonNull java.util.List<TransportThread> transports,
          @NonNull java.util.List<TransportContour> transportContours)
```

## Methods

### getLine

```java
@NonNull
Line getLine()
```

Mass transit line.

### getTransports

```java
@NonNull
java.util.List<TransportThread> getTransports()
```

Collection of mass transit threads of the specified line suitable for the constructed route.

### getTransportContours

```java
@NonNull
java.util.List<TransportContour> getTransportContours()
```

Describes [mapkit.transport.masstransit.TransportContour](TransportContour.md) in borders of which this block is located

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
