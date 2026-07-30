---
title: "UserLocationObjectListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationObjectListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationObjectListener.html"
---
# UserLocationObjectListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationObjectListener.html)

**Package** com.yandex.mapkit.user_location

`interface UserLocationObjectListener`

User location events object listener.

Use it to customize the user location view. Although some callbacks are unused, the generic structure of the interface is suitable for object layer listeners.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onObjectAdded(@NonNull UserLocationView view)`<br>Called when the layer object is added. |
| `void` | `onObjectRemoved(@NonNull UserLocationView view)`<br>Called when the layer object is being removed. |
| `void` | `onObjectUpdated(@NonNull UserLocationView view, @NonNull ObjectEvent event)`<br>Called when the layer object is being updated. |

## Methods

### onObjectAdded

```java
@UiThread
void onObjectAdded(@NonNull UserLocationView view)
```

Called when the layer object is added.

It is called once when the user location icon appears the first time.

### onObjectRemoved

```java
@UiThread
void onObjectRemoved(@NonNull UserLocationView view)
```

Called when the layer object is being removed.

It is never called for the user location icon.

### onObjectUpdated

```java
@UiThread
void onObjectUpdated(@NonNull UserLocationView view,
                     @NonNull ObjectEvent event)
```

Called when the layer object is being updated.

The 'event' parameter can be one of the derived types.
