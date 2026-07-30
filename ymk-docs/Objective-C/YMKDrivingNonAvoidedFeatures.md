---
title: "YMKDrivingNonAvoidedFeatures"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingNonAvoidedFeatures"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingNonAvoidedFeatures.html"
---
# YMKDrivingNonAvoidedFeatures

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingNonAvoidedFeatures.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingNonAvoidedFeatures : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingNonAvoidedFeatures *)nonAvoidedFeaturesWithTolls:( BOOL)tolls
                                                              ferries:( BOOL)ferries
                                                        fordCrossings:( BOOL)fordCrossings
                                                             highways:( BOOL)highways
                                                     railwayCrossings:( BOOL)railwayCrossings
                                                              tunnels:( BOOL)tunnels
                                                 inPoorConditionRoads:( BOOL)inPoorConditionRoads
                                                         unpavedRoads:( BOOL)unpavedRoads
                                                           avoidZones:( BOOL)avoidZones;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL tolls;
```

```objectivec
@property (nonatomic, readonly) BOOL ferries;
```

```objectivec
@property (nonatomic, readonly) BOOL fordCrossings;
```

```objectivec
@property (nonatomic, readonly) BOOL highways;
```

```objectivec
@property (nonatomic, readonly) BOOL railwayCrossings;
```

```objectivec
@property (nonatomic, readonly) BOOL tunnels;
```

```objectivec
@property (nonatomic, readonly) BOOL inPoorConditionRoads;
```

```objectivec
@property (nonatomic, readonly) BOOL unpavedRoads;
```

```objectivec
@property (nonatomic, readonly) BOOL avoidZones;
```

## Class methods

### nonAvoidedFeaturesWithTolls:ferries:fordCrossings:highways:railwayCrossings:tunnels:inPoorConditionRoads:unpavedRoads:avoidZones:

```objectivec
+ (nonnull YMKDrivingNonAvoidedFeatures *)nonAvoidedFeaturesWithTolls:( BOOL)tolls
                                                              ferries:( BOOL)ferries
                                                        fordCrossings:( BOOL)fordCrossings
                                                             highways:( BOOL)highways
                                                     railwayCrossings:( BOOL)railwayCrossings
                                                              tunnels:( BOOL)tunnels
                                                 inPoorConditionRoads:( BOOL)inPoorConditionRoads
                                                         unpavedRoads:( BOOL)unpavedRoads
                                                           avoidZones:( BOOL)avoidZones;
```

## Properties

### tolls

```objectivec
@property (nonatomic, readonly) BOOL tolls;
```

### ferries

```objectivec
@property (nonatomic, readonly) BOOL ferries;
```

### fordCrossings

```objectivec
@property (nonatomic, readonly) BOOL fordCrossings;
```

### highways

```objectivec
@property (nonatomic, readonly) BOOL highways;
```

### railwayCrossings

```objectivec
@property (nonatomic, readonly) BOOL railwayCrossings;
```

### tunnels

```objectivec
@property (nonatomic, readonly) BOOL tunnels;
```

### inPoorConditionRoads

```objectivec
@property (nonatomic, readonly) BOOL inPoorConditionRoads;
```

### unpavedRoads

```objectivec
@property (nonatomic, readonly) BOOL unpavedRoads;
```

### avoidZones

```objectivec
@property (nonatomic, readonly) BOOL avoidZones;
```
