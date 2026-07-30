---
title: "YMKIndoorPlan"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKIndoorPlan"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIndoorPlan.html"
---
# YMKIndoorPlan

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIndoorPlan.html)

```swift
class YMKIndoorPlan : NSObject
```

Describes indoor plan of building. Use activeLevelId property to select active level.

## Summary

### Properties

```swift
var levels: [YMKIndoorLevel] { get }
```

List of all levels in indoor plan, from bottom to top

```swift
var activeLevelId: String { get set }
```

Gets/sets active id

## Properties

### levels

```swift
var levels: [YMKIndoorLevel] { get }
```

List of all levels in indoor plan, from bottom to top.

### activeLevelId

```swift
var activeLevelId: String { get set }
```

Gets/sets active id.
