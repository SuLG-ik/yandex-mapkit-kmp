---
title: "ActionMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ActionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ActionMetadata.html"
---
# ActionMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ActionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ActionMetadata

`class ActionMetadata implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ActionMetadata()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static ActionMetadata` | `fromUturnMetadata(@NonNull UturnMetadata uturnMetadata)` |
| `static ActionMetadata` | `fromLeaveRoundaboutMetadata(@NonNull LeaveRoundaboutMetadata leaveRoundaboutMetadata)` |
| `static ActionMetadata` | `fromTurnMetadata(@NonNull TurnMetadata turnMetadata)` |
| `static ActionMetadata` | `fromExitMetadata(@NonNull ExitMetadata exitMetadata)` |
| `UturnMetadata` | `getUturnMetadata()` |
| `LeaveRoundaboutMetadata` | `getLeaveRoundaboutMetadata()` |
| `TurnMetadata` | `getTurnMetadata()` |
| `ExitMetadata` | `getExitMetadata()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ActionMetadata

```java
ActionMetadata()
```

## Methods

### fromUturnMetadata

```java
@NonNull
ActionMetadata fromUturnMetadata(@NonNull UturnMetadata uturnMetadata)
```

### fromLeaveRoundaboutMetadata

```java
@NonNull
ActionMetadata fromLeaveRoundaboutMetadata(@NonNull LeaveRoundaboutMetadata leaveRoundaboutMetadata)
```

### fromTurnMetadata

```java
@NonNull
ActionMetadata fromTurnMetadata(@NonNull TurnMetadata turnMetadata)
```

### fromExitMetadata

```java
@NonNull
ActionMetadata fromExitMetadata(@NonNull ExitMetadata exitMetadata)
```

### getUturnMetadata

```java
@Nullable
UturnMetadata getUturnMetadata()
```

### getLeaveRoundaboutMetadata

```java
@Nullable
LeaveRoundaboutMetadata getLeaveRoundaboutMetadata()
```

### getTurnMetadata

```java
@Nullable
TurnMetadata getTurnMetadata()
```

### getExitMetadata

```java
@Nullable
ExitMetadata getExitMetadata()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
