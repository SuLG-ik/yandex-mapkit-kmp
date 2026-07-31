---
title: "NumberRange"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FilterCollection_NumberRange"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection_NumberRange.html"
---
# NumberRange

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection_NumberRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FilterCollection.NumberRange

`static class NumberRange implements Serializable`

Number range.

Used for range filter.

## Summary

### Constructors

**Signature and Description**

```java
NumberRange(double from,
            double to)
```

```java
NumberRange()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getFrom()`<br>Lower range limit. |
| `double` | `getTo()`<br>Upper range limit. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### NumberRange

```java
NumberRange(double from,
            double to)
```

### NumberRange

```java
NumberRange()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFrom

```java
double getFrom()
```

Lower range limit.

### getTo

```java
double getTo()
```

Upper range limit.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
