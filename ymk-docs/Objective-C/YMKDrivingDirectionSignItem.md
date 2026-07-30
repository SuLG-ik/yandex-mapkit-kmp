---
title: "YMKDrivingDirectionSignItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignItem.html"
---
# YMKDrivingDirectionSignItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignItem : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithToponym:(nonnull YMKDrivingDirectionSignToponym *)toponym;
```

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithRoad:(nonnull YMKDrivingDirectionSignRoad *)road;
```

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithExit:(nonnull YMKDrivingDirectionSignExit *)exit;
```

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithIcon:(nonnull YMKDrivingDirectionSignIcon *)icon;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignToponym *toponym
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignRoad *road
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignExit *exit
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignIcon *icon
```

## Class methods

### directionSignItemWithToponym:

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithToponym:(nonnull YMKDrivingDirectionSignToponym *)toponym;
```

### directionSignItemWithRoad:

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithRoad:(nonnull YMKDrivingDirectionSignRoad *)road;
```

### directionSignItemWithExit:

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithExit:(nonnull YMKDrivingDirectionSignExit *)exit;
```

### directionSignItemWithIcon:

```objectivec
+ (nonnull YMKDrivingDirectionSignItem *)directionSignItemWithIcon:(nonnull YMKDrivingDirectionSignIcon *)icon;
```

## Properties

### toponym

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignToponym *toponym
```

### road

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignRoad *road
```

### exit

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignExit *exit
```

### icon

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSignIcon *icon
```
