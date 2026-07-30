---
title: "YMKSearchAvailability"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchAvailability"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAvailability.html"
---
# YMKSearchAvailability

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAvailability.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchAvailability : NSObject
```

A single value of availability information.

Allows to describe business schedule for a group of days. For example, an organization open on weekdays from 9 AM to 6 PM with a lunch break from 1 PM to 2 PM can be described as a single `Availability` with `days` equal to `DayGroup::Weekdays` and two time ranges (9:00-13:00, 14:00-18:00). More complicated schedules will require multiple `Availabilities`.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchAvailability *)availabilityWithDays:( YMKSearchDayGroup)days
                                             timeRanges:(nonnull NSArray<YMKSearchTimeRange *> *)timeRanges;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKSearchDayGroup days;
```

Days where time ranges are applicable

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchTimeRange *> *timeRanges;
```

Ranges for open hours

## Class methods

### availabilityWithDays:timeRanges:

```objectivec
+ (nonnull YMKSearchAvailability *)availabilityWithDays:( YMKSearchDayGroup)days
                                             timeRanges:(nonnull NSArray<YMKSearchTimeRange *> *)timeRanges;
```

## Properties

### days

```objectivec
@property (nonatomic, readonly) YMKSearchDayGroup days;
```

Days where time ranges are applicable

### timeRanges

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchTimeRange *> *timeRanges;
```

Ranges for open hours
