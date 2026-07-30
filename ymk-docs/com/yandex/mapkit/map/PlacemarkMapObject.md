---
title: "PlacemarkMapObject"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarkMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkMapObject.html"
---
# PlacemarkMapObject

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkMapObject.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[MapObject](MapObject.md)*

`interface PlacemarkMapObject extends MapObject`

Represents a geo-positioned object on the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getGeometry()` |
| `void` | `setGeometry(@NonNull Point geometry)` |
| `float` | `getDirection()`<br>Angle between the direction of an object and the direction to north. |
| `void` | `setDirection(float direction)` |
| `float` | `getOpacity()`<br>Opacity multiplicator for the placemark content. |
| `void` | `setOpacity(float opacity)` |
| `void` | `setIcon(@NonNull ImageProvider image)`<br>Sets an icon with the default style for the placemark. |
| `void` | `setIcon(@NonNull ImageProvider image, @NonNull IconStyle style)`<br>Sets an icon with the given style for the placemark. |
| `void` | `setIcon(@NonNull ImageProvider image, @NonNull Callback onFinished)`<br>Sets an icon with the default style for the placemark. |
| `void` | `setIcon(@NonNull ImageProvider image, @NonNull IconStyle style, @NonNull Callback onFinished)`<br>Sets an icon with the given style for the placemark. |
| `void` | `setIconStyle(@NonNull IconStyle style)`<br>Changes the icon style. |
| `Icon` | `useIcon()`<br>Returns Icon object that can be used to set image or view and its style for the placemark. |
| `CompositeIcon` | `useCompositeIcon()`<br>Returns CompositeIcon object that can be used to set icons and their styles for the placemark. |
| `Model` | `useModel()`<br>Returns Model object that can be used to set model and its style for the placemark. |
| `PlacemarkAnimation` | `useAnimation()`<br>Returns PlacemarkAnimation object that can be used to control animation of the placemark. |
| `PlacemarkText` | `getText()`<br>PlacemarkText can be used to set text and its style for the placemark. |
| `void` | `setView(@NonNull ViewProvider view)`<br>Sets the view with the default style for the placemark. |
| `void` | `setView(@NonNull ViewProvider view, @NonNull IconStyle style)`<br>Sets the view with the given style for the placemark. |
| `void` | `setView(@NonNull ViewProvider view, @NonNull Callback onFinished)`<br>Sets the view with the default style for the placemark. |
| `void` | `setView(@NonNull ViewProvider view, @NonNull IconStyle style, @NonNull Callback onFinished)`<br>Sets the view with the given style for the placemark. |
| `void` | `setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)`<br>Sets piecewise linear scale, depending on the zoom. |
| `void` | `setText(@NonNull java.lang.String text)`<br>Sets the text for the placemark, current text style is used |
| `void` | `setText(@NonNull java.lang.String text, @NonNull TextStyle style)`<br>Sets the text with the given style for the placemark |
| `void` | `setTextStyle(@NonNull TextStyle style)`<br>Changes the text style. |

## Methods

### getGeometry

```java
@NonNull
Point getGeometry()
```

### setGeometry

```java
void setGeometry(@NonNull Point geometry)
```

### getDirection

```java
float getDirection()
```

Angle between the direction of an object and the direction to north.

Measured in degrees. Default: 0.f.

### setDirection

```java
void setDirection(float direction)
```

### getOpacity

```java
float getOpacity()
```

Opacity multiplicator for the placemark content.

Values below 0 will be set to 0. Default: 1.

### setOpacity

```java
void setOpacity(float opacity)
```

### setIcon

```java
void setIcon(@NonNull ImageProvider image)
```

Sets an icon with the default style for the placemark.

Switches off and resets model/composite icon/animation/view.

### setIcon

```java
void setIcon(@NonNull ImageProvider image,
             @NonNull IconStyle style)
```

Sets an icon with the given style for the placemark.

Switches off and resets model/composite icon/animation/view.

### setIcon

```java
void setIcon(@NonNull ImageProvider image,
             @NonNull Callback onFinished)
```

Sets an icon with the default style for the placemark.

Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the icon is loaded. |

### setIcon

```java
void setIcon(@NonNull ImageProvider image,
             @NonNull IconStyle style,
             @NonNull Callback onFinished)
```

Sets an icon with the given style for the placemark.

Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the icon is loaded. |

### setIconStyle

```java
void setIconStyle(@NonNull IconStyle style)
```

Changes the icon style.

Valid only for the single icon, the view and the animated icon.

### useIcon

```java
@NonNull
Icon useIcon()
```

Returns Icon object that can be used to set image or view and its style for the placemark.

Switches off and resets composite icon/model/animation/view.

### useCompositeIcon

```java
@NonNull
CompositeIcon useCompositeIcon()
```

Returns CompositeIcon object that can be used to set icons and their styles for the placemark.

Switches off and resets icon/model/animation/view.

### useModel

```java
@NonNull
Model useModel()
```

Returns Model object that can be used to set model and its style for the placemark.

Switches off and resets icon/composite icon/animation/view.

### useAnimation

```java
@NonNull
PlacemarkAnimation useAnimation()
```

Returns PlacemarkAnimation object that can be used to control animation of the placemark.

Switches off and resets icon/composite icon/model/view.

### getText

```java
@NonNull
PlacemarkText getText()
```

PlacemarkText can be used to set text and its style for the placemark.

It's optional parameter and can be used in addition to placemark objects

### setView

```java
void setView(@NonNull ViewProvider view)
```

Sets the view with the default style for the placemark.

Switches off and resets icon/composite icon/animation/model.

### setView

```java
void setView(@NonNull ViewProvider view,
             @NonNull IconStyle style)
```

Sets the view with the given style for the placemark.

Switches off and resets icon/composite icon/animation/view.

### setView

```java
void setView(@NonNull ViewProvider view,
             @NonNull Callback onFinished)
```

Sets the view with the default style for the placemark.

Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the icon is loaded. |

### setView

```java
void setView(@NonNull ViewProvider view,
             @NonNull IconStyle style,
             @NonNull Callback onFinished)
```

Sets the view with the given style for the placemark.

Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the icon is loaded. |

### setScaleFunction

```java
void setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)
```

Sets piecewise linear scale, depending on the zoom.

The 'points' must be sorted by x; x coordinates must be unique. If zoom  minZoom(points) or zoom > maxZoom(points), it is set within the defined bounds before applying the function. By default, the scale function is defined by a single point (1, 1). If points is null or points.empty(), it resets the function to the default. If points.size() == 1, the scale is constant and equals point.y.

### setText

```java
void setText(@NonNull java.lang.String text)
```

Sets the text for the placemark, current text style is used

| Parameters |   |
| --- | --- |
| `text` | is a string in UTF-8 encoding |

### setText

```java
void setText(@NonNull java.lang.String text,
             @NonNull TextStyle style)
```

Sets the text with the given style for the placemark

| Parameters |   |
| --- | --- |
| `text` | is a string in UTF-8 encoding |

### setTextStyle

```java
void setTextStyle(@NonNull TextStyle style)
```

Changes the text style.
