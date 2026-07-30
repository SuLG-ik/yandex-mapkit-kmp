---
title: "Entrance"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Entrance"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Entrance.html"
---
# Entrance

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Entrance.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Entrance

`class Entrance implements Serializable`

An entrance to a building

## Summary

### Constructors

**Signature and Description**

```java
Entrance()
```

Use constructor with parameters in your code.

```java
Entrance(@Nullable java.lang.String name,
         @NonNull Point point,
         @Nullable Direction direction)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Optional field, can be null. |
| `synchronized Point` | `getPoint()` |
| `synchronized Direction` | `getDirection()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Entrance

```java
Entrance()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Entrance

```java
Entrance(@Nullable java.lang.String name,
         @NonNull Point point,
         @Nullable Direction direction)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

Optional field, can be null.

### getPoint

```java
@NonNull
Point getPoint()
```

### getDirection

```java
@Nullable
Direction getDirection()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
