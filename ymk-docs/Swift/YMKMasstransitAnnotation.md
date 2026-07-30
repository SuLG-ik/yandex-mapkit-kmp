---
title: "YMKMasstransitAnnotation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitAnnotation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitAnnotation.html"
---
# YMKMasstransitAnnotation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitAnnotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitAnnotation : NSObject
```

Contains info about actions on part of route. Either `action` or `landmark` should be non-empty.

## Summary

### Class methods

```swift
 init(position: YMKPolylinePosition,
        action: NSNumber?,
      landmark: NSNumber?,
       toponym: YMKMasstransitToponym?)
```

### Properties

```swift
var position: YMKPolylinePosition { get }
```

Position of annotation on part of route

```swift
var action: NSNumber? { get }
```

Action

Optional field, can be nil

```swift
var landmark: NSNumber? { get }
```

Landmark

Optional field, can be nil

```swift
var toponym: YMKMasstransitToponym? { get }
```

The toponym of the location

## Class methods

### init(position:action:landmark:toponym:)

```swift
 init(position: YMKPolylinePosition,
        action: NSNumber?,
      landmark: NSNumber?,
       toponym: YMKMasstransitToponym?)
```

## Properties

### position

```swift
var position: YMKPolylinePosition { get }
```

Position of annotation on part of route

### action

```swift
var action: NSNumber? { get }
```

Action

Optional field, can be nil.

### landmark

```swift
var landmark: NSNumber? { get }
```

Landmark

Optional field, can be nil.

### toponym

```swift
var toponym: YMKMasstransitToponym? { get }
```

The toponym of the location.

Optional field, can be nil.
