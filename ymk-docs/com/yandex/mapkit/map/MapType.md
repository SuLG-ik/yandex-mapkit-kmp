---
title: "MapType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapType.html"
---
# MapType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapType.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.MapType

`final enum MapType`

The type of map displayed.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NONE](MapType.md#none) | Do not use any of the predefined maps. |
| [MAP](MapType.md#map) | Raster map. |
| [SATELLITE](MapType.md#satellite) | Allowed only for Yandex apps Default satellite map. |
| [HYBRID](MapType.md#hybrid) | Allowed only for Yandex apps Satellite map with roads, placemarks and labels. |
| [VECTOR_MAP](MapType.md#vector_map) | Vector map. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static MapType[]` | `values()` |
| `static MapType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NONE

|   |   |   |
| --- | --- | --- |
| `static final` | [MapType](MapType.md) | NONE |

Do not use any of the predefined maps.

### MAP

|   |   |   |
| --- | --- | --- |
| `static final` | [MapType](MapType.md) | MAP |

Raster map.

### SATELLITE

|   |   |   |
| --- | --- | --- |
| `static final` | [MapType](MapType.md) | SATELLITE |

Allowed only for Yandex apps Default satellite map.

### HYBRID

|   |   |   |
| --- | --- | --- |
| `static final` | [MapType](MapType.md) | HYBRID |

Allowed only for Yandex apps Satellite map with roads, placemarks and labels.

### VECTOR_MAP

|   |   |   |
| --- | --- | --- |
| `static final` | [MapType](MapType.md) | VECTOR_MAP |

Vector map.

## Methods

### values

```java
MapType[] values()
```

### valueOf

```java
MapType valueOf(java.lang.String name)
```
