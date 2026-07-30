---
title: "RouteView"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / RouteView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RouteView.html"
---
# RouteView

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RouteView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

`interface RouteView`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `DrivingRoute` | `getRoute()` |
| `java.util.List<BalloonView>` | `getBalloonViews()`<br>Balloons displayed on map about the route. |
| `boolean` | `isValid()`<br>Tells if this **RouteView** is valid or not. |

## Methods

### getRoute

```java
@NonNull
DrivingRoute getRoute()
```

### getBalloonViews

```java
@NonNull
java.util.List<BalloonView> getBalloonViews()
```

Balloons displayed on map about the route.

### isValid

```java
boolean isValid()
```

Tells if this **RouteView** is valid or not.

Any other method (except for this one) called on an invalid **RouteView** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
