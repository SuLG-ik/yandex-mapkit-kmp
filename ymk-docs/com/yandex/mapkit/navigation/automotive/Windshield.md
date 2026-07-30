---
title: "Windshield"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / Windshield"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Windshield.html"
---
# Windshield

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Windshield.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface Windshield`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<UpcomingManoeuvre>` | `getManoeuvres()`<br>Vector with next manoeuvres. |
| `java.util.List<UpcomingRoadEvent>` | `getRoadEvents()`<br>Vector with all road events between current position and the next manoeuvre. |
| `java.util.List<UpcomingLaneSign>` | `getLaneSigns()`<br>Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector. |
| `java.util.List<UpcomingDirectionSign>` | `getDirectionSigns()`<br>Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector. |
| `void` | `addListener(@NonNull WindshieldListener windshieldListener)`<br>The class does not retain the object in the 'windshieldListener' parameter. |
| `void` | `removeListener(@NonNull WindshieldListener windshieldListener)` |
| `boolean` | `isValid()`<br>Tells if this **Windshield** is valid or not. |

## Methods

### getManoeuvres

```java
@NonNull
java.util.List<UpcomingManoeuvre> getManoeuvres()
```

Vector with next manoeuvres.

Contains several items only if they are close to each other.

### getRoadEvents

```java
@NonNull
java.util.List<UpcomingRoadEvent> getRoadEvents()
```

Vector with all road events between current position and the next manoeuvre.

Sorted by distance.

### getLaneSigns

```java
@NonNull
java.util.List<UpcomingLaneSign> getLaneSigns()
```

Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector.

Sorted by distance.

### getDirectionSigns

```java
@NonNull
java.util.List<UpcomingDirectionSign> getDirectionSigns()
```

Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector.

Sorted by distance.

### addListener

```java
void addListener(@NonNull WindshieldListener windshieldListener)
```

The class does not retain the object in the 'windshieldListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull WindshieldListener windshieldListener)
```

### isValid

```java
boolean isValid()
```

Tells if this **Windshield** is valid or not.

Any other method (except for this one) called on an invalid **Windshield** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
