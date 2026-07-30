---
title: "TrafficLevel"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.traffic"
section: "Android / Справочник / com.yandex.mapkit.traffic / TrafficLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficLevel.html"
---
# TrafficLevel

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficLevel.html)

**Package** com.yandex.mapkit.traffic

java.lang.Object
↳ com.yandex.mapkit.traffic.TrafficLevel

`class TrafficLevel implements Serializable`

The level of traffic.

## Summary

### Constructors

**Signature and Description**

```java
TrafficLevel(@NonNull TrafficColor color,
             int level)
```

```java
TrafficLevel()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `TrafficColor` | `getColor()`<br>The color that represents traffic. |
| `int` | `getLevel()`<br>Traffic level. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TrafficLevel

```java
TrafficLevel(@NonNull TrafficColor color,
             int level)
```

### TrafficLevel

```java
TrafficLevel()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getColor

```java
@NonNull
TrafficColor getColor()
```

The color that represents traffic.

### getLevel

```java
int getLevel()
```

Traffic level.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
