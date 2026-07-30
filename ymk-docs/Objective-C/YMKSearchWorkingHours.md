---
title: "YMKSearchWorkingHours"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchWorkingHours"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchWorkingHours.html"
---
# YMKSearchWorkingHours

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchWorkingHours.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchWorkingHours : NSObject
```

Open hours for an organization.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchWorkingHours *)workingHoursWithText:(nonnull NSString *)text
                                         availabilities:(nonnull NSArray<YMKSearchAvailability *> *)availabilities
                                                  state:(nullable YMKSearchWorkingHoursState *)state;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Human-readable localized open hours description

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchAvailability *> *availabilities;
```

Structured open hours information

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHoursState *state;
```

Current company working status

Optional field, can be nil

## Class methods

### workingHoursWithText:availabilities:state:

```objectivec
+ (nonnull YMKSearchWorkingHours *)workingHoursWithText:(nonnull NSString *)text
                                         availabilities:(nonnull NSArray<YMKSearchAvailability *> *)availabilities
                                                  state:(nullable YMKSearchWorkingHoursState *)state;
```

## Properties

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Human-readable localized open hours description.

### availabilities

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchAvailability *> *availabilities;
```

Structured open hours information.

### state

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHoursState *state;
```

Current company working status

Optional field, can be nil.
