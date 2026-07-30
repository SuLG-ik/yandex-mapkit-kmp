---
title: "PlacemarkAnimation"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarkAnimation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkAnimation.html"
---
# PlacemarkAnimation

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkAnimation.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[PlacemarkPresentation](PlacemarkPresentation.md)*

`interface PlacemarkAnimation extends PlacemarkPresentation`

Provides an interface to load and control animation of placemark.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setIcon(@NonNull AnimatedImageProvider image, @NonNull IconStyle style)`<br>Sets the animated image and icon style. |
| `void` | `setIcon(@NonNull AnimatedImageProvider image, @NonNull IconStyle style, @NonNull Callback onFinished)`<br>Sets the animated image and icon style. |
| `void` | `setIconStyle(@NonNull IconStyle style)`<br>Changes the icon style. |
| `void` | `play()`<br>Starts animation. |
| `void` | `play(@NonNull Callback onFinished)`<br>Starts animation and handles the callback. |
| `void` | `resume()`<br>Resumes paused animation. |
| `void` | `stop()`<br>Stops animation. |
| `void` | `pause()`<br>Pauses animation. |
| `boolean` | `isReversed()`<br>If true, animation will be played in the reverse direction. |
| `void` | `setReversed(boolean reversed)` |

## Methods

### setIcon

```java
void setIcon(@NonNull AnimatedImageProvider image,
             @NonNull IconStyle style)
```

Sets the animated image and icon style.

The new animation will be in the paused state.

### setIcon

```java
void setIcon(@NonNull AnimatedImageProvider image,
             @NonNull IconStyle style,
             @NonNull Callback onFinished)
```

Sets the animated image and icon style.

The new animation will be in the paused state.

| Parameters |   |
| --- | --- |
| `onFinished` | is called when the icon is loaded. |

### setIconStyle

```java
void setIconStyle(@NonNull IconStyle style)
```

Changes the icon style.

### play

```java
void play()
```

Starts animation.

Removes the current play callback. Same as play(null).

### play

```java
void play(@NonNull Callback onFinished)
```

Starts animation and handles the callback.

| Parameters |   |
| --- | --- |
| `onFinished` | is called when animation finishes and replaces the previous callback. |

### resume

```java
void resume()
```

Resumes paused animation.

Callback (if any) is NOT removed.

### stop

```java
void stop()
```

Stops animation.

Animation returns to the initial paused state.

### pause

```java
void pause()
```

Pauses animation.

### isReversed

```java
boolean isReversed()
```

If true, animation will be played in the reverse direction.

Default value is false.

### setReversed

```java
void setReversed(boolean reversed)
```
