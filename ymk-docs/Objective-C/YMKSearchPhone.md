---
title: "YMKSearchPhone"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPhone"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPhone.html"
---
# YMKSearchPhone

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPhone.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPhone : NSObject
```

Organization phone.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPhone *)phoneWithType:( YMKSearchPhoneType)type
                          formattedNumber:(nonnull NSString *)formattedNumber
                                     info:(nullable NSString *)info
                                  country:(nullable NSString *)country
                                   prefix:(nullable NSString *)prefix
                                      ext:(nullable NSString *)ext
                                   number:(nullable NSString *)number;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKSearchPhoneType type;
```

Phone type

```objectivec
@property (nonatomic, readonly, nonnull) NSString *formattedNumber;
```

Full phone number as human readable string

```objectivec
@property (nonatomic, readonly, nullable) NSString *info;
```

Some additional info to differentiate multiple phones for single organization

```objectivec
@property (nonatomic, readonly, nullable) NSString *country;
```

Phone country code

```objectivec
@property (nonatomic, readonly, nullable) NSString *prefix;
```

Phone prefix

```objectivec
@property (nonatomic, readonly, nullable) NSString *ext;
```

Phone extension

```objectivec
@property (nonatomic, readonly, nullable) NSString *number;
```

Phone number

## Class methods

### phoneWithType:formattedNumber:info:country:prefix:ext:number:

```objectivec
+ (nonnull YMKSearchPhone *)phoneWithType:( YMKSearchPhoneType)type
                          formattedNumber:(nonnull NSString *)formattedNumber
                                     info:(nullable NSString *)info
                                  country:(nullable NSString *)country
                                   prefix:(nullable NSString *)prefix
                                      ext:(nullable NSString *)ext
                                   number:(nullable NSString *)number;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKSearchPhoneType type;
```

Phone type.

### formattedNumber

```objectivec
@property (nonatomic, readonly, nonnull) NSString *formattedNumber;
```

Full phone number as human readable string.

### info

```objectivec
@property (nonatomic, readonly, nullable) NSString *info;
```

Some additional info to differentiate multiple phones for single organization.

Optional field, can be nil.

### country

```objectivec
@property (nonatomic, readonly, nullable) NSString *country;
```

Phone country code.

Optional field, can be nil.

### prefix

```objectivec
@property (nonatomic, readonly, nullable) NSString *prefix;
```

Phone prefix.

Optional field, can be nil.

### ext

```objectivec
@property (nonatomic, readonly, nullable) NSString *ext;
```

Phone extension.

Optional field, can be nil.

### number

```objectivec
@property (nonatomic, readonly, nullable) NSString *number;
```

Phone number.

Optional field, can be nil.
