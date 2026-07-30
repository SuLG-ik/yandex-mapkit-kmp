---
title: "Style"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Line_Style"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Line_Style.html"
---
# Style

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Line_Style.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Line.Style

`static class Style implements Serializable`

Describes the style of line.

## Summary

### Constructors

**Signature and Description**

```java
Style(@Nullable java.lang.Integer color)
```

```java
Style()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Integer` | `getColor()`<br>Line color in #RRGGBB format. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Style

```java
Style(@Nullable java.lang.Integer color)
```

### Style

```java
Style()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getColor

```java
@Nullable
java.lang.Integer getColor()
```

Line color in #RRGGBB format.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
