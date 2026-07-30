---
title: "YMKAddressCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAddressCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressCollection.html"
---
# YMKAddressCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressCollection.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAddressCollection : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAddressCollection *)addressCollectionWithTitle:(nonnull NSString *)title
                                                 description:(nullable NSString *)description
                                                     records:(nonnull NSArray<YMKAddressRecord *> *)records;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKAddressRecord *> *records;
```

## Class methods

### addressCollectionWithTitle:description:records:

```objectivec
+ (nonnull YMKAddressCollection *)addressCollectionWithTitle:(nonnull NSString *)title
                                                 description:(nullable NSString *)description
                                                     records:(nonnull NSArray<YMKAddressRecord *> *)records;
```

## Properties

### title

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

### description

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Optional field, can be nil.

### records

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKAddressRecord *> *records;
```
