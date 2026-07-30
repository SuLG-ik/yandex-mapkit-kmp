---
title: "YMKSearchAddress"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchAddress"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAddress.html"
---
# YMKSearchAddress

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAddress.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchAddress : NSObject
```

Contains structured address, formatted address, postal code and country code.

Structured address is an ordered list of components (usually administrative hierarchy). Formatted address is a full address as a single string. Formatted address generally can't be obtained from component names. Some components could be ignored (large administrative region) or absent (office number).

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchAddress *)addressWithFormattedAddress:(nonnull NSString *)formattedAddress
                                           additionalInfo:(nullable NSString *)additionalInfo
                                               postalCode:(nullable NSString *)postalCode
                                              countryCode:(nullable NSString *)countryCode
                                               components:(nonnull NSArray<YMKSearchAddressComponent *> *)components;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *formattedAddress;
```

Human-readable address

```objectivec
@property (nonatomic, readonly, nullable) NSString *additionalInfo;
```

Additional address info

```objectivec
@property (nonatomic, readonly, nullable) NSString *postalCode;
```

Postal/Zip code

```objectivec
@property (nonatomic, readonly, nullable) NSString *countryCode;
```

Country code in ISO 3166-1 alpha-2 format (two-letter country code)

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchAddressComponent *> *components;
```

Address component list, see YMKSearchAddressComponent, may be empty

## Class methods

### addressWithFormattedAddress:additionalInfo:postalCode:countryCode:components:

```objectivec
+ (nonnull YMKSearchAddress *)addressWithFormattedAddress:(nonnull NSString *)formattedAddress
                                           additionalInfo:(nullable NSString *)additionalInfo
                                               postalCode:(nullable NSString *)postalCode
                                              countryCode:(nullable NSString *)countryCode
                                               components:(nonnull NSArray<YMKSearchAddressComponent *> *)components;
```

## Properties

### formattedAddress

```objectivec
@property (nonatomic, readonly, nonnull) NSString *formattedAddress;
```

Human-readable address.

### additionalInfo

```objectivec
@property (nonatomic, readonly, nullable) NSString *additionalInfo;
```

Additional address info.

Optional field, can be nil.

### postalCode

```objectivec
@property (nonatomic, readonly, nullable) NSString *postalCode;
```

Postal/Zip code.

Optional field, can be nil.

### countryCode

```objectivec
@property (nonatomic, readonly, nullable) NSString *countryCode;
```

Country code in ISO 3166-1 alpha-2 format (two-letter country code).

Optional field, can be nil.

### components

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchAddressComponent *> *components;
```

Address component list, see YMKSearchAddressComponent, may be empty.
