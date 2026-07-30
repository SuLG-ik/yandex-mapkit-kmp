---
title: "Event"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Event"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Event.html"
---
# Event

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Event.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Event

`class Event implements Serializable`

Road event.

## Summary

### Constructors

**Signature and Description**

```java
Event()
```

Use constructor with parameters in your code.

```java
Event(@NonNull PolylinePosition polylinePosition,
      @NonNull java.lang.String eventId,
      @Nullable java.lang.String descriptionText,
      @NonNull java.util.List<EventTag> tags,
      @NonNull Point location,
      @Nullable java.lang.Float speedLimit)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPolylinePosition()`<br>The position of the polyline. |
| `synchronized java.lang.String` | `getEventId()`<br>The unique ID of the event. |
| `synchronized java.lang.String` | `getDescriptionText()`<br>The description of the event. |
| `synchronized java.util.List<EventTag>` | `getTags()`<br>The types of the road event. |
| `synchronized Point` | `getLocation()`<br>The location of the road event. |
| `synchronized java.lang.Float` | `getSpeedLimit()`<br>The speed limit on the road. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Event

```java
Event()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Event

```java
Event(@NonNull PolylinePosition polylinePosition,
      @NonNull java.lang.String eventId,
      @Nullable java.lang.String descriptionText,
      @NonNull java.util.List<EventTag> tags,
      @NonNull Point location,
      @Nullable java.lang.Float speedLimit)
```

## Methods

### getPolylinePosition

```java
@NonNull
PolylinePosition getPolylinePosition()
```

The position of the polyline.

### getEventId

```java
@NonNull
java.lang.String getEventId()
```

The unique ID of the event.

### getDescriptionText

```java
@Nullable
java.lang.String getDescriptionText()
```

The description of the event.

Optional field, can be null.

### getTags

```java
@NonNull
java.util.List<EventTag> getTags()
```

The types of the road event.

### getLocation

```java
@NonNull
Point getLocation()
```

The location of the road event.

### getSpeedLimit

```java
@Nullable
java.lang.Float getSpeedLimit()
```

The speed limit on the road.

Valid only for cameras.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
