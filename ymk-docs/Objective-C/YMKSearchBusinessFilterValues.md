---
title: "YMKSearchBusinessFilterValues"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilterValues"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterValues.html"
---
# YMKSearchBusinessFilterValues

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterValues.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilterValues : NSObject
```

Possible filter values.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithBooleans:(nonnull NSArray<YMKSearchBusinessFilterBooleanValue *> *)booleans;
```

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithEnums:(nonnull NSArray<YMKSearchBusinessFilterEnumValue *> *)enums;
```

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithRange:(nonnull YMKSearchBusinessFilterRangeValue *)range;
```

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithDate:(nonnull YMKSearchBusinessFilterDateValue *)date;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchBusinessFilterBooleanValue *> *booleans
```

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchBusinessFilterEnumValue *> *enums
```

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchBusinessFilterRangeValue *range
```

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchBusinessFilterDateValue *date
```

## Class methods

### valuesWithBooleans:

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithBooleans:(nonnull NSArray<YMKSearchBusinessFilterBooleanValue *> *)booleans;
```

### valuesWithEnums:

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithEnums:(nonnull NSArray<YMKSearchBusinessFilterEnumValue *> *)enums;
```

### valuesWithRange:

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithRange:(nonnull YMKSearchBusinessFilterRangeValue *)range;
```

### valuesWithDate:

```objectivec
+ (nonnull YMKSearchBusinessFilterValues *)valuesWithDate:(nonnull YMKSearchBusinessFilterDateValue *)date;
```

## Properties

### booleans

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchBusinessFilterBooleanValue *> *booleans
```

### enums

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchBusinessFilterEnumValue *> *enums
```

### range

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchBusinessFilterRangeValue *range
```

### date

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchBusinessFilterDateValue *date
```
