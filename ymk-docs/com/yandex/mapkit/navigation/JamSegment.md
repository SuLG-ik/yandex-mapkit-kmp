---
title: "JamSegment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation / JamSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamSegment.html"
---
# JamSegment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamSegment.html)

**Package** com.yandex.mapkit.navigation

java.lang.Object
↳ com.yandex.mapkit.navigation.JamSegment

`class JamSegment implements Serializable`

A segment of a traffic jam that has specific traffic conditions.

## Summary

### Constructors

**Signature and Description**

```java
JamSegment(@NonNull JamType jamType,
           double speed)
```

```java
JamSegment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `JamType` | `getJamType()`<br>The type of the traffic jam. |
| `double` | `getSpeed()`<br>The speed at which traffic is moving. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### JamSegment

```java
JamSegment(@NonNull JamType jamType,
           double speed)
```

### JamSegment

```java
JamSegment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getJamType

```java
@NonNull
JamType getJamType()
```

The type of the traffic jam.

### getSpeed

```java
double getSpeed()
```

The speed at which traffic is moving.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
