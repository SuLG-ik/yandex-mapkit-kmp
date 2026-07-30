---
title: "YMKSearchFilterCollectionDateRange"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFilterCollectionDateRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionDateRange.html"
---
# YMKSearchFilterCollectionDateRange

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionDateRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFilterCollectionDateRange : NSObject
```

Date range. Dates are encoded as strings in YYYYMMDD format.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFilterCollectionDateRange *)dateRangeWithFrom:(nonnull NSString *)from
                                                               to:(nonnull NSString *)to;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *from;
```

Lower range limit

```objectivec
@property (nonatomic, readonly, nonnull) NSString *to;
```

Upper range limit

## Class methods

### dateRangeWithFrom:to:

```objectivec
+ (nonnull YMKSearchFilterCollectionDateRange *)dateRangeWithFrom:(nonnull NSString *)from
                                                               to:(nonnull NSString *)to;
```

## Properties

### from

```objectivec
@property (nonatomic, readonly, nonnull) NSString *from;
```

Lower range limit.

### to

```objectivec
@property (nonatomic, readonly, nonnull) NSString *to;
```

Upper range limit.
