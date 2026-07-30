---
title: "TimeRange"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / TimeRange"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/TimeRange.html"
---
# TimeRange

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/TimeRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.TimeRange

`class TimeRange implements Serializable`

The time interval used to compose availability info.

Can describe two kinds of intervals: 1. 24-hour interval (`isTwentyFourHours` is true, `from` and `to` are not used). 2. Smaller time interval (`isTwentyFourHours` is false, `from` and `to` are set to the begin and end of the interval)

## Summary

### Constructors

**Signature and Description**

```java
TimeRange(@Nullable java.lang.Boolean isTwentyFourHours,
          @Nullable java.lang.Integer from,
          @Nullable java.lang.Integer to)
```

```java
TimeRange()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Boolean` | `getIsTwentyFourHours()`<br>All day (24 hours) time range marker. |
| `java.lang.Integer` | `getFrom()`<br>Interval start (seconds from midnight). |
| `java.lang.Integer` | `getTo()`<br>Interval end (seconds from midnight). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TimeRange

```java
TimeRange(@Nullable java.lang.Boolean isTwentyFourHours,
          @Nullable java.lang.Integer from,
          @Nullable java.lang.Integer to)
```

### TimeRange

```java
TimeRange()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getIsTwentyFourHours

```java
@Nullable
java.lang.Boolean getIsTwentyFourHours()
```

All day (24 hours) time range marker.

Optional field, can be null.

### getFrom

```java
@Nullable
java.lang.Integer getFrom()
```

Interval start (seconds from midnight).

Optional field, can be null.

### getTo

```java
@Nullable
java.lang.Integer getTo()
```

Interval end (seconds from midnight).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
