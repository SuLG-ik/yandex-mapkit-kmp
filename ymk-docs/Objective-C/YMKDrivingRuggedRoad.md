---
title: "YMKDrivingRuggedRoad"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRuggedRoad"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRuggedRoad.html"
---
# YMKDrivingRuggedRoad

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRuggedRoad.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRuggedRoad : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRuggedRoad *)ruggedRoadWithPosition:(nonnull YMKSubpolyline *)position
                                                 unpaved:( BOOL)unpaved
                                         inPoorCondition:( BOOL)inPoorCondition;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *position;
```

```objectivec
@property (nonatomic, readonly) BOOL unpaved;
```

```objectivec
@property (nonatomic, readonly) BOOL inPoorCondition;
```

## Class methods

### ruggedRoadWithPosition:unpaved:inPoorCondition:

```objectivec
+ (nonnull YMKDrivingRuggedRoad *)ruggedRoadWithPosition:(nonnull YMKSubpolyline *)position
                                                 unpaved:( BOOL)unpaved
                                         inPoorCondition:( BOOL)inPoorCondition;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *position;
```

### unpaved

```objectivec
@property (nonatomic, readonly) BOOL unpaved;
```

### inPoorCondition

```objectivec
@property (nonatomic, readonly) BOOL inPoorCondition;
```
