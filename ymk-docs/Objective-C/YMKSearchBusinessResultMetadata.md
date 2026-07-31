---
title: "YMKSearchBusinessResultMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessResultMetadata.html"
---
# YMKSearchBusinessResultMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessResultMetadata : NSObject
```

Common info for business search response.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessResultMetadata *)businessResultMetadataWithCategories:(nonnull NSArray<YMKSearchCategory *> *)categories
                                                                           chains:(nonnull NSArray<YMKSearchChain *> *)chains
                                                                  businessFilters:(nonnull NSArray<YMKSearchBusinessFilter *> *)businessFilters
                                                                 importantFilters:(nullable YMKSearchFilterSet *)importantFilters
                                                                     filterGroups:(nonnull NSArray<YMKSearchBusinessFilterGroup *> *)filterGroups
                                                                 pricesCurrencies:(nonnull NSArray<NSString *> *)pricesCurrencies;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCategory *> *categories;
```

List of categories (also known as rubrics) present in response

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchChain *> *chains;
```

List of chains present in response

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessFilter *> *businessFilters;
```

List of applicable filters

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFilterSet *importantFilters;
```

Collection of filters that probably are of utmost interest to the user

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessFilterGroup *> *filterGroups;
```

Grouped BusinessFilter's by their meaning

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *pricesCurrencies;
```

Relevant currency for the prices

## Class methods

### businessResultMetadataWithCategories:chains:businessFilters:importantFilters:filterGroups:pricesCurrencies:

```objectivec
+ (nonnull YMKSearchBusinessResultMetadata *)businessResultMetadataWithCategories:(nonnull NSArray<YMKSearchCategory *> *)categories
                                                                           chains:(nonnull NSArray<YMKSearchChain *> *)chains
                                                                  businessFilters:(nonnull NSArray<YMKSearchBusinessFilter *> *)businessFilters
                                                                 importantFilters:(nullable YMKSearchFilterSet *)importantFilters
                                                                     filterGroups:(nonnull NSArray<YMKSearchBusinessFilterGroup *> *)filterGroups
                                                                 pricesCurrencies:(nonnull NSArray<NSString *> *)pricesCurrencies;
```

## Properties

### categories

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCategory *> *categories;
```

List of categories (also known as rubrics) present in response. Non-empty list means that the request was treated as a 'category request' by the server (for example requests like "where to eat", "cinema", and other).

### chains

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchChain *> *chains;
```

List of chains present in response. Non-empty list means that the request was treaded as 'chain request' (for example "mcdonalds", "starbucks", and other).

### businessFilters

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessFilter *> *businessFilters;
```

List of applicable filters.

### importantFilters

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFilterSet *importantFilters;
```

Collection of filters that probably are of utmost interest to the user.

Optional field, can be nil.

### filterGroups

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessFilterGroup *> *filterGroups;
```

Grouped BusinessFilter's by their meaning.

### pricesCurrencies

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *pricesCurrencies;
```

Relevant currency for the prices
