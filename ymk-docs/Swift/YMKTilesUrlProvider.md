---
title: "YMKTilesUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKTilesUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTilesUrlProvider.html"
---
# YMKTilesUrlProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTilesUrlProvider.html)

```swift
protocol YMKTilesUrlProvider : NSObjectProtocol
```

Provides a formatted URL.

## Summary

### Instance methods

```swift
func formatUrl(with tileId: YMKTileId,
                   version: YMKVersion,
                  features: [String : String]) -> String
```

Create s a URL based on the tile ID, version, and features

## Instance methods

### formatUrl(with:version:features:)

```swift
func formatUrl(with tileId: YMKTileId,
                   version: YMKVersion,
                  features: [String : String]) -> String
```

Create s a URL based on the tile ID, version, and features. Features are some layer customisations. Tiles with appropriate features are prioretized over tiles without them when loading.

This method may be called on any thread. Its implementation must be thread-safe.
