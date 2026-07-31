---
title: "ImageSize"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Image_ImageSize"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Image_ImageSize.html"
---
# ImageSize

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Image_ImageSize.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Image.ImageSize

`static class ImageSize implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ImageSize(@NonNull java.lang.String size,
          @Nullable java.lang.Integer width,
          @Nullable java.lang.Integer height)
```

```java
ImageSize()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getSize()` |
| `java.lang.Integer` | `getWidth()`<br>Optional field, can be null. |
| `java.lang.Integer` | `getHeight()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ImageSize

```java
ImageSize(@NonNull java.lang.String size,
          @Nullable java.lang.Integer width,
          @Nullable java.lang.Integer height)
```

### ImageSize

```java
ImageSize()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSize

```java
@NonNull
java.lang.String getSize()
```

### getWidth

```java
@Nullable
java.lang.Integer getWidth()
```

Optional field, can be null.

### getHeight

```java
@Nullable
java.lang.Integer getHeight()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
