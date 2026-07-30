---
title: "YMKBicycleFlags"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleFlags.html"
---
# YMKBicycleFlags

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleFlags : NSObject
```

Indicates whether the suggested route has one or more of the specified properties.

## Summary

### Class methods

```swift
 init(requiresAccessPass: Bool, hasAutoRoad: Bool)
```

### Properties

```swift
var requiresAccessPass: Bool { get }
```

Indicates whether the suggested route requires an access pass

```swift
var hasAutoRoad: Bool { get }
```

Indicates whether the suggested route includes automotive roads

## Class methods

### init(requiresAccessPass:hasAutoRoad:)

```swift
 init(requiresAccessPass: Bool, hasAutoRoad: Bool)
```

## Properties

### requiresAccessPass

```swift
var requiresAccessPass: Bool { get }
```

Indicates whether the suggested route requires an access pass.

### hasAutoRoad

```swift
var hasAutoRoad: Bool { get }
```

Indicates whether the suggested route includes automotive roads.
