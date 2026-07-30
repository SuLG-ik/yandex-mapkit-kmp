---
title: "YMKGuidance"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGuidance"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGuidance.html"
---
# YMKGuidance

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGuidance.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKGuidance : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)switchToRouteWithRoute:(nonnull YMKDrivingRoute *)route;
```

Start guidance with given alternative

```objectivec
- (void)addListenerWithGuidanceListener:
    (nonnull id<YMKGuidanceListener>)guidanceListener;
```

The class does not retain the object in the 'guidanceListener' parameter

```objectivec
- (void)removeListenerWithGuidanceListener:
    (nonnull id<YMKGuidanceListener>)guidanceListener;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isEnableAlternatives) BOOL enableAlternatives;
```

Enables/Disables alternatives suggestion while guiding

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isEnableReroutes) BOOL enableReroutes;
```

Enables/Disables rerouting

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigationWindshield *windshield;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKAnnotator *annotator;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingRoute *currentRoute;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationAlternative *> *alternatives;
```

Vector with all alternatives ahead

```objectivec
@property (nonatomic, readonly, nullable)
    YMKNavigationAlternative *fastestAlternative;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKLocation *location;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *locationClass;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *roadName;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly) YMKRouteStatus routeStatus;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpeedLimitsPolicy *speedLimitsPolicy;
```

In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    double speedLimitTolerance;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *speedLimit;
```

Speed limit of the current road

```objectivec
@property (nonatomic, readonly) YMKSpeedLimitStatus speedLimitStatus;
```

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### switchToRouteWithRoute:

```objectivec
- (void)switchToRouteWithRoute:(nonnull YMKDrivingRoute *)route;
```

Start guidance with given alternative. It only accepts routes obtained from this Guidance.routes field.

### addListenerWithGuidanceListener:

```objectivec
- (void)addListenerWithGuidanceListener:
    (nonnull id<YMKGuidanceListener>)guidanceListener;
```

The class does not retain the object in the 'guidanceListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithGuidanceListener:

```objectivec
- (void)removeListenerWithGuidanceListener:
    (nonnull id<YMKGuidanceListener>)guidanceListener;
```

## Properties

### enableAlternatives

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isEnableAlternatives) BOOL enableAlternatives;
```

Enables/Disables alternatives suggestion while guiding. Enabled by default.

### enableReroutes

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isEnableReroutes) BOOL enableReroutes;
```

Enables/Disables rerouting. Enabled by default.

### windshield

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigationWindshield *windshield;
```

### annotator

```objectivec
@property (nonatomic, readonly, nonnull) YMKAnnotator *annotator;
```

### currentRoute

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingRoute *currentRoute;
```

Optional property, can be nil.

### alternatives

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationAlternative *> *alternatives;
```

Vector with all alternatives ahead. Sorted by distance.

### fastestAlternative

```objectivec
@property (nonatomic, readonly, nullable)
    YMKNavigationAlternative *fastestAlternative;
```

Optional property, can be nil.

### location

```objectivec
@property (nonatomic, readonly, nullable) YMKLocation *location;
```

Optional property, can be nil.

### locationClass

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *locationClass;
```

Optional property, can be nil.

### roadName

```objectivec
@property (nonatomic, readonly, nullable) NSString *roadName;
```

Optional property, can be nil.

### routeStatus

```objectivec
@property (nonatomic, readonly) YMKRouteStatus routeStatus;
```

### speedLimitsPolicy

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpeedLimitsPolicy *speedLimitsPolicy;
```

In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used.

### speedLimitTolerance

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    double speedLimitTolerance;
```

### speedLimit

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *speedLimit;
```

Speed limit of the current road.

Optional property, can be nil.

### speedLimitStatus

```objectivec
@property (nonatomic, readonly) YMKSpeedLimitStatus speedLimitStatus;
```

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
