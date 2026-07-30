---
title: "YMKSearchChain"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchChain"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchChain.html"
---
# YMKSearchChain

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchChain.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchChain : NSObject
```

Single chain (group of companies) description.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchChain *)chainWithId:(nonnull NSString *)id
                                   name:(nonnull NSString *)name;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Chain identifier

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Chain name

## Class methods

### chainWithId:name:

```objectivec
+ (nonnull YMKSearchChain *)chainWithId:(nonnull NSString *)id
                                   name:(nonnull NSString *)name;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Chain identifier.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Chain name.
