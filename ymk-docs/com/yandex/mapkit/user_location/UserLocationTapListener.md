---
title: "UserLocationTapListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationTapListener.html"
---
# UserLocationTapListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationTapListener.html)

**Package** com.yandex.mapkit.user_location

`interface UserLocationTapListener`

Triggered by a tap on the user location icon.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onUserLocationObjectTap(@NonNull Point point)`<br>Called when the user taps a location object. |

## Methods

### onUserLocationObjectTap

```java
@UiThread
void onUserLocationObjectTap(@NonNull Point point)
```

Called when the user taps a location object.
