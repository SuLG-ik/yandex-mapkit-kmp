---
title: "YMKSearchEncyclopediaObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchEncyclopediaObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchEncyclopediaObjectMetadata.html"
---
# YMKSearchEncyclopediaObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchEncyclopediaObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchEncyclopediaObjectMetadata : NSObject, YMKBaseMetadata
```

Snippet with encyclopedia data.

## Summary

### Class methods

```swift
 init(title: String?, description: String?, attribution: YMKAttribution?)
```

### Properties

```swift
var title: String? { get }
```

Encyclopedia article title

```swift
var description: String? { get }
```

Encyclopedia article body

```swift
var attribution: YMKAttribution? { get }
```

Attribution information

## Class methods

### init(title:description:attribution:)

```swift
 init(title: String?, description: String?, attribution: YMKAttribution?)
```

## Properties

### title

```swift
var title: String? { get }
```

Encyclopedia article title.

Optional field, can be nil.

### description

```swift
var description: String? { get }
```

Encyclopedia article body.

Optional field, can be nil.

### attribution

```swift
var attribution: YMKAttribution? { get }
```

Attribution information.

Optional field, can be nil.
