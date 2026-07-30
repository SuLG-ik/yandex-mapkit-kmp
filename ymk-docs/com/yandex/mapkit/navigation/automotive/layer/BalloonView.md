---
title: "BalloonView"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / BalloonView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/BalloonView.html"
---
# BalloonView

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/BalloonView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

`interface BalloonView`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `BalloonAnchor` | `getAnchor()` |
| `Balloon` | `getBalloon()` |
| `boolean` | `isIsVisible()`<br>True if balloon currently visible on the screen. |
| `boolean` | `isIsEnabled()`<br>If 'true', balloons will be shown whenever it possible. |
| `void` | `setIsEnabled(boolean isEnabled)` |
| `DrivingRoute` | `getHostRoute()`<br>The route to which this balloon belongs. |
| `boolean` | `isValid()`<br>Tells if this **BalloonView** is valid or not. |

## Methods

### getAnchor

```java
@NonNull
BalloonAnchor getAnchor()
```

### getBalloon

```java
@NonNull
Balloon getBalloon()
```

### isIsVisible

```java
boolean isIsVisible()
```

True if balloon currently visible on the screen.

Always false if balloon disabled

### isIsEnabled

```java
boolean isIsEnabled()
```

If 'true', balloons will be shown whenever it possible.

If 'false', balloons will be always hidden. `BalloonViewListener.onBalloonContentChanged` is called regardless of isEnabled value. `RouteView.showBalloons` call changes this attribute. Enabled by default.

### setIsEnabled

```java
void setIsEnabled(boolean isEnabled)
```

### getHostRoute

```java
@NonNull
DrivingRoute getHostRoute()
```

The route to which this balloon belongs.

### isValid

```java
boolean isValid()
```

Tells if this **BalloonView** is valid or not.

Any other method (except for this one) called on an invalid **BalloonView** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
