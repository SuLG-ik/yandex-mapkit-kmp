---
title: "Annotator"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / Annotator"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Annotator.html"
---
# Annotator

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Annotator.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface Annotator`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setSpeaker(@Nullable Speaker speaker)`<br>The class does not retain the object in the 'speaker' parameter. |
| `int` | `getAnnotatedEvents()` |
| `void` | `setAnnotatedEvents(int annotatedEvents)` |
| `int` | `getAnnotatedRoadEvents()` |
| `void` | `setAnnotatedRoadEvents(int annotatedRoadEvents)` |
| `void` | `mute()` |
| `void` | `unmute()` |
| `void` | `addListener(@NonNull AnnotatorListener annotatorListener)`<br>The class does not retain the object in the 'annotatorListener' parameter. |
| `void` | `removeListener(@NonNull AnnotatorListener annotatorListener)` |
| `boolean` | `isValid()`<br>Tells if this **Annotator** is valid or not. |

## Methods

### setSpeaker

```java
void setSpeaker(@Nullable Speaker speaker)
```

The class does not retain the object in the 'speaker' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### getAnnotatedEvents

```java
int getAnnotatedEvents()
```

### setAnnotatedEvents

```java
void setAnnotatedEvents(int annotatedEvents)
```

### getAnnotatedRoadEvents

```java
int getAnnotatedRoadEvents()
```

### setAnnotatedRoadEvents

```java
void setAnnotatedRoadEvents(int annotatedRoadEvents)
```

### mute

```java
void mute()
```

### unmute

```java
void unmute()
```

### addListener

```java
void addListener(@NonNull AnnotatorListener annotatorListener)
```

The class does not retain the object in the 'annotatorListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull AnnotatorListener annotatorListener)
```

### isValid

```java
boolean isValid()
```

Tells if this **Annotator** is valid or not.

Any other method (except for this one) called on an invalid **Annotator** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
