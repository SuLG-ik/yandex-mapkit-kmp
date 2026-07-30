---
title: "AlternativeBalloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / AlternativeBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/AlternativeBalloon.html"
---
# AlternativeBalloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/AlternativeBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.AlternativeBalloon

`class AlternativeBalloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AlternativeBalloon()
```

Use constructor with parameters in your code.

```java
AlternativeBalloon(@NonNull Summary summary,
                   @NonNull Weight relativeWeight)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Summary` | `getSummary()` |
| `synchronized Weight` | `getRelativeWeight()`<br>contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### AlternativeBalloon

```java
AlternativeBalloon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### AlternativeBalloon

```java
AlternativeBalloon(@NonNull Summary summary,
                   @NonNull Weight relativeWeight)
```

## Methods

### getSummary

```java
@NonNull
Summary getSummary()
```

### getRelativeWeight

```java
@NonNull
Weight getRelativeWeight()
```

contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
