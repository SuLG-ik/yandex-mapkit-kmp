---
title: "YMKCustomRouteNavigation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCustomRouteNavigation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCustomRouteNavigation.html"
---
# YMKCustomRouteNavigation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCustomRouteNavigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKCustomRouteNavigation : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKCamera *)createCameraWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

This method allows to create camera which used in standart automotive navigation

```objectivec
- (void)startGuidanceWithRoute:(nullable YMKDrivingRoute *)route;
```

Start navigation with specified route

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigation *navigation;
```

This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class

## Instance methods

### createCameraWithMapWindow:

```objectivec
- (nonnull YMKCamera *)createCameraWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

This method allows to create camera which used in standart automotive navigation

### startGuidanceWithRoute:

```objectivec
- (void)startGuidanceWithRoute:(nullable YMKDrivingRoute *)route;
```

Start navigation with specified route.

## Properties

### navigation

```objectivec
@property (nonatomic, readonly, nonnull) YMKNavigation *navigation;
```

This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class
