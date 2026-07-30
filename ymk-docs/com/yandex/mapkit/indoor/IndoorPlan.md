---
title: "IndoorPlan"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.indoor"
section: "Android / Справочник / com.yandex.mapkit.indoor / IndoorPlan"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorPlan.html"
---
# IndoorPlan

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorPlan.html)

**Package** com.yandex.mapkit.indoor

`interface IndoorPlan`

Describes indoor plan of building.

Use activeLevelId property to select active level.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<IndoorLevel>` | `getLevels()`<br>List of all levels in indoor plan, from bottom to top. |
| `java.lang.String` | `getActiveLevelId()`<br>Gets/sets active id. |
| `void` | `setActiveLevelId(@NonNull java.lang.String activeLevelId)` |

## Methods

### getLevels

```java
@NonNull
java.util.List<IndoorLevel> getLevels()
```

List of all levels in indoor plan, from bottom to top.

### getActiveLevelId

```java
@NonNull
java.lang.String getActiveLevelId()
```

Gets/sets active id.

### setActiveLevelId

```java
void setActiveLevelId(@NonNull java.lang.String activeLevelId)
```
