---
title: "YMKSearchFeatureGroup"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFeatureGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeatureGroup.html"
---
# YMKSearchFeatureGroup

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeatureGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFeatureGroup : NSObject
```

Group of features.

## Summary

### Class methods

```swift
 init(name: String?, ids: [String])
```

### Properties

```swift
var name: String? { get }
```

Group name

```swift
var ids: [String] { get }
```

IDs for features in the group

## Class methods

### init(name:ids:)

```swift
 init(name: String?, ids: [String])
```

## Properties

### name

```swift
var name: String? { get }
```

Group name.

Optional field, can be nil.

### ids

```swift
var ids: [String] { get }
```

IDs for features in the group.
