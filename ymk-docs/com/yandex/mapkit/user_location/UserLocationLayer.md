---
title: "UserLocationLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationLayer.html"
---
# UserLocationLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationLayer.html)

**Package** com.yandex.mapkit.user_location

`interface UserLocationLayer`

Use the UserLocationLayer interface to manage the location icon: its appearance, following mode, data source and so on.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setVisible(boolean on)`<br>Sets user location visibility. |
| `boolean` | `isVisible()`<br>Checks if user location is visible. |
| `boolean` | `isHeadingModeActive()`<br>Enables/disables heading mode. |
| `void` | `setHeadingModeActive(boolean headingModeActive)` |
| `void` | `setAnchor(@NonNull android.graphics.PointF anchorNormal, @NonNull android.graphics.PointF anchorCourse)`<br>Sets the anchor to the specified position in pixels and enables Anchor mode. |
| `void` | `resetAnchor()`<br>Resets anchor mode. |
| `boolean` | `isAnchorEnabled()`<br>Returns true if anchor mode is set, and false otherwise. |
| `boolean` | `isAutoZoomEnabled()`<br>Enables/disables auto zoom. |
| `void` | `setAutoZoomEnabled(boolean autoZoomEnabled)` |
| `CameraPosition` | `cameraPosition()`<br>Calculates the camera position that projects the current location into view. |
| `void` | `setSource(@Nullable LocationViewSource source)`<br>Sets/gets the data source. |
| `void` | `setDefaultSource()`<br>Sets the data source with the global location manager |
| `void` | `setTapListener(@Nullable java.lang.ref.WeakReference<UserLocationTapListener> tapListener)`<br>Sets/resets the tap listener. |
| `void` | `setObjectListener(@Nullable java.lang.ref.WeakReference<UserLocationObjectListener> objectListener)`<br>Sets/resets the object listener. |
| `boolean` | `isValid()`<br>Tells if this **UserLocationLayer** is valid or not. |

## Methods

### setVisible

```java
void setVisible(boolean on)
```

Sets user location visibility.

### isVisible

```java
boolean isVisible()
```

Checks if user location is visible.

### isHeadingModeActive

```java
boolean isHeadingModeActive()
```

Enables/disables heading mode.

If heading mode is enabled, the map is rotated. If heading mode is disabled, the location icon is rotated.

### setHeadingModeActive

```java
void setHeadingModeActive(boolean headingModeActive)
```

### setAnchor

```java
void setAnchor(@NonNull android.graphics.PointF anchorNormal,
               @NonNull android.graphics.PointF anchorCourse)
```

Sets the anchor to the specified position in pixels and enables Anchor mode.

(0, 0) denotes the top-left corner of the screen.

| Parameters |   |
| --- | --- |
| `anchorNormal` | The anchor position when the app is not on a steady course; usually, the center of the screen. |
| `anchorCourse` | An anchor position near the bottom line for steady course mode. |

### resetAnchor

```java
void resetAnchor()
```

Resets anchor mode.

### isAnchorEnabled

```java
boolean isAnchorEnabled()
```

Returns true if anchor mode is set, and false otherwise.

### isAutoZoomEnabled

```java
boolean isAutoZoomEnabled()
```

Enables/disables auto zoom.

### setAutoZoomEnabled

```java
void setAutoZoomEnabled(boolean autoZoomEnabled)
```

### cameraPosition

```java
@Nullable
CameraPosition cameraPosition()
```

Calculates the camera position that projects the current location into view.

If the current location is unknown, returns none. If the current location is known, returns the camera position that displays the location position.

### setSource

```java
void setSource(@Nullable LocationViewSource source)
```

Sets/gets the data source.

### setDefaultSource

```java
void setDefaultSource()
```

Sets the data source with the global location manager

### setTapListener

```java
void setTapListener(@Nullable java.lang.ref.WeakReference<UserLocationTapListener> tapListener)
```

Sets/resets the tap listener.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setObjectListener

```java
void setObjectListener(@Nullable java.lang.ref.WeakReference<UserLocationObjectListener> objectListener)
```

Sets/resets the object listener.

The class does not retain the object in the 'objectListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### isValid

```java
boolean isValid()
```

Tells if this **UserLocationLayer** is valid or not.

Any other method (except for this one) called on an invalid **UserLocationLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
