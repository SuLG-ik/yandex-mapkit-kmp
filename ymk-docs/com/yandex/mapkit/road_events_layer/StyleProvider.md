---
title: "StyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events_layer"
section: "Android / Справочник / com.yandex.mapkit.road_events_layer / StyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/StyleProvider.html"
---
# StyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/StyleProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.road_events_layer

`interface StyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `provideStyle(@NonNull RoadEventStylingProperties roadEventStylingProperties, boolean isNightMode, float scaleFactor, @NonNull RoadEventStyle style)`<br>Provide style for given road event. |

## Methods

### provideStyle

```java
@UiThread
boolean provideStyle(@NonNull RoadEventStylingProperties roadEventStylingProperties,
                     boolean isNightMode,
                     float scaleFactor,
                     @NonNull RoadEventStyle style)
```

Provide style for given road event.

Must produce same style for same input arguments.

| Parameters |   |
| --- | --- |
| `scaleFactor` | Scale factor of a map window displaying this road event. Road event icon image scale factor must match this value. |

**Returns**

`false` if road event must not be displayed at all.
