---
title: "Category"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Category"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Category.html"
---
# Category

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Category.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Category

`class Category implements Serializable`

Single category (also known as rubric) description.

## Summary

### Constructors

**Signature and Description**

```java
Category()
```

Use constructor with parameters in your code.

```java
Category(@NonNull java.lang.String name,
         @Nullable java.lang.String categoryClass,
         @NonNull java.util.List<java.lang.String> tags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Category name. |
| `synchronized java.lang.String` | `getCategoryClass()`<br>Category class. |
| `synchronized java.util.List<java.lang.String>` | `getTags()`<br>Additional non-structured data for the category. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Category

```java
Category()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Category

```java
Category(@NonNull java.lang.String name,
         @Nullable java.lang.String categoryClass,
         @NonNull java.util.List<java.lang.String> tags)
```

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

Category name.

### getCategoryClass

```java
@Nullable
java.lang.String getCategoryClass()
```

Category class.

Different categories can have the same class. For example, "Bar", "Cafe" and "Restaurant" categories inhabit "restaurants" category class.

Optional field, can be null.

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

Additional non-structured data for the category.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
