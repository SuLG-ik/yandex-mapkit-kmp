---
title: "YMKMasstransitRoute"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRoute.html"
---
# YMKMasstransitRoute

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRoute : NSObject
```

Contains information about a route constructed by the mass transit router.

## Summary

### Instance methods

```objectivec
- (double)
    distanceBetweenPolylinePositionsWithFrom:(nonnull YMKPolylinePosition *)from
                                          to:(nonnull YMKPolylinePosition *)to;
```

Return distance between two polyline positions

```objectivec
- (double)
    timeBetweenPolylinePositionsWithFrom:(nonnull YMKPolylinePosition *)from
                                      to:(nonnull YMKPolylinePosition *)to;
```

Return travel time between two polyline positions

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitRouteMetadata *metadata;
```

General route information

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitWayPoint *> *wayPoints;
```

List of route waypoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitSection *> *sections;
```

Vector of sections of the route

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Polyline of the entire route

```objectivec
@property (nonatomic, readonly, nonnull) YMKUriObjectMetadata *uriMetadata;
```

Route URI, which can be used with YMKMasstransitRouter to fetch additional information about the route or can be bookmarked for future reference

## Instance methods

### distanceBetweenPolylinePositionsWithFrom:to:

```objectivec
- (double)
    distanceBetweenPolylinePositionsWithFrom:(nonnull YMKPolylinePosition *)from
                                          to:(nonnull YMKPolylinePosition *)to;
```

Return distance between two polyline positions.

### timeBetweenPolylinePositionsWithFrom:to:

```objectivec
- (double)
    timeBetweenPolylinePositionsWithFrom:(nonnull YMKPolylinePosition *)from
                                      to:(nonnull YMKPolylinePosition *)to;
```

Return travel time between two polyline positions.

## Properties

### metadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitRouteMetadata *metadata;
```

General route information.

### wayPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitWayPoint *> *wayPoints;
```

List of route waypoints. See YMKMasstransitWayPoint for details

### sections

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitSection *> *sections;
```

Vector of sections of the route.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Polyline of the entire route.

### uriMetadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKUriObjectMetadata *uriMetadata;
```

Route URI, which can be used with YMKMasstransitRouter to fetch additional information about the route or can be bookmarked for future reference.
