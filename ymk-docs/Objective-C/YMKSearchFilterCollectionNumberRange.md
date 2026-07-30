---
title: "YMKSearchFilterCollectionNumberRange"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFilterCollectionNumberRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionNumberRange.html"
---
# YMKSearchFilterCollectionNumberRange

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionNumberRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFilterCollectionNumberRange : NSObject
```

Number range. Used for range filter.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFilterCollectionNumberRange *)numberRangeWithFrom:( double)from
                                                                   to:( double)to;
```

### Properties

```objectivec
@property (nonatomic, readonly) double from;
```

Lower range limit

```objectivec
@property (nonatomic, readonly) double to;
```

Upper range limit

## Class methods

### numberRangeWithFrom:to:

```objectivec
+ (nonnull YMKSearchFilterCollectionNumberRange *)numberRangeWithFrom:( double)from
                                                                   to:( double)to;
```

## Properties

### from

```objectivec
@property (nonatomic, readonly) double from;
```

Lower range limit.

### to

```objectivec
@property (nonatomic, readonly) double to;
```

Upper range limit.
