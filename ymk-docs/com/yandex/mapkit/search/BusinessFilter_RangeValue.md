---
title: "RangeValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilter_RangeValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_RangeValue.html"
---
# RangeValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_RangeValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilter.RangeValue

`static class RangeValue implements Serializable`

Value for range filters.

## Summary

### Constructors

**Signature and Description**

```java
RangeValue(double from,
           double to)
```

```java
RangeValue()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getFrom()`<br>Minimum allowed filter value. |
| `double` | `getTo()`<br>Maximum allowed filter value. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RangeValue

```java
RangeValue(double from,
           double to)
```

### RangeValue

```java
RangeValue()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFrom

```java
double getFrom()
```

Minimum allowed filter value.

### getTo

```java
double getTo()
```

Maximum allowed filter value.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
