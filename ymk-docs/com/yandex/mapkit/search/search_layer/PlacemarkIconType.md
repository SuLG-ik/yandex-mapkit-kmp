---
title: "PlacemarkIconType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / PlacemarkIconType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/PlacemarkIconType.html"
---
# PlacemarkIconType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/PlacemarkIconType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.search_layer.PlacemarkIconType

`final enum PlacemarkIconType`

Possible placemark icon types

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NONE](PlacemarkIconType.md#none) | No icon. |
| [DUST](PlacemarkIconType.md#dust) | Dust. |
| [DUST_VISITED](PlacemarkIconType.md#dust_visited) | Dust, search result is already visited. |
| [ICON](PlacemarkIconType.md#icon) | Icon. |
| [ICON_VISITED](PlacemarkIconType.md#icon_visited) | Icon, search result is already visited. |
| [LABEL_SHORT_LEFT](PlacemarkIconType.md#label_short_left) | One-line label to the left of the icon. |
| [LABEL_SHORT_RIGHT](PlacemarkIconType.md#label_short_right) | One-line label to the right of the icon. |
| [LABEL_DETAILED_LEFT](PlacemarkIconType.md#label_detailed_left) | Detailed label to the left of the icon. |
| [LABEL_DETAILED_RIGHT](PlacemarkIconType.md#label_detailed_right) | Detailed label to the right of the icon. |
| [SELECTED](PlacemarkIconType.md#selected) | Search result is selected. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static PlacemarkIconType[]` | `values()` |
| `static PlacemarkIconType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NONE

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | NONE |

No icon.

This type will never be passed to `AssetsProvider` methods.

### DUST

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | DUST |

Dust.

### DUST_VISITED

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | DUST_VISITED |

Dust, search result is already visited.

### ICON

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | ICON |

Icon.

### ICON_VISITED

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | ICON_VISITED |

Icon, search result is already visited.

### LABEL_SHORT_LEFT

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | LABEL_SHORT_LEFT |

One-line label to the left of the icon.

### LABEL_SHORT_RIGHT

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | LABEL_SHORT_RIGHT |

One-line label to the right of the icon.

### LABEL_DETAILED_LEFT

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | LABEL_DETAILED_LEFT |

Detailed label to the left of the icon.

### LABEL_DETAILED_RIGHT

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | LABEL_DETAILED_RIGHT |

Detailed label to the right of the icon.

### SELECTED

|   |   |   |
| --- | --- | --- |
| `static final` | [PlacemarkIconType](PlacemarkIconType.md) | SELECTED |

Search result is selected.

## Methods

### values

```java
PlacemarkIconType[] values()
```

### valueOf

```java
PlacemarkIconType valueOf(java.lang.String name)
```
