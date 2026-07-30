---
title: "YMKMasstransitSectionPaymentOption"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSectionPaymentOption"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionPaymentOption.html"
---
# YMKMasstransitSectionPaymentOption

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionPaymentOption.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSectionPaymentOption : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitSectionPaymentOption *)sectionPaymentOptionWithPayment:(nullable YMKMasstransitPayment *)payment
                                                                    appliedFare:( YMKMasstransitSectionPaymentOptionAppliedFare)appliedFare;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitPayment *payment;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly)
    YMKMasstransitSectionPaymentOptionAppliedFare appliedFare;
```

## Class methods

### sectionPaymentOptionWithPayment:appliedFare:

```objectivec
+ (nonnull YMKMasstransitSectionPaymentOption *)sectionPaymentOptionWithPayment:(nullable YMKMasstransitPayment *)payment
                                                                    appliedFare:( YMKMasstransitSectionPaymentOptionAppliedFare)appliedFare;
```

## Properties

### payment

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitPayment *payment;
```

Optional field, can be nil.

### appliedFare

```objectivec
@property (nonatomic, readonly)
    YMKMasstransitSectionPaymentOptionAppliedFare appliedFare;
```
