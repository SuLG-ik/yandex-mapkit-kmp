---
title: "Purpose"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / Purpose"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Purpose.html"
---
# Purpose

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Purpose.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.location.Purpose

`final enum Purpose`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [GENERAL](Purpose.md#general) | This mode uses less resources and is the default. |
| [AUTOMOTIVE_NAVIGATION](Purpose.md#automotive_navigation) | This mode is used to configure LocationManager for automotive navigation. |
| [PEDESTRIAN_NAVIGATION](Purpose.md#pedestrian_navigation) | This mode is used to configure LocationManager for pedestrian navigation. |
| [BICYCLE_NAVIGATION](Purpose.md#bicycle_navigation) | This mode is used to configure LocationManager for bicycle navigation. |
| [SCOOTER_NAVIGATION](Purpose.md#scooter_navigation) | This mode is used to configure LocationManager for scooter navigation. |
| [STATIC_DISPLAY_LOCATION](Purpose.md#static_display_location) | This mode is used to configure LocationManager for show current user location. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Purpose[]` | `values()` |
| `static Purpose` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### GENERAL

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | GENERAL |

This mode uses less resources and is the default.

### AUTOMOTIVE_NAVIGATION

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | AUTOMOTIVE_NAVIGATION |

This mode is used to configure LocationManager for automotive navigation.

Frequent location updates are desired even though more resources are used.

### PEDESTRIAN_NAVIGATION

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | PEDESTRIAN_NAVIGATION |

This mode is used to configure LocationManager for pedestrian navigation.

Frequent location updates are desired even though more resources are used.

### BICYCLE_NAVIGATION

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | BICYCLE_NAVIGATION |

This mode is used to configure LocationManager for bicycle navigation.

Frequent location updates are desired even though more resources are used.

### SCOOTER_NAVIGATION

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | SCOOTER_NAVIGATION |

This mode is used to configure LocationManager for scooter navigation.

Frequent location updates are desired even though more resources are used.

### STATIC_DISPLAY_LOCATION

|   |   |   |
| --- | --- | --- |
| `static final` | [Purpose](Purpose.md) | STATIC_DISPLAY_LOCATION |

This mode is used to configure LocationManager for show current user location.

This mode uses less resources and as the default value, but this value turns on location reporting.

## Methods

### values

```java
Purpose[] values()
```

### valueOf

```java
Purpose valueOf(java.lang.String name)
```
