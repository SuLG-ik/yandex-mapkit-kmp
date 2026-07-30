---
title: "EventTag"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events"
section: "Android / Справочник / com.yandex.mapkit.road_events / EventTag"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventTag.html"
---
# EventTag

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventTag.html)

**Package** com.yandex.mapkit.road_events

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.road_events.EventTag

`final enum EventTag`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [OTHER](EventTag.md#other) |   |
| [FEEDBACK](EventTag.md#feedback) |   |
| [CHAT](EventTag.md#chat) |   |
| [LOCAL_CHAT](EventTag.md#local_chat) | Same as Chat but limited by distance that you can see it from |
| [DRAWBRIDGE](EventTag.md#drawbridge) | Temporary issues |
| [CLOSED](EventTag.md#closed) |   |
| [RECONSTRUCTION](EventTag.md#reconstruction) |   |
| [ACCIDENT](EventTag.md#accident) |   |
| [DANGER](EventTag.md#danger) | Potentially dangerous zones |
| [SCHOOL](EventTag.md#school) |   |
| [OVERTAKING_DANGER](EventTag.md#overtaking_danger) |   |
| [PEDESTRIAN_DANGER](EventTag.md#pedestrian_danger) |   |
| [CROSS_ROAD_DANGER](EventTag.md#cross_road_danger) |   |
| [POLICE](EventTag.md#police) | Generalizing tag that has any traffic code control event. |
| [LANE_CONTROL](EventTag.md#lane_control) | Traffic code control tags |
| [ROAD_MARKING_CONTROL](EventTag.md#road_marking_control) |   |
| [CROSS_ROAD_CONTROL](EventTag.md#cross_road_control) |   |
| [NO_STOPPING_CONTROL](EventTag.md#no_stopping_control) |   |
| [MOBILE_CONTROL](EventTag.md#mobile_control) |   |
| [SPEED_CONTROL](EventTag.md#speed_control) |   |
| [TRAFFIC_CONTROL](EventTag.md#traffic_control) |   |
| [POLICE_PATROL](EventTag.md#police_patrol) |   |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static EventTag[]` | `values()` |
| `static EventTag` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### OTHER

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | OTHER |

### FEEDBACK

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | FEEDBACK |

### CHAT

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | CHAT |

### LOCAL_CHAT

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | LOCAL_CHAT |

Same as Chat but limited by distance that you can see it from

### DRAWBRIDGE

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | DRAWBRIDGE |

Temporary issues

### CLOSED

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | CLOSED |

### RECONSTRUCTION

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | RECONSTRUCTION |

### ACCIDENT

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | ACCIDENT |

### DANGER

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | DANGER |

Potentially dangerous zones

### SCHOOL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | SCHOOL |

### OVERTAKING_DANGER

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | OVERTAKING_DANGER |

### PEDESTRIAN_DANGER

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | PEDESTRIAN_DANGER |

### CROSS_ROAD_DANGER

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | CROSS_ROAD_DANGER |

### POLICE

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | POLICE |

Generalizing tag that has any traffic code control event.

In old clients all new events fallback to this tag

### LANE_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | LANE_CONTROL |

Traffic code control tags

### ROAD_MARKING_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | ROAD_MARKING_CONTROL |

### CROSS_ROAD_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | CROSS_ROAD_CONTROL |

### NO_STOPPING_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | NO_STOPPING_CONTROL |

### MOBILE_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | MOBILE_CONTROL |

### SPEED_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | SPEED_CONTROL |

### TRAFFIC_CONTROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | TRAFFIC_CONTROL |

### POLICE_PATROL

|   |   |   |
| --- | --- | --- |
| `static final` | [EventTag](EventTag.md) | POLICE_PATROL |

## Methods

### values

```java
EventTag[] values()
```

### valueOf

```java
EventTag valueOf(java.lang.String name)
```
