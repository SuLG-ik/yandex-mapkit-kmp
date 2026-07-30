---
title: "FeatureGroup"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FeatureGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FeatureGroup.html"
---
# FeatureGroup

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FeatureGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FeatureGroup

`class FeatureGroup implements Serializable`

Group of features.

## Summary

### Constructors

**Signature and Description**

```java
FeatureGroup()
```

Use constructor with parameters in your code.

```java
FeatureGroup(@Nullable java.lang.String name,
             @NonNull java.util.List<java.lang.String> ids)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Group name. |
| `synchronized java.util.List<java.lang.String>` | `getIds()`<br>IDs for features in the group. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FeatureGroup

```java
FeatureGroup()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FeatureGroup

```java
FeatureGroup(@Nullable java.lang.String name,
             @NonNull java.util.List<java.lang.String> ids)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

Group name.

Optional field, can be null.

### getIds

```java
@NonNull
java.util.List<java.lang.String> getIds()
```

IDs for features in the group.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
