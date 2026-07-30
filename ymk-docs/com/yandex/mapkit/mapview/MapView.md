---
title: "MapView"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.mapview"
section: "Android / Справочник / com.yandex.mapkit.mapview / MapView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/mapview/MapView.html"
---
# MapView

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/mapview/MapView.html)

**Package** com.yandex.mapkit.mapview

java.lang.Object
↳ android.view.View
↳ android.view.ViewGroup
↳ android.widget.RelativeLayout
↳ com.yandex.mapkit.mapview.MapView

`class MapView extends RelativeLayout`

MapView can be customized by using the yandex:movable XML attribute.

If yandex:movable="true" then PlatformGLTextureView will be used for rendering and MapView can be used, for example, in a ListView. If yandex:movable="false" or is not set, PlatfromGLSurfaceView will be used for rendering and MapView should not be used in a ListView or a GridView. If yandex:movable="false" then this MapView can't overlap with any other MapView (either movable or not).

## Summary

### Constructors

**Signature and Description**

```java
MapView(android.content.Context context)
```

```java
MapView(android.content.Context context,
        android.util.AttributeSet attrs)
```

```java
MapView(android.content.Context context,
        android.util.AttributeSet attrs,
        int defStyle)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `MapWindow` | `getMapWindow()` |
| `void` | `setNoninteractive(boolean is)` |
| `void` | `onStop()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `void` | `onStart()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `boolean` | `isDebugModeEnabled()`<br>is debug mode enabled |
| `void` | `destroy()`<br>Explicitly destroys MapView, releasing its native resources. |

## Constuctors

### MapView

```java
MapView(android.content.Context context)
```

### MapView

```java
MapView(android.content.Context context,
        android.util.AttributeSet attrs)
```

### MapView

```java
MapView(android.content.Context context,
        android.util.AttributeSet attrs,
        int defStyle)
```

## Methods

### getMapWindow

```java
MapWindow getMapWindow()
```

### setNoninteractive

```java
void setNoninteractive(boolean is)
```

### onStop

```java
void onStop()
```

Should be called from from corresponding method of activity or fragment containing this view

### onStart

```java
void onStart()
```

Should be called from from corresponding method of activity or fragment containing this view

### isDebugModeEnabled

```java
boolean isDebugModeEnabled()
```

is debug mode enabled

### destroy

```java
void destroy()
```

Explicitly destroys MapView, releasing its native resources.

Should be called when MapView no longer used, e.g., from Activity.onDestroy().
