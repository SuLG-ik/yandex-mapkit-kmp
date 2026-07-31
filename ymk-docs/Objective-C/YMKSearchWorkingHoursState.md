---
title: "YMKSearchWorkingHoursState"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchWorkingHoursState"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchWorkingHoursState.html"
---
# YMKSearchWorkingHoursState

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchWorkingHoursState.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchWorkingHoursState : NSObject
```

Describes if an organization is open or closed now.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchWorkingHoursState *)workingHoursStateWithIsOpenNow:(nullable NSNumber *)isOpenNow
                                                                  text:(nullable NSString *)text
                                                             shortText:(nullable NSString *)shortText
                                                                  tags:(nonnull NSArray<NSString *> *)tags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *isOpenNow;
```

Is open right now

```objectivec
@property (nonatomic, readonly, nullable) NSString *text;
```

Human-readable localized description of current state

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortText;
```

Human-readable short localized description of current state

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'

## Class methods

### workingHoursStateWithIsOpenNow:text:shortText:tags:

```objectivec
+ (nonnull YMKSearchWorkingHoursState *)workingHoursStateWithIsOpenNow:(nullable NSNumber *)isOpenNow
                                                                  text:(nullable NSString *)text
                                                             shortText:(nullable NSString *)shortText
                                                                  tags:(nonnull NSArray<NSString *> *)tags;
```

## Properties

### isOpenNow

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *isOpenNow;
```

Is open right now.

Optional field, can be nil.

### text

```objectivec
@property (nonatomic, readonly, nullable) NSString *text;
```

Human-readable localized description of current state.

Optional field, can be nil.

### shortText

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortText;
```

Human-readable short localized description of current state.

Optional field, can be nil.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'. Additional tag values may be added eventually.
