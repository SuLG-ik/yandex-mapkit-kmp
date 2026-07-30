---
title: "YMKAlternativeBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAlternativeBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAlternativeBalloon.html"
---
# YMKAlternativeBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAlternativeBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAlternativeBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAlternativeBalloon *)alternativeBalloonWithSummary:(nonnull YMKDrivingSummary *)summary
                                                  relativeWeight:(nonnull YMKDrivingWeight *)relativeWeight;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSummary *summary;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *relativeWeight;
```

contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

## Class methods

### alternativeBalloonWithSummary:relativeWeight:

```objectivec
+ (nonnull YMKAlternativeBalloon *)alternativeBalloonWithSummary:(nonnull YMKDrivingSummary *)summary
                                                  relativeWeight:(nonnull YMKDrivingWeight *)relativeWeight;
```

## Properties

### summary

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSummary *summary;
```

### relativeWeight

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *relativeWeight;
```

contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing
