---
title: "JamStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation / JamStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamStyle.html"
---
# JamStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/JamStyle.html)

**Package** com.yandex.mapkit.navigation

java.lang.Object
↳ com.yandex.mapkit.navigation.JamStyle

`class JamStyle implements Serializable`

The style that is used to display traffic intensity.

## Summary

### Constructors

**Signature and Description**

```java
JamStyle()
```

Use constructor with parameters in your code.

```java
JamStyle(@NonNull java.util.List<JamTypeColor> colors)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<JamTypeColor>` | `getColors()`<br>Collection of colors for traffic intensity. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### JamStyle

```java
JamStyle()
```

Use constructor with parameters in your code.

This one is for serialization only!

### JamStyle

```java
JamStyle(@NonNull java.util.List<JamTypeColor> colors)
```

## Methods

### getColors

```java
@NonNull
java.util.List<JamTypeColor> getColors()
```

Collection of colors for traffic intensity.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
