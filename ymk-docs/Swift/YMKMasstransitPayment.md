---
title: "YMKMasstransitPayment"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitPayment"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitPayment.html"
---
# YMKMasstransitPayment

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitPayment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitPayment : NSObject
```

## Summary

### Class methods

```swift
 init(paymentMedia: YMKMasstransitPaymentMedia?, price: YMKTaxiMoney)
```

### Properties

```swift
var paymentMedia: YMKMasstransitPaymentMedia? { get }
```

Contains information about the payment media

```swift
var price: YMKTaxiMoney { get }
```

Cost of travel in the vehicle

## Class methods

### init(paymentMedia:price:)

```swift
 init(paymentMedia: YMKMasstransitPaymentMedia?, price: YMKTaxiMoney)
```

## Properties

### paymentMedia

```swift
var paymentMedia: YMKMasstransitPaymentMedia? { get }
```

Contains information about the payment media.

Optional field, can be nil.

### price

```swift
var price: YMKTaxiMoney { get }
```

Cost of travel in the vehicle.
