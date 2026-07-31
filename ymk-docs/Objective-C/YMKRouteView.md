---
title: "YMKRouteView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRouteView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteView.html"
---
# YMKRouteView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKRouteView : NSObject
```

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRoute *route;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBalloonView *> *balloonViews;
```

Balloons displayed on map about the route

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### route

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRoute *route;
```

### balloonViews

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBalloonView *> *balloonViews;
```

Balloons displayed on map about the route.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
