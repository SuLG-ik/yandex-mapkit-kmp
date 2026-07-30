---
title: "YMKMasstransitBoardingOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitBoardingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitBoardingOptions.html"
---
# YMKMasstransitBoardingOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitBoardingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitBoardingOptions : NSObject
```

Contains information about underground or railway boarding recommendations.

## Summary

### Class methods

```swift
 init(area: [YMKMasstransitBoardingOptionsBoardingArea],
 railwayOptions: YMKMasstransitRailwayOptions)
```

### Properties

```swift
var area: [YMKMasstransitBoardingOptionsBoardingArea] { get }
```

Vector of recommended areas to board

```swift
var railwayOptions: YMKMasstransitRailwayOptions { get }
```

Options about boarding to trains

## Class methods

### init(area:railwayOptions:)

```swift
 init(area: [YMKMasstransitBoardingOptionsBoardingArea],
 railwayOptions: YMKMasstransitRailwayOptions)
```

## Properties

### area

```swift
var area: [YMKMasstransitBoardingOptionsBoardingArea] { get }
```

Vector of recommended areas to board.

### railwayOptions

```swift
var railwayOptions: YMKMasstransitRailwayOptions { get }
```

Options about boarding to trains.
