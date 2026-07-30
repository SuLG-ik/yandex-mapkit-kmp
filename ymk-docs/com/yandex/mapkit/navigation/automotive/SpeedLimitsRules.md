---
title: "SpeedLimitsRules"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / SpeedLimitsRules"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitsRules.html"
---
# SpeedLimitsRules

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitsRules.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.SpeedLimitsRules

`class SpeedLimitsRules implements Serializable`

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Type](SpeedLimitsRules_Type.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
SpeedLimitsRules(@NonNull Type urban,
                 @NonNull Type rural,
                 @NonNull Type expressway)
```

```java
SpeedLimitsRules()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Type` | `getUrban()` |
| `Type` | `getRural()` |
| `Type` | `getExpressway()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SpeedLimitsRules

```java
SpeedLimitsRules(@NonNull Type urban,
                 @NonNull Type rural,
                 @NonNull Type expressway)
```

### SpeedLimitsRules

```java
SpeedLimitsRules()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getUrban

```java
@NonNull
Type getUrban()
```

### getRural

```java
@NonNull
Type getRural()
```

### getExpressway

```java
@NonNull
Type getExpressway()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
