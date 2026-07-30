---
title: "YMKMasstransitIndoorLevel"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitIndoorLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorLevel.html"
---
# YMKMasstransitIndoorLevel

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitIndoorLevel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitIndoorLevel : NSObject
```

Indoor level (floor).

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitIndoorLevel *)indoorLevelWithLevelId:(nonnull NSString *)levelId
                                                    levelName:(nonnull NSString *)levelName;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *levelId;
```

Level id that can be passed to the Router

```objectivec
@property (nonatomic, readonly, nonnull) NSString *levelName;
```

Localized level name

## Class methods

### indoorLevelWithLevelId:levelName:

```objectivec
+ (nonnull YMKMasstransitIndoorLevel *)indoorLevelWithLevelId:(nonnull NSString *)levelId
                                                    levelName:(nonnull NSString *)levelName;
```

## Properties

### levelId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *levelId;
```

Level id that can be passed to the Router.

### levelName

```objectivec
@property (nonatomic, readonly, nonnull) NSString *levelName;
```

Localized level name.
