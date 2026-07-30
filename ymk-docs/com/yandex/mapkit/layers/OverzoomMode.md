---
title: "OverzoomMode"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / OverzoomMode"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/OverzoomMode.html"
---
# OverzoomMode

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/OverzoomMode.html)

**Package** com.yandex.mapkit.layers

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.layers.OverzoomMode

`final enum OverzoomMode`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [DISABLED](OverzoomMode.md#disabled) | Overzoom is fully disabled. |
| [ENABLED](OverzoomMode.md#enabled) | If a tile is absent or translucent, tiles from lower or higher zooms will be shown. |
| [WITH_PREFETCH](OverzoomMode.md#with_prefetch) | Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static OverzoomMode[]` | `values()` |
| `static OverzoomMode` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### DISABLED

|   |   |   |
| --- | --- | --- |
| `static final` | [OverzoomMode](OverzoomMode.md) | DISABLED |

Overzoom is fully disabled.

### ENABLED

|   |   |   |
| --- | --- | --- |
| `static final` | [OverzoomMode](OverzoomMode.md) | ENABLED |

If a tile is absent or translucent, tiles from lower or higher zooms will be shown.

### WITH_PREFETCH

|   |   |   |
| --- | --- | --- |
| `static final` | [OverzoomMode](OverzoomMode.md) | WITH_PREFETCH |

Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with.

## Methods

### values

```java
OverzoomMode[] values()
```

### valueOf

```java
OverzoomMode valueOf(java.lang.String name)
```
