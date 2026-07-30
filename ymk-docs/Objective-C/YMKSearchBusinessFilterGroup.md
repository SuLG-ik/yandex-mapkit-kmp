---
title: "YMKSearchBusinessFilterGroup"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilterGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterGroup.html"
---
# YMKSearchBusinessFilterGroup

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilterGroup : NSObject
```

Group of filters.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilterGroup *)businessFilterGroupWithName:(nullable NSString *)name
                                                            filterIds:(nonnull NSArray<NSString *> *)filterIds;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Group name

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *filterIds;
```

IDs for filters in the group

## Class methods

### businessFilterGroupWithName:filterIds:

```objectivec
+ (nonnull YMKSearchBusinessFilterGroup *)businessFilterGroupWithName:(nullable NSString *)name
                                                            filterIds:(nonnull NSArray<NSString *> *)filterIds;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Group name.

Optional field, can be nil.

### filterIds

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *filterIds;
```

IDs for filters in the group.
