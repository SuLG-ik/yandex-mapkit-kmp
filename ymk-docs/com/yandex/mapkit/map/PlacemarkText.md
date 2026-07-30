---
title: "PlacemarkText"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarkText"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkText.html"
---
# PlacemarkText

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkText.html)

**Package** com.yandex.mapkit.map

`interface PlacemarkText`

Provides an interface to set text and its style for a placemark.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getText()`<br>UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text |
| `void` | `setText(@NonNull java.lang.String text)` |
| `TextStyle` | `getStyle()`<br>The style properties (size, color, etc.) of the placemark text. |
| `void` | `setStyle(@NonNull TextStyle style)` |
| `boolean` | `isValid()`<br>Tells if this **PlacemarkText** is valid or not. |

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text

### setText

```java
void setText(@NonNull java.lang.String text)
```

### getStyle

```java
@NonNull
TextStyle getStyle()
```

The style properties (size, color, etc.) of the placemark text.

Note: The current style cannot be modified directly - you must reset it to apply changes.

### setStyle

```java
void setStyle(@NonNull TextStyle style)
```

### isValid

```java
boolean isValid()
```

Tells if this **PlacemarkText** is valid or not.

Any other method (except for this one) called on an invalid **PlacemarkText** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
