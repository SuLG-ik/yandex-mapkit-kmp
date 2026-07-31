---
title: "Directions"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions"
section: "Android / Справочник / com.yandex.mapkit.directions / Directions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/Directions.html"
---
# Directions

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/Directions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions

`interface Directions`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `CarparksLayer` | `createCarparksLayer(@NonNull MapWindow mapWindow)`<br>Creates the carparks layer. |
| `DrivingRouter` | `createDrivingRouter(@NonNull DrivingRouterType type)`<br>Creates a manager that builds driving routes. |
| `boolean` | `isValid()`<br>Tells if this **Directions** is valid or not. |

## Methods

### createCarparksLayer

```java
@NonNull
CarparksLayer createCarparksLayer(@NonNull MapWindow mapWindow)
```

Creates the carparks layer.

### createDrivingRouter

```java
@NonNull
DrivingRouter createDrivingRouter(@NonNull DrivingRouterType type)
```

Creates a manager that builds driving routes.

### isValid

```java
boolean isValid()
```

Tells if this **Directions** is valid or not.

Any other method (except for this one) called on an invalid **Directions** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
