---
title: "YMKSearchTimeRange"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchTimeRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchTimeRange.html"
---
# YMKSearchTimeRange

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchTimeRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchTimeRange : NSObject
```

The time interval used to compose availability info.

Can describe two kinds of intervals: 1. 24-hour interval (`isTwentyFourHours` is true, `from` and `to` are not used). 2. Smaller time interval (`isTwentyFourHours` is false, `from` and `to` are set to the begin and end of the interval)

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchTimeRange *)timeRangeWithIsTwentyFourHours:(nullable NSNumber *)isTwentyFourHours
                                                          from:(nullable NSNumber *)from
                                                            to:(nullable NSNumber *)to;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *isTwentyFourHours;
```

All day (24 hours) time range marker

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *from;
```

Interval start (seconds from midnight)

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *to;
```

Interval end (seconds from midnight)

## Class methods

### timeRangeWithIsTwentyFourHours:from:to:

```objectivec
+ (nonnull YMKSearchTimeRange *)timeRangeWithIsTwentyFourHours:(nullable NSNumber *)isTwentyFourHours
                                                          from:(nullable NSNumber *)from
                                                            to:(nullable NSNumber *)to;
```

## Properties

### isTwentyFourHours

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *isTwentyFourHours;
```

All day (24 hours) time range marker.

Optional field, can be nil.

### from

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *from;
```

Interval start (seconds from midnight).

Optional field, can be nil.

### to

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *to;
```

Interval end (seconds from midnight).

Optional field, can be nil.
