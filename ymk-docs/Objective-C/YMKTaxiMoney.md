---
title: "YMKTaxiMoney"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTaxiMoney"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTaxiMoney.html"
---
# YMKTaxiMoney

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTaxiMoney.html)

```objectivec
@interface YMKTaxiMoney : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKTaxiMoney *)moneyWithValue:( double)value
                                    text:(nonnull NSString *)text
                                currency:(nonnull NSString *)currency;
```

### Properties

```objectivec
@property (nonatomic, readonly) double value;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSString *currency;
```

## Class methods

### moneyWithValue:text:currency:

```objectivec
+ (nonnull YMKTaxiMoney *)moneyWithValue:( double)value
                                    text:(nonnull NSString *)text
                                currency:(nonnull NSString *)currency;
```

## Properties

### value

```objectivec
@property (nonatomic, readonly) double value;
```

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

### currency

```objectivec
@property (nonatomic, readonly, nonnull) NSString *currency;
```
