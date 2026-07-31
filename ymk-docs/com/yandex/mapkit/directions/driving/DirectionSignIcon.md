---
title: "DirectionSignIcon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignIcon.html"
---
# DirectionSignIcon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignIcon.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignIcon

`class DirectionSignIcon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignIcon(@NonNull DirectionSignImage image,
                  @NonNull DirectionSignStyle style)
```

```java
DirectionSignIcon()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `DirectionSignImage` | `getImage()` |
| `DirectionSignStyle` | `getStyle()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignIcon

```java
DirectionSignIcon(@NonNull DirectionSignImage image,
                  @NonNull DirectionSignStyle style)
```

### DirectionSignIcon

```java
DirectionSignIcon()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getImage

```java
@NonNull
DirectionSignImage getImage()
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
