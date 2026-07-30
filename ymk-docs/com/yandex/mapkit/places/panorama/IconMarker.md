---
title: "IconMarker"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / IconMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconMarker.html"
---
# IconMarker

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.IconMarker

`class IconMarker implements Serializable`

Icon marker struct

## Summary

### Constructors

**Signature and Description**

```java
IconMarker()
```

Use constructor with parameters in your code.

```java
IconMarker(@NonNull Direction angularPosition,
           @NonNull java.lang.String iconId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Direction` | `getAngularPosition()`<br>Angular position, degrees. |
| `synchronized java.lang.String` | `getIconId()`<br>The marker iconId. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### IconMarker

```java
IconMarker()
```

Use constructor with parameters in your code.

This one is for serialization only!

### IconMarker

```java
IconMarker(@NonNull Direction angularPosition,
           @NonNull java.lang.String iconId)
```

## Methods

### getAngularPosition

```java
@NonNull
Direction getAngularPosition()
```

Angular position, degrees.

(bearing, tilt) (0, 0) - (north, horizon)

### getIconId

```java
@NonNull
java.lang.String getIconId()
```

The marker iconId.

The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
