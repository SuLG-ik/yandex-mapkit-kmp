---
title: "RoadEventStylingProperties"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events_layer"
section: "Android / Справочник / com.yandex.mapkit.road_events_layer / RoadEventStylingProperties"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEventStylingProperties.html"
---
# RoadEventStylingProperties

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEventStylingProperties.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.road_events_layer

`interface RoadEventStylingProperties`

Interface that has subset of fields of RoadEvent necessary for providing style.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<EventTag>` | `getTags()`<br>Set of road event tags. |
| `boolean` | `hasSignificanceGreaterOrEqual(@NonNull RoadEventSignificance significance)`<br>Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only. |
| `boolean` | `isInFuture()`<br>Whether road event will become active in the future. |
| `boolean` | `isOnRoute()`<br>Road event placed on a route. |
| `boolean` | `isSelected()`<br>Road event was selected by RoadEventsLayer.selectRoadEvent. |
| `boolean` | `isUserEvent()`<br>Currently logged in user is either an author of this road event or has commented it. |
| `boolean` | `isValid()`<br>Tells if this **RoadEventStylingProperties** is valid or not. |

## Methods

### getTags

```java
@NonNull
java.util.List<EventTag> getTags()
```

Set of road event tags.

### hasSignificanceGreaterOrEqual

```java
boolean hasSignificanceGreaterOrEqual(@NonNull RoadEventSignificance significance)
```

Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only.

Significance of a road event can depend on a road category this event is snapped to, number of comments of this event and other factors. Two road events with same significance but different tag sets can be visible on different zoom ranges.

### isInFuture

```java
boolean isInFuture()
```

Whether road event will become active in the future.

See RoadEvent for details.

### isOnRoute

```java
boolean isOnRoute()
```

Road event placed on a route.

See RoadEventsLayer.setRoadEventsOnRoute.

### isSelected

```java
boolean isSelected()
```

Road event was selected by RoadEventsLayer.selectRoadEvent.

### isUserEvent

```java
boolean isUserEvent()
```

Currently logged in user is either an author of this road event or has commented it.

### isValid

```java
boolean isValid()
```

Tells if this **RoadEventStylingProperties** is valid or not.

Any other method (except for this one) called on an invalid **RoadEventStylingProperties** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
