---
title: "SystemOfMeasurement"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.runtime.i18n"
section: "Android / Справочник / com.yandex.runtime.i18n / SystemOfMeasurement"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/SystemOfMeasurement.html"
---
# SystemOfMeasurement

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/SystemOfMeasurement.html)

**Package** com.yandex.runtime.i18n

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.runtime.i18n.SystemOfMeasurement

`final enum SystemOfMeasurement`

The .h generated from this idl should define the same entities as libs/i18n/include/yandex/maps/i18n/prefs.h from the mapscore repo.

Please edit these two files simultaneously. The system of measurement to use.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [DEFAULT](SystemOfMeasurement.md#default) |   |
| [METRIC](SystemOfMeasurement.md#metric) | Metric system. |
| [IMPERIAL](SystemOfMeasurement.md#imperial) | Imperial system. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SystemOfMeasurement[]` | `values()` |
| `static SystemOfMeasurement` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### DEFAULT

|   |   |   |
| --- | --- | --- |
| `static final` | [SystemOfMeasurement](SystemOfMeasurement.md) | DEFAULT |

### METRIC

|   |   |   |
| --- | --- | --- |
| `static final` | [SystemOfMeasurement](SystemOfMeasurement.md) | METRIC |

Metric system.

(kilometers etc)

### IMPERIAL

|   |   |   |
| --- | --- | --- |
| `static final` | [SystemOfMeasurement](SystemOfMeasurement.md) | IMPERIAL |

Imperial system.

(miles etc)

## Methods

### values

```java
SystemOfMeasurement[] values()
```

### valueOf

```java
SystemOfMeasurement valueOf(java.lang.String name)
```
