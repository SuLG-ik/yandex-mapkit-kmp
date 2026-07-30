---
title: "LocationClass"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / LocationClass"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/LocationClass.html"
---
# LocationClass

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/LocationClass.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.navigation.automotive.LocationClass

`final enum LocationClass`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [FINE](LocationClass.md#fine) |   |
| [EXTRAPOLATED](LocationClass.md#extrapolated) |   |
| [COARSE](LocationClass.md#coarse) |   |
| [OUTDATED](LocationClass.md#outdated) | We haven't received a precise location for a long time. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static LocationClass[]` | `values()` |
| `static LocationClass` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### FINE

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationClass](LocationClass.md) | FINE |

### EXTRAPOLATED

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationClass](LocationClass.md) | EXTRAPOLATED |

### COARSE

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationClass](LocationClass.md) | COARSE |

### OUTDATED

|   |   |   |
| --- | --- | --- |
| `static final` | [LocationClass](LocationClass.md) | OUTDATED |

We haven't received a precise location for a long time.

## Methods

### values

```java
LocationClass[] values()
```

### valueOf

```java
LocationClass valueOf(java.lang.String name)
```
