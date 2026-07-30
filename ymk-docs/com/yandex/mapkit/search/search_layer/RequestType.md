---
title: "RequestType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / RequestType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/RequestType.html"
---
# RequestType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/RequestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.search_layer.RequestType

`final enum RequestType`

Type of search layer's search requests.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NEW_QUERY](RequestType.md#new_query) | Primary request initiated via new query methods. |
| [MANUAL_RESUBMIT](RequestType.md#manual_resubmit) | Manual resubmit on search layer. |
| [FETCH_NEXT_PAGE](RequestType.md#fetch_next_page) | Request to fetch next page of results. |
| [MAP_MOVE_BY_APP](RequestType.md#map_move_by_app) | Request was initiated by map moved via API call. |
| [MAP_MOVE_BY_GESTURE](RequestType.md#map_move_by_gesture) | Request was initiated by map moved via user gesture. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static RequestType[]` | `values()` |
| `static RequestType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NEW_QUERY

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestType](RequestType.md) | NEW_QUERY |

Primary request initiated via new query methods.

### MANUAL_RESUBMIT

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestType](RequestType.md) | MANUAL_RESUBMIT |

Manual resubmit on search layer.

### FETCH_NEXT_PAGE

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestType](RequestType.md) | FETCH_NEXT_PAGE |

Request to fetch next page of results.

### MAP_MOVE_BY_APP

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestType](RequestType.md) | MAP_MOVE_BY_APP |

Request was initiated by map moved via API call.

### MAP_MOVE_BY_GESTURE

|   |   |   |
| --- | --- | --- |
| `static final` | [RequestType](RequestType.md) | MAP_MOVE_BY_GESTURE |

Request was initiated by map moved via user gesture.

## Methods

### values

```java
RequestType[] values()
```

### valueOf

```java
RequestType valueOf(java.lang.String name)
```
