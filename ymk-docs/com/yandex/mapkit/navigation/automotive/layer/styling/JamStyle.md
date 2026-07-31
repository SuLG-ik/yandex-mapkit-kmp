---
title: "JamStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / JamStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/JamStyle.html"
---
# JamStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/JamStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface JamStyle`

The style that is used to display traffic intensity.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setColors(@NonNull java.util.List<JamTypeColor> colors)`<br>Collection of colors for traffic intensity. |
| `void` | `setGradientLength(float gradientLength)` |
| `boolean` | `isValid()`<br>Tells if this **JamStyle** is valid or not. |

## Methods

### setColors

```java
void setColors(@NonNull java.util.List<JamTypeColor> colors)
```

Collection of colors for traffic intensity.

### setGradientLength

```java
void setGradientLength(float gradientLength)
```

### isValid

```java
boolean isValid()
```

Tells if this **JamStyle** is valid or not.

Any other method (except for this one) called on an invalid **JamStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
