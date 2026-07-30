---
title: "YMKMasstransitRoutePaymentOption"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRoutePaymentOption"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRoutePaymentOption.html"
---
# YMKMasstransitRoutePaymentOption

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRoutePaymentOption.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRoutePaymentOption : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRoutePaymentOption *)routePaymentOptionWithPayment:(nonnull NSArray<YMKMasstransitPayment *> *)payment
                                                                 totalPrice:(nonnull NSArray<YMKTaxiMoney *> *)totalPrice;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitPayment *> *payment;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKTaxiMoney *> *totalPrice;
```

## Class methods

### routePaymentOptionWithPayment:totalPrice:

```objectivec
+ (nonnull YMKMasstransitRoutePaymentOption *)routePaymentOptionWithPayment:(nonnull NSArray<YMKMasstransitPayment *> *)payment
                                                                 totalPrice:(nonnull NSArray<YMKTaxiMoney *> *)totalPrice;
```

## Properties

### payment

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitPayment *> *payment;
```

### totalPrice

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKTaxiMoney *> *totalPrice;
```
