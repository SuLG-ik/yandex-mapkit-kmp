---
title: "YMKSearchToponymResultMetadataResponseInfo"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchToponymResultMetadataResponseInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymResultMetadataResponseInfo.html"
---
# YMKSearchToponymResultMetadataResponseInfo

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymResultMetadataResponseInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchToponymResultMetadataResponseInfo : NSObject
```

Additional response info.

## Summary

### Class methods

```swift
 init(mode: YMKSearchToponymResultMetadataSearchMode, accuracy: NSNumber?)
```

### Properties

```swift
var mode: YMKSearchToponymResultMetadataSearchMode { get }
```

Search mode

```swift
var accuracy: NSNumber? { get }
```

Search response accuracy

## Class methods

### init(mode:accuracy:)

```swift
 init(mode: YMKSearchToponymResultMetadataSearchMode, accuracy: NSNumber?)
```

## Properties

### mode

```swift
var mode: YMKSearchToponymResultMetadataSearchMode { get }
```

Search mode.

### accuracy

```swift
var accuracy: NSNumber? { get }
```

Search response accuracy.

Optional field, can be nil.
