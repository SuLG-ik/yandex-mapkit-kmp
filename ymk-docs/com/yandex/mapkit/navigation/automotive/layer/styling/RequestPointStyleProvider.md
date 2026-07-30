---
title: "RequestPointStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / RequestPointStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RequestPointStyleProvider.html"
---
# RequestPointStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RequestPointStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface RequestPointStyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `provideStyle(int requestPointIndex, int requestPointsNumber, @NonNull RequestPointType requestPointType, float scaleFactor, boolean isSelected, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |

## Methods

### provideStyle

```java
@UiThread
void provideStyle(int requestPointIndex,
                  int requestPointsNumber,
                  @NonNull RequestPointType requestPointType,
                  float scaleFactor,
                  boolean isSelected,
                  boolean isNightMode,
                  @NonNull NavigationLayerMode navigationLayerMode,
                  @NonNull PlacemarkStyle style)
```
