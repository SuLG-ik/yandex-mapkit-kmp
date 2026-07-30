---
title: "NonAvoidedFeatures"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / NonAvoidedFeatures"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/NonAvoidedFeatures.html"
---
# NonAvoidedFeatures

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/NonAvoidedFeatures.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.NonAvoidedFeatures

`class NonAvoidedFeatures implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
NonAvoidedFeatures(boolean tolls,
                   boolean ferries,
                   boolean fordCrossings,
                   boolean highways,
                   boolean railwayCrossings,
                   boolean tunnels,
                   boolean inPoorConditionRoads,
                   boolean unpavedRoads,
                   boolean avoidZones)
```

```java
NonAvoidedFeatures()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getTolls()` |
| `boolean` | `getFerries()` |
| `boolean` | `getFordCrossings()` |
| `boolean` | `getHighways()` |
| `boolean` | `getRailwayCrossings()` |
| `boolean` | `getTunnels()` |
| `boolean` | `getInPoorConditionRoads()` |
| `boolean` | `getUnpavedRoads()` |
| `boolean` | `getAvoidZones()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### NonAvoidedFeatures

```java
NonAvoidedFeatures(boolean tolls,
                   boolean ferries,
                   boolean fordCrossings,
                   boolean highways,
                   boolean railwayCrossings,
                   boolean tunnels,
                   boolean inPoorConditionRoads,
                   boolean unpavedRoads,
                   boolean avoidZones)
```

### NonAvoidedFeatures

```java
NonAvoidedFeatures()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTolls

```java
boolean getTolls()
```

### getFerries

```java
boolean getFerries()
```

### getFordCrossings

```java
boolean getFordCrossings()
```

### getHighways

```java
boolean getHighways()
```

### getRailwayCrossings

```java
boolean getRailwayCrossings()
```

### getTunnels

```java
boolean getTunnels()
```

### getInPoorConditionRoads

```java
boolean getInPoorConditionRoads()
```

### getUnpavedRoads

```java
boolean getUnpavedRoads()
```

### getAvoidZones

```java
boolean getAvoidZones()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
