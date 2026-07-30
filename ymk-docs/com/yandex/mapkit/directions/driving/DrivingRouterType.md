---
title: "DrivingRouterType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingRouterType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouterType.html"
---
# DrivingRouterType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouterType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.directions.driving.DrivingRouterType

`final enum DrivingRouterType`

Driving router type.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [ONLINE](DrivingRouterType.md#online) | Online driving router. |
| [OFFLINE](DrivingRouterType.md#offline) | Offline driving router. |
| [COMBINED](DrivingRouterType.md#combined) | Combined driving router. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static DrivingRouterType[]` | `values()` |
| `static DrivingRouterType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### ONLINE

|   |   |   |
| --- | --- | --- |
| `static final` | [DrivingRouterType](DrivingRouterType.md) | ONLINE |

Online driving router.

Always tries to use online router even if network is not available.

### OFFLINE

|   |   |   |
| --- | --- | --- |
| `static final` | [DrivingRouterType](DrivingRouterType.md) | OFFLINE |

Offline driving router.

Always tries to use offline router even if network is available.

### COMBINED

|   |   |   |
| --- | --- | --- |
| `static final` | [DrivingRouterType](DrivingRouterType.md) | COMBINED |

Combined driving router.

Decision to use online or offline router is based on internal timeout. If server manages to respond within given time, then online router result is returned. Otherwise uses offline router.  Will combine online and offline router result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline router is returned to the listener. After that timeout is reduced to zero for all following resubmits.

## Methods

### values

```java
DrivingRouterType[] values()
```

### valueOf

```java
DrivingRouterType valueOf(java.lang.String name)
```
