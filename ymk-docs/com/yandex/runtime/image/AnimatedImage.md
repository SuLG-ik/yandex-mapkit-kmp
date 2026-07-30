---
title: "AnimatedImage"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.image"
section: "Android / Справочник / com.yandex.runtime.image / AnimatedImage"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/AnimatedImage.html"
---
# AnimatedImage

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/image/AnimatedImage.html)

**Package** com.yandex.runtime.image

java.lang.Object
↳ com.yandex.runtime.image.AnimatedImage

`class AnimatedImage`

An animated image.

## Summary

### Constructors

**Signature and Description**

```java
AnimatedImage(int loopCount,
              java.util.List<Frame> frames)
```

```java
AnimatedImage(int loopCount)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addFrame(ImageProvider image, long duration)` |
| `java.util.List<Frame>` | `getFrames()`<br>Returns a list of animation frames. |
| `int` | `getLoopCount()`<br>Returns the number of animation loops. |

## Constuctors

### AnimatedImage

```java
AnimatedImage(int loopCount,
              java.util.List<Frame> frames)
```

### AnimatedImage

```java
AnimatedImage(int loopCount)
```

## Methods

### addFrame

```java
void addFrame(ImageProvider image,
              long duration)
```

### getFrames

```java
java.util.List<Frame> getFrames()
```

Returns a list of animation frames.

### getLoopCount

```java
int getLoopCount()
```

Returns the number of animation loops.

The zero value is treated as infinity.
