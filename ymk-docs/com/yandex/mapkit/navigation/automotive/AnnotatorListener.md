---
title: "AnnotatorListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / AnnotatorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/AnnotatorListener.html"
---
# AnnotatorListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/AnnotatorListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface AnnotatorListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `manoeuvreAnnotated()` |
| `void` | `roadEventAnnotated()` |
| `void` | `speedingAnnotated()` |
| `void` | `fasterAlternativeAnnotated()` |

## Methods

### manoeuvreAnnotated

```java
@UiThread
void manoeuvreAnnotated()
```

### roadEventAnnotated

```java
@UiThread
void roadEventAnnotated()
```

### speedingAnnotated

```java
@UiThread
void speedingAnnotated()
```

### fasterAlternativeAnnotated

```java
@UiThread
void fasterAlternativeAnnotated()
```
