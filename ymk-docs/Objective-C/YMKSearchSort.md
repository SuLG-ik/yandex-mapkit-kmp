---
title: "YMKSearchSort"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchSort"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSort.html"
---
# YMKSearchSort

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSort.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchSort : NSObject
```

Describes response sort.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchSort *)sortWithType:( YMKSearchSortType)type
                                 origin:(nullable NSNumber *)origin;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKSearchSortType type;
```

Sorting type

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *origin;
```

Sort origin (if results are ordered by distance)

## Class methods

### sortWithType:origin:

```objectivec
+ (nonnull YMKSearchSort *)sortWithType:( YMKSearchSortType)type
                                 origin:(nullable NSNumber *)origin;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKSearchSortType type;
```

Sorting type.

### origin

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *origin;
```

Sort origin (if results are ordered by distance).

Optional field, can be nil.
