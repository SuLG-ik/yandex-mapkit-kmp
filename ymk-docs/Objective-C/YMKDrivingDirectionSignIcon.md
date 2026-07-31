---
title: "YMKDrivingDirectionSignIcon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignIcon.html"
---
# YMKDrivingDirectionSignIcon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignIcon.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignIcon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignIcon *)directionSignIconWithImage:( YMKDrivingDirectionSignImage)image
                                                              style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKDrivingDirectionSignImage image;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```

## Class methods

### directionSignIconWithImage:style:

```objectivec
+ (nonnull YMKDrivingDirectionSignIcon *)directionSignIconWithImage:( YMKDrivingDirectionSignImage)image
                                                              style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

## Properties

### image

```objectivec
@property (nonatomic, readonly) YMKDrivingDirectionSignImage image;
```

### style

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```
