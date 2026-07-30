---
title: "State"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / RawTile_State"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RawTile_State.html"
---
# State

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RawTile_State.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.RawTile.State

`static final enum State`

Available tile states.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [OK](RawTile_State.md#ok) | Tile is available. |
| [NOT_MODIFIED](RawTile_State.md#not_modified) | Tile was not modified. |
| [ERROR](RawTile_State.md#error) | An error occurred when processing the tile. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static State[]` | `values()` |
| `static State` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### OK

|   |   |   |
| --- | --- | --- |
| `static final` | [State](RawTile_State.md) | OK |

Tile is available.

### NOT_MODIFIED

|   |   |   |
| --- | --- | --- |
| `static final` | [State](RawTile_State.md) | NOT_MODIFIED |

Tile was not modified.

### ERROR

|   |   |   |
| --- | --- | --- |
| `static final` | [State](RawTile_State.md) | ERROR |

An error occurred when processing the tile.

## Methods

### values

```java
State[] values()
```

### valueOf

```java
State valueOf(java.lang.String name)
```
