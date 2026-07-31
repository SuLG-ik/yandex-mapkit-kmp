---
title: "YMKMasstransitWeight"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitWeight"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWeight.html"
---
# YMKMasstransitWeight

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWeight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitWeight : NSObject
```

Numeric characteristics of a route or a route section.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                                 walkingDistance:(nonnull YMKLocalizedValue *)walkingDistance
                                  transfersCount:( NSUInteger)transfersCount;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Travel time for a route or a route section

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *walkingDistance;
```

Distance of the pedestrian part of the route or a route section

```objectivec
@property (nonatomic, readonly) NSUInteger transfersCount;
```

The number of transfers for a route or a route section

## Class methods

### weightWithTime:walkingDistance:transfersCount:

```objectivec
+ (nonnull YMKMasstransitWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                                 walkingDistance:(nonnull YMKLocalizedValue *)walkingDistance
                                  transfersCount:( NSUInteger)transfersCount;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Travel time for a route or a route section.

### walkingDistance

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *walkingDistance;
```

Distance of the pedestrian part of the route or a route section.

### transfersCount

```objectivec
@property (nonatomic, readonly) NSUInteger transfersCount;
```

The number of transfers for a route or a route section.
