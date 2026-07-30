---
title: "YMKUserData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKUserData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserData.html"
---
# YMKUserData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserData.html)

```objectivec
@interface YMKUserData : NSObject <YMKBaseMetadata>
```

Describes data attached to features in user layer.

## Summary

### Class methods

```objectivec
+ (nonnull YMKUserData *)userDataWithData:(nonnull NSDictionary<NSString *, NSString *> *)data;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSString *> *data;
```

A dictionary of data

## Class methods

### userDataWithData:

```objectivec
+ (nonnull YMKUserData *)userDataWithData:(nonnull NSDictionary<NSString *, NSString *> *)data;
```

## Properties

### data

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSString *> *data;
```

A dictionary of data.
