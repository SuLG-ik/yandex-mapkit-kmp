---
title: "YMKSearchProperties"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchProperties"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchProperties.html"
---
# YMKSearchProperties

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchProperties.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchProperties : NSObject
```

Generic key-value property storage.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchProperties *)propertiesWithItems:(nonnull NSArray<YMKSearchPropertiesItem *> *)items;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPropertiesItem *> *items;
```

Property list

## Class methods

### propertiesWithItems:

```objectivec
+ (nonnull YMKSearchProperties *)propertiesWithItems:(nonnull NSArray<YMKSearchPropertiesItem *> *)items;
```

## Properties

### items

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPropertiesItem *> *items;
```

Property list.
