---
title: "YMKSearchCurrencyExchangeType"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchCurrencyExchangeType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCurrencyExchangeType.html"
---
# YMKSearchCurrencyExchangeType

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCurrencyExchangeType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchCurrencyExchangeType : NSObject
```

Single currency exchange prices.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchCurrencyExchangeType *)currencyExchangeTypeWithName:(nullable NSString *)name
                                                                    buy:(nullable YMKTaxiMoney *)buy
                                                                   sell:(nullable YMKTaxiMoney *)sell;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

ISO-4217 currency name, for example "USD" or "RUB" or "EUR"

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *buy;
```

Buy rate

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *sell;
```

Sell rate

## Class methods

### currencyExchangeTypeWithName:buy:sell:

```objectivec
+ (nonnull YMKSearchCurrencyExchangeType *)currencyExchangeTypeWithName:(nullable NSString *)name
                                                                    buy:(nullable YMKTaxiMoney *)buy
                                                                   sell:(nullable YMKTaxiMoney *)sell;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

ISO-4217 currency name, for example "USD" or "RUB" or "EUR".

Optional field, can be nil.

### buy

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *buy;
```

Buy rate.

Optional field, can be nil.

### sell

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *sell;
```

Sell rate.

Optional field, can be nil.
