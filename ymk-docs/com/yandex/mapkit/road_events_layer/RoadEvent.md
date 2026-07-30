---
title: "RoadEvent"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events_layer"
section: "Android / Справочник / com.yandex.mapkit.road_events_layer / RoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEvent.html"
---
# RoadEvent

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEvent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.road_events_layer

java.lang.Object
↳ com.yandex.mapkit.road_events_layer.RoadEvent

`class RoadEvent implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RoadEvent()
```

Use constructor with parameters in your code.

```java
RoadEvent(@NonNull java.lang.String id,
          @NonNull Point position,
          @NonNull java.util.List<EventTag> tags,
          @NonNull java.lang.String caption,
          boolean isInFuture)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>The road event unique id. |
| `synchronized Point` | `getPosition()`<br>Position of the road event on the globe. |
| `synchronized java.util.List<EventTag>` | `getTags()`<br>Set of road event tags. |
| `synchronized java.lang.String` | `getCaption()`<br>Text caption displayed under the road event icon. |
| `synchronized boolean` | `getIsInFuture()`<br>Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RoadEvent

```java
RoadEvent()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RoadEvent

```java
RoadEvent(@NonNull java.lang.String id,
          @NonNull Point position,
          @NonNull java.util.List<EventTag> tags,
          @NonNull java.lang.String caption,
          boolean isInFuture)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

The road event unique id.

### getPosition

```java
@NonNull
Point getPosition()
```

Position of the road event on the globe.

### getTags

```java
@NonNull
java.util.List<EventTag> getTags()
```

Set of road event tags.

### getCaption

```java
@NonNull
java.lang.String getCaption()
```

Text caption displayed under the road event icon.

### getIsInFuture

```java
boolean getIsInFuture()
```

Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures.

Usually such events have a greyscale icon and/or clock drawn in the icon's corner.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
