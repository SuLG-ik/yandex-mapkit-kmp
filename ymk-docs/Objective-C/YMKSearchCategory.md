---
title: "YMKSearchCategory"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchCategory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCategory.html"
---
# YMKSearchCategory

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCategory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchCategory : NSObject
```

Single category (also known as rubric) description.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchCategory *)categoryWithName:(nonnull NSString *)name
                                  categoryClass:(nullable NSString *)categoryClass
                                           tags:(nonnull NSArray<NSString *> *)tags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Category name

```objectivec
@property (nonatomic, readonly, nullable) NSString *categoryClass;
```

Category class

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Additional non-structured data for the category

## Class methods

### categoryWithName:categoryClass:tags:

```objectivec
+ (nonnull YMKSearchCategory *)categoryWithName:(nonnull NSString *)name
                                  categoryClass:(nullable NSString *)categoryClass
                                           tags:(nonnull NSArray<NSString *> *)tags;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Category name.

### categoryClass

```objectivec
@property (nonatomic, readonly, nullable) NSString *categoryClass;
```

Category class. Different categories can have the same class. For example, "Bar", "Cafe" and "Restaurant" categories inhabit "restaurants" category class.

Optional field, can be nil.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Additional non-structured data for the category.
