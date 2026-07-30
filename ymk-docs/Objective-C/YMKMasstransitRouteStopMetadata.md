---
title: "YMKMasstransitRouteStopMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouteStopMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteStopMetadata.html"
---
# YMKMasstransitRouteStopMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteStopMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouteStopMetadata : NSObject <YMKBaseMetadata>
```

The metadata about the mass transit stop.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRouteStopMetadata *)routeStopMetadataWithStop:(nonnull YMKMasstransitStop *)stop
                                                              stopExit:(nullable YMKMasstransitStop *)stopExit
                                                             exitPoint:(nullable YMKPoint *)exitPoint;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Route stop information

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitStop *stopExit;
```

Underground station exit

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *exitPoint;
```

Coordinates of underground station exit

Optional field, can be nil

## Class methods

### routeStopMetadataWithStop:stopExit:exitPoint:

```objectivec
+ (nonnull YMKMasstransitRouteStopMetadata *)routeStopMetadataWithStop:(nonnull YMKMasstransitStop *)stop
                                                              stopExit:(nullable YMKMasstransitStop *)stopExit
                                                             exitPoint:(nullable YMKPoint *)exitPoint;
```

## Properties

### stop

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Route stop information.

### stopExit

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitStop *stopExit;
```

Underground station exit

Optional field, can be nil.

### exitPoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *exitPoint;
```

Coordinates of underground station exit

Optional field, can be nil.
