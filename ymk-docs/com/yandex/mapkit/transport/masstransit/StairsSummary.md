---
title: "StairsSummary"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / StairsSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/StairsSummary.html"
---
# StairsSummary

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/StairsSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.StairsSummary

`class StairsSummary implements Serializable`

Represents summary info about stairs along the route

## Summary

### Constructors

**Signature and Description**

```java
StairsSummary(int numberOfStairs,
              int numberOfStairsWithRamp)
```

```java
StairsSummary()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getNumberOfStairs()`<br>Number of stairs along the route. |
| `int` | `getNumberOfStairsWithRamp()`<br>Number of stairs with ramps along the route. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### StairsSummary

```java
StairsSummary(int numberOfStairs,
              int numberOfStairsWithRamp)
```

### StairsSummary

```java
StairsSummary()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getNumberOfStairs

```java
int getNumberOfStairs()
```

Number of stairs along the route.

### getNumberOfStairsWithRamp

```java
int getNumberOfStairsWithRamp()
```

Number of stairs with ramps along the route.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
