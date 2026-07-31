---
title: "YMKSearchSubtitleItem"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchSubtitleItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSubtitleItem.html"
---
# YMKSearchSubtitleItem

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSubtitleItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchSubtitleItem : NSObject
```

Separate subtitle of a certain type.

## Summary

### Class methods

```swift
 init(type: String, text: String?, properties: [YRTKeyValuePair])
```

### Properties

```swift
var type: String { get }
```

Subtitle type

```swift
var text: String? { get }
```

Short summary text

```swift
var properties: [YRTKeyValuePair] { get }
```

Detailed subtitle info

## Class methods

### init(type:text:properties:)

```swift
 init(type: String, text: String?, properties: [YRTKeyValuePair])
```

## Properties

### type

```swift
var type: String { get }
```

Subtitle type. For example, "exchange".

### text

```swift
var text: String? { get }
```

Short summary text. For example, "USD 57.69/57.3".

Optional field, can be nil.

### properties

```swift
var properties: [YRTKeyValuePair] { get }
```

Detailed subtitle info. For example, [ {"key": "currency", "value": "USD"}, {"key": "buy", "value": "57.3"}, {"key": "sell", "value": "57.69"} ].
