---
title: "YMKTileDataSourceBuilder"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTileDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileDataSourceBuilder.html"
---
# YMKTileDataSourceBuilder

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTileDataSourceBuilder.html)

```swift
class YMKTileDataSourceBuilder : YMKBaseDataSourceBuilder
```

## Summary

### Instance methods

```swift
func setTileUrlProviderWith(_ urlProvider: any YMKTilesUrlProvider)
```

The class does not retain the object in the 'urlProvider' parameter

```swift
func setTileProviderWith(_ tileProvider: any YMKTileProvider)
```

The class does not retain the object in the 'tileProvider' parameter

```swift
func setProjectionWith(_ projection: YMKProjection)
```

```swift
func setZoomRangesWith(_ zoomRanges: [YMKZoomRange])
```

```swift
func setTileFormatWith(_ format: YMKTileFormat)
```

## Instance methods

### setTileUrlProviderWith(_:)

```swift
func setTileUrlProviderWith(_ urlProvider: any YMKTilesUrlProvider)
```

The class does not retain the object in the 'urlProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setTileProviderWith(_:)

```swift
func setTileProviderWith(_ tileProvider: any YMKTileProvider)
```

The class does not retain the object in the 'tileProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setProjectionWith(_:)

```swift
func setProjectionWith(_ projection: YMKProjection)
```

### setZoomRangesWith(_:)

```swift
func setZoomRangesWith(_ zoomRanges: [YMKZoomRange])
```

### setTileFormatWith(_:)

```swift
func setTileFormatWith(_ format: YMKTileFormat)
```
