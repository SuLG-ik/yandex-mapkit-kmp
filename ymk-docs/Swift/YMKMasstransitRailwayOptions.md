---
title: "YMKMasstransitRailwayOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRailwayOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRailwayOptions.html"
---
# YMKMasstransitRailwayOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRailwayOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRailwayOptions : NSObject
```

Contains information about boarding to or dropOff from trains.

## Summary

### Class methods

```swift
 init(tracks: String?, platforms: String?, uncertain: Bool)
```

### Properties

```swift
var tracks: String? { get }
```

Departure track annotation, e

```swift
var platforms: String? { get }
```

Departure platform annotation, e

```swift
var uncertain: Bool { get }
```

Flag of track/platform selection uncertainty to suggest user double-check it in the station

## Class methods

### init(tracks:platforms:uncertain:)

```swift
 init(tracks: String?, platforms: String?, uncertain: Bool)
```

## Properties

### tracks

```swift
var tracks: String? { get }
```

Departure track annotation, e.g. "3 or 4 track".

Optional field, can be nil.

### platforms

```swift
var platforms: String? { get }
```

Departure platform annotation, e.g. "2 platform".

Optional field, can be nil.

### uncertain

```swift
var uncertain: Bool { get }
```

Flag of track/platform selection uncertainty to suggest user double-check it in the station.
