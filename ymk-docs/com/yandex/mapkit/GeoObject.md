---
title: "GeoObject"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / GeoObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObject.html"
---
# GeoObject

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObject.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.GeoObject

`class GeoObject implements Serializable`

Geo object.

Can be displayed as a placemark, polyline, polygon, and other, depending on the geometry type.

## Summary

### Constructors

**Signature and Description**

```java
GeoObject()
```

Use constructor with parameters in your code.

```java
GeoObject(@Nullable java.lang.String name,
          @Nullable java.lang.String descriptionText,
          @NonNull java.util.List<Geometry> geometry,
          @Nullable BoundingBox boundingBox,
          @NonNull java.util.Map<java.lang.String, Attribution> attributionMap,
          @NonNull TypeDictionary<BaseMetadata> metadataContainer,
          @NonNull java.util.List<java.lang.String> aref)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Object name. |
| `synchronized java.lang.String` | `getDescriptionText()`<br>The description of the object. |
| `synchronized java.util.List<Geometry>` | `getGeometry()`<br>The object's geometry. |
| `synchronized BoundingBox` | `getBoundingBox()`<br>A rectangular box around the object. |
| `synchronized java.util.Map<java.lang.String, Attribution>` | `getAttributionMap()`<br>The attribution of information to a specific author. |
| `synchronized TypeDictionary<BaseMetadata>` | `getMetadataContainer()`<br>The object's metadata. |
| `synchronized java.util.List<java.lang.String>` | `getAref()`<br>The name of the internet resource. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### GeoObject

```java
GeoObject()
```

Use constructor with parameters in your code.

This one is for serialization only!

### GeoObject

```java
GeoObject(@Nullable java.lang.String name,
          @Nullable java.lang.String descriptionText,
          @NonNull java.util.List<Geometry> geometry,
          @Nullable BoundingBox boundingBox,
          @NonNull java.util.Map<java.lang.String, Attribution> attributionMap,
          @NonNull TypeDictionary<BaseMetadata> metadataContainer,
          @NonNull java.util.List<java.lang.String> aref)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

Object name.

Optional field, can be null.

### getDescriptionText

```java
@Nullable
java.lang.String getDescriptionText()
```

The description of the object.

Optional field, can be null.

### getGeometry

```java
@NonNull
java.util.List<Geometry> getGeometry()
```

The object's geometry.

### getBoundingBox

```java
@Nullable
BoundingBox getBoundingBox()
```

A rectangular box around the object.

Optional field, can be null.

### getAttributionMap

```java
@NonNull
java.util.Map<java.lang.String, Attribution> getAttributionMap()
```

The attribution of information to a specific author.

### getMetadataContainer

```java
@NonNull
TypeDictionary<BaseMetadata> getMetadataContainer()
```

The object's metadata.

### getAref

```java
@NonNull
java.util.List<java.lang.String> getAref()
```

The name of the internet resource.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
