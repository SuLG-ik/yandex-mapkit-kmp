---
title: "DirectionSignToponym"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignToponym"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignToponym.html"
---
# DirectionSignToponym

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignToponym.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignToponym

`class DirectionSignToponym implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignToponym(@NonNull java.lang.String text,
                     @NonNull DirectionSignStyle style)
```

```java
DirectionSignToponym()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getText()` |
| `DirectionSignStyle` | `getStyle()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignToponym

```java
DirectionSignToponym(@NonNull java.lang.String text,
                     @NonNull DirectionSignStyle style)
```

### DirectionSignToponym

```java
DirectionSignToponym()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

### getStyle

```java
@NonNull
DirectionSignStyle getStyle()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
