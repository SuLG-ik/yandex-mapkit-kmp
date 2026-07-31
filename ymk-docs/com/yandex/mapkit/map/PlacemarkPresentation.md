---
title: "PlacemarkPresentation"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarkPresentation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkPresentation.html"
---
# PlacemarkPresentation

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkPresentation.html)

**Package** com.yandex.mapkit.map

## All known Subinterfaces:

*[CompositeIcon](CompositeIcon.md)*, *[Icon](Icon.md)*, *[Model](Model.md)*, *[PlacemarkAnimation](PlacemarkAnimation.md)*

`interface PlacemarkPresentation`

A general interface for placemark presentation objects

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `remove()`<br>Removes the presentation. |
| `boolean` | `isValid()`<br>Tells if this **PlacemarkPresentation** is valid or not. |

## Methods

### remove

```java
void remove()
```

Removes the presentation.

This method invalidates object.

### isValid

```java
boolean isValid()
```

Tells if this **PlacemarkPresentation** is valid or not.

Any other method (except for this one) called on an invalid **PlacemarkPresentation** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
