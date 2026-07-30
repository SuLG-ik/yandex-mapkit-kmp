---
title: "PersonalizedPoiExtraMetadataEntry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.personalized_poi"
section: "Android / Справочник / com.yandex.mapkit.personalized_poi / PersonalizedPoiExtraMetadataEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/personalized_poi/PersonalizedPoiExtraMetadataEntry.html"
---
# PersonalizedPoiExtraMetadataEntry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/personalized_poi/PersonalizedPoiExtraMetadataEntry.html)

**Package** com.yandex.mapkit.personalized_poi

java.lang.Object
↳ com.yandex.mapkit.personalized_poi.PersonalizedPoiExtraMetadataEntry

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class PersonalizedPoiExtraMetadataEntry implements BaseMetadata, Serializable`

## Summary

### Constructors

**Signature and Description**

```java
PersonalizedPoiExtraMetadataEntry()
```

Use constructor with parameters in your code.

```java
PersonalizedPoiExtraMetadataEntry(@Nullable java.lang.String key,
                                  @Nullable java.lang.String value)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getKey()`<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getValue()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PersonalizedPoiExtraMetadataEntry

```java
PersonalizedPoiExtraMetadataEntry()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PersonalizedPoiExtraMetadataEntry

```java
PersonalizedPoiExtraMetadataEntry(@Nullable java.lang.String key,
                                  @Nullable java.lang.String value)
```

## Methods

### getKey

```java
@Nullable
java.lang.String getKey()
```

Optional field, can be null.

### getValue

```java
@Nullable
java.lang.String getValue()
```

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
