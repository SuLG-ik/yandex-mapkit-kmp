---
title: "Flags"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Flags"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Flags.html"
---
# Flags

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Flags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Flags

`class Flags implements Serializable`

Indicates whether the suggested route has one or more of the specified properties.

## Summary

### Constructors

**Signature and Description**

```java
Flags(boolean requiresAccessPass,
      boolean hasAutoRoad)
```

```java
Flags()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getRequiresAccessPass()`<br>Indicates whether the suggested route requires an access pass. |
| `boolean` | `getHasAutoRoad()`<br>Indicates whether the suggested route includes automotive roads. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Flags

```java
Flags(boolean requiresAccessPass,
      boolean hasAutoRoad)
```

### Flags

```java
Flags()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getRequiresAccessPass

```java
boolean getRequiresAccessPass()
```

Indicates whether the suggested route requires an access pass.

### getHasAutoRoad

```java
boolean getHasAutoRoad()
```

Indicates whether the suggested route includes automotive roads.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
