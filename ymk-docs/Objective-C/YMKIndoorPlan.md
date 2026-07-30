---
title: "YMKIndoorPlan"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKIndoorPlan"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorPlan.html"
---
# YMKIndoorPlan

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorPlan.html)

```objectivec
@interface YMKIndoorPlan : NSObject
```

Describes indoor plan of building. Use activeLevelId property to select active level.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKIndoorLevel *> *levels;
```

List of all levels in indoor plan, from bottom to top

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSString *activeLevelId;
```

Gets/sets active id

## Properties

### levels

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKIndoorLevel *> *levels;
```

List of all levels in indoor plan, from bottom to top.

### activeLevelId

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSString *activeLevelId;
```

Gets/sets active id.
