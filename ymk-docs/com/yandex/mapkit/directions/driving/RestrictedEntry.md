---
title: "RestrictedEntry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RestrictedEntry.html"
---
# RestrictedEntry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RestrictedEntry

`class RestrictedEntry implements Serializable`

A restricted entry object.

## Summary

### Constructors

**Signature and Description**

```java
RestrictedEntry(@NonNull PolylinePosition position)
```

```java
RestrictedEntry()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>The position of the restricted entry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RestrictedEntry

```java
RestrictedEntry(@NonNull PolylinePosition position)
```

### RestrictedEntry

```java
RestrictedEntry()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of the restricted entry.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
