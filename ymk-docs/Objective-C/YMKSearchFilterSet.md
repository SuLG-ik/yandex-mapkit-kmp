---
title: "YMKSearchFilterSet"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFilterSet"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterSet.html"
---
# YMKSearchFilterSet

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFilterSet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFilterSet : NSObject
```

Collection of filters.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFilterSet *)filterSetWithIds:(nonnull NSArray<NSString *> *)ids;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for filters in the collection

## Class methods

### filterSetWithIds:

```objectivec
+ (nonnull YMKSearchFilterSet *)filterSetWithIds:(nonnull NSArray<NSString *> *)ids;
```

## Properties

### ids

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for filters in the collection.
