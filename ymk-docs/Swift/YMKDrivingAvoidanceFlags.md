---
title: "YMKDrivingAvoidanceFlags"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingAvoidanceFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingAvoidanceFlags.html"
---
# YMKDrivingAvoidanceFlags

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingAvoidanceFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingAvoidanceFlags : NSObject
```

## Summary

### Class methods

```swift
 init(avoidTolls: Bool,
    avoidUnpaved: Bool,
 avoidPoorCondition: Bool,
 avoidRailwayCrossing: Bool,
  avoidBoatFerry: Bool,
 avoidFordCrossing: Bool,
     avoidTunnel: Bool,
    avoidHighway: Bool)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var avoidTolls: Bool { get set }
```

The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible

```swift
var avoidUnpaved: Bool { get set }
```

The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible

```swift
var avoidPoorCondition: Bool { get set }
```

The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible

```swift
var avoidRailwayCrossing: Bool { get set }
```

The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible

```swift
var avoidBoatFerry: Bool { get set }
```

The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible

```swift
var avoidFordCrossing: Bool { get set }
```

The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible

```swift
var avoidTunnel: Bool { get set }
```

The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible

```swift
var avoidHighway: Bool { get set }
```

The 'avoidHighway' option instructs the router to return routes that avoid highways when possible

## Class methods

### init(avoidTolls:avoidUnpaved:avoidPoorCondition:avoidRailwayCrossing:avoidBoatFerry:avoidFordCrossing:avoidTunnel:avoidHighway:)

```swift
 init(avoidTolls: Bool,
    avoidUnpaved: Bool,
 avoidPoorCondition: Bool,
 avoidRailwayCrossing: Bool,
  avoidBoatFerry: Bool,
 avoidFordCrossing: Bool,
     avoidTunnel: Bool,
    avoidHighway: Bool)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### avoidTolls

```swift
var avoidTolls: Bool { get set }
```

The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible.

### avoidUnpaved

```swift
var avoidUnpaved: Bool { get set }
```

The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible.

### avoidPoorCondition

```swift
var avoidPoorCondition: Bool { get set }
```

The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible.

### avoidRailwayCrossing

```swift
var avoidRailwayCrossing: Bool { get set }
```

The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible.

### avoidBoatFerry

```swift
var avoidBoatFerry: Bool { get set }
```

The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible.

### avoidFordCrossing

```swift
var avoidFordCrossing: Bool { get set }
```

The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible.

### avoidTunnel

```swift
var avoidTunnel: Bool { get set }
```

The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible.

### avoidHighway

```swift
var avoidHighway: Bool { get set }
```

The 'avoidHighway' option instructs the router to return routes that avoid highways when possible.
