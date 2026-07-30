---
title: "IconConnection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / IconConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconConnection.html"
---
# IconConnection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.IconConnection

`class IconConnection implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
IconConnection()
```

Use constructor with parameters in your code.

```java
IconConnection(@NonNull Direction angularPosition,
               @NonNull java.lang.String iconId,
               @NonNull java.lang.String panoramaId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Direction` | `getAngularPosition()`<br>Angular position, degrees. |
| `synchronized java.lang.String` | `getIconId()`<br>The connection iconId. |
| `synchronized java.lang.String` | `getPanoramaId()`<br>panoramaId is passed as a parameter to the onPanoramaChangeIntent method. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### IconConnection

```java
IconConnection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### IconConnection

```java
IconConnection(@NonNull Direction angularPosition,
               @NonNull java.lang.String iconId,
               @NonNull java.lang.String panoramaId)
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

The connection iconId.

The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider once iconId is visible

### getPanoramaId

```java
@NonNull
java.lang.String getPanoramaId()
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
