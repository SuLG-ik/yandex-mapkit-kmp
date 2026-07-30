---
title: "ArrowConnection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / ArrowConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/ArrowConnection.html"
---
# ArrowConnection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/ArrowConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.ArrowConnection

`class ArrowConnection implements Serializable`

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Style](ArrowConnection_Style.md) | Player arrow styles |

## Summary

### Constructors

**Signature and Description**

```java
ArrowConnection()
```

Use constructor with parameters in your code.

```java
ArrowConnection(@NonNull Direction angularPosition,
                @NonNull java.lang.String label,
                @NonNull Style arrowStyle,
                @NonNull java.lang.String panoramaId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Direction` | `getAngularPosition()`<br>Angular position, degrees. |
| `synchronized java.lang.String` | `getLabel()`<br>label is shown near the arrow |
| `synchronized Style` | `getArrowStyle()`<br>Arrow style. |
| `synchronized java.lang.String` | `getPanoramaId()`<br>panoramaId is passed as a parameter to the onPanoramaChangeIntent method. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ArrowConnection

```java
ArrowConnection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ArrowConnection

```java
ArrowConnection(@NonNull Direction angularPosition,
                @NonNull java.lang.String label,
                @NonNull Style arrowStyle,
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

### getLabel

```java
@NonNull
java.lang.String getLabel()
```

label is shown near the arrow

### getArrowStyle

```java
@NonNull
Style getArrowStyle()
```

Arrow style.

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
