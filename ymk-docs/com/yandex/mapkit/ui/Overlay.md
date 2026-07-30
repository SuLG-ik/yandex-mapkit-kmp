---
title: "Overlay"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.ui"
section: "Android / Справочник / com.yandex.mapkit.ui / Overlay"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ui/Overlay.html"
---
# Overlay

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ui/Overlay.html)

**Package** com.yandex.mapkit.ui

`interface Overlay`

Allows to render overlay on the screen.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setImage(@NonNull ImageProvider image, @NonNull ScreenRect rect)`<br>Sets image as content of overlay, resets view. |
| `void` | `setView(@NonNull ViewProvider view, @NonNull ScreenRect rect)`<br>Sets view as content of overlay, resets image. |
| `void` | `remove()`<br>Removes the overlay from the map. |
| `boolean` | `isValid()`<br>Tells if this **Overlay** is valid or not. |

## Methods

### setImage

```java
void setImage(@NonNull ImageProvider image,
              @NonNull ScreenRect rect)
```

Sets image as content of overlay, resets view.

Window origin (0, 0) - top left corner.

### setView

```java
void setView(@NonNull ViewProvider view,
             @NonNull ScreenRect rect)
```

Sets view as content of overlay, resets image.

Window origin (0, 0) - top left corner.

### remove

```java
void remove()
```

Removes the overlay from the map.

### isValid

```java
boolean isValid()
```

Tells if this **Overlay** is valid or not.

Any other method (except for this one) called on an invalid **Overlay** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
