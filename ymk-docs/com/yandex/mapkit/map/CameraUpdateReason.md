---
title: "CameraUpdateReason"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CameraUpdateReason"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraUpdateReason.html"
---
# CameraUpdateReason

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraUpdateReason.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.CameraUpdateReason

`final enum CameraUpdateReason`

The reason of the camera update.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [GESTURES](CameraUpdateReason.md#gestures) | User manipulation, for example: zoom, scroll, rotate, fling. |
| [APPLICATION](CameraUpdateReason.md#application) | Application, by calling the map::move method. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static CameraUpdateReason[]` | `values()` |
| `static CameraUpdateReason` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### GESTURES

|   |   |   |
| --- | --- | --- |
| `static final` | [CameraUpdateReason](CameraUpdateReason.md) | GESTURES |

User manipulation, for example: zoom, scroll, rotate, fling.

### APPLICATION

|   |   |   |
| --- | --- | --- |
| `static final` | [CameraUpdateReason](CameraUpdateReason.md) | APPLICATION |

Application, by calling the map::move method.

## Methods

### values

```java
CameraUpdateReason[] values()
```

### valueOf

```java
CameraUpdateReason valueOf(java.lang.String name)
```
