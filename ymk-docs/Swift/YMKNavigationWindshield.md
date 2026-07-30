---
title: "YMKNavigationWindshield"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationWindshield"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationWindshield.html"
---
# YMKNavigationWindshield

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationWindshield.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationWindshield : NSObject
```

## Summary

### Instance methods

```swift
func addListener(with windshieldListener: any YMKNavigationWindshieldListener)
```

The class does not retain the object in the 'windshieldListener' parameter

```swift
func removeListener(with windshieldListener: any YMKNavigationWindshieldListener)
```

### Properties

```swift
var manoeuvres: [YMKNavigationUpcomingManoeuvre] { get }
```

Vector with next manoeuvres

```swift
var roadEvents: [YMKNavigationUpcomingRoadEvent] { get }
```

Vector with all road events between current position and the next manoeuvre

```swift
var laneSigns: [YMKNavigationUpcomingLaneSign] { get }
```

Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector

```swift
var directionSigns: [YMKNavigationUpcomingDirectionSign] { get }
```

Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### addListener(with:)

```swift
func addListener(with windshieldListener: any YMKNavigationWindshieldListener)
```

The class does not retain the object in the 'windshieldListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with windshieldListener: any YMKNavigationWindshieldListener)
```

## Properties

### manoeuvres

```swift
var manoeuvres: [YMKNavigationUpcomingManoeuvre] { get }
```

Vector with next manoeuvres. Contains several items only if they are close to each other.

### roadEvents

```swift
var roadEvents: [YMKNavigationUpcomingRoadEvent] { get }
```

Vector with all road events between current position and the next manoeuvre. Sorted by distance.

### laneSigns

```swift
var laneSigns: [YMKNavigationUpcomingLaneSign] { get }
```

Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector. Sorted by distance.

### directionSigns

```swift
var directionSigns: [YMKNavigationUpcomingDirectionSign] { get }
```

Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector. Sorted by distance.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
