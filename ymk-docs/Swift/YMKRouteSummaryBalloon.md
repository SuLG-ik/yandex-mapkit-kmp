---
title: "YMKRouteSummaryBalloon"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRouteSummaryBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteSummaryBalloon.html"
---
# YMKRouteSummaryBalloon

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteSummaryBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKRouteSummaryBalloon : NSObject
```

## Summary

### Class methods

```swift
 init(summary: YMKDrivingSummary,
         tags: [String],
 relativeWeight: YMKDrivingWeight?)
```

### Properties

```swift
var summary: YMKDrivingSummary { get }
```

```swift
var tags: [String] { get }
```

```swift
var relativeWeight: YMKDrivingWeight? { get }
```

presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

Optional field, can be nil

## Class methods

### init(summary:tags:relativeWeight:)

```swift
 init(summary: YMKDrivingSummary,
         tags: [String],
 relativeWeight: YMKDrivingWeight?)
```

## Properties

### summary

```swift
var summary: YMKDrivingSummary { get }
```

### tags

```swift
var tags: [String] { get }
```

### relativeWeight

```swift
var relativeWeight: YMKDrivingWeight? { get }
```

presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

Optional field, can be nil.
