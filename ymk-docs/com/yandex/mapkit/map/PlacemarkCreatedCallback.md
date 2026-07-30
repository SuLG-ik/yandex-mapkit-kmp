---
title: "PlacemarkCreatedCallback"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarkCreatedCallback"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkCreatedCallback.html"
---
# PlacemarkCreatedCallback

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarkCreatedCallback.html)

**Package** com.yandex.mapkit.map

`interface PlacemarkCreatedCallback`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPlacemarkCreated(@NonNull PlacemarkMapObject placemark)`<br>Can be used to setup placemark style and position Will be called before MapObjectCollectionListener#onMapObjectAdded |

## Methods

### onPlacemarkCreated

```java
@UiThread
void onPlacemarkCreated(@NonNull PlacemarkMapObject placemark)
```

Can be used to setup placemark style and position Will be called before MapObjectCollectionListener#onMapObjectAdded
