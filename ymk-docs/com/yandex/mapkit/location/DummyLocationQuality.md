---
title: "DummyLocationQuality"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / DummyLocationQuality"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/DummyLocationQuality.html"
---
# DummyLocationQuality

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/DummyLocationQuality.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.location.DummyLocationQuality

`final enum DummyLocationQuality`

The overall current quality of locations.

This is used to switch MapKit between different operating modes. If the locations are of high-quality and frequent (1 Hz), then specify 'High'; otherwise, specify 'Low'.

It is strongly recommended not to change it often, e.g., every location.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [HIGH](DummyLocationQuality.md#high) |   |
| [LOW](DummyLocationQuality.md#low) |   |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static DummyLocationQuality[]` | `values()` |
| `static DummyLocationQuality` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### HIGH

|   |   |   |
| --- | --- | --- |
| `static final` | [DummyLocationQuality](DummyLocationQuality.md) | HIGH |

### LOW

|   |   |   |
| --- | --- | --- |
| `static final` | [DummyLocationQuality](DummyLocationQuality.md) | LOW |

## Methods

### values

```java
DummyLocationQuality[] values()
```

### valueOf

```java
DummyLocationQuality valueOf(java.lang.String name)
```
