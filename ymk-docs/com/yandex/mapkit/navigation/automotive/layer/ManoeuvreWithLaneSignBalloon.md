---
title: "ManoeuvreWithLaneSignBalloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / ManoeuvreWithLaneSignBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/ManoeuvreWithLaneSignBalloon.html"
---
# ManoeuvreWithLaneSignBalloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/ManoeuvreWithLaneSignBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.ManoeuvreWithLaneSignBalloon

`class ManoeuvreWithLaneSignBalloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ManoeuvreWithLaneSignBalloon()
```

Use constructor with parameters in your code.

```java
ManoeuvreWithLaneSignBalloon(@NonNull Manoeuvre manoeuvre,
                             @NonNull LaneSign laneSign,
                             @Nullable DirectionSign directionSign)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Manoeuvre` | `getManoeuvre()` |
| `synchronized LaneSign` | `getLaneSign()` |
| `synchronized DirectionSign` | `getDirectionSign()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ManoeuvreWithLaneSignBalloon

```java
ManoeuvreWithLaneSignBalloon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ManoeuvreWithLaneSignBalloon

```java
ManoeuvreWithLaneSignBalloon(@NonNull Manoeuvre manoeuvre,
                             @NonNull LaneSign laneSign,
                             @Nullable DirectionSign directionSign)
```

## Methods

### getManoeuvre

```java
@NonNull
Manoeuvre getManoeuvre()
```

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
