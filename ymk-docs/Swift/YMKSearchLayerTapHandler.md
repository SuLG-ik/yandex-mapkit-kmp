---
title: "YMKSearchLayerTapHandler"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKSearchLayerTapHandler"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerTapHandler.html"
---
# YMKSearchLayerTapHandler

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerTapHandler.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKSearchLayerTapHandler : NSObjectProtocol
```

Interface for callbacks on placemark events.

## Summary

### Instance methods

```swift
func onTap(with searchResultItem: YMKSearchResultItem) -> Bool
```

Called when user taps on placemark

## Instance methods

### onTap(with:)

```swift
func onTap(with searchResultItem: YMKSearchResultItem) -> Bool
```

Called when user taps on placemark.

| Parameters |   |
| --- | --- |
| searchResultItem | Corresponding search result. |
