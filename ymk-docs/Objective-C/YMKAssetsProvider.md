---
title: "YMKAssetsProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKAssetsProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAssetsProvider.html"
---
# YMKAssetsProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAssetsProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKAssetsProvider <NSObject>
```

Interface for providing images, image sizes and icon styles to the search layer. Call with static_cast(PlacemarkIconType) in all methods.

## Summary

### Instance methods

```objectivec
- (nonnull UIImage *)imageWithSearchResult:
                         (nonnull YMKSearchResultItem *)searchResult
                         placemarkIconType:(NSInteger)placemarkIconType;
```

Returns an image for certain placemark type with given search result

This method will be called on a background thread

```objectivec
- (nonnull YMKSize *)sizeWithSearchResult:
                         (nonnull YMKSearchResultItem *)searchResult
                        placemarkIconType:(NSInteger)placemarkIconType;
```

Returns the size of the icon of certain placemark type with given search result

This method may be called on any thread

```objectivec
- (nonnull YMKIconStyle *)
    iconStyleWithSearchResult:(nonnull YMKSearchResultItem *)searchResult
            placemarkIconType:(NSInteger)placemarkIconType;
```

Returns the icon style for certain placemark type with given search result

```objectivec
- (BOOL)canProvideLabelsWithSearchResult:
    (nonnull YMKSearchResultItem *)searchResult;
```

Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`

## Instance methods

### imageWithSearchResult:placemarkIconType:

```objectivec
- (nonnull UIImage *)imageWithSearchResult:
                         (nonnull YMKSearchResultItem *)searchResult
                         placemarkIconType:(NSInteger)placemarkIconType;
```

Returns an image for certain placemark type with given search result

This method will be called on a background thread.

### sizeWithSearchResult:placemarkIconType:

```objectivec
- (nonnull YMKSize *)sizeWithSearchResult:
                         (nonnull YMKSearchResultItem *)searchResult
                        placemarkIconType:(NSInteger)placemarkIconType;
```

Returns the size of the icon of certain placemark type with given search result

This method may be called on any thread. Its implementation must be thread-safe.

### iconStyleWithSearchResult:placemarkIconType:

```objectivec
- (nonnull YMKIconStyle *)
    iconStyleWithSearchResult:(nonnull YMKSearchResultItem *)searchResult
            placemarkIconType:(NSInteger)placemarkIconType;
```

Returns the icon style for certain placemark type with given search result. If obtainAdIcons mode is enabled, IconStyle.anchor will be replaced for advertisement pins

This method may be called on any thread. Its implementation must be thread-safe.

### canProvideLabelsWithSearchResult:

```objectivec
- (BOOL)canProvideLabelsWithSearchResult:
    (nonnull YMKSearchResultItem *)searchResult;
```

Returns `true` if provider is able to provide images for given search result and placemark types of `LabelShortLeft`, `LabelShortRight`, `LabelDetailedLeft` and `LabelDetailedRight`. If `false` is returned then no label would be shown for this search result.

This method may be called on any thread. Its implementation must be thread-safe.
