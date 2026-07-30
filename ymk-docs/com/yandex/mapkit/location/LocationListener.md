---
title: "LocationListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationListener.html"
---
# LocationListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationListener.html)

**Package** com.yandex.mapkit.location

`interface LocationListener`

The listener that handles the updates to the device location.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onLocationUpdated(@NonNull Location location)`<br>Handle location update information. |
| `void` | `onLocationStatusUpdated(@NonNull LocationStatus status)`<br>Handle change in location provider status. |

## Methods

### onLocationUpdated

```java
@UiThread
void onLocationUpdated(@NonNull Location location)
```

Handle location update information.

### onLocationStatusUpdated

```java
@UiThread
void onLocationStatusUpdated(@NonNull LocationStatus status)
```

Handle change in location provider status.
