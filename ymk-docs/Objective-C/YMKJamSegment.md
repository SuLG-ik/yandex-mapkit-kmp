---
title: "YMKJamSegment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKJamSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamSegment.html"
---
# YMKJamSegment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKJamSegment.html)

```objectivec
@interface YMKJamSegment : NSObject
```

A segment of a traffic jam that has specific traffic conditions.

## Summary

### Class methods

```objectivec
+ (nonnull YMKJamSegment *)jamSegmentWithJamType:( YMKJamType)jamType
                                           speed:( double)speed;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKJamType jamType;
```

The type of the traffic jam

```objectivec
@property (nonatomic, readonly) double speed;
```

The speed at which traffic is moving

## Class methods

### jamSegmentWithJamType:speed:

```objectivec
+ (nonnull YMKJamSegment *)jamSegmentWithJamType:( YMKJamType)jamType
                                           speed:( double)speed;
```

## Properties

### jamType

```objectivec
@property (nonatomic, readonly) YMKJamType jamType;
```

The type of the traffic jam.

### speed

```objectivec
@property (nonatomic, readonly) double speed;
```

The speed at which traffic is moving.
