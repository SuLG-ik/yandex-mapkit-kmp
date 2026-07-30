---
title: "YMKNavigationSerialization"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationSerialization"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationSerialization.html"
---
# YMKNavigationSerialization

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationSerialization.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationSerialization : NSObject
```

## Summary

### Class methods

```swift
class func serialize(_ navigation: YMKNavigation) -> Data
```

Serializes a given instance of Navigation

```swift
class func deserialize(_ serializedNavigation: Data) -> YMKNavigation?
```

Deserializes a given instance of Navigation

## Class methods

### serialize(_:)

```swift
class func serialize(_ navigation: YMKNavigation) -> Data
```

Serializes a given instance of Navigation.

### deserialize(_:)

```swift
class func deserialize(_ serializedNavigation: Data) -> YMKNavigation?
```

Deserializes a given instance of Navigation. Navigation will be in the suspended mode. Returns null if deserialization failed.
