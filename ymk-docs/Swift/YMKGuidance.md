---
title: "YMKGuidance"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGuidance"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGuidance.html"
---
# YMKGuidance

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGuidance.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKGuidance : NSObject
```

## Summary

### Instance methods

```swift
func switchToRoute(with route: YMKDrivingRoute)
```

Start guidance with given alternative

```swift
func addListener(with guidanceListener: any YMKGuidanceListener)
```

The class does not retain the object in the 'guidanceListener' parameter

```swift
func removeListener(with guidanceListener: any YMKGuidanceListener)
```

### Properties

```swift
var isEnableAlternatives: Bool { get set }
```

Enables/Disables alternatives suggestion while guiding

```swift
var isEnableReroutes: Bool { get set }
```

Enables/Disables rerouting

```swift
var windshield: YMKNavigationWindshield { get }
```

```swift
var annotator: YMKAnnotator { get }
```

```swift
var currentRoute: YMKDrivingRoute? { get }
```

Optional property, can be nil

```swift
var alternatives: [YMKNavigationAlternative] { get }
```

Vector with all alternatives ahead

```swift
var fastestAlternative: YMKNavigationAlternative? { get }
```

Optional property, can be nil

```swift
var location: YMKLocation? { get }
```

Optional property, can be nil

```swift
var locationClass: NSNumber? { get }
```

Optional property, can be nil

```swift
var roadName: String? { get }
```

Optional property, can be nil

```swift
var routeStatus: YMKRouteStatus { get }
```

```swift
var speedLimitsPolicy: YMKSpeedLimitsPolicy { get }
```

In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used

```swift
var speedLimitTolerance: Double { get set }
```

```swift
var speedLimit: YMKLocalizedValue? { get }
```

Speed limit of the current road

```swift
var speedLimitStatus: YMKSpeedLimitStatus { get }
```

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### switchToRoute(with:)

```swift
func switchToRoute(with route: YMKDrivingRoute)
```

Start guidance with given alternative. It only accepts routes obtained from this Guidance.routes field.

### addListener(with:)

```swift
func addListener(with guidanceListener: any YMKGuidanceListener)
```

The class does not retain the object in the 'guidanceListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with guidanceListener: any YMKGuidanceListener)
```

## Properties

### isEnableAlternatives

```swift
var isEnableAlternatives: Bool { get set }
```

Enables/Disables alternatives suggestion while guiding. Enabled by default.

### isEnableReroutes

```swift
var isEnableReroutes: Bool { get set }
```

Enables/Disables rerouting. Enabled by default.

### windshield

```swift
var windshield: YMKNavigationWindshield { get }
```

### annotator

```swift
var annotator: YMKAnnotator { get }
```

### currentRoute

```swift
var currentRoute: YMKDrivingRoute? { get }
```

Optional property, can be nil.

### alternatives

```swift
var alternatives: [YMKNavigationAlternative] { get }
```

Vector with all alternatives ahead. Sorted by distance.

### fastestAlternative

```swift
var fastestAlternative: YMKNavigationAlternative? { get }
```

Optional property, can be nil.

### location

```swift
var location: YMKLocation? { get }
```

Optional property, can be nil.

### locationClass

```swift
var locationClass: NSNumber? { get }
```

Optional property, can be nil.

### roadName

```swift
var roadName: String? { get }
```

Optional property, can be nil.

### routeStatus

```swift
var routeStatus: YMKRouteStatus { get }
```

### speedLimitsPolicy

```swift
var speedLimitsPolicy: YMKSpeedLimitsPolicy { get }
```

In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used.

### speedLimitTolerance

```swift
var speedLimitTolerance: Double { get set }
```

### speedLimit

```swift
var speedLimit: YMKLocalizedValue? { get }
```

Speed limit of the current road.

Optional property, can be nil.

### speedLimitStatus

```swift
var speedLimitStatus: YMKSpeedLimitStatus { get }
```

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
