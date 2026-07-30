---
title: "BusinessFilterGroup"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilterGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilterGroup.html"
---
# BusinessFilterGroup

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilterGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilterGroup

`class BusinessFilterGroup implements Serializable`

Group of filters.

## Summary

### Constructors

**Signature and Description**

```java
BusinessFilterGroup()
```

Use constructor with parameters in your code.

```java
BusinessFilterGroup(@Nullable java.lang.String name,
                    @NonNull java.util.List<java.lang.String> filterIds)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Group name. |
| `synchronized java.util.List<java.lang.String>` | `getFilterIds()`<br>IDs for filters in the group. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessFilterGroup

```java
BusinessFilterGroup()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessFilterGroup

```java
BusinessFilterGroup(@Nullable java.lang.String name,
                    @NonNull java.util.List<java.lang.String> filterIds)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

Group name.

Optional field, can be null.

### getFilterIds

```java
@NonNull
java.util.List<java.lang.String> getFilterIds()
```

IDs for filters in the group.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
