---
title: "YMKDrivingFlags"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingFlags.html"
---
# YMKDrivingFlags

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingFlags : NSObject
```

Overall characteristics of the route.

## Summary

### Class methods

```swift
 init(blocked: Bool,
   hasFerries: Bool,
     hasTolls: Bool,
 requiresAccessPass: Bool,
   forParking: Bool,
 futureBlocked: Bool,
      deadJam: Bool,
 builtOffline: Bool,
    predicted: Bool,
 hasRuggedRoads: Bool,
 hasFordCrossing: Bool,
 hasVehicleRestrictions: Bool,
 hasUnpavedRoads: Bool,
 hasInPoorConditionRoads: Bool,
 hasRailwayCrossing: Bool,
 hasCheckpoints: Bool,
 scheduledDeparture: Bool,
 hasNonTransactionalTolls: Bool,
   hasTunnels: Bool,
  hasHighways: Bool)
```

### Properties

```swift
var blocked: Bool { get }
```

Route is blocked

```swift
var hasFerries: Bool { get }
```

Route has ferries on it

```swift
var hasTolls: Bool { get }
```

Route has toll posts, which are always paid

```swift
var requiresAccessPass: Bool { get }
```

Route requires special access

```swift
var forParking: Bool { get }
```

Route is made for parking

```swift
var futureBlocked: Bool { get }
```

Route will be blocked soon

```swift
var deadJam: Bool { get }
```

Route has a severe traffic jam

```swift
var builtOffline: Bool { get }
```

Route was built by using offline data

```swift
var predicted: Bool { get }
```

Predicted optimal route

```swift
var hasRuggedRoads: Bool { get }
```

Route has rugged roads on it

```swift
var hasFordCrossing: Bool { get }
```

Route has ford crossing on it

```swift
var hasVehicleRestrictions: Bool { get }
```

Route has vehicle restrictions on it

```swift
var hasUnpavedRoads: Bool { get }
```

Route has unpaved roads on it

```swift
var hasInPoorConditionRoads: Bool { get }
```

Route has poor condition roads on it

```swift
var hasRailwayCrossing: Bool { get }
```

Route has railway crossing on it

```swift
var hasCheckpoints: Bool { get }
```

Route has checkpoints on it

```swift
var scheduledDeparture: Bool { get }
```

Route was requested with custom departure time

```swift
var hasNonTransactionalTolls: Bool { get }
```

Route has conditionally-toll-free toll posts

```swift
var hasTunnels: Bool { get }
```

Route has tunnels on it

```swift
var hasHighways: Bool { get }
```

Route has highways on it

## Class methods

### init(blocked:hasFerries:hasTolls:requiresAccessPass:forParking:futureBlocked:deadJam:builtOffline:predicted:hasRuggedRoads:hasFordCrossing:hasVehicleRestrictions:hasUnpavedRoads:hasInPoorConditionRoads:hasRailwayCrossing:hasCheckpoints:scheduledDeparture:hasNonTransactionalTolls:hasTunnels:hasHighways:)

```swift
 init(blocked: Bool,
   hasFerries: Bool,
     hasTolls: Bool,
 requiresAccessPass: Bool,
   forParking: Bool,
 futureBlocked: Bool,
      deadJam: Bool,
 builtOffline: Bool,
    predicted: Bool,
 hasRuggedRoads: Bool,
 hasFordCrossing: Bool,
 hasVehicleRestrictions: Bool,
 hasUnpavedRoads: Bool,
 hasInPoorConditionRoads: Bool,
 hasRailwayCrossing: Bool,
 hasCheckpoints: Bool,
 scheduledDeparture: Bool,
 hasNonTransactionalTolls: Bool,
   hasTunnels: Bool,
  hasHighways: Bool)
```

## Properties

### blocked

```swift
var blocked: Bool { get }
```

Route is blocked.

### hasFerries

```swift
var hasFerries: Bool { get }
```

Route has ferries on it.

### hasTolls

```swift
var hasTolls: Bool { get }
```

Route has toll posts, which are always paid.

### requiresAccessPass

```swift
var requiresAccessPass: Bool { get }
```

Route requires special access.

### forParking

```swift
var forParking: Bool { get }
```

Route is made for parking.

### futureBlocked

```swift
var futureBlocked: Bool { get }
```

Route will be blocked soon.

### deadJam

```swift
var deadJam: Bool { get }
```

Route has a severe traffic jam.

### builtOffline

```swift
var builtOffline: Bool { get }
```

Route was built by using offline data.

### predicted

```swift
var predicted: Bool { get }
```

Predicted optimal route.

### hasRuggedRoads

```swift
var hasRuggedRoads: Bool { get }
```

Route has rugged roads on it.

### hasFordCrossing

```swift
var hasFordCrossing: Bool { get }
```

Route has ford crossing on it.

### hasVehicleRestrictions

```swift
var hasVehicleRestrictions: Bool { get }
```

Route has vehicle restrictions on it.

### hasUnpavedRoads

```swift
var hasUnpavedRoads: Bool { get }
```

Route has unpaved roads on it.

### hasInPoorConditionRoads

```swift
var hasInPoorConditionRoads: Bool { get }
```

Route has poor condition roads on it.

### hasRailwayCrossing

```swift
var hasRailwayCrossing: Bool { get }
```

Route has railway crossing on it.

### hasCheckpoints

```swift
var hasCheckpoints: Bool { get }
```

Route has checkpoints on it.

### scheduledDeparture

```swift
var scheduledDeparture: Bool { get }
```

Route was requested with custom departure time.

### hasNonTransactionalTolls

```swift
var hasNonTransactionalTolls: Bool { get }
```

Route has conditionally-toll-free toll posts

### hasTunnels

```swift
var hasTunnels: Bool { get }
```

Route has tunnels on it.

### hasHighways

```swift
var hasHighways: Bool { get }
```

Route has highways on it.
