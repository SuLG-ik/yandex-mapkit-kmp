---
title: "ImageProvider"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.image"
section: "Android / Справочник / com.yandex.runtime.image / ImageProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/ImageProvider.html"
---
# ImageProvider

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/ImageProvider.html)

**Package** com.yandex.runtime.image

java.lang.Object
↳ com.yandex.runtime.image.ImageProvider

`abstract class ImageProvider`

Provides **Bitmap** objects from different input sources.

Extend this class to provide images from custom sources.

## Summary

### Constructors

**Signature and Description**

```java
ImageProvider()
```

```java
ImageProvider(boolean cacheable)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isCacheable()`<br>Determines whether image should be cached on GPU or not. |
| `abstract java.lang.String` | `getId()`<br>Returns the unique identifier for an image. |
| `abstract android.graphics.Bitmap` | `getImage()`<br>Returns the image in bitmap format. |
| `static ImageProvider` | `fromBitmap(android.graphics.Bitmap bitmap)` |
| `static ImageProvider` | `fromBitmap(android.graphics.Bitmap bitmap, boolean cacheable, java.lang.String id)`<br>Returns the image provider based on a given bitmap. |
| `static ImageProvider` | `fromAsset(android.content.Context context, java.lang.String assetName)` |
| `static ImageProvider` | `fromAsset(android.content.Context context, java.lang.String assetName, boolean cacheable)`<br>Returns the image provider based on a given asset (from the assets/ folder). |
| `static ImageProvider` | `fromResource(android.content.Context context, int resourceId)` |
| `static ImageProvider` | `fromResource(android.content.Context context, int resourceId, boolean cacheable)`<br>Returns the image provider based on an application resource (from the res/ folder). |
| `static ImageProvider` | `fromFile(java.lang.String fileName)` |
| `static ImageProvider` | `fromFile(java.lang.String fileName, boolean cacheable)`<br>Returns the image provider based on an image file from the internal storage. |

## Constuctors

### ImageProvider

```java
ImageProvider()
```

### ImageProvider

```java
ImageProvider(boolean cacheable)
```

## Methods

### isCacheable

```java
boolean isCacheable()
```

Determines whether image should be cached on GPU or not.

### getId

```java
java.lang.String getId()
```

Returns the unique identifier for an image.

Providers can be cached based on it.

### getImage

```java
android.graphics.Bitmap getImage()
```

Returns the image in bitmap format.

### fromBitmap

```java
ImageProvider fromBitmap(android.graphics.Bitmap bitmap)
```

### fromBitmap

```java
ImageProvider fromBitmap(android.graphics.Bitmap bitmap,
                         boolean cacheable,
                         java.lang.String id)
```

Returns the image provider based on a given bitmap.

### fromAsset

```java
ImageProvider fromAsset(android.content.Context context,
                        java.lang.String assetName)
```

### fromAsset

```java
ImageProvider fromAsset(android.content.Context context,
                        java.lang.String assetName,
                        boolean cacheable)
```

Returns the image provider based on a given asset (from the assets/ folder).

### fromResource

```java
ImageProvider fromResource(android.content.Context context,
                           int resourceId)
```

### fromResource

```java
ImageProvider fromResource(android.content.Context context,
                           int resourceId,
                           boolean cacheable)
```

Returns the image provider based on an application resource (from the res/ folder).

### fromFile

```java
ImageProvider fromFile(java.lang.String fileName)
```

### fromFile

```java
ImageProvider fromFile(java.lang.String fileName,
                       boolean cacheable)
```

Returns the image provider based on an image file from the internal storage.
