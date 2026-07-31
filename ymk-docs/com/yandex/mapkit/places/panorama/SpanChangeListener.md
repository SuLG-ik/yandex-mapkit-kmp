---
title: "SpanChangeListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / SpanChangeListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SpanChangeListener.html"
---
# SpanChangeListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SpanChangeListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface SpanChangeListener`

Listener to handle the change in panorama span.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaSpanChanged(@NonNull Player player)`<br>Called if the user changed the zoom level or the span has been changed by the setSpan() method. |

## Methods

### onPanoramaSpanChanged

```java
@UiThread
void onPanoramaSpanChanged(@NonNull Player player)
```

Called if the user changed the zoom level or the span has been changed by the setSpan() method.

| Parameters |   |
| --- | --- |
| `player` | Panorama player that sent the event. |
