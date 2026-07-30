---
title: "YMKMasstransitPayment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitPayment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitPayment.html"
---
# YMKMasstransitPayment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitPayment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitPayment : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitPayment *)paymentWithPaymentMedia:(nullable YMKMasstransitPaymentMedia *)paymentMedia
                                                     price:(nonnull YMKTaxiMoney *)price;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitPaymentMedia *paymentMedia;
```

Contains information about the payment media

```objectivec
@property (nonatomic, readonly, nonnull) YMKTaxiMoney *price;
```

Cost of travel in the vehicle

## Class methods

### paymentWithPaymentMedia:price:

```objectivec
+ (nonnull YMKMasstransitPayment *)paymentWithPaymentMedia:(nullable YMKMasstransitPaymentMedia *)paymentMedia
                                                     price:(nonnull YMKTaxiMoney *)price;
```

## Properties

### paymentMedia

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitPaymentMedia *paymentMedia;
```

Contains information about the payment media.

Optional field, can be nil.

### price

```objectivec
@property (nonatomic, readonly, nonnull) YMKTaxiMoney *price;
```

Cost of travel in the vehicle.
