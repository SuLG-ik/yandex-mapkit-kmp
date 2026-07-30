---
title: "TextStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events_layer"
section: "Android / Справочник / com.yandex.mapkit.road_events_layer / TextStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/TextStyle.html"
---
# TextStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/TextStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.road_events_layer

java.lang.Object
↳ com.yandex.mapkit.road_events_layer.TextStyle

`class TextStyle implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
TextStyle()
```

Use constructor with parameters in your code.

```java
TextStyle(float fontSize,
          int color,
          @Nullable java.lang.Integer outlineColor)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized float` | `getFontSize()`<br>Font size in device-independent pixels. |
| `synchronized int` | `getColor()`<br>Text primary color. |
| `synchronized java.lang.Integer` | `getOutlineColor()`<br>Text outline color. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TextStyle

```java
TextStyle()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TextStyle

```java
TextStyle(float fontSize,
          int color,
          @Nullable java.lang.Integer outlineColor)
```

## Methods

### getFontSize

```java
float getFontSize()
```

Font size in device-independent pixels.

### getColor

```java
int getColor()
```

Text primary color.

### getOutlineColor

```java
@Nullable
java.lang.Integer getOutlineColor()
```

Text outline color.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
