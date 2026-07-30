---
title: "YMKMasstransitFlags"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitFlags.html"
---
# YMKMasstransitFlags

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitFlags : NSObject
```

Indicates whether the suggested route has one or more of the specified properties.

## Summary

### Class methods

```swift
 init(requiresAccessPass: Bool, hasAutoRoad: Bool)
```

### Instance methods

```swift
init()
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

## Instance methods

### init()

```swift
init()
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
