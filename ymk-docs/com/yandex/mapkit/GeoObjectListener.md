---
title: "GeoObjectListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / GeoObjectListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectListener.html"
---
# GeoObjectListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectListener.html)

**Package** com.yandex.mapkit

`static interface GeoObjectListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onGeoObjectResult(@NonNull GeoObject obj)`<br>Called when a user is requesting detailed info for the specified object. |
| `void` | `onGeoObjectError(@NonNull Error error)`<br>Called when an error occurs. |

## Methods

### onGeoObjectResult

```java
@UiThread
void onGeoObjectResult(@NonNull GeoObject obj)
```

Called when a user is requesting detailed info for the specified object.

### onGeoObjectError

```java
@UiThread
void onGeoObjectError(@NonNull Error error)
```

Called when an error occurs.
