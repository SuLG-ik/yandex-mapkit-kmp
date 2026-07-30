---
title: "Frame"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.image"
section: "Android / Справочник / com.yandex.runtime.image / Frame"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/Frame.html"
---
# Frame

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/Frame.html)

**Package** com.yandex.runtime.image

java.lang.Object
↳ com.yandex.runtime.image.Frame

`class Frame`

## Summary

### Constructors

**Signature and Description**

```java
Frame(ImageProvider image,
      long duration)
```

A frame in the animated image.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ImageProvider` | `getImage()`<br>Returns a provider of the frame image. |
| `long` | `getDuration()`<br>Returns the number of milliseconds the image is displayed. |

## Constuctors

### Frame

```java
Frame(ImageProvider image,
      long duration)
```

A frame in the animated image.

## Methods

### getImage

```java
ImageProvider getImage()
```

Returns a provider of the frame image.

### getDuration

```java
long getDuration()
```

Returns the number of milliseconds the image is displayed.
