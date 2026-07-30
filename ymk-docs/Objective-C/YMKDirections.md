---
title: "YMKDirections"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDirections"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDirections.html"
---
# YMKDirections

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDirections.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDirections : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKCarparksLayer *)createCarparksLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates the carparks layer

```objectivec
- (nonnull YMKDrivingRouter *)createDrivingRouterWithType:
    (YMKDrivingRouterType)type;
```

Creates a manager that builds driving routes

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### createCarparksLayerWithMapWindow:

```objectivec
- (nonnull YMKCarparksLayer *)createCarparksLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates the carparks layer.

### createDrivingRouterWithType:

```objectivec
- (nonnull YMKDrivingRouter *)createDrivingRouterWithType:
    (YMKDrivingRouterType)type;
```

Creates a manager that builds driving routes.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
