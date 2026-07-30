---
title: "LaneSignBalloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / LaneSignBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/LaneSignBalloon.html"
---
# LaneSignBalloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/LaneSignBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.LaneSignBalloon

`class LaneSignBalloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LaneSignBalloon()
```

Use constructor with parameters in your code.

```java
LaneSignBalloon(@NonNull LaneSign laneSign,
                @Nullable DirectionSign directionSign)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized LaneSign` | `getLaneSign()` |
| `synchronized DirectionSign` | `getDirectionSign()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LaneSignBalloon

```java
LaneSignBalloon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LaneSignBalloon

```java
LaneSignBalloon(@NonNull LaneSign laneSign,
                @Nullable DirectionSign directionSign)
```

## Methods

### getLaneSign

```java
@NonNull
LaneSign getLaneSign()
```

### getDirectionSign

```java
@Nullable
DirectionSign getDirectionSign()
```

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
