---
title: "ProportionFunction"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / ProportionFunction"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/ProportionFunction.html"
---
# ProportionFunction

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/ProportionFunction.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

java.lang.Object
↳ com.yandex.mapkit.styling.ProportionFunction

`class ProportionFunction implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ProportionFunction()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static ProportionFunction` | `fromConstantFunction(@NonNull ConstantFunctionPoints constantFunction)` |
| `static ProportionFunction` | `fromZoomFunction(@NonNull LinearZoomFunctionPoints zoomFunction)` |
| `static ProportionFunction` | `fromTiltFunction(@NonNull LinearTiltFunctionPoints tiltFunction)` |
| `static ProportionFunction` | `fromZoomTiltFunction(@NonNull BilinearFunctionMatrix zoomTiltFunction)` |
| `ConstantFunctionPoints` | `getConstantFunction()` |
| `LinearZoomFunctionPoints` | `getZoomFunction()` |
| `LinearTiltFunctionPoints` | `getTiltFunction()` |
| `BilinearFunctionMatrix` | `getZoomTiltFunction()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ProportionFunction

```java
ProportionFunction()
```

## Methods

### fromConstantFunction

```java
@NonNull
ProportionFunction fromConstantFunction(@NonNull ConstantFunctionPoints constantFunction)
```

### fromZoomFunction

```java
@NonNull
ProportionFunction fromZoomFunction(@NonNull LinearZoomFunctionPoints zoomFunction)
```

### fromTiltFunction

```java
@NonNull
ProportionFunction fromTiltFunction(@NonNull LinearTiltFunctionPoints tiltFunction)
```

### fromZoomTiltFunction

```java
@NonNull
ProportionFunction fromZoomTiltFunction(@NonNull BilinearFunctionMatrix zoomTiltFunction)
```

### getConstantFunction

```java
@Nullable
ConstantFunctionPoints getConstantFunction()
```

### getZoomFunction

```java
@Nullable
LinearZoomFunctionPoints getZoomFunction()
```

### getTiltFunction

```java
@Nullable
LinearTiltFunctionPoints getTiltFunction()
```

### getZoomTiltFunction

```java
@Nullable
BilinearFunctionMatrix getZoomTiltFunction()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
