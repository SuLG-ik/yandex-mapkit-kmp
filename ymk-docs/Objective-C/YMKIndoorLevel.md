---
title: "YMKIndoorLevel"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKIndoorLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorLevel.html"
---
# YMKIndoorLevel

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorLevel.html)

```objectivec
@interface YMKIndoorLevel : NSObject
```

Describes level of indoor plan.

## Summary

### Class methods

```objectivec
+ (nonnull YMKIndoorLevel *)indoorLevelWithId:(nonnull NSString *)id
                                         name:(nonnull NSString *)name
                                isUnderground:( BOOL)isUnderground;
```

### Instance methods

```objectivec
- (nonnull YMKIndoorLevel *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Universal identifier of the level

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Localized display name of the level

```objectivec
@property (nonatomic, readonly) BOOL isUnderground;
```

true if level is under ground

## Class methods

### indoorLevelWithId:name:isUnderground:

```objectivec
+ (nonnull YMKIndoorLevel *)indoorLevelWithId:(nonnull NSString *)id
                                         name:(nonnull NSString *)name
                                isUnderground:( BOOL)isUnderground;
```

## Instance methods

### init

```objectivec
- (nonnull YMKIndoorLevel *)init;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Universal identifier of the level.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Localized display name of the level.

### isUnderground

```objectivec
@property (nonatomic, readonly) BOOL isUnderground;
```

true if level is under ground
