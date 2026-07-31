---
title: "PlacemarkListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / PlacemarkListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/PlacemarkListener.html"
---
# PlacemarkListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/PlacemarkListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

`interface PlacemarkListener`

Interface for callbacks on placemark events.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `onTap(@NonNull SearchResultItem searchResultItem)`<br>Called when user taps on placemark. |

## Methods

### onTap

```java
@UiThread
boolean onTap(@NonNull SearchResultItem searchResultItem)
```

Called when user taps on placemark.

| Parameters |   |
| --- | --- |
| `searchResultItem` | Corresponding search result. |
