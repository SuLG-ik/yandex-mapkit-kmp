---
title: "YMKAddressBook"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAddressBook"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBook.html"
---
# YMKAddressBook

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBook.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAddressBook : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAddressBook *)addressBookWithHome:(nullable YMKAddressRecord *)home
                                           work:(nullable YMKAddressRecord *)work
                                      favorites:(nonnull NSArray<YMKAddressRecord *> *)favorites
                              customCollections:(nonnull NSArray<YMKAddressCollection *> *)customCollections;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKAddressRecord *home;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKAddressRecord *work;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKAddressRecord *> *favorites;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKAddressCollection *> *customCollections;
```

## Class methods

### addressBookWithHome:work:favorites:customCollections:

```objectivec
+ (nonnull YMKAddressBook *)addressBookWithHome:(nullable YMKAddressRecord *)home
                                           work:(nullable YMKAddressRecord *)work
                                      favorites:(nonnull NSArray<YMKAddressRecord *> *)favorites
                              customCollections:(nonnull NSArray<YMKAddressCollection *> *)customCollections;
```

## Properties

### home

```objectivec
@property (nonatomic, readonly, nullable) YMKAddressRecord *home;
```

Optional field, can be nil.

### work

```objectivec
@property (nonatomic, readonly, nullable) YMKAddressRecord *work;
```

Optional field, can be nil.

### favorites

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKAddressRecord *> *favorites;
```

### customCollections

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKAddressCollection *> *customCollections;
```
