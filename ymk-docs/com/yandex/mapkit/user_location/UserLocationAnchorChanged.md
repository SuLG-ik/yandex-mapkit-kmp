---
title: "UserLocationAnchorChanged"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.user_location"
section: "Android / Справочник / com.yandex.mapkit.user_location / UserLocationAnchorChanged"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationAnchorChanged.html"
---
# UserLocationAnchorChanged

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/user_location/UserLocationAnchorChanged.html)

**Package** com.yandex.mapkit.user_location

## All Superinterfaces:

*[ObjectEvent](../layers/ObjectEvent.md)*

`interface UserLocationAnchorChanged extends ObjectEvent`

Event for a change in the user location icon anchor.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `UserLocationAnchorType` | `getAnchorType()`<br>Gets the type of anchor used. |

## Methods

### getAnchorType

```java
@NonNull
UserLocationAnchorType getAnchorType()
```

Gets the type of anchor used.
