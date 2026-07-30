---
title: "YMKSearchFeatureSet"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFeatureSet"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureSet.html"
---
# YMKSearchFeatureSet

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureSet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFeatureSet : NSObject
```

Collection of features.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFeatureSet *)featureSetWithIds:(nonnull NSArray<NSString *> *)ids;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for features in the collection

## Class methods

### featureSetWithIds:

```objectivec
+ (nonnull YMKSearchFeatureSet *)featureSetWithIds:(nonnull NSArray<NSString *> *)ids;
```

## Properties

### ids

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for features in the collection.
