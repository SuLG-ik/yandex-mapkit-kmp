---
title: "RouteSummaryBalloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / RouteSummaryBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RouteSummaryBalloon.html"
---
# RouteSummaryBalloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RouteSummaryBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.RouteSummaryBalloon

`class RouteSummaryBalloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RouteSummaryBalloon()
```

Use constructor with parameters in your code.

```java
RouteSummaryBalloon(@NonNull Summary summary,
                    @NonNull java.util.List<java.lang.String> tags,
                    @Nullable Weight relativeWeight)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Summary` | `getSummary()` |
| `synchronized java.util.List<java.lang.String>` | `getTags()` |
| `synchronized Weight` | `getRelativeWeight()`<br>presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RouteSummaryBalloon

```java
RouteSummaryBalloon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RouteSummaryBalloon

```java
RouteSummaryBalloon(@NonNull Summary summary,
                    @NonNull java.util.List<java.lang.String> tags,
                    @Nullable Weight relativeWeight)
```

## Methods

### getSummary

```java
@NonNull
Summary getSummary()
```

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

### getRelativeWeight

```java
@Nullable
Weight getRelativeWeight()
```

presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
