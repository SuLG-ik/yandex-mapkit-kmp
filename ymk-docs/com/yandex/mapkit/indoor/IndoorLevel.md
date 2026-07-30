---
title: "IndoorLevel"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.indoor"
section: "Android / Справочник / com.yandex.mapkit.indoor / IndoorLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorLevel.html"
---
# IndoorLevel

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorLevel.html)

**Package** com.yandex.mapkit.indoor

java.lang.Object
↳ com.yandex.mapkit.indoor.IndoorLevel

`class IndoorLevel implements Serializable`

Describes level of indoor plan.

## Summary

### Constructors

**Signature and Description**

```java
IndoorLevel(@NonNull java.lang.String id,
            @NonNull java.lang.String name,
            boolean isUnderground)
```

```java
IndoorLevel()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Universal identifier of the level. |
| `java.lang.String` | `getName()`<br>Localized display name of the level. |
| `boolean` | `getIsUnderground()`<br>true if level is under ground |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### IndoorLevel

```java
IndoorLevel(@NonNull java.lang.String id,
            @NonNull java.lang.String name,
            boolean isUnderground)
```

### IndoorLevel

```java
IndoorLevel()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Universal identifier of the level.

### getName

```java
@NonNull
java.lang.String getName()
```

Localized display name of the level.

### getIsUnderground

```java
boolean getIsUnderground()
```

true if level is under ground

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
