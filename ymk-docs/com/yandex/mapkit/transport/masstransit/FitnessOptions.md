---
title: "FitnessOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / FitnessOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/FitnessOptions.html"
---
# FitnessOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/FitnessOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.FitnessOptions

`class FitnessOptions implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
FitnessOptions(boolean avoidSteep,
               boolean avoidStairs)
```

```java
FitnessOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getAvoidSteep()`<br>If true, router will try avoid steep (in height meaning) routes. |
| `boolean` | `getAvoidStairs()`<br>If true, router will try avoid stairs. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### FitnessOptions

```java
FitnessOptions(boolean avoidSteep,
               boolean avoidStairs)
```

### FitnessOptions

```java
FitnessOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAvoidSteep

```java
boolean getAvoidSteep()
```

If true, router will try avoid steep (in height meaning) routes.

### getAvoidStairs

```java
boolean getAvoidStairs()
```

If true, router will try avoid stairs.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
