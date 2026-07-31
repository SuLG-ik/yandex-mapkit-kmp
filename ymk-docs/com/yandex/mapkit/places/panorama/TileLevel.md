---
title: "TileLevel"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / TileLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileLevel.html"
---
# TileLevel

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileLevel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.TileLevel

`class TileLevel implements Serializable`

The TileLevel struct.

## Summary

### Constructors

**Signature and Description**

```java
TileLevel()
```

Use constructor with parameters in your code.

```java
TileLevel(int level,
          @NonNull ImageSize imageSize)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getLevel()`<br>level is passed as a parameter to the TileImageFactory or to the TileUrlProvider. |
| `synchronized ImageSize` | `getImageSize()`<br>Source image size. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TileLevel

```java
TileLevel()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TileLevel

```java
TileLevel(int level,
          @NonNull ImageSize imageSize)
```

## Methods

### getLevel

```java
int getLevel()
```

level is passed as a parameter to the TileImageFactory or to the TileUrlProvider.

Each panorama description tile level must have unique value.

### getImageSize

```java
@NonNull
ImageSize getImageSize()
```

Source image size.

The imageSize width must be multiples of the tileSize width. The imageSize height must be in range [1..imageSize.width/2]

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
