---
title: "YMKSearchFeatureGroup"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFeatureGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureGroup.html"
---
# YMKSearchFeatureGroup

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFeatureGroup : NSObject
```

Group of features.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFeatureGroup *)featureGroupWithName:(nullable NSString *)name
                                                    ids:(nonnull NSArray<NSString *> *)ids;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Group name

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for features in the group

## Class methods

### featureGroupWithName:ids:

```objectivec
+ (nonnull YMKSearchFeatureGroup *)featureGroupWithName:(nullable NSString *)name
                                                    ids:(nonnull NSArray<NSString *> *)ids;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Group name.

Optional field, can be nil.

### ids

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *ids;
```

IDs for features in the group.
