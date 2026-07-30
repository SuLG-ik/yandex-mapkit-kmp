---
title: "YMKDrivingAvoidanceFlags"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingAvoidanceFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingAvoidanceFlags.html"
---
# YMKDrivingAvoidanceFlags

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingAvoidanceFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingAvoidanceFlags : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingAvoidanceFlags *)avoidanceFlagsWithAvoidTolls:( BOOL)avoidTolls
                                                      avoidUnpaved:( BOOL)avoidUnpaved
                                                avoidPoorCondition:( BOOL)avoidPoorCondition
                                              avoidRailwayCrossing:( BOOL)avoidRailwayCrossing
                                                    avoidBoatFerry:( BOOL)avoidBoatFerry
                                                 avoidFordCrossing:( BOOL)avoidFordCrossing
                                                       avoidTunnel:( BOOL)avoidTunnel
                                                      avoidHighway:( BOOL)avoidHighway;
```

### Instance methods

```objectivec
- (nonnull YMKDrivingAvoidanceFlags *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidTolls;
```

The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidUnpaved;
```

The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidPoorCondition;
```

The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidRailwayCrossing;
```

The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidBoatFerry;
```

The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidFordCrossing;
```

The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidTunnel;
```

The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidHighway;
```

The 'avoidHighway' option instructs the router to return routes that avoid highways when possible

## Class methods

### avoidanceFlagsWithAvoidTolls:avoidUnpaved:avoidPoorCondition:avoidRailwayCrossing:avoidBoatFerry:avoidFordCrossing:avoidTunnel:avoidHighway:

```objectivec
+ (nonnull YMKDrivingAvoidanceFlags *)avoidanceFlagsWithAvoidTolls:( BOOL)avoidTolls
                                                      avoidUnpaved:( BOOL)avoidUnpaved
                                                avoidPoorCondition:( BOOL)avoidPoorCondition
                                              avoidRailwayCrossing:( BOOL)avoidRailwayCrossing
                                                    avoidBoatFerry:( BOOL)avoidBoatFerry
                                                 avoidFordCrossing:( BOOL)avoidFordCrossing
                                                       avoidTunnel:( BOOL)avoidTunnel
                                                      avoidHighway:( BOOL)avoidHighway;
```

## Instance methods

### init

```objectivec
- (nonnull YMKDrivingAvoidanceFlags *)init;
```

## Properties

### avoidTolls

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidTolls;
```

The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible.

### avoidUnpaved

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidUnpaved;
```

The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible.

### avoidPoorCondition

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidPoorCondition;
```

The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible.

### avoidRailwayCrossing

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidRailwayCrossing;
```

The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible.

### avoidBoatFerry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidBoatFerry;
```

The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible.

### avoidFordCrossing

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL avoidFordCrossing;
```

The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible.

### avoidTunnel

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidTunnel;
```

The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible.

### avoidHighway

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL avoidHighway;
```

The 'avoidHighway' option instructs the router to return routes that avoid highways when possible.
