---
title: "YMKSearchLayerTapHandler"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKSearchLayerTapHandler"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerTapHandler.html"
---
# YMKSearchLayerTapHandler

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerTapHandler.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKSearchLayerTapHandler <NSObject>
```

Interface for callbacks on placemark events.

## Summary

### Instance methods

```objectivec
- (BOOL)onTapWithSearchResultItem:
    (nonnull YMKSearchResultItem *)searchResultItem;
```

Called when user taps on placemark

## Instance methods

### onTapWithSearchResultItem:

```objectivec
- (BOOL)onTapWithSearchResultItem:
    (nonnull YMKSearchResultItem *)searchResultItem;
```

Called when user taps on placemark.

| Parameters |   |
| --- | --- |
| searchResultItem | Corresponding search result. |
