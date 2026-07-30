---
title: "Icon"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Icon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Icon.html"
---
# Icon

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Icon.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[PlacemarkPresentation](PlacemarkPresentation.md)*

`interface Icon extends PlacemarkPresentation`

Provides an interface to set icon and its style for a placemark.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setImage(@NonNull ImageProvider image)`<br>Sets the image for the icon. |
| `void` | `setImage(@NonNull ImageProvider image, @Nullable IconStyle style)`<br>Sets the image for the icon. |
| `void` | `setImage(@NonNull ImageProvider image, @Nullable IconStyle style, @Nullable Callback onFinished)`<br>Sets the image for the icon. |
| `void` | `setView(@NonNull ViewProvider view)`<br>Sets the view for the icon. |
| `void` | `setView(@NonNull ViewProvider view, @Nullable IconStyle style)`<br>Sets the view for the icon. |
| `void` | `setView(@NonNull ViewProvider view, @Nullable IconStyle style, @Nullable Callback onFinished)`<br>Sets the view for the icon. |
| `IconStyle` | `getStyle()`<br>The style properties (scale, zIndex, etc.) of the icon placemark. |
| `void` | `setStyle(@NonNull IconStyle style)` |

## Methods

### setImage

```java
void setImage(@NonNull ImageProvider image)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setImage

```java
void setImage(@NonNull ImageProvider image,
              @Nullable IconStyle style)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setImage

```java
void setImage(@NonNull ImageProvider image,
              @Nullable IconStyle style,
              @Nullable Callback onFinished)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setView

```java
void setView(@NonNull ViewProvider view)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setView

```java
void setView(@NonNull ViewProvider view,
             @Nullable IconStyle style)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setView

```java
void setView(@NonNull ViewProvider view,
             @Nullable IconStyle style,
             @Nullable Callback onFinished)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### getStyle

```java
@NonNull
IconStyle getStyle()
```

The style properties (scale, zIndex, etc.) of the icon placemark.

Note: The current style cannot be modified directly - you must reset it to apply changes.

### setStyle

```java
void setStyle(@NonNull IconStyle style)
```
