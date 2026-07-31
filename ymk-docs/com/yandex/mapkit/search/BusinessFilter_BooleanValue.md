---
title: "BooleanValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilter_BooleanValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_BooleanValue.html"
---
# BooleanValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_BooleanValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilter.BooleanValue

`static class BooleanValue implements Serializable`

Value for boolean filters.

## Summary

### Constructors

**Signature and Description**

```java
BooleanValue(boolean value,
             @Nullable java.lang.Boolean selected)
```

```java
BooleanValue()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getValue()`<br>Filter value. |
| `java.lang.Boolean` | `getSelected()`<br>Selected marker. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### BooleanValue

```java
BooleanValue(boolean value,
             @Nullable java.lang.Boolean selected)
```

### BooleanValue

```java
BooleanValue()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getValue

```java
boolean getValue()
```

Filter value.

Set in server reponse for selected filters.

### getSelected

```java
@Nullable
java.lang.Boolean getSelected()
```

Selected marker.

Set in server response for selected filters.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
