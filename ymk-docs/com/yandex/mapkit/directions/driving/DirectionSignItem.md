---
title: "DirectionSignItem"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignItem"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignItem.html"
---
# DirectionSignItem

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignItem

`class DirectionSignItem implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignItem()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static DirectionSignItem` | `fromToponym(@NonNull DirectionSignToponym toponym)` |
| `static DirectionSignItem` | `fromRoad(@NonNull DirectionSignRoad road)` |
| `static DirectionSignItem` | `fromExit(@NonNull DirectionSignExit exit)` |
| `static DirectionSignItem` | `fromIcon(@NonNull DirectionSignIcon icon)` |
| `DirectionSignToponym` | `getToponym()` |
| `DirectionSignRoad` | `getRoad()` |
| `DirectionSignExit` | `getExit()` |
| `DirectionSignIcon` | `getIcon()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignItem

```java
DirectionSignItem()
```

## Methods

### fromToponym

```java
@NonNull
DirectionSignItem fromToponym(@NonNull DirectionSignToponym toponym)
```

### fromRoad

```java
@NonNull
DirectionSignItem fromRoad(@NonNull DirectionSignRoad road)
```

### fromExit

```java
@NonNull
DirectionSignItem fromExit(@NonNull DirectionSignExit exit)
```

### fromIcon

```java
@NonNull
DirectionSignItem fromIcon(@NonNull DirectionSignIcon icon)
```

### getToponym

```java
@Nullable
DirectionSignToponym getToponym()
```

### getRoad

```java
@Nullable
DirectionSignRoad getRoad()
```

### getExit

```java
@Nullable
DirectionSignExit getExit()
```

### getIcon

```java
@Nullable
DirectionSignIcon getIcon()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
