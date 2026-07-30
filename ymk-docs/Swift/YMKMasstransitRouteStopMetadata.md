---
title: "YMKMasstransitRouteStopMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouteStopMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteStopMetadata.html"
---
# YMKMasstransitRouteStopMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteStopMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouteStopMetadata : NSObject, YMKBaseMetadata
```

The metadata about the mass transit stop.

## Summary

### Class methods

```swift
 init(stop: YMKMasstransitStop,
  stopExit: YMKMasstransitStop?,
 exitPoint: YMKPoint?)
```

### Properties

```swift
var stop: YMKMasstransitStop { get }
```

Route stop information

```swift
var stopExit: YMKMasstransitStop? { get }
```

Underground station exit

Optional field, can be nil

```swift
var exitPoint: YMKPoint? { get }
```

Coordinates of underground station exit

Optional field, can be nil

## Class methods

### init(stop:stopExit:exitPoint:)

```swift
 init(stop: YMKMasstransitStop,
  stopExit: YMKMasstransitStop?,
 exitPoint: YMKPoint?)
```

## Properties

### stop

```swift
var stop: YMKMasstransitStop { get }
```

Route stop information.

### stopExit

```swift
var stopExit: YMKMasstransitStop? { get }
```

Underground station exit

Optional field, can be nil.

### exitPoint

```swift
var exitPoint: YMKPoint? { get }
```

Coordinates of underground station exit

Optional field, can be nil.
