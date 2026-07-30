---
title: "IndoorLevel"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / IndoorLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorLevel.html"
---
# IndoorLevel

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorLevel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.IndoorLevel

`class IndoorLevel implements Serializable`

Indoor level (floor).

## Summary

### Constructors

**Signature and Description**

```java
IndoorLevel(@NonNull java.lang.String levelId,
            @NonNull java.lang.String levelName)
```

```java
IndoorLevel()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getLevelId()`<br>Level id that can be passed to the Router. |
| `java.lang.String` | `getLevelName()`<br>Localized level name. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### IndoorLevel

```java
IndoorLevel(@NonNull java.lang.String levelId,
            @NonNull java.lang.String levelName)
```

### IndoorLevel

```java
IndoorLevel()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getLevelId

```java
@NonNull
java.lang.String getLevelId()
```

Level id that can be passed to the Router.

### getLevelName

```java
@NonNull
java.lang.String getLevelName()
```

Localized level name.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
