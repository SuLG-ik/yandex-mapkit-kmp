---
title: "ViewArea"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / ViewArea"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/ViewArea.html"
---
# ViewArea

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/ViewArea.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.ViewArea

`class ViewArea implements Serializable`

Defines the visible area.

## Summary

### Constructors

**Signature and Description**

```java
ViewArea(double lengthwise,
         double transverse)
```

```java
ViewArea()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getLengthwise()`<br>The length of the view area in meters. |
| `double` | `getTransverse()`<br>The width of the view area from center in meters. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ViewArea

```java
ViewArea(double lengthwise,
         double transverse)
```

### ViewArea

```java
ViewArea()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getLengthwise

```java
double getLengthwise()
```

The length of the view area in meters.

### getTransverse

```java
double getTransverse()
```

The width of the view area from center in meters.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
