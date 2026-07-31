---
title: "TransferStop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransferStop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransferStop.html"
---
# TransferStop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransferStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransferStop

`class TransferStop implements Serializable`

Represents a stop in path which is not a part of any transport trip but must be visited according travelling.

For example, exit from subway may require transfer on other stop.

## Summary

### Constructors

**Signature and Description**

```java
TransferStop()
```

Use constructor with parameters in your code.

```java
TransferStop(@NonNull RouteStop routeStop,
             @NonNull java.util.List<Transport> transports)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized RouteStop` | `getRouteStop()`<br>Stop information. |
| `synchronized java.util.List<Transport>` | `getTransports()`<br>Transports at the stops |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TransferStop

```java
TransferStop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TransferStop

```java
TransferStop(@NonNull RouteStop routeStop,
             @NonNull java.util.List<Transport> transports)
```

## Methods

### getRouteStop

```java
@NonNull
RouteStop getRouteStop()
```

Stop information.

### getTransports

```java
@NonNull
java.util.List<Transport> getTransports()
```

Transports at the stops

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
