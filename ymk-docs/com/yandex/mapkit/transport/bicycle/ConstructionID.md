---
title: "ConstructionID"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / ConstructionID"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ConstructionID.html"
---
# ConstructionID

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ConstructionID.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.transport.bicycle.ConstructionID

`final enum ConstructionID`

Construction types for the segments in the geometry.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [UNKNOWN](ConstructionID.md#unknown) | Regular bicycle path segment or a segment without any additional information known. |
| [BINDING](ConstructionID.md#binding) | Edge connecting the route endpoint to the bicycle route network. |
| [STAIRS_UP](ConstructionID.md#stairs_up) | Stairway with stairs going up along a path. |
| [STAIRS_DOWN](ConstructionID.md#stairs_down) | Stairway with stairs going down along a path. |
| [STAIRS_UNKNOWN](ConstructionID.md#stairs_unknown) | Stairway with no information whether stairs go up or down along a path. |
| [UNDERPASS](ConstructionID.md#underpass) | Underground crossing. |
| [OVERPASS](ConstructionID.md#overpass) | Overground crossing. |
| [CROSSING](ConstructionID.md#crossing) | Crossing that is not an underground tunnel or a bridge. |
| [TUNNEL](ConstructionID.md#tunnel) | Tunnel that is not a crossing. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static ConstructionID[]` | `values()` |
| `static ConstructionID` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### UNKNOWN

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | UNKNOWN |

Regular bicycle path segment or a segment without any additional information known.

### BINDING

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | BINDING |

Edge connecting the route endpoint to the bicycle route network.

### STAIRS_UP

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | STAIRS_UP |

Stairway with stairs going up along a path.

### STAIRS_DOWN

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | STAIRS_DOWN |

Stairway with stairs going down along a path.

### STAIRS_UNKNOWN

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | STAIRS_UNKNOWN |

Stairway with no information whether stairs go up or down along a path.

### UNDERPASS

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | UNDERPASS |

Underground crossing.

### OVERPASS

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | OVERPASS |

Overground crossing.

### CROSSING

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | CROSSING |

Crossing that is not an underground tunnel or a bridge.

### TUNNEL

|   |   |   |
| --- | --- | --- |
| `static final` | [ConstructionID](ConstructionID.md) | TUNNEL |

Tunnel that is not a crossing.

## Methods

### values

```java
ConstructionID[] values()
```

### valueOf

```java
ConstructionID valueOf(java.lang.String name)
```
