---
title: "Sort"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Sort"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Sort.html"
---
# Sort

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Sort.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Sort

`class Sort implements Serializable`

Describes response sort.

## Summary

### Constructors

**Signature and Description**

```java
Sort(@NonNull SortType type,
     @Nullable SortOrigin origin)
```

```java
Sort()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SortType` | `getType()`<br>Sorting type. |
| `SortOrigin` | `getOrigin()`<br>Sort origin (if results are ordered by distance). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Sort

```java
Sort(@NonNull SortType type,
     @Nullable SortOrigin origin)
```

### Sort

```java
Sort()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getType

```java
@NonNull
SortType getType()
```

Sorting type.

### getOrigin

```java
@Nullable
SortOrigin getOrigin()
```

Sort origin (if results are ordered by distance).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
