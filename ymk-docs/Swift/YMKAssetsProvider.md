---
title: "YMKAssetsProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKAssetsProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAssetsProvider.html"
---
# YMKAssetsProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAssetsProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKAssetsProvider : NSObjectProtocol
```

Interface for providing images, image sizes and icon styles to the search layer. Call with static_cast(PlacemarkIconType) in all methods.

## Summary

### Instance methods

```swift
func image(withSearchResult searchResult: YMKSearchResultItem,
                       placemarkIconType: Int) -> UIImage
```

Returns an image for certain placemark type with given search result

This method will be called on a background thread

```swift
func size(withSearchResult searchResult: YMKSearchResultItem,
                      placemarkIconType: Int) -> YMKSize
```

Returns the size of the icon of certain placemark type with given search result

This method may be called on any thread

```swift
func iconStyle(withSearchResult searchResult: YMKSearchResultItem,
                           placemarkIconType: Int) -> YMKIconStyle
```

Returns the icon style for certain placemark type with given search result

```swift
func canProvideLabels(withSearchResult searchResult: YMKSearchResultItem) -> Bool
```

Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`

## Instance methods

### image(withSearchResult:placemarkIconType:)

```swift
func image(withSearchResult searchResult: YMKSearchResultItem,
                       placemarkIconType: Int) -> UIImage
```

Returns an image for certain placemark type with given search result

This method will be called on a background thread.

### size(withSearchResult:placemarkIconType:)

```swift
func size(withSearchResult searchResult: YMKSearchResultItem,
                      placemarkIconType: Int) -> YMKSize
```

Returns the size of the icon of certain placemark type with given search result

This method may be called on any thread. Its implementation must be thread-safe.

### iconStyle(withSearchResult:placemarkIconType:)

```swift
func iconStyle(withSearchResult searchResult: YMKSearchResultItem,
                           placemarkIconType: Int) -> YMKIconStyle
```

Returns the icon style for certain placemark type with given search result. If obtainAdIcons mode is enabled, IconStyle.anchor will be replaced for advertisement pins

This method may be called on any thread. Its implementation must be thread-safe.

### canProvideLabels(withSearchResult:)

```swift
func canProvideLabels(withSearchResult searchResult: YMKSearchResultItem) -> Bool
```

Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`. If `false` is returned then no label would be shown for this search result.

This method may be called on any thread. Its implementation must be thread-safe.
