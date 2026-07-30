---
title: "YMKDrivingDirectionSignStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignStyle.html"
---
# YMKDrivingDirectionSignStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignStyle : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignStyle *)directionSignStyleWithTextColor:(nonnull UIColor *)textColor
                                                                  bgColor:(nonnull UIColor *)bgColor;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *textColor;
```

Text color in RGB format

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *bgColor;
```

Background color in RGB format

## Class methods

### directionSignStyleWithTextColor:bgColor:

```objectivec
+ (nonnull YMKDrivingDirectionSignStyle *)directionSignStyleWithTextColor:(nonnull UIColor *)textColor
                                                                  bgColor:(nonnull UIColor *)bgColor;
```

## Properties

### textColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *textColor;
```

Text color in RGB format

### bgColor

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *bgColor;
```

Background color in RGB format
