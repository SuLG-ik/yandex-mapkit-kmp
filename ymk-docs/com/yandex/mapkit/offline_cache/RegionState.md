---
title: "RegionState"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / RegionState"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionState.html"
---
# RegionState

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionState.html)

**Package** com.yandex.mapkit.offline_cache

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.offline_cache.RegionState

`final enum RegionState`

The state of the region.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [AVAILABLE](RegionState.md#available) | Available for download on the server. |
| [DOWNLOADING](RegionState.md#downloading) | Download in progress. |
| [PAUSED](RegionState.md#paused) | Download is paused. |
| [COMPLETED](RegionState.md#completed) | Cache data installation is finished. |
| [OUTDATED](RegionState.md#outdated) | The region was completed but there is a newer version on the server. |
| [UNSUPPORTED](RegionState.md#unsupported) | The region was removed from regions list and will never be updated |
| [NEED_UPDATE](RegionState.md#need_update) | The region is significantly outdated or it contains invalid data. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static RegionState[]` | `values()` |
| `static RegionState` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### AVAILABLE

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | AVAILABLE |

Available for download on the server.

### DOWNLOADING

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | DOWNLOADING |

Download in progress.

### PAUSED

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | PAUSED |

Download is paused.

### COMPLETED

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | COMPLETED |

Cache data installation is finished.

### OUTDATED

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | OUTDATED |

The region was completed but there is a newer version on the server.

### UNSUPPORTED

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | UNSUPPORTED |

The region was removed from regions list and will never be updated

### NEED_UPDATE

|   |   |   |
| --- | --- | --- |
| `static final` | [RegionState](RegionState.md) | NEED_UPDATE |

The region is significantly outdated or it contains invalid data.

OCM will redownload it automatically if autoupdate enabled.

## Methods

### values

```java
RegionState[] values()
```

### valueOf

```java
RegionState valueOf(java.lang.String name)
```
