---
title: "LocationStatus"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationStatus"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationStatus.html"
---
# LocationStatus

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationStatus.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.location.LocationStatus

`final enum LocationStatus`

Defines if the location is available or not.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NOT_AVAILABLE](LocationStatus.md#not_available) | Location is not available. |
| [AVAILABLE](LocationStatus.md#available) | Location is available. |
| [RESET](LocationStatus.md#reset) | Global location manager has been changed. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static LocationStatus[]` | `values()` |
| `static LocationStatus` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NOT_AVAILABLE

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationStatus](LocationStatus.md) | NOT_AVAILABLE |

Location is not available.

### AVAILABLE

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationStatus](LocationStatus.md) | AVAILABLE |

Location is available.

### RESET

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationStatus](LocationStatus.md) | RESET |

Global location manager has been changed.

Clients need to reset any state and checks related to location.

## Methods

### values

```java
LocationStatus[] values()
```

### valueOf

```java
LocationStatus valueOf(java.lang.String name)
```
