---
title: "ObjectEvent"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / ObjectEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/ObjectEvent.html"
---
# ObjectEvent

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/ObjectEvent.html)

**Package** com.yandex.mapkit.layers

## All known Subinterfaces:

*[UserLocationAnchorChanged](../user_location/UserLocationAnchorChanged.md)*, *[UserLocationIconChanged](../user_location/UserLocationIconChanged.md)*

`interface ObjectEvent`

Base abstract class for an object event.

Layers that produce object event callbacks need to provide derived event classes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isValid()`<br>Tells if this **ObjectEvent** is valid or not. |

## Methods

### isValid

```java
boolean isValid()
```

Tells if this **ObjectEvent** is valid or not.

Any other method (except for this one) called on an invalid **ObjectEvent** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
