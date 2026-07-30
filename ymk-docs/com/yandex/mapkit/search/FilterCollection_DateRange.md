---
title: "DateRange"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FilterCollection_DateRange"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection_DateRange.html"
---
# DateRange

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection_DateRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FilterCollection.DateRange

`static class DateRange implements Serializable`

Date range.

Dates are encoded as strings in YYYYMMDD format.

## Summary

### Constructors

**Signature and Description**

```java
DateRange(@NonNull java.lang.String from,
          @NonNull java.lang.String to)
```

```java
DateRange()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getFrom()`<br>Lower range limit. |
| `java.lang.String` | `getTo()`<br>Upper range limit. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DateRange

```java
DateRange(@NonNull java.lang.String from,
          @NonNull java.lang.String to)
```

### DateRange

```java
DateRange()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFrom

```java
@NonNull
java.lang.String getFrom()
```

Lower range limit.

### getTo

```java
@NonNull
java.lang.String getTo()
```

Upper range limit.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
