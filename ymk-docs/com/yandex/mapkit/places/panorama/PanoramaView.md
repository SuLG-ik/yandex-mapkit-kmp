---
title: "PanoramaView"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / PanoramaView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaView.html"
---
# PanoramaView

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaView.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ android.view.View
↳ android.view.ViewGroup
↳ android.widget.RelativeLayout
↳ com.yandex.mapkit.places.panorama.PanoramaView

`class PanoramaView extends RelativeLayout`

## Summary

### Constructors

**Signature and Description**

```java
PanoramaView(android.content.Context context)
```

```java
PanoramaView(android.content.Context context,
             android.util.AttributeSet attrs)
```

```java
PanoramaView(android.content.Context context,
             android.util.AttributeSet attrs,
             int defStyle)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Player` | `getPlayer()` |
| `void` | `setNoninteractive(boolean is)` |
| `void` | `onStop()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `void` | `onStart()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `void` | `onMemoryWarning()`<br>Should be called from ComponentCallbacks2.onTrimMemory. |

## Constuctors

### PanoramaView

```java
PanoramaView(android.content.Context context)
```

### PanoramaView

```java
PanoramaView(android.content.Context context,
             android.util.AttributeSet attrs)
```

### PanoramaView

```java
PanoramaView(android.content.Context context,
             android.util.AttributeSet attrs,
             int defStyle)
```

## Methods

### getPlayer

```java
Player getPlayer()
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

### onMemoryWarning

```java
void onMemoryWarning()
```

Should be called from ComponentCallbacks2.onTrimMemory.

Recommended levels are TRIM_MEMORY_RUNNING_LOW (foreground) and TRIM_MEMORY_COMPLETE(backgrdound).
