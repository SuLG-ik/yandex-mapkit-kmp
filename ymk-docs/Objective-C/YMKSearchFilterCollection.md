---
title: "YMKSearchFilterCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFilterCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollection.html"
---
# YMKSearchFilterCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFilterCollection : NSObject
```

Filters for search request. Use builder to setup this class.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFilterCollection *)filterCollectionWithBooleanFilters:(nonnull NSArray<NSString *> *)booleanFilters
                                                              enumFilters:(nonnull NSDictionary<NSString *, NSArray<NSString *> *> *)enumFilters
                                                             rangeFilters:(nonnull NSDictionary<NSString *, YMKSearchFilterCollectionNumberRange *> *)rangeFilters
                                                              dateFilters:(nonnull NSDictionary<NSString *, YMKSearchFilterCollectionDateRange *> *)dateFilters;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *booleanFilters;
```

List of boolean filter ids to be set

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSArray<NSString *> *> *enumFilters;
```

Mapping of enum filter ids to list of enum value ids

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKSearchFilterCollectionNumberRange *>
        *rangeFilters;
```

Mapping of range filter ids to number range

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKSearchFilterCollectionDateRange *> *dateFilters;
```

Mapping of date filter ids to date range

## Class methods

### filterCollectionWithBooleanFilters:enumFilters:rangeFilters:dateFilters:

```objectivec
+ (nonnull YMKSearchFilterCollection *)filterCollectionWithBooleanFilters:(nonnull NSArray<NSString *> *)booleanFilters
                                                              enumFilters:(nonnull NSDictionary<NSString *, NSArray<NSString *> *> *)enumFilters
                                                             rangeFilters:(nonnull NSDictionary<NSString *, YMKSearchFilterCollectionNumberRange *> *)rangeFilters
                                                              dateFilters:(nonnull NSDictionary<NSString *, YMKSearchFilterCollectionDateRange *> *)dateFilters;
```

## Properties

### booleanFilters

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *booleanFilters;
```

List of boolean filter ids to be set.

### enumFilters

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSArray<NSString *> *> *enumFilters;
```

Mapping of enum filter ids to list of enum value ids.

### rangeFilters

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKSearchFilterCollectionNumberRange *>
        *rangeFilters;
```

Mapping of range filter ids to number range.

### dateFilters

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKSearchFilterCollectionDateRange *> *dateFilters;
```

Mapping of date filter ids to date range.
