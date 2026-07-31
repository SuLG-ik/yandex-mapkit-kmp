---
title: "YMKMasstransitRailwayOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRailwayOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRailwayOptions.html"
---
# YMKMasstransitRailwayOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRailwayOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRailwayOptions : NSObject
```

Contains information about boarding to or dropOff from trains.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRailwayOptions *)railwayOptionsWithTracks:(nullable NSString *)tracks
                                                         platforms:(nullable NSString *)platforms
                                                         uncertain:( BOOL)uncertain;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *tracks;
```

Departure track annotation, e

```objectivec
@property (nonatomic, readonly, nullable) NSString *platforms;
```

Departure platform annotation, e

```objectivec
@property (nonatomic, readonly) BOOL uncertain;
```

Flag of track/platform selection uncertainty to suggest user double-check it in the station

## Class methods

### railwayOptionsWithTracks:platforms:uncertain:

```objectivec
+ (nonnull YMKMasstransitRailwayOptions *)railwayOptionsWithTracks:(nullable NSString *)tracks
                                                         platforms:(nullable NSString *)platforms
                                                         uncertain:( BOOL)uncertain;
```

## Properties

### tracks

```objectivec
@property (nonatomic, readonly, nullable) NSString *tracks;
```

Departure track annotation, e.g. "3 or 4 track".

Optional field, can be nil.

### platforms

```objectivec
@property (nonatomic, readonly, nullable) NSString *platforms;
```

Departure platform annotation, e.g. "2 platform".

Optional field, can be nil.

### uncertain

```objectivec
@property (nonatomic, readonly) BOOL uncertain;
```

Flag of track/platform selection uncertainty to suggest user double-check it in the station.
