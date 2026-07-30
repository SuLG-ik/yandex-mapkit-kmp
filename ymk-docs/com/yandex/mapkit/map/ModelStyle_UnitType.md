---
title: "UnitType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / ModelStyle_UnitType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ModelStyle_UnitType.html"
---
# UnitType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ModelStyle_UnitType.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.ModelStyle.UnitType

`static final enum UnitType`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [UNIT](ModelStyle_UnitType.md#unit) | The model is given in units. |
| [NORMALIZED](ModelStyle_UnitType.md#normalized) |   |
| [METER](ModelStyle_UnitType.md#meter) | The model is given in meters. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static UnitType[]` | `values()` |
| `static UnitType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### UNIT

|   |   |   |
| --- | --- | --- |
| `static final` | [UnitType](ModelStyle_UnitType.md) | UNIT |

The model is given in units.

The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### NORMALIZED

|   |   |   |
| --- | --- | --- |
| `static final` | [UnitType](ModelStyle_UnitType.md) | NORMALIZED |

> [!CAUTION] Внимание
> Use UnitType.Unit instead. Scale model proportionally to fit into 1x1x1 box.

### METER

|   |   |   |
| --- | --- | --- |
| `static final` | [UnitType](ModelStyle_UnitType.md) | METER |

The model is given in meters.

## Methods

### values

```java
UnitType[] values()
```

### valueOf

```java
UnitType valueOf(java.lang.String name)
```
