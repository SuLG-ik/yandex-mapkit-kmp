---
title: "BoardingArea"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / BoardingOptions_BoardingArea"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/BoardingOptions_BoardingArea.html"
---
# BoardingArea

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/BoardingOptions_BoardingArea.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.BoardingOptions.BoardingArea

`static class BoardingArea implements Serializable`

Area recommended for boarding: wagon, sector, etc.

## Summary

### Constructors

**Signature and Description**

```java
BoardingArea()
```

Use constructor with parameters in your code.

```java
BoardingArea(@Nullable java.lang.String id)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Machine-readable non-localisable boarding area identifier. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BoardingArea

```java
BoardingArea()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BoardingArea

```java
BoardingArea(@Nullable java.lang.String id)
```

## Methods

### getId

```java
@Nullable
java.lang.String getId()
```

Machine-readable non-localisable boarding area identifier.

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
