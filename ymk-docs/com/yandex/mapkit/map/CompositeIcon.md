---
title: "CompositeIcon"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CompositeIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CompositeIcon.html"
---
# CompositeIcon

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CompositeIcon.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[PlacemarkPresentation](PlacemarkPresentation.md)*

`interface CompositeIcon extends PlacemarkPresentation`

Combines multiple icons into one.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image)`<br>Creates or resets a named layer with an icon and its style. |
| `void` | `setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image, @Nullable IconStyle style)`<br>Creates or resets a named layer with an icon and its style. |
| `void` | `setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image, @Nullable IconStyle style, @Nullable Callback onFinished)`<br>Creates or resets a named layer with an icon and its style. |
| `void` | `setIconStyle(@NonNull java.lang.String name, @NonNull IconStyle style)`<br>Changes the icon style for a specific layer. |
| `Icon` | `icon(@NonNull java.lang.String name)`<br>Returns named Icon object that can be used to set icon and its style. |
| `void` | `removeIcon(@NonNull java.lang.String name)`<br>Removes the named layer. |
| `void` | `removeAll()`<br>Removes all layers. |

## Methods

### setIcon

```java
void setIcon(@NonNull java.lang.String name,
             @NonNull ImageProvider image)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| `name` | Unique identifier of the icon layer. Used to create or update. |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setIcon

```java
void setIcon(@NonNull java.lang.String name,
             @NonNull ImageProvider image,
             @Nullable IconStyle style)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| `name` | Unique identifier of the icon layer. Used to create or update. |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setIcon

```java
void setIcon(@NonNull java.lang.String name,
             @NonNull ImageProvider image,
             @Nullable IconStyle style,
             @Nullable Callback onFinished)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| `name` | Unique identifier of the icon layer. Used to create or update. |
| `style` | The icon style. If not specified, the default style is used. |
| `onFinished` | Optional callback invoked when the icon is loaded. |

### setIconStyle

```java
void setIconStyle(@NonNull java.lang.String name,
                  @NonNull IconStyle style)
```

Changes the icon style for a specific layer.

### icon

```java
@NonNull
Icon icon(@NonNull java.lang.String name)
```

Returns named Icon object that can be used to set icon and its style.

Creates an empty Icon if it didn't exist.

### removeIcon

```java
void removeIcon(@NonNull java.lang.String name)
```

Removes the named layer.

### removeAll

```java
void removeAll()
```

Removes all layers.
