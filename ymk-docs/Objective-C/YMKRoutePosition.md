---
title: "YMKRoutePosition"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoutePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoutePosition.html"
---
# YMKRoutePosition

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoutePosition.html)

```objectivec
@interface YMKRoutePosition : NSObject
```

## Summary

### Instance methods

```objectivec
- (BOOL)onRouteWithRouteId:(nonnull NSString *)routeId;
```

Check if this position on the same route as passed

```objectivec
- (nullable YMKPolylinePosition *)positionOnRouteWithRouteId:
    (nonnull NSString *)routeId;
```

Return polyline position on route

```objectivec
- (nonnull YMKRoutePosition *)advanceWithDistance:(double)distance;
```

Create position shifted by distance

```objectivec
- (nullable NSNumber *)distanceToWithTo:(nonnull YMKRoutePosition *)to;
```

Distance to another point on the route

```objectivec
- (BOOL)precedesWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position precedes another position on the route

```objectivec
- (BOOL)precedesOrEqualsWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position precedes or equals another position on the route

```objectivec
- (BOOL)equalsWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position equals another position on the route

```objectivec
- (double)heading;
```

Heading movement on the route at this position

```objectivec
- (double)distanceToFinish;
```

Distance to the end of the route

```objectivec
- (double)timeToFinish;
```

Time to the end of the route

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

As point on the map

## Instance methods

### onRouteWithRouteId:

```objectivec
- (BOOL)onRouteWithRouteId:(nonnull NSString *)routeId;
```

Check if this position on the same route as passed.

### positionOnRouteWithRouteId:

```objectivec
- (nullable YMKPolylinePosition *)positionOnRouteWithRouteId:
    (nonnull NSString *)routeId;
```

Return polyline position on route. If the position not on the passed route none will be returned.

### advanceWithDistance:

```objectivec
- (nonnull YMKRoutePosition *)advanceWithDistance:(double)distance;
```

Create position shifted by distance. If the distance is more than remains route length, the end of the route will be returned. If the distance is less than a negative distance from the start, the beginning of the route will be returned.

### distanceToWithTo:

```objectivec
- (nullable NSNumber *)distanceToWithTo:(nonnull YMKRoutePosition *)to;
```

Distance to another point on the route. Return none if point on another route. May be less 0 if position "to" stay before this position.

### precedesWithAnother:

```objectivec
- (BOOL)precedesWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position precedes another position on the route. Throws if another position belongs to another route.

### precedesOrEqualsWithAnother:

```objectivec
- (BOOL)precedesOrEqualsWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position precedes or equals another position on the route. Throws if another position belongs to another route.

### equalsWithAnother:

```objectivec
- (BOOL)equalsWithAnother:(nonnull YMKRoutePosition *)another;
```

Determines if position equals another position on the route. Throws if another position belongs to another route.

### heading

```objectivec
- (double)heading;
```

Heading movement on the route at this position. It is equal heading of the segment which is belonged position.

### distanceToFinish

```objectivec
- (double)distanceToFinish;
```

Distance to the end of the route.

### timeToFinish

```objectivec
- (double)timeToFinish;
```

Time to the end of the route.

## Properties

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

As point on the map
