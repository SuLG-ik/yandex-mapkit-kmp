---
title: "YMKManoeuvreBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKManoeuvreBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvreBalloon.html"
---
# YMKManoeuvreBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvreBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKManoeuvreBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKManoeuvreBalloon *)manoeuvreBalloonWithManoeuvre:(nonnull YMKManoeuvre *)manoeuvre
                                                 directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKManoeuvre *manoeuvre;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil

## Class methods

### manoeuvreBalloonWithManoeuvre:directionSign:

```objectivec
+ (nonnull YMKManoeuvreBalloon *)manoeuvreBalloonWithManoeuvre:(nonnull YMKManoeuvre *)manoeuvre
                                                 directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

## Properties

### manoeuvre

```objectivec
@property (nonatomic, readonly, nonnull) YMKManoeuvre *manoeuvre;
```

### directionSign

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil.
