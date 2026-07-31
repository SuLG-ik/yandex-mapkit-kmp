---
title: "Balloon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / Balloon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/Balloon.html"
---
# Balloon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/Balloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.Balloon

`class Balloon implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Balloon()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Balloon` | `fromManoeuvre(@NonNull ManoeuvreBalloon manoeuvre)` |
| `static Balloon` | `fromManoeuvreWithLaneSign(@NonNull ManoeuvreWithLaneSignBalloon manoeuvreWithLaneSign)` |
| `static Balloon` | `fromLaneSign(@NonNull LaneSignBalloon laneSign)` |
| `static Balloon` | `fromRouteSummary(@NonNull RouteSummaryBalloon routeSummary)` |
| `static Balloon` | `fromAlternative(@NonNull AlternativeBalloon alternative)` |
| `ManoeuvreBalloon` | `getManoeuvre()` |
| `ManoeuvreWithLaneSignBalloon` | `getManoeuvreWithLaneSign()` |
| `LaneSignBalloon` | `getLaneSign()` |
| `RouteSummaryBalloon` | `getRouteSummary()` |
| `AlternativeBalloon` | `getAlternative()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Balloon

```java
Balloon()
```

## Methods

### fromManoeuvre

```java
@NonNull
Balloon fromManoeuvre(@NonNull ManoeuvreBalloon manoeuvre)
```

### fromManoeuvreWithLaneSign

```java
@NonNull
Balloon fromManoeuvreWithLaneSign(@NonNull ManoeuvreWithLaneSignBalloon manoeuvreWithLaneSign)
```

### fromLaneSign

```java
@NonNull
Balloon fromLaneSign(@NonNull LaneSignBalloon laneSign)
```

### fromRouteSummary

```java
@NonNull
Balloon fromRouteSummary(@NonNull RouteSummaryBalloon routeSummary)
```

### fromAlternative

```java
@NonNull
Balloon fromAlternative(@NonNull AlternativeBalloon alternative)
```

### getManoeuvre

```java
@Nullable
ManoeuvreBalloon getManoeuvre()
```

### getManoeuvreWithLaneSign

```java
@Nullable
ManoeuvreWithLaneSignBalloon getManoeuvreWithLaneSign()
```

### getLaneSign

```java
@Nullable
LaneSignBalloon getLaneSign()
```

### getRouteSummary

```java
@Nullable
RouteSummaryBalloon getRouteSummary()
```

### getAlternative

```java
@Nullable
AlternativeBalloon getAlternative()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
