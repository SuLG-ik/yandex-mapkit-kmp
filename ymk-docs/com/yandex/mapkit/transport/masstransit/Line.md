---
title: "Line"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Line"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Line.html"
---
# Line

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Line.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Line

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class Line implements BaseMetadata, Serializable`

Describes a public transport line.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Style](Line_Style.md) | Describes the style of line. |

## Summary

### Constructors

**Signature and Description**

```java
Line()
```

Use constructor with parameters in your code.

```java
Line(@NonNull java.lang.String id,
     @NonNull java.lang.String name,
     @NonNull java.util.List<java.lang.String> vehicleTypes,
     @Nullable Style style,
     boolean isNight,
     @Nullable java.lang.String uri,
     @Nullable java.lang.String shortName,
     @Nullable java.lang.String transportSystemId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Line ID. |
| `synchronized java.lang.String` | `getName()`<br>Line name. |
| `synchronized java.util.List<java.lang.String>` | `getVehicleTypes()`<br>List of line types. |
| `synchronized Style` | `getStyle()`<br>Line style; see [mapkit.transport.masstransit.Line.Style](Line_Style.md). |
| `synchronized boolean` | `getIsNight()`<br>True if the line operates only at night. |
| `synchronized java.lang.String` | `getUri()`<br>URI for a line. |
| `synchronized java.lang.String` | `getShortName()`<br>Subway short line name. |
| `synchronized java.lang.String` | `getTransportSystemId()`<br>Subway transport system ID. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Line

```java
Line()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Line

```java
Line(@NonNull java.lang.String id,
     @NonNull java.lang.String name,
     @NonNull java.util.List<java.lang.String> vehicleTypes,
     @Nullable Style style,
     boolean isNight,
     @Nullable java.lang.String uri,
     @Nullable java.lang.String shortName,
     @Nullable java.lang.String transportSystemId)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Line ID.

### getName

```java
@NonNull
java.lang.String getName()
```

Line name.

### getVehicleTypes

```java
@NonNull
java.util.List<java.lang.String> getVehicleTypes()
```

List of line types.

Starts from the most detailed, ends with the most general.

### getStyle

```java
@Nullable
Style getStyle()
```

Line style; see [mapkit.transport.masstransit.Line.Style](Line_Style.md).

Optional field, can be null.

### getIsNight

```java
boolean getIsNight()
```

True if the line operates only at night.

### getUri

```java
@Nullable
java.lang.String getUri()
```

URI for a line.

Optional field, can be null.

### getShortName

```java
@Nullable
java.lang.String getShortName()
```

Subway short line name.

Optional field, can be null.

### getTransportSystemId

```java
@Nullable
java.lang.String getTransportSystemId()
```

Subway transport system ID.

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
