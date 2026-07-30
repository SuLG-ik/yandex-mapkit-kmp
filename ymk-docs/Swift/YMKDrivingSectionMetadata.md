---
title: "YMKDrivingSectionMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingSectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSectionMetadata.html"
---
# YMKDrivingSectionMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingSectionMetadata : NSObject
```

Information about section metadata.

## Summary

### Class methods

```swift
 init(legIndex: UInt,
        weight: YMKDrivingWeight,
    annotation: YMKDrivingAnnotation,
 viaPointPositions: [NSNumber])
```

### Properties

```swift
var legIndex: UInt { get }
```

A leg is a section of the route between two consecutive waypoints

```swift
var weight: YMKDrivingWeight { get }
```

The "weight" of the section

```swift
var annotation: YMKDrivingAnnotation { get }
```

Section annotation

```swift
var viaPointPositions: [NSNumber] { get }
```

Via points (throughpoints) can appear only at nodes of the section's geometry

## Class methods

### init(legIndex:weight:annotation:viaPointPositions:)

```swift
 init(legIndex: UInt,
        weight: YMKDrivingWeight,
    annotation: YMKDrivingAnnotation,
 viaPointPositions: [NSNumber])
```

## Properties

### legIndex

```swift
var legIndex: UInt { get }
```

A leg is a section of the route between two consecutive waypoints.

### weight

```swift
var weight: YMKDrivingWeight { get }
```

The "weight" of the section.

### annotation

```swift
var annotation: YMKDrivingAnnotation { get }
```

Section annotation.

### viaPointPositions

```swift
var viaPointPositions: [NSNumber] { get }
```

Via points (throughpoints) can appear only at nodes of the section's geometry. The vector contains the positions of all corresponding nodes. These positions should be listed in ascending order.
