---
title: "RouteOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteOptions.html"
---
# RouteOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RouteOptions

`class RouteOptions implements Serializable`

Settings for router, which help personalize or optimize routes

## Summary

### Constructors

**Signature and Description**

```java
RouteOptions(@NonNull FitnessOptions fitnessOptions)
```

```java
RouteOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `FitnessOptions` | `getFitnessOptions()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RouteOptions

```java
RouteOptions(@NonNull FitnessOptions fitnessOptions)
```

### RouteOptions

```java
RouteOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFitnessOptions

```java
@NonNull
FitnessOptions getFitnessOptions()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
