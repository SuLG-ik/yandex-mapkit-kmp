---
title: "BalloonImageProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / BalloonImageProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/BalloonImageProvider.html"
---
# BalloonImageProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/BalloonImageProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface BalloonImageProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<BalloonGeometry>` | `geometriesForBalloon(@NonNull Balloon balloon, float scaleFactor, boolean isNightMode)`<br>returns geometry for all possible anchor placements |
| `ImageProvider` | `createImage(@NonNull Balloon balloon, @NonNull BalloonAnchor anchor, float scaleFactor, boolean isNightMode)` |

## Methods

### geometriesForBalloon

```java
@UiThread @NonNull
java.util.List<BalloonGeometry> geometriesForBalloon(@NonNull Balloon balloon,
                                                     float scaleFactor,
                                                     boolean isNightMode)
```

returns geometry for all possible anchor placements

### createImage

```java
@UiThread @NonNull
ImageProvider createImage(@NonNull Balloon balloon,
                          @NonNull BalloonAnchor anchor,
                          float scaleFactor,
                          boolean isNightMode)
```
