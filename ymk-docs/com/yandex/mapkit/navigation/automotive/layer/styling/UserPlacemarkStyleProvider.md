---
title: "UserPlacemarkStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / UserPlacemarkStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/UserPlacemarkStyleProvider.html"
---
# UserPlacemarkStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/UserPlacemarkStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface UserPlacemarkStyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `provideStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |

## Methods

### provideStyle

```java
@UiThread
void provideStyle(float scaleFactor,
                  boolean isNightMode,
                  @NonNull NavigationLayerMode navigationLayerMode,
                  @NonNull PlacemarkStyle style)
```
