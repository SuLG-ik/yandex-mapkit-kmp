---
title: "RotationType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / RotationType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/RotationType.html"
---
# RotationType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/RotationType.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.RotationType

`final enum RotationType`

The way rotation is handled.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NO_ROTATION](RotationType.md#no_rotation) | Ignores the placemark direction; stable in screen space. |
| [ROTATE](RotationType.md#rotate) | Follows the placemark direction. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static RotationType[]` | `values()` |
| `static RotationType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NO_ROTATION

|   |   |   |
| --- | --- | --- |
| `static final` | [RotationType](RotationType.md) | NO_ROTATION |

Ignores the placemark direction; stable in screen space.

### ROTATE

|   |   |   |
| --- | --- | --- |
| `static final` | [RotationType](RotationType.md) | ROTATE |

Follows the placemark direction.

For non-flat placemarks, the direction vector is projected onto the screen plane.

## Methods

### values

```java
RotationType[] values()
```

### valueOf

```java
RotationType valueOf(java.lang.String name)
```
