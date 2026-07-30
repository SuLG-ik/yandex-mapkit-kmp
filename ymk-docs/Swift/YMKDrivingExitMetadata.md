---
title: "YMKDrivingExitMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingExitMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingExitMetadata.html"
---
# YMKDrivingExitMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingExitMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingExitMetadata : NSObject
```

## Summary

### Class methods

```swift
 init(sequentialNumber: NSNumber?, numerationProximityMask: NSNumber?)
```

### Properties

```swift
var sequentialNumber: NSNumber? { get }
```

The number in the sequence of consecutive exits

```swift
var numerationProximityMask: NSNumber? { get }
```

Determines whether it is necessary to annotate the exit number in the imm stage

## Class methods

### init(sequentialNumber:numerationProximityMask:)

```swift
 init(sequentialNumber: NSNumber?, numerationProximityMask: NSNumber?)
```

## Properties

### sequentialNumber

```swift
var sequentialNumber: NSNumber? { get }
```

The number in the sequence of consecutive exits.

Optional field, can be nil.

### numerationProximityMask

```swift
var numerationProximityMask: NSNumber? { get }
```

Determines whether it is necessary to annotate the exit number in the imm stage.

Optional field, can be nil.
