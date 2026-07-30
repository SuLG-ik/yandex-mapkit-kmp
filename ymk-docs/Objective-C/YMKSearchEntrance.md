---
title: "YMKSearchEntrance"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchEntrance"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchEntrance.html"
---
# YMKSearchEntrance

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchEntrance.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchEntrance : NSObject
```

An entrance to a building

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchEntrance *)entranceWithName:(nullable NSString *)name
                                          point:(nonnull YMKPoint *)point
                                      direction:(nullable YMKDirection *)direction;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDirection *direction;
```

Optional field, can be nil

## Class methods

### entranceWithName:point:direction:

```objectivec
+ (nonnull YMKSearchEntrance *)entranceWithName:(nullable NSString *)name
                                          point:(nonnull YMKPoint *)point
                                      direction:(nullable YMKDirection *)direction;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Optional field, can be nil.

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

### direction

```objectivec
@property (nonatomic, readonly, nullable) YMKDirection *direction;
```

Optional field, can be nil.
