---
title: "DropOffOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / DropOffOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/DropOffOptions.html"
---
# DropOffOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/DropOffOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.DropOffOptions

`class DropOffOptions implements Serializable`

Options about railway station dropoff expectations.

## Summary

### Constructors

**Signature and Description**

```java
DropOffOptions()
```

Use constructor with parameters in your code.

```java
DropOffOptions(@NonNull RailwayOptions railwayOptions)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized RailwayOptions` | `getRailwayOptions()`<br>Options about dropoff from trains. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### DropOffOptions

```java
DropOffOptions()
```

Use constructor with parameters in your code.

This one is for serialization only!

### DropOffOptions

```java
DropOffOptions(@NonNull RailwayOptions railwayOptions)
```

## Methods

### getRailwayOptions

```java
@NonNull
RailwayOptions getRailwayOptions()
```

Options about dropoff from trains.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
