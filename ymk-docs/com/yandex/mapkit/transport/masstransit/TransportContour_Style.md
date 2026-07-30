---
title: "Style"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportContour_Style"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportContour_Style.html"
---
# Style

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportContour_Style.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportContour.Style

`static class Style implements Serializable`

Describes the style of transport contour objects

## Summary

### Constructors

**Signature and Description**

```java
Style(@Nullable java.lang.Integer mainColor,
      @Nullable java.lang.Integer mainColorNight)
```

```java
Style()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Integer` | `getMainColor()`<br>Describes the main color of transport contour. |
| `java.lang.Integer` | `getMainColorNight()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Style

```java
Style(@Nullable java.lang.Integer mainColor,
      @Nullable java.lang.Integer mainColorNight)
```

### Style

```java
Style()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getMainColor

```java
@Nullable
java.lang.Integer getMainColor()
```

Describes the main color of transport contour.

Main color is used to identify the object among others. For example, the color of MCD line icon meant to be the main color of the contour. Presented in versions for light and dark themes.

Optional field, can be null.

### getMainColorNight

```java
@Nullable
java.lang.Integer getMainColorNight()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
