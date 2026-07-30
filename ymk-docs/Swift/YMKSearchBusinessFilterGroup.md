---
title: "YMKSearchBusinessFilterGroup"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessFilterGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterGroup.html"
---
# YMKSearchBusinessFilterGroup

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessFilterGroup : NSObject
```

Group of filters.

## Summary

### Class methods

```swift
 init(name: String?, filterIds: [String])
```

### Properties

```swift
var name: String? { get }
```

Group name

```swift
var filterIds: [String] { get }
```

IDs for filters in the group

## Class methods

### init(name:filterIds:)

```swift
 init(name: String?, filterIds: [String])
```

## Properties

### name

```swift
var name: String? { get }
```

Group name.

Optional field, can be nil.

### filterIds

```swift
var filterIds: [String] { get }
```

IDs for filters in the group.
