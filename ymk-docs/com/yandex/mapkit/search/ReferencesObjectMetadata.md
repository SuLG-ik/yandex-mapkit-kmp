---
title: "ReferencesObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ReferencesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ReferencesObjectMetadata.html"
---
# ReferencesObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ReferencesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ReferencesObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class ReferencesObjectMetadata implements BaseMetadata, Serializable`

Reference metadata information.

## Summary

### Constructors

**Signature and Description**

```java
ReferencesObjectMetadata()
```

Use constructor with parameters in your code.

```java
ReferencesObjectMetadata(@NonNull java.util.List<ReferenceType> references)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<ReferenceType>` | `getReferences()`<br>The  list of references. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ReferencesObjectMetadata

```java
ReferencesObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ReferencesObjectMetadata

```java
ReferencesObjectMetadata(@NonNull java.util.List<ReferenceType> references)
```

## Methods

### getReferences

```java
@NonNull
java.util.List<ReferenceType> getReferences()
```

The  list of references.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
