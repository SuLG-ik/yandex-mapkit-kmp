---
title: "YMKRawTile"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRawTile"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRawTile.html"
---
# YMKRawTile

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRawTile.html)

```swift
class YMKRawTile : NSObject
```

A raw tile that can be displayed on the map.

## Summary

### Class methods

```swift
 init(version: YMKVersion,
     features: [String : String],
         etag: String,
     useCache: YMKRawTileUseCache,
        state: YMKRawTileState,
      rawData: Data)
```

### Properties

```swift
var version: YMKVersion { get }
```

```swift
var features: [String : String] { get }
```

```swift
var etag: String { get }
```

```swift
var useCache: YMKRawTileUseCache { get }
```

```swift
var state: YMKRawTileState { get }
```

```swift
var rawData: Data { get }
```

## Class methods

### init(version:features:etag:useCache:state:rawData:)

```swift
 init(version: YMKVersion,
     features: [String : String],
         etag: String,
     useCache: YMKRawTileUseCache,
        state: YMKRawTileState,
      rawData: Data)
```

## Properties

### version

```swift
var version: YMKVersion { get }
```

### features

```swift
var features: [String : String] { get }
```

### etag

```swift
var etag: String { get }
```

### useCache

```swift
var useCache: YMKRawTileUseCache { get }
```

### state

```swift
var state: YMKRawTileState { get }
```

### rawData

```swift
var rawData: Data { get }
```
