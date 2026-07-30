---
title: "SubpolylineHelper"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / SubpolylineHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/SubpolylineHelper.html"
---
# SubpolylineHelper

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/SubpolylineHelper.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.SubpolylineHelper

`class SubpolylineHelper`

## Summary

### Constructors

**Signature and Description**

```java
SubpolylineHelper()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native Polyline` | `subpolyline(@NonNull Polyline polyline, @NonNull Subpolyline subpolyline)`<br>Cuts subpolyline geometry from polyline. |
| `static native double` | `subpolylineLength(@NonNull Polyline polyline, @NonNull Subpolyline subpolyline)`<br>Calculates length of subpolyline geometry. |

## Constuctors

### SubpolylineHelper

```java
SubpolylineHelper()
```

## Methods

### subpolyline

```java
@NonNull
Polyline subpolyline(@NonNull Polyline polyline,
                     @NonNull Subpolyline subpolyline)
```

Cuts subpolyline geometry from polyline.

### subpolylineLength

```java
double subpolylineLength(@NonNull Polyline polyline,
                         @NonNull Subpolyline subpolyline)
```

Calculates length of subpolyline geometry.
