---
title: "RouteStopMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteStopMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteStopMetadata.html"
---
# RouteStopMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteStopMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RouteStopMetadata

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class RouteStopMetadata implements BaseMetadata, Serializable`

The metadata about the mass transit stop.

## Summary

### Constructors

**Signature and Description**

```java
RouteStopMetadata()
```

Use constructor with parameters in your code.

```java
RouteStopMetadata(@NonNull Stop stop,
                  @Nullable Stop stopExit,
                  @Nullable Point exitPoint)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Stop` | `getStop()`<br>Route stop information. |
| `synchronized Stop` | `getStopExit()`<br>Underground station exit<br>Optional field, can be null. |
| `synchronized Point` | `getExitPoint()`<br>Coordinates of underground station exit<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RouteStopMetadata

```java
RouteStopMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RouteStopMetadata

```java
RouteStopMetadata(@NonNull Stop stop,
                  @Nullable Stop stopExit,
                  @Nullable Point exitPoint)
```

## Methods

### getStop

```java
@NonNull
Stop getStop()
```

Route stop information.

### getStopExit

```java
@Nullable
Stop getStopExit()
```

Underground station exit

Optional field, can be null.

### getExitPoint

```java
@Nullable
Point getExitPoint()
```

Coordinates of underground station exit

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
