---
title: "FeatureSet"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FeatureSet"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FeatureSet.html"
---
# FeatureSet

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FeatureSet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FeatureSet

`class FeatureSet implements Serializable`

Collection of features.

## Summary

### Constructors

**Signature and Description**

```java
FeatureSet()
```

Use constructor with parameters in your code.

```java
FeatureSet(@NonNull java.util.List<java.lang.String> ids)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.String>` | `getIds()`<br>IDs for features in the collection. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FeatureSet

```java
FeatureSet()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FeatureSet

```java
FeatureSet(@NonNull java.util.List<java.lang.String> ids)
```

## Methods

### getIds

```java
@NonNull
java.util.List<java.lang.String> getIds()
```

IDs for features in the collection.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
