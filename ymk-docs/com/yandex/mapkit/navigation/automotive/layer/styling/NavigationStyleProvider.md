---
title: "NavigationStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / NavigationStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.html"
---
# NavigationStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface NavigationStyleProvider`

Provides default style and icons when for navigation_layer objects when their look is refreshed (for example on creation or on night mode switch).

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `RouteViewStyleProvider` | `routeViewStyleProvider()` |
| `BalloonImageProvider` | `balloonImageProvider()` |
| `RequestPointStyleProvider` | `requestPointStyleProvider()` |
| `UserPlacemarkStyleProvider` | `userPlacemarkStyleProvider()` |
| `RoutePinsStyleProvider` | `routePinsStyleProvider()` |
| `HighlightStyleProvider` | `highlightStyleProvider()` |

## Methods

### routeViewStyleProvider

```java
@UiThread @NonNull
RouteViewStyleProvider routeViewStyleProvider()
```

### balloonImageProvider

```java
@UiThread @NonNull
BalloonImageProvider balloonImageProvider()
```

### requestPointStyleProvider

```java
@UiThread @NonNull
RequestPointStyleProvider requestPointStyleProvider()
```

### userPlacemarkStyleProvider

```java
@UiThread @NonNull
UserPlacemarkStyleProvider userPlacemarkStyleProvider()
```

### routePinsStyleProvider

```java
@UiThread @NonNull
RoutePinsStyleProvider routePinsStyleProvider()
```

### highlightStyleProvider

```java
@UiThread @NonNull
HighlightStyleProvider highlightStyleProvider()
```
