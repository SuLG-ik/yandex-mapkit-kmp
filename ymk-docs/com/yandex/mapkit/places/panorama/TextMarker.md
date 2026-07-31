---
title: "TextMarker"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / TextMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TextMarker.html"
---
# TextMarker

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TextMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.TextMarker

`class TextMarker implements Serializable`

Text marker struct

## Summary

### Constructors

**Signature and Description**

```java
TextMarker()
```

Use constructor with parameters in your code.

```java
TextMarker(@NonNull Direction angularPosition,
           @NonNull java.lang.String shortLabel,
           @NonNull java.lang.String fullLabel)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Direction` | `getAngularPosition()`<br>Angular position, degrees. |
| `synchronized java.lang.String` | `getShortLabel()`<br>The text displayed in short mode. |
| `synchronized java.lang.String` | `getFullLabel()`<br>The text displayed in full mode. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TextMarker

```java
TextMarker()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TextMarker

```java
TextMarker(@NonNull Direction angularPosition,
           @NonNull java.lang.String shortLabel,
           @NonNull java.lang.String fullLabel)
```

## Methods

### getAngularPosition

```java
@NonNull
Direction getAngularPosition()
```

Angular position, degrees.

(bearing, tilt) (0, 0) - (north, horizon)

### getShortLabel

```java
@NonNull
java.lang.String getShortLabel()
```

The text displayed in short mode.

For example, a house name '14b'

### getFullLabel

```java
@NonNull
java.lang.String getFullLabel()
```

The text displayed in full mode.

For example, street name + house name 'Lesnaya ul. 14b'

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
