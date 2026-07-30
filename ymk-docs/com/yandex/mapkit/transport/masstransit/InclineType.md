---
title: "InclineType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / InclineType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/InclineType.html"
---
# InclineType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/InclineType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.transport.masstransit.InclineType

`final enum InclineType`

Rough estimate of user experience on a specific section of a fitness route

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [EXTREME_ASCENT](InclineType.md#extreme_ascent) | Very quick elevation gain, difficult for any non-athlete |
| [MODERATE_ASCENT](InclineType.md#moderate_ascent) | Moderate elevation gain, could be difficult for some people |
| [PLATEAU](InclineType.md#plateau) | No meaningful elevation gain or loss, |
| [MODERATE_DESCENT](InclineType.md#moderate_descent) | Moderate elevation loss |
| [EXTREME_DESCENT](InclineType.md#extreme_descent) | Very quick elevation loss, could be difficult or dangerous |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static InclineType[]` | `values()` |
| `static InclineType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### EXTREME_ASCENT

|   |   |   |
| --- | --- | --- |
| `static final` | [InclineType](InclineType.md) | EXTREME_ASCENT |

Very quick elevation gain, difficult for any non-athlete

### MODERATE_ASCENT

|   |   |   |
| --- | --- | --- |
| `static final` | [InclineType](InclineType.md) | MODERATE_ASCENT |

Moderate elevation gain, could be difficult for some people

### PLATEAU

|   |   |   |
| --- | --- | --- |
| `static final` | [InclineType](InclineType.md) | PLATEAU |

No meaningful elevation gain or loss,

### MODERATE_DESCENT

|   |   |   |
| --- | --- | --- |
| `static final` | [InclineType](InclineType.md) | MODERATE_DESCENT |

Moderate elevation loss

### EXTREME_DESCENT

|   |   |   |
| --- | --- | --- |
| `static final` | [InclineType](InclineType.md) | EXTREME_DESCENT |

Very quick elevation loss, could be difficult or dangerous

## Methods

### values

```java
InclineType[] values()
```

### valueOf

```java
InclineType valueOf(java.lang.String name)
```
