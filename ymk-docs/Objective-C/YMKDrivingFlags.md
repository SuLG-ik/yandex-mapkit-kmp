---
title: "YMKDrivingFlags"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingFlags.html"
---
# YMKDrivingFlags

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingFlags : NSObject
```

Overall characteristics of the route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingFlags *)flagsWithBlocked:( BOOL)blocked
                                   hasFerries:( BOOL)hasFerries
                                     hasTolls:( BOOL)hasTolls
                           requiresAccessPass:( BOOL)requiresAccessPass
                                   forParking:( BOOL)forParking
                                futureBlocked:( BOOL)futureBlocked
                                      deadJam:( BOOL)deadJam
                                 builtOffline:( BOOL)builtOffline
                                    predicted:( BOOL)predicted
                               hasRuggedRoads:( BOOL)hasRuggedRoads
                              hasFordCrossing:( BOOL)hasFordCrossing
                       hasVehicleRestrictions:( BOOL)hasVehicleRestrictions
                              hasUnpavedRoads:( BOOL)hasUnpavedRoads
                      hasInPoorConditionRoads:( BOOL)hasInPoorConditionRoads
                           hasRailwayCrossing:( BOOL)hasRailwayCrossing
                               hasCheckpoints:( BOOL)hasCheckpoints
                           scheduledDeparture:( BOOL)scheduledDeparture
                     hasNonTransactionalTolls:( BOOL)hasNonTransactionalTolls
                                   hasTunnels:( BOOL)hasTunnels
                                  hasHighways:( BOOL)hasHighways;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL blocked;
```

Route is blocked

```objectivec
@property (nonatomic, readonly) BOOL hasFerries;
```

Route has ferries on it

```objectivec
@property (nonatomic, readonly) BOOL hasTolls;
```

Route has toll posts, which are always paid

```objectivec
@property (nonatomic, readonly) BOOL requiresAccessPass;
```

Route requires special access

```objectivec
@property (nonatomic, readonly) BOOL forParking;
```

Route is made for parking

```objectivec
@property (nonatomic, readonly) BOOL futureBlocked;
```

Route will be blocked soon

```objectivec
@property (nonatomic, readonly) BOOL deadJam;
```

Route has a severe traffic jam

```objectivec
@property (nonatomic, readonly) BOOL builtOffline;
```

Route was built by using offline data

```objectivec
@property (nonatomic, readonly) BOOL predicted;
```

Predicted optimal route

```objectivec
@property (nonatomic, readonly) BOOL hasRuggedRoads;
```

Route has rugged roads on it

```objectivec
@property (nonatomic, readonly) BOOL hasFordCrossing;
```

Route has ford crossing on it

```objectivec
@property (nonatomic, readonly) BOOL hasVehicleRestrictions;
```

Route has vehicle restrictions on it

```objectivec
@property (nonatomic, readonly) BOOL hasUnpavedRoads;
```

Route has unpaved roads on it

```objectivec
@property (nonatomic, readonly) BOOL hasInPoorConditionRoads;
```

Route has poor condition roads on it

```objectivec
@property (nonatomic, readonly) BOOL hasRailwayCrossing;
```

Route has railway crossing on it

```objectivec
@property (nonatomic, readonly) BOOL hasCheckpoints;
```

Route has checkpoints on it

```objectivec
@property (nonatomic, readonly) BOOL scheduledDeparture;
```

Route was requested with custom departure time

```objectivec
@property (nonatomic, readonly) BOOL hasNonTransactionalTolls;
```

Route has conditionally-toll-free toll posts

```objectivec
@property (nonatomic, readonly) BOOL hasTunnels;
```

Route has tunnels on it

```objectivec
@property (nonatomic, readonly) BOOL hasHighways;
```

Route has highways on it

## Class methods

### flagsWithBlocked:hasFerries:hasTolls:requiresAccessPass:forParking:futureBlocked:deadJam:builtOffline:predicted:hasRuggedRoads:hasFordCrossing:hasVehicleRestrictions:hasUnpavedRoads:hasInPoorConditionRoads:hasRailwayCrossing:hasCheckpoints:scheduledDeparture:hasNonTransactionalTolls:hasTunnels:hasHighways:

