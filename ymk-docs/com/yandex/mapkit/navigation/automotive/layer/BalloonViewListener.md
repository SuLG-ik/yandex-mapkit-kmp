---
title: "BalloonViewListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / BalloonViewListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/BalloonViewListener.html"
---
# BalloonViewListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/BalloonViewListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

`interface BalloonViewListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onBalloonViewsChanged(@NonNull RouteView route)` |
| `void` | `onBalloonViewTap(@NonNull BalloonView balloon)` |
| `void` | `onBalloonVisibilityChanged(@NonNull BalloonView balloon)` |
| `void` | `onBalloonContentChanged(@NonNull BalloonView balloon)`<br>called on BalloonView.balloon changing |

## Methods

### onBalloonViewsChanged

```java
@UiThread
void onBalloonViewsChanged(@NonNull RouteView route)
```

### onBalloonViewTap

```java
@UiThread
void onBalloonViewTap(@NonNull BalloonView balloon)
```

### onBalloonVisibilityChanged

```java
@UiThread
void onBalloonVisibilityChanged(@NonNull BalloonView balloon)
```

### onBalloonContentChanged

```java
@UiThread
void onBalloonContentChanged(@NonNull BalloonView balloon)
```

called on BalloonView.balloon changing
