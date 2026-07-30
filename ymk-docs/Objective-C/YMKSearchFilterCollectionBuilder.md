---
title: "YMKSearchFilterCollectionBuilder"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFilterCollectionBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionBuilder.html"
---
# YMKSearchFilterCollectionBuilder

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterCollectionBuilder.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFilterCollectionBuilder : NSObject
```

Builder for filter collection.

## Summary

### Instance methods

```objectivec
- (void)addBooleanFilterWithFilterId:(nonnull NSString *)filterId;
```

Adds boolean filter with given id to collection

```objectivec
- (void)addEnumFilterWithFilterId:(nonnull NSString *)filterId
                         valueIds:(nonnull NSArray<NSString *> *)valueIds;
```

Adds enum filter with given id and values to the collection

```objectivec
- (void)addRangeFilterWithFilterId:(nonnull NSString *)filterId
                              from:(double)from
                                to:(double)to;
```

Adds range filter with given id and limits to the collection

```objectivec
- (void)addDateFilterWithFilterId:(nonnull NSString *)filterId
                             from:(nonnull NSString *)from
                               to:(nonnull NSString *)to;
```

Adds date filter with given id and limits to the collection

```objectivec
- (nonnull YMKSearchFilterCollection *)build;
```

Builds resulting collection

## Instance methods

### addBooleanFilterWithFilterId:

```objectivec
- (void)addBooleanFilterWithFilterId:(nonnull NSString *)filterId;
```

Adds boolean filter with given id to collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |

### addEnumFilterWithFilterId:valueIds:

```objectivec
- (void)addEnumFilterWithFilterId:(nonnull NSString *)filterId
                         valueIds:(nonnull NSArray<NSString *> *)valueIds;
```

Adds enum filter with given id and values to the collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| valueIds | list of value ids for the enum filter. |

### addRangeFilterWithFilterId:from:to:

```objectivec
- (void)addRangeFilterWithFilterId:(nonnull NSString *)filterId
                              from:(double)from
                                to:(double)to;
```

Adds range filter with given id and limits to the collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| from | lower range limit. |
| to | upper range limit. |

### addDateFilterWithFilterId:from:to:

```objectivec
- (void)addDateFilterWithFilterId:(nonnull NSString *)filterId
                             from:(nonnull NSString *)from
                               to:(nonnull NSString *)to;
```

Adds date filter with given id and limits to the collection. Limits are encoded as strings in YYYYMMDD format.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| from | lower range limit. |
| to | upper range limit. |

### build

```objectivec
- (nonnull YMKSearchFilterCollection *)build;
```

Builds resulting collection.

**Returns**

collection built from previously given filters.
