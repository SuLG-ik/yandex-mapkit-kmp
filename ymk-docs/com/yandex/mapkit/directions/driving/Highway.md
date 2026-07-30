---
title: "Highway"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Highway"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Highway.html"
---
# Highway

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Highway.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Highway

`class Highway implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Highway(@NonNull Subpolyline position)
```

```java
Highway()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Subpolyline` | `getPosition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Highway

```java
Highway(@NonNull Subpolyline position)
```

### Highway

```java
Highway()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
Subpolyline getPosition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
