---
title: "TransportStop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportStop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportStop.html"
---
# TransportStop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportStop

`class TransportStop implements Serializable`

The data about the public transport stop.

## Summary

### Constructors

**Signature and Description**

```java
TransportStop()
```

Use constructor with parameters in your code.

```java
TransportStop(@NonNull Stop stop,
              @NonNull Point position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Stop` | `getStop()`<br>Information about public transport stops. |
| `synchronized Point` | `getPosition()`<br>Coordinates of the stop. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TransportStop

```java
TransportStop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TransportStop

```java
TransportStop(@NonNull Stop stop,
              @NonNull Point position)
```

## Methods

### getStop

```java
@NonNull
Stop getStop()
```

Information about public transport stops.

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
