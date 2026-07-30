---
title: "TextStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / TextStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/TextStyle.html"
---
# TextStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/TextStyle.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.TextStyle

`final class TextStyle implements Serializable`

The style of placemarks's text.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Placement](TextStyle_Placement.md) | Text placement positions |

## Summary

### Constructors

**Signature and Description**

```java
TextStyle(float size,
          int color,
          float outlineWidth,
          int outlineColor,
          @NonNull Placement placement,
          float offset,
          boolean offsetFromIcon,
          boolean textOptional)
```

```java
TextStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getSize()`<br>Text font size in units. |
| `TextStyle` | `setSize(float size)`<br>See **#getSize()**. |
| `int` | `getColor()`<br>Text color. |
| `TextStyle` | `setColor(int color)`<br>See **#getColor()**. |
| `float` | `getOutlineWidth()`<br>Outline width in units. |
| `TextStyle` | `setOutlineWidth(float outlineWidth)`<br>See **#getOutlineWidth()**. |
| `int` | `getOutlineColor()`<br>Outline color. |
| `TextStyle` | `setOutlineColor(int outlineColor)`<br>See **#getOutlineColor()**. |
| `Placement` | `getPlacement()`<br>Text placement position. |
| `TextStyle` | `setPlacement(@NonNull Placement placement)`<br>See **#getPlacement()**. |
| `float` | `getOffset()`<br>Text offset in units. |
| `TextStyle` | `setOffset(float offset)`<br>See **#getOffset()**. |
| `boolean` | `getOffsetFromIcon()`<br>When set, [mapkit.map.TextStyle#offset](TextStyle.md#offset) is a padding between the text and icon edges. |
| `TextStyle` | `setOffsetFromIcon(boolean offsetFromIcon)`<br>See **#getOffsetFromIcon()**. |
| `boolean` | `getTextOptional()`<br>Allow dropping text but keeping icon during conflict resolution default: false |
| `TextStyle` | `setTextOptional(boolean textOptional)`<br>See **#getTextOptional()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TextStyle

```java
TextStyle(float size,
          int color,
          float outlineWidth,
          int outlineColor,
          @NonNull Placement placement,
          float offset,
          boolean offsetFromIcon,
          boolean textOptional)
```

### TextStyle

```java
TextStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSize

```java
float getSize()
```

Text font size in units.

default: 8

### setSize

```java
TextStyle setSize(float size)
```

See **#getSize()**.

### getColor

```java
int getColor()
```

Text color.

default: black

### setColor

```java
TextStyle setColor(int color)
```

See **#getColor()**.

### getOutlineWidth

```java
float getOutlineWidth()
```

Outline width in units.

default: 1

### setOutlineWidth

```java
TextStyle setOutlineWidth(float outlineWidth)
```

See **#getOutlineWidth()**.

### getOutlineColor

```java
int getOutlineColor()
```

Outline color.

default: white

### setOutlineColor

```java
TextStyle setOutlineColor(int outlineColor)
```

See **#getOutlineColor()**.

### getPlacement

```java
@NonNull
Placement getPlacement()
```

Text placement position.

default: Center

### setPlacement

```java
TextStyle setPlacement(@NonNull Placement placement)
```

See **#getPlacement()**.

### getOffset

```java
float getOffset()
```

Text offset in units.

Measured either from point or form icon edges, depending on [mapkit.map.TextStyle#offsetFromIcon](TextStyle.md#offsetfromicon) value Direction of the offset specified with [mapkit.map.TextStyle#placement](TextStyle.md#placement) property Ignored when **#placement** is 'Center' default: 0

### setOffset

```java
TextStyle setOffset(float offset)
```

See **#getOffset()**.

### getOffsetFromIcon

```java
boolean getOffsetFromIcon()
```

When set, [mapkit.map.TextStyle#offset](TextStyle.md#offset) is a padding between the text and icon edges.

default: true

### setOffsetFromIcon

```java
TextStyle setOffsetFromIcon(boolean offsetFromIcon)
```

See **#getOffsetFromIcon()**.

### getTextOptional

```java
boolean getTextOptional()
```

Allow dropping text but keeping icon during conflict resolution default: false

### setTextOptional

```java
TextStyle setTextOptional(boolean textOptional)
```

See **#getTextOptional()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
