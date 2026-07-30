---
title: "Animation"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Animation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Animation.html"
---
# Animation

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Animation.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Animation

`class Animation implements Serializable`

The animation that is used to switch between states.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Type](Animation_Type.md) | Available animation types. |

## Summary

### Constructors

**Signature and Description**

```java
Animation(@NonNull Type type,
          float duration)
```

```java
Animation()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Type` | `getType()`<br>Animation type. |
| `float` | `getDuration()`<br>Animation duration, in seconds. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Animation

```java
Animation(@NonNull Type type,
          float duration)
```

### Animation

```java
Animation()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getType

```java
@NonNull
Type getType()
```

Animation type.

### getDuration

```java
float getDuration()
```

Animation duration, in seconds.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
