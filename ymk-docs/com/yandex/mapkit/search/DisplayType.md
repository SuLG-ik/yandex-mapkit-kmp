---
title: "DisplayType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / DisplayType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/DisplayType.html"
---
# DisplayType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/DisplayType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.DisplayType

`final enum DisplayType`

Result display type.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [SINGLE](DisplayType.md#single) | Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out. |
| [MULTIPLE](DisplayType.md#multiple) | Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static DisplayType[]` | `values()` |
| `static DisplayType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### SINGLE

|   |   |   |
| --- | --- | --- |
| `static final` | [DisplayType](DisplayType.md) | SINGLE |

Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out.

### MULTIPLE

|   |   |   |
| --- | --- | --- |
| `static final` | [DisplayType](DisplayType.md) | MULTIPLE |

Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region.

## Methods

### values

```java
DisplayType[] values()
```

### valueOf

```java
DisplayType valueOf(java.lang.String name)
```
