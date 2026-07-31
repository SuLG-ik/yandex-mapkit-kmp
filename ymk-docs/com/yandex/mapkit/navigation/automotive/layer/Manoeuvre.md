---
title: "Manoeuvre"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / Manoeuvre"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/Manoeuvre.html"
---
# Manoeuvre

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/Manoeuvre.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.Manoeuvre

`class Manoeuvre implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Manoeuvre(@NonNull Action action,
          @NonNull LocalizedValue distance,
          @Nullable java.lang.String nextRoadName)
```

```java
Manoeuvre()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Action` | `getAction()` |
| `LocalizedValue` | `getDistance()` |
| `java.lang.String` | `getNextRoadName()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Manoeuvre

```java
Manoeuvre(@NonNull Action action,
          @NonNull LocalizedValue distance,
          @Nullable java.lang.String nextRoadName)
```

### Manoeuvre

```java
Manoeuvre()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAction

```java
@NonNull
Action getAction()
```

### getDistance

```java
@NonNull
LocalizedValue getDistance()
```

### getNextRoadName

```java
@Nullable
java.lang.String getNextRoadName()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
