---
title: "MasstransitRouteSerializer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / MasstransitRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/MasstransitRouteSerializer.html"
---
# MasstransitRouteSerializer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/MasstransitRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface MasstransitRouteSerializer`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `byte[]` | `save(@NonNull Route route)`<br>Serializes the route. |
| `Route` | `load(@NonNull byte[] data)`<br>Deserializes the route. |

## Methods

### save

```java
@NonNull
byte[] save(@NonNull Route route)
```

Serializes the route.

**Returns**

Route's serialized representation. Empty array in case of any errors.

### load

```java
@Nullable
Route load(@NonNull byte[] data)
```

Deserializes the route.

**Returns**

Deserialized Route. Null in case of any errors.
