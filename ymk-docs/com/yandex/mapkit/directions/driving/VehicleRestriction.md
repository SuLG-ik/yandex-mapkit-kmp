---
title: "VehicleRestriction"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / VehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/VehicleRestriction.html"
---
# VehicleRestriction

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/VehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.VehicleRestriction

`class VehicleRestriction implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
VehicleRestriction(@Nullable java.lang.Float weightLimit,
                   @Nullable java.lang.Float axleWeightLimit,
                   @Nullable java.lang.Float maxWeightLimit,
                   @Nullable java.lang.Float heightLimit,
                   @Nullable java.lang.Float widthLimit,
                   @Nullable java.lang.Float lengthLimit,
                   @Nullable java.lang.Float payloadLimit,
                   @Nullable java.lang.Integer minEcoClass,
                   @Nullable java.lang.Boolean trailerNotAllowed,
                   @Nullable java.lang.Boolean legal)
```

```java
VehicleRestriction()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Float` | `getWeightLimit()`<br>Actual weight limit, tons. |
| `java.lang.Float` | `getAxleWeightLimit()`<br>Axle load weight limit, tons. |
| `java.lang.Float` | `getMaxWeightLimit()`<br>Maximal allowed weight limit, tons. |
| `java.lang.Float` | `getHeightLimit()`<br>Height limit, meters. |
| `java.lang.Float` | `getWidthLimit()`<br>Width limit, meters. |
| `java.lang.Float` | `getLengthLimit()`<br>Length limit, meters. |
| `java.lang.Float` | `getPayloadLimit()`<br>Payload limit, tons. |
| `java.lang.Integer` | `getMinEcoClass()`<br>Minimal allowed engine ecological class. |
| `java.lang.Boolean` | `getTrailerNotAllowed()`<br>Trailer is not allowed. |
| `java.lang.Boolean` | `getLegal()`<br>Legal or physical limitation. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### VehicleRestriction

```java
VehicleRestriction(@Nullable java.lang.Float weightLimit,
                   @Nullable java.lang.Float axleWeightLimit,
                   @Nullable java.lang.Float maxWeightLimit,
                   @Nullable java.lang.Float heightLimit,
                   @Nullable java.lang.Float widthLimit,
                   @Nullable java.lang.Float lengthLimit,
                   @Nullable java.lang.Float payloadLimit,
                   @Nullable java.lang.Integer minEcoClass,
                   @Nullable java.lang.Boolean trailerNotAllowed,
                   @Nullable java.lang.Boolean legal)
```

### VehicleRestriction

```java
VehicleRestriction()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getWeightLimit

```java
@Nullable
java.lang.Float getWeightLimit()
```

Actual weight limit, tons.

See Driving Rules sign 3.11.

Optional field, can be null.

### getAxleWeightLimit

```java
@Nullable
java.lang.Float getAxleWeightLimit()
```

Axle load weight limit, tons.

See Driving Rules sign 3.12.

Optional field, can be null.

### getMaxWeightLimit

```java
@Nullable
java.lang.Float getMaxWeightLimit()
```

Maximal allowed weight limit, tons.

See Driving Rules sign 3.4, table 8.11.

Optional field, can be null.

### getHeightLimit

```java
@Nullable
java.lang.Float getHeightLimit()
```

Height limit, meters.

See Driving Rules sign 3.13.

Optional field, can be null.

### getWidthLimit

```java
@Nullable
java.lang.Float getWidthLimit()
```

Width limit, meters.

See Driving Rules sign 3.14.

Optional field, can be null.

### getLengthLimit

```java
@Nullable
java.lang.Float getLengthLimit()
```

Length limit, meters.

See Driving Rules sign 3.15.

Optional field, can be null.

### getPayloadLimit

```java
@Nullable
java.lang.Float getPayloadLimit()
```

Payload limit, tons.

Optional field, can be null.

### getMinEcoClass

```java
@Nullable
java.lang.Integer getMinEcoClass()
```

Minimal allowed engine ecological class.

See Driving Rules sign 5.35 and 5.36.

Optional field, can be null.

### getTrailerNotAllowed

```java
@Nullable
java.lang.Boolean getTrailerNotAllowed()
```

Trailer is not allowed.

See Driving Rules sign 3.7.

Optional field, can be null.

### getLegal

```java
@Nullable
java.lang.Boolean getLegal()
```

Legal or physical limitation.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
