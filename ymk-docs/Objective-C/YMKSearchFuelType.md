---
title: "YMKSearchFuelType"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFuelType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFuelType.html"
---
# YMKSearchFuelType

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFuelType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFuelType : NSObject
```

Fuel name and price.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFuelType *)fuelTypeWithName:(nullable NSString *)name
                                          price:(nullable YMKTaxiMoney *)price;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Fuel name

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *price;
```

Fuel price

## Class methods

### fuelTypeWithName:price:

```objectivec
+ (nonnull YMKSearchFuelType *)fuelTypeWithName:(nullable NSString *)name
                                          price:(nullable YMKTaxiMoney *)price;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Fuel name.

Optional field, can be nil.

### price

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *price;
```

Fuel price.

Optional field, can be nil.
