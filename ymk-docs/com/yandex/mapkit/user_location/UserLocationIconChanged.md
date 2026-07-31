---
title: "UserLocationIconChanged"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationIconChanged"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationIconChanged.html"
---
# UserLocationIconChanged

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationIconChanged.html)

**Package** com.yandex.mapkit.user_location

## All Superinterfaces:

*[ObjectEvent](../layers/ObjectEvent.md)*

`interface UserLocationIconChanged extends ObjectEvent`

This event triggers when the user location icon type is changed.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `UserLocationIconType` | `getIconType()`<br>Gets the type of user location icon used. |

## Methods

### getIconType

```java
@NonNull
UserLocationIconType getIconType()
```

Gets the type of user location icon used.
