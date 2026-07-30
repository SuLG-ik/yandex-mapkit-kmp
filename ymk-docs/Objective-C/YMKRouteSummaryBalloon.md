---
title: "YMKRouteSummaryBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRouteSummaryBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteSummaryBalloon.html"
---
# YMKRouteSummaryBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteSummaryBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKRouteSummaryBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKRouteSummaryBalloon *)routeSummaryBalloonWithSummary:(nonnull YMKDrivingSummary *)summary
                                                              tags:(nonnull NSArray<NSString *> *)tags
                                                    relativeWeight:(nullable YMKDrivingWeight *)relativeWeight;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSummary *summary;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingWeight *relativeWeight;
```

presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

Optional field, can be nil

## Class methods

### routeSummaryBalloonWithSummary:tags:relativeWeight:

```objectivec
+ (nonnull YMKRouteSummaryBalloon *)routeSummaryBalloonWithSummary:(nonnull YMKDrivingSummary *)summary
                                                              tags:(nonnull NSArray<NSString *> *)tags
                                                    relativeWeight:(nullable YMKDrivingWeight *)relativeWeight;
```

## Properties

### summary

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSummary *summary;
```

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

### relativeWeight

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingWeight *relativeWeight;
```

presented only if any another route selected in navigation layer contains (weight(alternative) - weight(selectedRoute)) automatically updated on selected route changing

Optional field, can be nil.
