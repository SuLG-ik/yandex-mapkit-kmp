---
title: "YMKSearchToponymResultMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchToponymResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymResultMetadata.html"
---
# YMKSearchToponymResultMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchToponymResultMetadata : NSObject, YMKBaseMetadata
```

Common info for response from toponym search.

## Summary

### Class methods

```swift
 init(found: Int,
 responseInfo: YMKSearchToponymResultMetadataResponseInfo?,
 reverse reversePoint: YMKPoint?)
```

### Properties

```swift
var found: Int { get }
```

Approximate number of found objects

```swift
var responseInfo: YMKSearchToponymResultMetadataResponseInfo? { get }
```

Additional response info

```swift
var reversePoint: YMKPoint? { get }
```

The search coordinates given via 'll' or parsed from 'text' (only in reverse mode)

## Class methods

### init(found:responseInfo:reverse:)

```swift
 init(found: Int,
 responseInfo: YMKSearchToponymResultMetadataResponseInfo?,
 reverse reversePoint: YMKPoint?)
```

## Properties

### found

```swift
var found: Int { get }
```

Approximate number of found objects.

### responseInfo

```swift
var responseInfo: YMKSearchToponymResultMetadataResponseInfo? { get }
```

Additional response info.

Optional field, can be nil.

### reversePoint

```swift
var reversePoint: YMKPoint? { get }
```

The search coordinates given via 'll' or parsed from 'text' (only in reverse mode).

Optional field, can be nil.
