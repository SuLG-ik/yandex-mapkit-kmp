---
title: "PersonalizedPoiExtraMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.personalized_poi"
section: "Android / Справочник / com.yandex.mapkit.personalized_poi / PersonalizedPoiExtraMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/personalized_poi/PersonalizedPoiExtraMetadata.html"
---
# PersonalizedPoiExtraMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/personalized_poi/PersonalizedPoiExtraMetadata.html)

**Package** com.yandex.mapkit.personalized_poi

java.lang.Object
↳ com.yandex.mapkit.personalized_poi.PersonalizedPoiExtraMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class PersonalizedPoiExtraMetadata implements BaseMetadata, Serializable`

## Summary

### Constructors

**Signature and Description**

```java
PersonalizedPoiExtraMetadata()
```

Use constructor with parameters in your code.

```java
PersonalizedPoiExtraMetadata(@NonNull java.util.List<PersonalizedPoiExtraMetadataEntry> data)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<PersonalizedPoiExtraMetadataEntry>` | `getData()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PersonalizedPoiExtraMetadata

```java
PersonalizedPoiExtraMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PersonalizedPoiExtraMetadata

```java
PersonalizedPoiExtraMetadata(@NonNull java.util.List<PersonalizedPoiExtraMetadataEntry> data)
```

## Methods

### getData

```java
@NonNull
java.util.List<PersonalizedPoiExtraMetadataEntry> getData()
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
