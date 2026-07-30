---
title: "MrcPhotoTrackView"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.mrc"
section: "Android / Справочник / com.yandex.mapkit.places.mrc / MrcPhotoTrackView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/mrc/MrcPhotoTrackView.html"
---
# MrcPhotoTrackView

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/mrc/MrcPhotoTrackView.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.mrc

java.lang.Object
↳ android.view.View
↳ android.view.ViewGroup
↳ android.widget.RelativeLayout
↳ com.yandex.mapkit.places.mrc.MrcPhotoTrackView

`class MrcPhotoTrackView extends RelativeLayout`

## Summary

### Constructors

**Signature and Description**

```java
MrcPhotoTrackView(android.content.Context context)
```

```java
MrcPhotoTrackView(android.content.Context context,
                  android.util.AttributeSet attrs)
```

```java
MrcPhotoTrackView(android.content.Context context,
                  android.util.AttributeSet attrs,
                  int defStyle)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `com.yandex.mapkit.places.mrc.MrcPhotoTrackPlayer` | `getPlayer()` |
| `void` | `setNoninteractive(boolean is)` |
| `void` | `onStop()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `void` | `onStart()`<br>Should be called from from corresponding method of activity or fragment containing this view |
| `void` | `onMemoryWarning()`<br>Should be called from ComponentCallbacks2.onTrimMemory. |

## Constuctors

### MrcPhotoTrackView

```java
MrcPhotoTrackView(android.content.Context context)
```

### MrcPhotoTrackView

```java
MrcPhotoTrackView(android.content.Context context,
                  android.util.AttributeSet attrs)
```

### MrcPhotoTrackView

```java
MrcPhotoTrackView(android.content.Context context,
                  android.util.AttributeSet attrs,
                  int defStyle)
```

## Methods

### getPlayer

```java
com.yandex.mapkit.places.mrc.MrcPhotoTrackPlayer getPlayer()
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
