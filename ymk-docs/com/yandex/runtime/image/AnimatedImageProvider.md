---
title: "AnimatedImageProvider"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.image"
section: "Android / Справочник / com.yandex.runtime.image / AnimatedImageProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/AnimatedImageProvider.html"
---
# AnimatedImageProvider

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/AnimatedImageProvider.html)

**Package** com.yandex.runtime.image

java.lang.Object
↳ com.yandex.runtime.image.AnimatedImageProvider

`abstract class AnimatedImageProvider`

Provides the animated image data.

## Summary

### Constructors

**Signature and Description**

```java
AnimatedImageProvider()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `abstract java.lang.String` | `getId()`<br>Returns the unique identifier for the image. |
| `abstract java.lang.Object` | `getImage()`<br>Returns an animated image data buffer. |
| `static AnimatedImageProvider` | `fromByteArray(byte[] image)`<br>Returns an animated image provider based on the given data. |
| `static AnimatedImageProvider` | `fromResource(android.content.Context context, int resourceId)`<br>Returns an animated image provider based on a given resource. |
| `static AnimatedImageProvider` | `fromAsset(android.content.Context context, java.lang.String assetName)`<br>Returns an animated image provider based on a given asset (from the assets/ directory). |
| `static AnimatedImageProvider` | `fromFile(java.lang.String fileName)`<br>Returns an animated image provider based on an image file from the internal storage. |
| `static AnimatedImageProvider` | `fromAnimatedImage(AnimatedImage image)`<br>Returns an animated image provider. |

## Constuctors

### AnimatedImageProvider

```java
AnimatedImageProvider()
```

## Methods

### getId

```java
java.lang.String getId()
```

Returns the unique identifier for the image.

Providers can be cached based on it.

### getImage

```java
java.lang.Object getImage()
```

Returns an animated image data buffer.

### fromByteArray

```java
AnimatedImageProvider fromByteArray(byte[] image)
```

Returns an animated image provider based on the given data.

Supports only APNG format.

### fromResource

```java
AnimatedImageProvider fromResource(android.content.Context context,
                                   int resourceId)
```

Returns an animated image provider based on a given resource.

Supports only APNG format.

### fromAsset

```java
AnimatedImageProvider fromAsset(android.content.Context context,
                                java.lang.String assetName)
```

Returns an animated image provider based on a given asset (from the assets/ directory).

Supports only APNG format.

### fromFile

```java
AnimatedImageProvider fromFile(java.lang.String fileName)
```

Returns an animated image provider based on an image file from the internal storage.

Supports only APNG format.

### fromAnimatedImage

```java
AnimatedImageProvider fromAnimatedImage(AnimatedImage image)
```

Returns an animated image provider.
