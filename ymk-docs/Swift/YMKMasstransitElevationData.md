---
title: "YMKMasstransitElevationData"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitElevationData"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitElevationData.html"
---
# YMKMasstransitElevationData

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitElevationData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitElevationData : NSObject
```

Information of elevation gain in loss in a fitness section

## Summary

### Class methods

```swift
 init(totalAscent: YMKLocalizedValue,
     totalDescent: YMKLocalizedValue,
            steps: YMKLocalizedValue?,
     kilocalories: YMKLocalizedValue,
  inclineSections: [YMKMasstransitInclineSection],
 elevationSegments: [YMKMasstransitElevationPoint])
```

### Properties

```swift
var totalAscent: YMKLocalizedValue { get }
```

Total ascent in meters

```swift
var totalDescent: YMKLocalizedValue { get }
```

Total descent in meters

```swift
var steps: YMKLocalizedValue? { get }
```

The number of steps required to cover the distance for an average person

Optional field, can be nil

```swift
var kilocalories: YMKLocalizedValue { get }
```

The number of kilocalories consumed by an average person to cover the distance

```swift
var inclineSections: [YMKMasstransitInclineSection] { get }
```

List of sections with notable incline

```swift
var elevationSegments: [YMKMasstransitElevationPoint] { get }
```

List of elevation for each point of the section polyline

## Class methods

### init(totalAscent:totalDescent:steps:kilocalories:inclineSections:elevationSegments:)

```swift
 init(totalAscent: YMKLocalizedValue,
     totalDescent: YMKLocalizedValue,
            steps: YMKLocalizedValue?,
     kilocalories: YMKLocalizedValue,
  inclineSections: [YMKMasstransitInclineSection],
 elevationSegments: [YMKMasstransitElevationPoint])
```

## Properties

### totalAscent

```swift
var totalAscent: YMKLocalizedValue { get }
```

Total ascent in meters

### totalDescent

```swift
var totalDescent: YMKLocalizedValue { get }
```

Total descent in meters

### steps

```swift
var steps: YMKLocalizedValue? { get }
```

The number of steps required to cover the distance for an average person

Optional field, can be nil.

### kilocalories

```swift
var kilocalories: YMKLocalizedValue { get }
```

The number of kilocalories consumed by an average person to cover the distance

### inclineSections

```swift
var inclineSections: [YMKMasstransitInclineSection] { get }
```

List of sections with notable incline

### elevationSegments

```swift
var elevationSegments: [YMKMasstransitElevationPoint] { get }
```

List of elevation for each point of the section polyline
