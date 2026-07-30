---
title: "AssetsProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / AssetsProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/AssetsProvider.html"
---
# AssetsProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/AssetsProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

`interface AssetsProvider`

Interface for providing images, image sizes and icon styles to the search layer.

Call with static_cast(PlacemarkIconType) in all methods.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ImageProvider` | `image(@NonNull SearchResultItem searchResult, int placemarkIconType)`<br>Returns an image for certain placemark type with given search result<br>This method will be called on a background thread. |
| `Size` | `size(@NonNull SearchResultItem searchResult, int placemarkIconType)`<br>Returns the size of the icon of certain placemark type with given search result<br>This method may be called on any thread. |
| `IconStyle` | `iconStyle(@NonNull SearchResultItem searchResult, int placemarkIconType)`<br>Returns the icon style for certain placemark type with given search result. |
| `boolean` | `canProvideLabels(@NonNull SearchResultItem searchResult)`<br>Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`. |

## Methods

### image

```java
@WorkerThread @NonNull
ImageProvider image(@NonNull SearchResultItem searchResult,
                    int placemarkIconType)
```

Returns an image for certain placemark type with given search result

This method will be called on a background thread.

### size

```java
@AnyThread @NonNull
Size size(@NonNull SearchResultItem searchResult,
          int placemarkIconType)
```

Returns the size of the icon of certain placemark type with given search result

This method may be called on any thread.

Its implementation must be thread-safe.

### iconStyle

```java
@AnyThread @NonNull
IconStyle iconStyle(@NonNull SearchResultItem searchResult,
                    int placemarkIconType)
```

Returns the icon style for certain placemark type with given search result.

If obtainAdIcons mode is enabled, IconStyle.anchor will be replaced for advertisement pins

This method may be called on any thread. Its implementation must be thread-safe.

### canProvideLabels

```java
@AnyThread
boolean canProvideLabels(@NonNull SearchResultItem searchResult)
```

Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`.

If `false` is returned then no label would be shown for this search result.

This method may be called on any thread. Its implementation must be thread-safe.