```objectivec
+ (nonnull YMKDrivingFlags *)flagsWithBlocked:( BOOL)blocked
                                   hasFerries:( BOOL)hasFerries
                                     hasTolls:( BOOL)hasTolls
                           requiresAccessPass:( BOOL)requiresAccessPass
                                   forParking:( BOOL)forParking
                                futureBlocked:( BOOL)futureBlocked
                                      deadJam:( BOOL)deadJam
                                 builtOffline:( BOOL)builtOffline
                                    predicted:( BOOL)predicted
                               hasRuggedRoads:( BOOL)hasRuggedRoads
                              hasFordCrossing:( BOOL)hasFordCrossing
                       hasVehicleRestrictions:( BOOL)hasVehicleRestrictions
                              hasUnpavedRoads:( BOOL)hasUnpavedRoads
                      hasInPoorConditionRoads:( BOOL)hasInPoorConditionRoads
                           hasRailwayCrossing:( BOOL)hasRailwayCrossing
                               hasCheckpoints:( BOOL)hasCheckpoints
                           scheduledDeparture:( BOOL)scheduledDeparture
                     hasNonTransactionalTolls:( BOOL)hasNonTransactionalTolls
                                   hasTunnels:( BOOL)hasTunnels
                                  hasHighways:( BOOL)hasHighways;
```

## Properties

### blocked

```objectivec
@property (nonatomic, readonly) BOOL blocked;
```

Route is blocked.

### hasFerries

```objectivec
@property (nonatomic, readonly) BOOL hasFerries;
```

Route has ferries on it.

### hasTolls

```objectivec
@property (nonatomic, readonly) BOOL hasTolls;
```

Route has toll posts, which are always paid.

### requiresAccessPass

```objectivec
@property (nonatomic, readonly) BOOL requiresAccessPass;
```

Route requires special access.

### forParking

```objectivec
@property (nonatomic, readonly) BOOL forParking;
```

Route is made for parking.

### futureBlocked

```objectivec
@property (nonatomic, readonly) BOOL futureBlocked;
```

Route will be blocked soon.

### deadJam

```objectivec
@property (nonatomic, readonly) BOOL deadJam;
```

Route has a severe traffic jam.

### builtOffline

```objectivec
@property (nonatomic, readonly) BOOL builtOffline;
```

Route was built by using offline data.

### predicted

```objectivec
@property (nonatomic, readonly) BOOL predicted;
```

Predicted optimal route.

### hasRuggedRoads

```objectivec
@property (nonatomic, readonly) BOOL hasRuggedRoads;
```

Route has rugged roads on it.

### hasFordCrossing

```objectivec
@property (nonatomic, readonly) BOOL hasFordCrossing;
```

Route has ford crossing on it.

### hasVehicleRestrictions

```objectivec
@property (nonatomic, readonly) BOOL hasVehicleRestrictions;
```

Route has vehicle restrictions on it.

### hasUnpavedRoads

```objectivec
@property (nonatomic, readonly) BOOL hasUnpavedRoads;
```

Route has unpaved roads on it.

### hasInPoorConditionRoads

```objectivec
@property (nonatomic, readonly) BOOL hasInPoorConditionRoads;
```

Route has poor condition roads on it.

### hasRailwayCrossing

```objectivec
@property (nonatomic, readonly) BOOL hasRailwayCrossing;
```

Route has railway crossing on it.

### hasCheckpoints

```objectivec
@property (nonatomic, readonly) BOOL hasCheckpoints;
```

Route has checkpoints on it.

### scheduledDeparture

```objectivec
@property (nonatomic, readonly) BOOL scheduledDeparture;
```

Route was requested with custom departure time.

### hasNonTransactionalTolls

```objectivec
@property (nonatomic, readonly) BOOL hasNonTransactionalTolls;
```

Route has conditionally-toll-free toll posts

### hasTunnels

```objectivec
@property (nonatomic, readonly) BOOL hasTunnels;
```

Route has tunnels on it.

### hasHighways

```objectivec
@property (nonatomic, readonly) BOOL hasHighways;
```

Route has highways on it.
