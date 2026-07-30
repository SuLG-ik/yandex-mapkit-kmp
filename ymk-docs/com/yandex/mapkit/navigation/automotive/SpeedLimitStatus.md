---
title: "SpeedLimitStatus"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / SpeedLimitStatus"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitStatus.html"
---
# SpeedLimitStatus

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitStatus.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.navigation.automotive.SpeedLimitStatus

`final enum SpeedLimitStatus`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [BELOW_LIMIT](SpeedLimitStatus.md#below_limit) | Speed limit is not exceeded |
| [STRICT_LIMIT_EXCEEDED](SpeedLimitStatus.md#strict_limit_exceeded) | Speed limit exceeded |
| [TOLERANT_LIMIT_EXCEEDED](SpeedLimitStatus.md#tolerant_limit_exceeded) | Speed limit exceeded by tolerance |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SpeedLimitStatus[]` | `values()` |
| `static SpeedLimitStatus` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### BELOW_LIMIT

|   |   |   |
| --- | --- | --- |
| `static final` | [SpeedLimitStatus](SpeedLimitStatus.md) | BELOW_LIMIT |

Speed limit is not exceeded

### STRICT_LIMIT_EXCEEDED

|   |   |   |
| --- | --- | --- |
| `static final` | [SpeedLimitStatus](SpeedLimitStatus.md) | STRICT_LIMIT_EXCEEDED |

Speed limit exceeded

### TOLERANT_LIMIT_EXCEEDED

|   |   |   |
| --- | --- | --- |
| `static final` | [SpeedLimitStatus](SpeedLimitStatus.md) | TOLERANT_LIMIT_EXCEEDED |

Speed limit exceeded by tolerance

## Methods

### values

```java
SpeedLimitStatus[] values()
```

### valueOf

```java
SpeedLimitStatus valueOf(java.lang.String name)
```
