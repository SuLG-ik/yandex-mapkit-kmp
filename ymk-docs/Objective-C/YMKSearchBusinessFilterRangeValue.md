---
title: "YMKSearchBusinessFilterRangeValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilterRangeValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterRangeValue.html"
---
# YMKSearchBusinessFilterRangeValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterRangeValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilterRangeValue : NSObject
```

Value for range filters.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilterRangeValue *)rangeValueWithFrom:( double)from
                                                               to:( double)to;
```

### Properties

```objectivec
@property (nonatomic, readonly) double from;
```

Minimum allowed filter value

```objectivec
@property (nonatomic, readonly) double to;
```

Maximum allowed filter value

## Class methods

### rangeValueWithFrom:to:

```objectivec
+ (nonnull YMKSearchBusinessFilterRangeValue *)rangeValueWithFrom:( double)from
                                                               to:( double)to;
```

## Properties

### from

```objectivec
@property (nonatomic, readonly) double from;
```

Minimum allowed filter value.

### to

```objectivec
@property (nonatomic, readonly) double to;
```

Maximum allowed filter value.
