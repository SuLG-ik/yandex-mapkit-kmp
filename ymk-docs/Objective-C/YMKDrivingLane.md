---
title: "YMKDrivingLane"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingLane"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLane.html"
---
# YMKDrivingLane

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLane.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingLane : NSObject
```

The lane object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingLane *)laneWithLaneKind:( YMKDrivingLaneKind)laneKind
                                  directions:(nonnull NSArray<NSNumber *> *)directions
                        highlightedDirection:(nullable NSNumber *)highlightedDirection;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKDrivingLaneKind laneKind;
```

The type of lane

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *directions;
```

Lane direction

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *highlightedDirection;
```

Highlighted lane direction

## Class methods

### laneWithLaneKind:directions:highlightedDirection:

```objectivec
+ (nonnull YMKDrivingLane *)laneWithLaneKind:( YMKDrivingLaneKind)laneKind
                                  directions:(nonnull NSArray<NSNumber *> *)directions
                        highlightedDirection:(nullable NSNumber *)highlightedDirection;
```

## Properties

### laneKind

```objectivec
@property (nonatomic, readonly) YMKDrivingLaneKind laneKind;
```

The type of lane.

### directions

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *directions;
```

Lane direction.

### highlightedDirection

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *highlightedDirection;
```

Highlighted lane direction.

Optional field, can be nil.
