---
title: "HighlightStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / HighlightStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/HighlightStyleProvider.html"
---
# HighlightStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/HighlightStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface HighlightStyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SpeedControlHighlightStyle` | `provideSpeedControlStyle(boolean isNightMode, @NonNull HighlightMode highlightMode)` |

## Methods

### provideSpeedControlStyle

```java
@UiThread @Nullable
SpeedControlHighlightStyle provideSpeedControlStyle(boolean isNightMode,
                                                    @NonNull HighlightMode highlightMode)
```
