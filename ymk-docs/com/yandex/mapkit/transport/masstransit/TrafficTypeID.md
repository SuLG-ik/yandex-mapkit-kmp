---
title: "TrafficTypeID"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TrafficTypeID"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TrafficTypeID.html"
---
# TrafficTypeID

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TrafficTypeID.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.transport.masstransit.TrafficTypeID

`final enum TrafficTypeID`

TrafficTypeID describes who the road is designed for.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [OTHER](TrafficTypeID.md#other) | Road that is not one of the following types. |
| [PEDESTRIAN](TrafficTypeID.md#pedestrian) | Footpath, designed only for pedestrian travel. |
| [BICYCLE](TrafficTypeID.md#bicycle) | Bikepath, designed only for bicycle travel. |
| [AUTO](TrafficTypeID.md#auto) | Road designed for motorized vehicles that might be dangerous for cyclists. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static TrafficTypeID[]` | `values()` |
| `static TrafficTypeID` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### OTHER

|   |   |   |
| --- | --- | --- |
| `static final` | [TrafficTypeID](TrafficTypeID.md) | OTHER |

Road that is not one of the following types.

### PEDESTRIAN

|   |   |   |
| --- | --- | --- |
| `static final` | [TrafficTypeID](TrafficTypeID.md) | PEDESTRIAN |

Footpath, designed only for pedestrian travel.

### BICYCLE

|   |   |   |
| --- | --- | --- |
| `static final` | [TrafficTypeID](TrafficTypeID.md) | BICYCLE |

Bikepath, designed only for bicycle travel.

### AUTO

|   |   |   |
| --- | --- | --- |
| `static final` | [TrafficTypeID](TrafficTypeID.md) | AUTO |

Road designed for motorized vehicles that might be dangerous for cyclists.

## Methods

### values

```java
TrafficTypeID[] values()
```

### valueOf

```java
TrafficTypeID valueOf(java.lang.String name)
```
