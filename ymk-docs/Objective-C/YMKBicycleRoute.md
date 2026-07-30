---
title: "YMKBicycleRoute"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRoute.html"
---
# YMKBicycleRoute

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleRoute : NSObject
```

Bicycle route.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBicycleSection *> *sections;
```

Sections of the route

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBicycleLeg *> *legs;
```

Legs of the route

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Polyline with geometry of the route

```objectivec
@property (nonatomic, readonly, nullable) YMKBicycleFlags *flags;
```

Specific properties of the route

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleConstructionSegment *> *constructions;
```

List of specific constructions along the bicycle path, such as stairs or crossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleTrafficTypeSegment *> *trafficTypes;
```

List of traffic types (YMKBicycleTrafficTypeID) along the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleRestrictedEntry *> *restrictedEntries;
```

List of restricted entries with their positions along the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleViaPoint *> *viaPoints;
```

List of via points on the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleWayPoint *> *wayPoints;
```

List of waypoints on the route

```objectivec
@property (nonatomic, readonly, nonnull) YMKUriObjectMetadata *uriMetadata;
```

Route URI, which can be used with YMKBicycleRouter to fetch additional information about the route or can be bookmarked for future reference

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeId;
```

Unique route id

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route.

### sections

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBicycleSection *> *sections;
```

Sections of the route.

### legs

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKBicycleLeg *> *legs;
```

Legs of the route.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Polyline with geometry of the route.

### flags

```objectivec
@property (nonatomic, readonly, nullable) YMKBicycleFlags *flags;
```

Specific properties of the route.

Optional property, can be nil.

### constructions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleConstructionSegment *> *constructions;
```

List of specific constructions along the bicycle path, such as stairs or crossings. See YMKBicycleConstructionID for a complete list of constructions. YMKBicycleConstructionSegment::subpolyline fields of all segments cover the entire YMKBicycleRoute::geometry.

### trafficTypes

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleTrafficTypeSegment *> *trafficTypes;
```

List of traffic types (YMKBicycleTrafficTypeID) along the path. Traffic type for an edge means who the road is designed for, such as pedestrians or cyclists. See YMKBicycleTrafficTypeID for a complete list of types. Fields YMKBicycleTrafficTypeSegment::subpolyline of all segments cover whole YMKBicycleRoute::geometry

### restrictedEntries

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleRestrictedEntry *> *restrictedEntries;
```

List of restricted entries with their positions along the path.

### viaPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleViaPoint *> *viaPoints;
```

List of via points on the path. See YMKBicycleViaPoint for details

### wayPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKBicycleWayPoint *> *wayPoints;
```

List of waypoints on the route. See YMKBicycleWayPoint for details.

### uriMetadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKUriObjectMetadata *uriMetadata;
```

Route URI, which can be used with YMKBicycleRouter to fetch additional information about the route or can be bookmarked for future reference.

### routeId

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeId;
```

Unique route id.

Optional property, can be nil.
