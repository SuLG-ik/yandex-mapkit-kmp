---
title: "YMKImageSize"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKImageSize"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImageSize.html"
---
# YMKImageSize

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImageSize.html)

```objectivec
@interface YMKImageSize : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKImageSize *)sizeWithSize:(nonnull NSString *)size
                                 width:(nullable NSNumber *)width
                                height:(nullable NSNumber *)height;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *size;
```

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *width;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *height;
```

Optional field, can be nil

## Class methods

### sizeWithSize:width:height:

```objectivec
+ (nonnull YMKImageSize *)sizeWithSize:(nonnull NSString *)size
                                 width:(nullable NSNumber *)width
                                height:(nullable NSNumber *)height;
```

## Properties

### size

```objectivec
@property (nonatomic, readonly, nonnull) NSString *size;
```

### width

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *width;
```

Optional field, can be nil.

### height

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *height;
```

Optional field, can be nil.
