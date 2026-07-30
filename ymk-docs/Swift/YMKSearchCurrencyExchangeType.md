---
title: "YMKSearchCurrencyExchangeType"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchCurrencyExchangeType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchCurrencyExchangeType.html"
---
# YMKSearchCurrencyExchangeType

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchCurrencyExchangeType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchCurrencyExchangeType : NSObject
```

Single currency exchange prices.

## Summary

### Class methods

```swift
 init(name: String?, buy: YMKTaxiMoney?, sell: YMKTaxiMoney?)
```

### Properties

```swift
var name: String? { get }
```

ISO-4217 currency name, for example "USD" or "RUB" or "EUR"

```swift
var buy: YMKTaxiMoney? { get }
```

Buy rate

```swift
var sell: YMKTaxiMoney? { get }
```

Sell rate

## Class methods

### init(name:buy:sell:)

```swift
 init(name: String?, buy: YMKTaxiMoney?, sell: YMKTaxiMoney?)
```

## Properties

### name

```swift
var name: String? { get }
```

ISO-4217 currency name, for example "USD" or "RUB" or "EUR".

Optional field, can be nil.

### buy

```swift
var buy: YMKTaxiMoney? { get }
```

Buy rate.

Optional field, can be nil.

### sell

```swift
var sell: YMKTaxiMoney? { get }
```

Sell rate.

Optional field, can be nil.
