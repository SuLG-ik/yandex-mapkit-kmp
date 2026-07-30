---
title: "BicycleRouteSerializer"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / BicycleRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/BicycleRouteSerializer.html"
---
# BicycleRouteSerializer

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/BicycleRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.BicycleRouteSerializer

`class BicycleRouteSerializer`

## Summary

### Constructors

**Signature and Description**

```java
BicycleRouteSerializer()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native byte[]` | `save(@NonNull Route route)`<br>Returns a route's serialized representation. |
| `static native Route` | `load(@NonNull byte[] data)`<br>Returns a deserialized route. |

## Constuctors

### BicycleRouteSerializer

```java
BicycleRouteSerializer()
```

## Methods

### save

```java
@NonNull
byte[] save(@NonNull Route route)
```

Returns a route's serialized representation.

Returns an empty array if there are any errors.

### load

```java
@NonNull
Route load(@NonNull byte[] data)
```

Returns a deserialized route.

Returns null on error.
