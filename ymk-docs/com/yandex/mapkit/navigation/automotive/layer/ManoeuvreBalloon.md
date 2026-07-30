---
title: "ManoeuvreBalloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / ManoeuvreBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/ManoeuvreBalloon.html"
---
# ManoeuvreBalloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/ManoeuvreBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.ManoeuvreBalloon

`class ManoeuvreBalloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ManoeuvreBalloon()
```

Use constructor with parameters in your code.

```java
ManoeuvreBalloon(@NonNull Manoeuvre manoeuvre,
                 @Nullable DirectionSign directionSign)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Manoeuvre` | `getManoeuvre()` |
| `synchronized DirectionSign` | `getDirectionSign()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ManoeuvreBalloon

```java
ManoeuvreBalloon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ManoeuvreBalloon

```java
ManoeuvreBalloon(@NonNull Manoeuvre manoeuvre,
                 @Nullable DirectionSign directionSign)
```

## Methods

### getManoeuvre

```java
@NonNull
Manoeuvre getManoeuvre()
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
