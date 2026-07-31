---
title: "YMKTileDataSource"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTileDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileDataSource.html"
---
# YMKTileDataSource

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileDataSource.html)

```swift
class YMKTileDataSource : YMKBaseDataSource
```

## Summary

### Instance methods

```swift
func invalidate(withVersion version: String)
```

Invalidates data source and reloads all tiles

## Instance methods

### invalidate(withVersion:)

```swift
func invalidate(withVersion version: String)
```

Invalidates data source and reloads all tiles. Must not be called if DataSource does not support versioning: LayerOptions.versionSupport = false;

This method may be called on any thread. Its implementation must be thread-safe.
