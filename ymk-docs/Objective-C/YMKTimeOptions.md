---
title: "YMKTimeOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTimeOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTimeOptions.html"
---
# YMKTimeOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTimeOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTimeOptions : NSObject
```

Desired departure/arrival time settings. Only one the departureTime and arrivalTime fields should be specified.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTimeOptions *)timeOptionsWithDepartureTime:(nullable NSDate *)departureTime
                                             arrivalTime:(nullable NSDate *)arrivalTime;
```

### Properties

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *departureTime;
```

Desired departure time in UTC for a time-dependent route request

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *arrivalTime;
```

Desired arrival time in UTC for a time-dependent route request

## Class methods

### timeOptionsWithDepartureTime:arrivalTime:

```objectivec
+ (nonnull YMKTimeOptions *)timeOptionsWithDepartureTime:(nullable NSDate *)departureTime
                                             arrivalTime:(nullable NSDate *)arrivalTime;
```

## Properties

### departureTime

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *departureTime;
```

Desired departure time in UTC for a time-dependent route request. The value is specified in milliseconds. This option cannot be used with arrivalTime.

Optional field, can be nil.

### arrivalTime

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSDate *arrivalTime;
```

Desired arrival time in UTC for a time-dependent route request. The value is specified in milliseconds. This option cannot be used with departureTime.

Optional field, can be nil.
