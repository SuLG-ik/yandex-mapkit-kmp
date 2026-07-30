---
title: "YMKAlternativeBalloon"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAlternativeBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAlternativeBalloon.html"
---
# YMKAlternativeBalloon

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAlternativeBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKAlternativeBalloon : NSObject
```

## Summary

### Class methods

```swift
 init(summary: YMKDrivingSummary, relativeWeight: YMKDrivingWeight)
```

### Properties

```swift
var summary: YMKDrivingSummary { get }
```

```swift
var relativeWeight: YMKDrivingWeight { get }
```

contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

## Class methods

### init(summary:relativeWeight:)

```swift
 init(summary: YMKDrivingSummary, relativeWeight: YMKDrivingWeight)
```

## Properties

### summary

```swift
var summary: YMKDrivingSummary { get }
```

### relativeWeight

```swift
var relativeWeight: YMKDrivingWeight { get }
```

contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing
