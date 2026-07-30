---
title: "YMKPersonalizedPoiExtraMetadataEntry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPersonalizedPoiExtraMetadataEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPersonalizedPoiExtraMetadataEntry.html"
---
# YMKPersonalizedPoiExtraMetadataEntry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPersonalizedPoiExtraMetadataEntry.html)

```objectivec
@interface YMKPersonalizedPoiExtraMetadataEntry : NSObject <YMKBaseMetadata>
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKPersonalizedPoiExtraMetadataEntry *)personalizedPoiExtraMetadataEntryWithKey:(nullable NSString *)key
                                                                                     value:(nullable NSString *)value;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *key;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *value;
```

Optional field, can be nil

## Class methods

### personalizedPoiExtraMetadataEntryWithKey:value:

```objectivec
+ (nonnull YMKPersonalizedPoiExtraMetadataEntry *)personalizedPoiExtraMetadataEntryWithKey:(nullable NSString *)key
                                                                                     value:(nullable NSString *)value;
```

## Properties

### key

```objectivec
@property (nonatomic, readonly, nullable) NSString *key;
```

Optional field, can be nil.

### value

```objectivec
@property (nonatomic, readonly, nullable) NSString *value;
```

Optional field, can be nil.
