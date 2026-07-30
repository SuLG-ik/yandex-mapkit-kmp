---
title: "YMKTileProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKTileProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileProvider.html"
---
# YMKTileProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileProvider.html)

```swift
protocol YMKTileProvider : NSObjectProtocol
```

Generates tiles.

## Summary

### Instance methods

```swift
func load(with tileId: YMKTileId,
              version: YMKVersion,
             features: [String : String],
                 etag: String) -> YMKRawTile
```

Generates tile

## Instance methods

### load(with:version:features:etag:)

```swift
func load(with tileId: YMKTileId,
              version: YMKVersion,
             features: [String : String],
                 etag: String) -> YMKRawTile
```

Generates tile.

This method will be called on a background thread.
