---
title: "LeaveRoundaboutMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / LeaveRoundaboutMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/LeaveRoundaboutMetadata.html"
---
# LeaveRoundaboutMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/LeaveRoundaboutMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.LeaveRoundaboutMetadata

`class LeaveRoundaboutMetadata implements Serializable`

The number of the exit for leaving the roundabout.

## Summary

### Constructors

**Signature and Description**

```java
LeaveRoundaboutMetadata(int exitNumber)
```

```java
LeaveRoundaboutMetadata()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getExitNumber()`<br>The exit number. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LeaveRoundaboutMetadata

```java
LeaveRoundaboutMetadata(int exitNumber)
```

### LeaveRoundaboutMetadata

```java
LeaveRoundaboutMetadata()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getExitNumber

```java
int getExitNumber()
```

The exit number.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
