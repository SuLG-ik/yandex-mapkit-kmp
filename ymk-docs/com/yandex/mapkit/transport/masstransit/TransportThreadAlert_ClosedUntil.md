---
title: "ClosedUntil"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportThreadAlert_ClosedUntil"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_ClosedUntil.html"
---
# ClosedUntil

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_ClosedUntil.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportThreadAlert.ClosedUntil

`static class ClosedUntil implements Serializable`

Thread is not operational until specified time.

## Summary

### Constructors

**Signature and Description**

```java
ClosedUntil(@NonNull Time time)
```

```java
ClosedUntil()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Time` | `getTime()`<br>Time of the next trip. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ClosedUntil

```java
ClosedUntil(@NonNull Time time)
```

### ClosedUntil

```java
ClosedUntil()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTime

```java
@NonNull
Time getTime()
```

Time of the next trip.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
