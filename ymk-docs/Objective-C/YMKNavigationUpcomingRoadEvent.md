---
title: "YMKNavigationUpcomingRoadEvent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationUpcomingRoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationUpcomingRoadEvent.html"
---
# YMKNavigationUpcomingRoadEvent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationUpcomingRoadEvent.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationUpcomingRoadEvent : NSObject
```

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingEvent *event;
```

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speedLimitStatus;
```

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *effectiveSpeedLimit;
```

Effective speed limit

```objectivec
@property (nonatomic, readonly, nonnull) YMKRoutePosition *position;
```

## Properties

### event

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingEvent *event;
```

### speedLimitStatus

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speedLimitStatus;
```

Optional property, can be nil.

### effectiveSpeedLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *effectiveSpeedLimit;
```

Effective speed limit. Non-empty only for speed control camera events. If a camera has no speed limit then some standard urban speed limit will be used.

Optional property, can be nil.

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKRoutePosition *position;
```
