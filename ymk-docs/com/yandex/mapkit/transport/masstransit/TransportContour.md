---
title: "TransportContour"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportContour"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportContour.html"
---
# TransportContour

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportContour.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportContour

`class TransportContour implements Serializable`

Describes transport contours and it's properties

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Style](TransportContour_Style.md) | Describes the style of transport contour objects |

## Summary

### Constructors

**Signature and Description**

```java
TransportContour()
```

Use constructor with parameters in your code.

```java
TransportContour(@NonNull java.lang.String name,
                 @Nullable Style style)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Contour name |
| `synchronized Style` | `getStyle()`<br>Contour style; see [mapkit.transport.masstransit.TransportContour.Style](TransportContour_Style.md). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TransportContour

```java
TransportContour()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TransportContour

```java
TransportContour(@NonNull java.lang.String name,
                 @Nullable Style style)
```

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

Contour name

### getStyle

```java
@Nullable
Style getStyle()
```

Contour style; see [mapkit.transport.masstransit.TransportContour.Style](TransportContour_Style.md).

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
