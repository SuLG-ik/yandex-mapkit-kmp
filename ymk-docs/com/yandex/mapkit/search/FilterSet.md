---
title: "FilterSet"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FilterSet"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterSet.html"
---
# FilterSet

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterSet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FilterSet

`class FilterSet implements Serializable`

Collection of filters.

## Summary

### Constructors

**Signature and Description**

```java
FilterSet()
```

Use constructor with parameters in your code.

```java
FilterSet(@NonNull java.util.List<java.lang.String> ids)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.String>` | `getIds()`<br>IDs for filters in the collection. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FilterSet

```java
FilterSet()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FilterSet

```java
FilterSet(@NonNull java.util.List<java.lang.String> ids)
```

## Methods

### getIds

```java
@NonNull
java.util.List<java.lang.String> getIds()
```

IDs for filters in the collection.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
