---
title: "GeoObjectSelectionMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / GeoObjectSelectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectSelectionMetadata.html"
---
# GeoObjectSelectionMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectSelectionMetadata.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.GeoObjectSelectionMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class GeoObjectSelectionMetadata implements BaseMetadata, Serializable`

Geo object metadata which is needed to select object.

## Summary

### Constructors

**Signature and Description**

```java
GeoObjectSelectionMetadata()
```

Use constructor with parameters in your code.

```java
GeoObjectSelectionMetadata(@NonNull java.lang.String objectId,
                           @NonNull java.lang.String dataSourceName,
                           @NonNull java.lang.String layerId,
                           @Nullable java.lang.Long groupId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getObjectId()`<br>Object ID. |
| `synchronized java.lang.String` | `getDataSourceName()`<br>Data source name. |
| `synchronized java.lang.String` | `getLayerId()`<br>Layer ID. |
| `synchronized java.lang.Long` | `getGroupId()`<br>Group ID. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### GeoObjectSelectionMetadata

```java
GeoObjectSelectionMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### GeoObjectSelectionMetadata

```java
GeoObjectSelectionMetadata(@NonNull java.lang.String objectId,
                           @NonNull java.lang.String dataSourceName,
                           @NonNull java.lang.String layerId,
                           @Nullable java.lang.Long groupId)
```

## Methods

### getObjectId

```java
@NonNull
java.lang.String getObjectId()
```

Object ID.

### getDataSourceName

```java
@NonNull
java.lang.String getDataSourceName()
```

Data source name.

### getLayerId

```java
@NonNull
java.lang.String getLayerId()
```

Layer ID.

### getGroupId

```java
@Nullable
java.lang.Long getGroupId()
```

Group ID.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
