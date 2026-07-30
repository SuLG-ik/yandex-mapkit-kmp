---
title: "SpeedLimits"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / SpeedLimits"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimits.html"
---
# SpeedLimits

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimits.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.SpeedLimits

`class SpeedLimits implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
SpeedLimits(@NonNull LocalizedValue urban,
            @NonNull LocalizedValue rural,
            @NonNull LocalizedValue expressway)
```

```java
SpeedLimits()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `LocalizedValue` | `getUrban()` |
| `LocalizedValue` | `getRural()` |
| `LocalizedValue` | `getExpressway()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SpeedLimits

```java
SpeedLimits(@NonNull LocalizedValue urban,
            @NonNull LocalizedValue rural,
            @NonNull LocalizedValue expressway)
```

### SpeedLimits

```java
SpeedLimits()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getUrban

```java
@NonNull
LocalizedValue getUrban()
```

### getRural

```java
@NonNull
LocalizedValue getRural()
```

### getExpressway

```java
@NonNull
LocalizedValue getExpressway()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
