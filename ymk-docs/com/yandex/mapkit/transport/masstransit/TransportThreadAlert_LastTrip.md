---
title: "LastTrip"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportThreadAlert_LastTrip"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_LastTrip.html"
---
# LastTrip

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_LastTrip.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportThreadAlert.LastTrip

`static class LastTrip implements Serializable`

Last trip for the thread.

Allows to get the time it takes to get to the end of the route.

## Summary

### Constructors

**Signature and Description**

```java
LastTrip(@NonNull Time time)
```

```java
LastTrip()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Time` | `getTime()`<br>Time required to finish the trip. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LastTrip

```java
LastTrip(@NonNull Time time)
```

### LastTrip

```java
LastTrip()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTime

```java
@NonNull
Time getTime()
```

Time required to finish the trip.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
