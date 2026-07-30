---
title: "RestrictedEntriesContainer"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RestrictedEntriesContainer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RestrictedEntriesContainer.html"
---
# RestrictedEntriesContainer

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RestrictedEntriesContainer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RestrictedEntriesContainer

`class RestrictedEntriesContainer implements Serializable`

Defines a vector of points on a pedestrian path.

## Summary

### Constructors

**Signature and Description**

```java
RestrictedEntriesContainer()
```

Use constructor with parameters in your code.

```java
RestrictedEntriesContainer(@NonNull java.util.List<RestrictedEntry> entries)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<RestrictedEntry>` | `getEntries()`<br>Vector of points on a pedestrian path. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RestrictedEntriesContainer

```java
RestrictedEntriesContainer()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RestrictedEntriesContainer

```java
RestrictedEntriesContainer(@NonNull java.util.List<RestrictedEntry> entries)
```

## Methods

### getEntries

```java
@NonNull
java.util.List<RestrictedEntry> getEntries()
```

Vector of points on a pedestrian path.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
