---
title: "JamTypeColor"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation / JamTypeColor"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamTypeColor.html"
---
# JamTypeColor

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamTypeColor.html)

**Package** com.yandex.mapkit.navigation

java.lang.Object
↳ com.yandex.mapkit.navigation.JamTypeColor

`class JamTypeColor implements Serializable`

Color for specific level of traffic intensity.

## Summary

### Constructors

**Signature and Description**

```java
JamTypeColor(@NonNull JamType jamType,
             int jamColor)
```

```java
JamTypeColor()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `JamType` | `getJamType()`<br>The type of the traffic jam. |
| `int` | `getJamColor()`<br>Traffic jam color. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### JamTypeColor

```java
JamTypeColor(@NonNull JamType jamType,
             int jamColor)
```

### JamTypeColor

```java
JamTypeColor()
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

### getJamColor

```java
int getJamColor()
```

Traffic jam color.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
