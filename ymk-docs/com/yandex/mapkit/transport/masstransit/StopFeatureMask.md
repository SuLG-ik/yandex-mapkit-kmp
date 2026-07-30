---
title: "StopFeatureMask"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / StopFeatureMask"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/StopFeatureMask.html"
---
# StopFeatureMask

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/StopFeatureMask.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.StopFeatureMask

`class StopFeatureMask implements Serializable`

Describes various features a stop can have.

## Summary

### Constructors

**Signature and Description**

```java
StopFeatureMask(boolean cooled,
                boolean heated)
```

```java
StopFeatureMask()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getCooled()`<br>The stop is cooled at hot weather conditions. |
| `boolean` | `getHeated()`<br>The stop is heated at cold weather conditions. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### StopFeatureMask

```java
StopFeatureMask(boolean cooled,
                boolean heated)
```

### StopFeatureMask

```java
StopFeatureMask()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getCooled

```java
boolean getCooled()
```

The stop is cooled at hot weather conditions.

### getHeated

```java
boolean getHeated()
```

The stop is heated at cold weather conditions.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
