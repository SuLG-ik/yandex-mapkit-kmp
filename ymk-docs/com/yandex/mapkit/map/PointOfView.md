---
title: "PointOfView"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PointOfView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PointOfView.html"
---
# PointOfView

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PointOfView.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.PointOfView

`final enum PointOfView`

The point of view.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [SCREEN_CENTER](PointOfView.md#screen_center) | Point of View is centered on the screen. |
| [ADAPT_TO_FOCUS_POINT_HORIZONTALLY](PointOfView.md#adapt_to_focus_point_horizontally) | Point of View has an x-coordinate at focusPoint and a y-coordinate at the center of the screen. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static PointOfView[]` | `values()` |
| `static PointOfView` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### SCREEN_CENTER

|   |   |   |
| --- | --- | --- |
| `static final` | [PointOfView](PointOfView.md) | SCREEN_CENTER |

Point of View is centered on the screen.

### ADAPT_TO_FOCUS_POINT_HORIZONTALLY

|   |   |   |
| --- | --- | --- |
| `static final` | [PointOfView](PointOfView.md) | ADAPT_TO_FOCUS_POINT_HORIZONTALLY |

Point of View has an x-coordinate at focusPoint and a y-coordinate at the center of the screen.

## Methods

### values

```java
PointOfView[] values()
```

### valueOf

```java
PointOfView valueOf(java.lang.String name)
```
