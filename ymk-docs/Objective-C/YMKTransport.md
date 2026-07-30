---
title: "YMKTransport"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTransport"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransport.html"
---
# YMKTransport

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTransport : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKBicycleRouter *)createBicycleRouter;
```

Creates a manager that builds bicycle routes using the origin and destination points

```objectivec
- (nonnull YMKMasstransitRouter *)createMasstransitRouter;
```

Creates a manager that builds public transit routes using the origin and destination points

```objectivec
- (nonnull YMKPedestrianRouter *)createPedestrianRouter;
```

Creates a manager that builds pedestrian routes using the origin and destination points

```objectivec
- (nonnull YMKBicycleRouterV2 *)createBicycleRouterV2;
```

Creates a manager that builds bicycle routes using the origin and destination points

```objectivec
- (nonnull YMKBicycleRouterV2 *)createScooterRouter;
```

Creates a manager that builds scooter routes using the origin and destination points

```objectivec
- (nonnull YMKBicycleRouterV2 *)createElectricBikeRouter;
```

Creates a manager that builds electric bike routes using the origin and destination points

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKAdjustedClock *adjustedClock;
```

Returns the clock that is constantly synchronized with the server

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### createBicycleRouter

```objectivec
- (nonnull YMKBicycleRouter *)createBicycleRouter;
```

Creates a manager that builds bicycle routes using the origin and destination points.

> [!CAUTION] Внимание
> use createBicycleRouterV2 instead

### createMasstransitRouter

```objectivec
- (nonnull YMKMasstransitRouter *)createMasstransitRouter;
```

Creates a manager that builds public transit routes using the origin and destination points.

### createPedestrianRouter

```objectivec
- (nonnull YMKPedestrianRouter *)createPedestrianRouter;
```

Creates a manager that builds pedestrian routes using the origin and destination points.

### createBicycleRouterV2

```objectivec
- (nonnull YMKBicycleRouterV2 *)createBicycleRouterV2;
```

Creates a manager that builds bicycle routes using the origin and destination points.

### createScooterRouter

```objectivec
- (nonnull YMKBicycleRouterV2 *)createScooterRouter;
```

Creates a manager that builds scooter routes using the origin and destination points.

### createElectricBikeRouter

```objectivec
- (nonnull YMKBicycleRouterV2 *)createElectricBikeRouter;
```

Creates a manager that builds electric bike routes using the origin and destination points.

## Properties

### adjustedClock

```objectivec
@property (nonatomic, readonly, nonnull) YMKAdjustedClock *adjustedClock;
```

Returns the clock that is constantly synchronized with the server.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
