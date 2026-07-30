---
title: "YMKSearchPropertiesItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPropertiesItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPropertiesItem.html"
---
# YMKSearchPropertiesItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPropertiesItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPropertiesItem : NSObject
```

Single property item.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPropertiesItem *)itemWithKey:(nonnull NSString *)key
                                           value:(nonnull NSString *)value;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *key;
```

Item key

```objectivec
@property (nonatomic, readonly, nonnull) NSString *value;
```

Item value

## Class methods

### itemWithKey:value:

```objectivec
+ (nonnull YMKSearchPropertiesItem *)itemWithKey:(nonnull NSString *)key
                                           value:(nonnull NSString *)value;
```

## Properties

### key

```objectivec
@property (nonatomic, readonly, nonnull) NSString *key;
```

Item key.

### value

```objectivec
@property (nonatomic, readonly, nonnull) NSString *value;
```

Item value.
