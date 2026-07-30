---
title: "YMKMasstransitTransportStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportStop.html"
---
# YMKMasstransitTransportStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportStop : NSObject
```

The data about the public transport stop.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportStop *)transportStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                      position:(nonnull YMKPoint *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Information about public transport stops

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the stop

## Class methods

### transportStopWithStop:position:

```objectivec
+ (nonnull YMKMasstransitTransportStop *)transportStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                      position:(nonnull YMKPoint *)position;
```

## Properties

### stop

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Information about public transport stops.

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the stop.
