---
title: "Availability"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Availability"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Availability.html"
---
# Availability

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Availability.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Availability

`class Availability implements Serializable`

A single value of availability information.

Allows to describe business schedule for a group of days. For example, an organization open on weekdays from 9 AM to 6 PM with a lunch break from 1 PM to 2 PM can be described as a single `Availability` with `days` equal to `DayGroup::Weekdays` and two time ranges (9:00-13:00, 14:00-18:00). More complicated schedules will require multiple `Availabilities`.

## Summary

### Constructors

**Signature and Description**

```java
Availability()
```

Use constructor with parameters in your code.

```java
Availability(int days,
             @NonNull java.util.List<TimeRange> timeRanges)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getDays()`<br>Days where time ranges are applicable |
| `synchronized java.util.List<TimeRange>` | `getTimeRanges()`<br>Ranges for open hours |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Availability

```java
Availability()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Availability

```java
Availability(int days,
             @NonNull java.util.List<TimeRange> timeRanges)
```

## Methods

### getDays

```java
int getDays()
```

Days where time ranges are applicable

### getTimeRanges

```java
@NonNull
java.util.List<TimeRange> getTimeRanges()
```

Ranges for open hours

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
