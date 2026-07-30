---
title: "YMKMasstransitRouteStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouteStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteStop.html"
---
# YMKMasstransitRouteStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouteStop : NSObject
```

Describes a YMKMasstransitStop on a YMKMasstransitRoute.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRouteStop *)routeStopWithMetadata:(nonnull YMKMasstransitRouteStopMetadata *)metadata
                                                  position:(nonnull YMKPoint *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRouteStopMetadata *metadata;
```

General information about a stop on a route and optionally about its exit

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the stop

## Class methods

### routeStopWithMetadata:position:

```objectivec
+ (nonnull YMKMasstransitRouteStop *)routeStopWithMetadata:(nonnull YMKMasstransitRouteStopMetadata *)metadata
                                                  position:(nonnull YMKPoint *)position;
```

## Properties

### metadata

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRouteStopMetadata *metadata;
```

General information about a stop on a route and optionally about its exit

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the stop.
