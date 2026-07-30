---
title: "EncyclopediaObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / EncyclopediaObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/EncyclopediaObjectMetadata.html"
---
# EncyclopediaObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/EncyclopediaObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.EncyclopediaObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class EncyclopediaObjectMetadata implements BaseMetadata, Serializable`

Snippet with encyclopedia data.

## Summary

### Constructors

**Signature and Description**

```java
EncyclopediaObjectMetadata()
```

Use constructor with parameters in your code.

```java
EncyclopediaObjectMetadata(@Nullable java.lang.String title,
                           @Nullable java.lang.String description,
                           @Nullable Attribution attribution)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getTitle()`<br>Encyclopedia article title. |
| `synchronized java.lang.String` | `getDescription()`<br>Encyclopedia article body. |
| `synchronized Attribution` | `getAttribution()`<br>Attribution information. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### EncyclopediaObjectMetadata

```java
EncyclopediaObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### EncyclopediaObjectMetadata

```java
EncyclopediaObjectMetadata(@Nullable java.lang.String title,
                           @Nullable java.lang.String description,
                           @Nullable Attribution attribution)
```

## Methods

### getTitle

```java
@Nullable
java.lang.String getTitle()
```

Encyclopedia article title.

Optional field, can be null.

### getDescription

```java
@Nullable
java.lang.String getDescription()
```

Encyclopedia article body.

Optional field, can be null.

### getAttribution

```java
@Nullable
Attribution getAttribution()
```

Attribution information.

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
