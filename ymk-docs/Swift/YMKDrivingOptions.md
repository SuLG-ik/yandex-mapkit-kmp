---
title: "YMKDrivingOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingOptions.html"
---
# YMKDrivingOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingOptions : NSObject
```

Driving options.

## Summary

### Class methods

```swift
 init(initialAzimuth: NSNumber?,
         routesCount: NSNumber?,
       departureTime: Date?,
  annotationLanguage: NSNumber?,
      avoidanceFlags: YMKDrivingAvoidanceFlags?)
```

### Properties

```swift
@NSCopying var initialAzimuth: NSNumber? { get set }
```

Starting location azimuth

```swift
@NSCopying var routesCount: NSNumber? { get set }
```

The number of alternatives

```swift
var departureTime: Date? { get set }
```

Optional field, can be nil

```swift
@NSCopying var annotationLanguage: NSNumber? { get set }
```

A method to set the annotation language

```swift
var avoidanceFlags: YMKDrivingAvoidanceFlags? { get set }
```

The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible

## Class methods

### init(initialAzimuth:routesCount:departureTime:annotationLanguage:avoidanceFlags:)

```swift
 init(initialAzimuth: NSNumber?,
         routesCount: NSNumber?,
       departureTime: Date?,
  annotationLanguage: NSNumber?,
      avoidanceFlags: YMKDrivingAvoidanceFlags?)
```

## Properties

### initialAzimuth

```swift
@NSCopying var initialAzimuth: NSNumber? { get set }
```

Starting location azimuth.

Optional field, can be nil.

### routesCount

```swift
@NSCopying var routesCount: NSNumber? { get set }
```

The number of alternatives.

Optional field, can be nil.

### departureTime

```swift
var departureTime: Date? { get set }
```

Optional field, can be nil.

### annotationLanguage

```swift
@NSCopying var annotationLanguage: NSNumber? { get set }
```

A method to set the annotation language. lang The annotation language.

Optional field, can be nil.

### avoidanceFlags

```swift
var avoidanceFlags: YMKDrivingAvoidanceFlags? { get set }
```

The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible.

Optional field, can be nil.
