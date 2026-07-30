---
title: "ImageDataDescriptor"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.images"
section: "Android / Справочник / com.yandex.mapkit.images / ImageDataDescriptor"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/images/ImageDataDescriptor.html"
---
# ImageDataDescriptor

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/images/ImageDataDescriptor.html)

**Package** com.yandex.mapkit.images

java.lang.Object
↳ com.yandex.mapkit.images.ImageDataDescriptor

`class ImageDataDescriptor implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ImageDataDescriptor(@NonNull java.lang.String imageId,
                    @Nullable java.lang.Integer primaryColor,
                    @Nullable java.lang.Integer secondaryColor,
                    @Nullable java.lang.Integer tertiaryColor)
```

```java
ImageDataDescriptor()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getImageId()` |
| `java.lang.Integer` | `getPrimaryColor()`<br>Optional field, can be null. |
| `java.lang.Integer` | `getSecondaryColor()`<br>Optional field, can be null. |
| `java.lang.Integer` | `getTertiaryColor()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ImageDataDescriptor

```java
ImageDataDescriptor(@NonNull java.lang.String imageId,
                    @Nullable java.lang.Integer primaryColor,
                    @Nullable java.lang.Integer secondaryColor,
                    @Nullable java.lang.Integer tertiaryColor)
```

### ImageDataDescriptor

```java
ImageDataDescriptor()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getImageId

```java
@NonNull
java.lang.String getImageId()
```

### getPrimaryColor

```java
@Nullable
java.lang.Integer getPrimaryColor()
```

Optional field, can be null.

### getSecondaryColor

```java
@Nullable
java.lang.Integer getSecondaryColor()
```

Optional field, can be null.

### getTertiaryColor

```java
@Nullable
java.lang.Integer getTertiaryColor()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
