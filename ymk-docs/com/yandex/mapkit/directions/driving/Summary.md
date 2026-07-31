---
title: "Summary"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Summary"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Summary.html"
---
# Summary

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Summary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Summary

`class Summary implements Serializable`

Route summary.

## Summary

### Constructors

**Signature and Description**

```java
Summary(@NonNull Weight weight,
        @NonNull Flags flags,
        @NonNull NonAvoidedFeatures nonAvoidedFeatures)
```

```java
Summary()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Weight` | `getWeight()`<br>Route "weight". |
| `Flags` | `getFlags()`<br>Overall route characteristics. |
| `NonAvoidedFeatures` | `getNonAvoidedFeatures()`<br>Route features that cannot be avoided |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Summary

```java
Summary(@NonNull Weight weight,
        @NonNull Flags flags,
        @NonNull NonAvoidedFeatures nonAvoidedFeatures)
```

### Summary

```java
Summary()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Route "weight".

### getFlags

```java
@NonNull
Flags getFlags()
```

Overall route characteristics.

### getNonAvoidedFeatures

```java
@NonNull
NonAvoidedFeatures getNonAvoidedFeatures()
```

Route features that cannot be avoided

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
