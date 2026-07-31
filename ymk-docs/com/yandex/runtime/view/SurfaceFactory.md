---
title: "SurfaceFactory"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.view"
section: "Android / Справочник / com.yandex.runtime.view / SurfaceFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/view/SurfaceFactory.html"
---
# SurfaceFactory

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/view/SurfaceFactory.html)

**Package** com.yandex.runtime.view

java.lang.Object
↳ com.yandex.runtime.view.SurfaceFactory

`class SurfaceFactory`

## Summary

### Constructors

**Signature and Description**

```java
SurfaceFactory()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native Surface` | `from(android.view.Surface surface)`<br>Creates a Surface object that wrap the given Android Surface object. |

## Constuctors

### SurfaceFactory

```java
SurfaceFactory()
```

## Methods

### from

```java
Surface from(android.view.Surface surface)
```

Creates a Surface object that wrap the given Android Surface object.

Surface is used to pass the MapWindow
