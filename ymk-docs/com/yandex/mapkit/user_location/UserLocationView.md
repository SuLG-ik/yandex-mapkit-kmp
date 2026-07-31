---
title: "UserLocationView"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationView"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationView.html"
---
# UserLocationView

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationView.html)

**Package** com.yandex.mapkit.user_location

`interface UserLocationView`

Use this interface to specify the appearance of the user location icon elements.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PlacemarkMapObject` | `getArrow()`<br>Gets the location arrow map object. |
| `PlacemarkMapObject` | `getPin()`<br>Gets the location pin map object. |
| `CircleMapObject` | `getAccuracyCircle()`<br>Gets the GPS accuracy circle map object. |
| `boolean` | `isValid()`<br>Tells if this **UserLocationView** is valid or not. |

## Methods

### getArrow

```java
@NonNull
PlacemarkMapObject getArrow()
```

Gets the location arrow map object.

### getPin

```java
@NonNull
PlacemarkMapObject getPin()
```

Gets the location pin map object.

### getAccuracyCircle

```java
@NonNull
CircleMapObject getAccuracyCircle()
```

Gets the GPS accuracy circle map object.

### isValid

```java
boolean isValid()
```

Tells if this **UserLocationView** is valid or not.

Any other method (except for this one) called on an invalid **UserLocationView** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
