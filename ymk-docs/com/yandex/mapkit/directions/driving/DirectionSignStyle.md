---
title: "DirectionSignStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignStyle.html"
---
# DirectionSignStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignStyle

`class DirectionSignStyle implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignStyle(int textColor,
                   int bgColor)
```

```java
DirectionSignStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getTextColor()`<br>Text color in RGB format |
| `int` | `getBgColor()`<br>Background color in RGB format |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignStyle

```java
DirectionSignStyle(int textColor,
                   int bgColor)
```

### DirectionSignStyle

```java
DirectionSignStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTextColor

```java
int getTextColor()
```

Text color in RGB format

### getBgColor

```java
int getBgColor()
```

Background color in RGB format

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
