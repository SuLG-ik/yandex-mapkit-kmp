---
title: "Line"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Line"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Line.html"
---
# Line

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Line.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Line

`class Line implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Line(@NonNull java.lang.String name)
```

```java
Line()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getName()`<br>Name of the line that the nearest stop is on. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Line

```java
Line(@NonNull java.lang.String name)
```

### Line

```java
Line()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

Name of the line that the nearest stop is on.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
