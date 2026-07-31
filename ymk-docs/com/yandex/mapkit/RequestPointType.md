---
title: "RequestPointType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / RequestPointType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RequestPointType.html"
---
# RequestPointType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RequestPointType.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.RequestPointType

`final enum RequestPointType`

The waypoint and a point the path must go through.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [WAYPOINT](RequestPointType.md#waypoint) | The target waypoint. |
| [VIAPOINT](RequestPointType.md#viapoint) | A point the route must pass through. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static RequestPointType[]` | `values()` |
| `static RequestPointType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### WAYPOINT

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestPointType](RequestPointType.md) | WAYPOINT |

The target waypoint.

### VIAPOINT

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestPointType](RequestPointType.md) | VIAPOINT |

A point the route must pass through.

## Methods

### values

```java
RequestPointType[] values()
```

### valueOf

```java
RequestPointType valueOf(java.lang.String name)
```
