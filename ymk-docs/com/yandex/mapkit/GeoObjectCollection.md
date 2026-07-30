---
title: "GeoObjectCollection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / GeoObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectCollection.html"
---
# GeoObjectCollection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectCollection.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.GeoObjectCollection

`class GeoObjectCollection implements Serializable`

A collection of geo objects.

Allows you to group geo objects for adding them to the map, setting options, etc. Collections are geo objects too.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Item](GeoObjectCollection_Item.md) | The geo objects in the collection. |

## Summary

### Constructors

**Signature and Description**

```java
GeoObjectCollection()
```

Use constructor with parameters in your code.

```java
GeoObjectCollection(@Nullable BoundingBox boundingBox,
                    @NonNull TypeDictionary<BaseMetadata> metadataContainer,
                    @NonNull java.util.List<Item> children)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized BoundingBox` | `getBoundingBox()`<br>The bounds around the collection of objects. |
| `synchronized TypeDictionary<BaseMetadata>` | `getMetadataContainer()`<br>The metadata for the objects. |
| `synchronized java.util.List<Item>` | `getChildren()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### GeoObjectCollection

```java
GeoObjectCollection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### GeoObjectCollection

```java
GeoObjectCollection(@Nullable BoundingBox boundingBox,
                    @NonNull TypeDictionary<BaseMetadata> metadataContainer,
                    @NonNull java.util.List<Item> children)
```

## Methods

### getBoundingBox

```java
@Nullable
BoundingBox getBoundingBox()
```

The bounds around the collection of objects.

Optional field, can be null.

### getMetadataContainer

```java
@NonNull
TypeDictionary<BaseMetadata> getMetadataContainer()
```

The metadata for the objects.

### getChildren

```java
@NonNull
java.util.List<Item> getChildren()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
