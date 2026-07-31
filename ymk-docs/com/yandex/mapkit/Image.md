---
title: "Image"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Image"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Image.html"
---
# Image

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Image.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Image

`class Image implements Serializable`

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [ImageSize](Image_ImageSize.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
Image()
```

Use constructor with parameters in your code.

```java
Image(@NonNull java.lang.String urlTemplate,
      @NonNull java.util.List<ImageSize> sizes,
      @NonNull java.util.List<java.lang.String> tags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getUrlTemplate()`<br>urlTemplate for the image. |
| `synchronized java.util.List<ImageSize>` | `getSizes()`<br>Image sizes. |
| `synchronized java.util.List<java.lang.String>` | `getTags()`<br>Image tags. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Image

```java
Image()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Image

```java
Image(@NonNull java.lang.String urlTemplate,
      @NonNull java.util.List<ImageSize> sizes,
      @NonNull java.util.List<java.lang.String> tags)
```

## Methods

### getUrlTemplate

```java
@NonNull
java.lang.String getUrlTemplate()
```

urlTemplate for the image.

### getSizes

```java
@NonNull
java.util.List<ImageSize> getSizes()
```

Image sizes.

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

Image tags.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
