---
title: "GeoObjectInspectionMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / GeoObjectInspectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectInspectionMetadata.html"
---
# GeoObjectInspectionMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectInspectionMetadata.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.GeoObjectInspectionMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class GeoObjectInspectionMetadata implements BaseMetadata, Serializable`

Metadata type added to all objects returned by Map.visibleObjects

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [ObjectType](GeoObjectInspectionMetadata_ObjectType.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
GeoObjectInspectionMetadata()
```

Use constructor with parameters in your code.

```java
GeoObjectInspectionMetadata(@NonNull java.lang.String layerId,
                            @NonNull ObjectType objectType)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getLayerId()` |
| `synchronized ObjectType` | `getObjectType()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### GeoObjectInspectionMetadata

```java
GeoObjectInspectionMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### GeoObjectInspectionMetadata

```java
GeoObjectInspectionMetadata(@NonNull java.lang.String layerId,
                            @NonNull ObjectType objectType)
```

## Methods

### getLayerId

```java
@NonNull
java.lang.String getLayerId()
```

### getObjectType

```java
@NonNull
ObjectType getObjectType()
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
