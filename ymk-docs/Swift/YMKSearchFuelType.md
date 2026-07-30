---
title: "YMKSearchFuelType"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFuelType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFuelType.html"
---
# YMKSearchFuelType

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFuelType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFuelType : NSObject
```

Fuel name and price.

## Summary

### Class methods

```swift
 init(name: String?, price: YMKTaxiMoney?)
```

### Properties

```swift
var name: String? { get }
```

Fuel name

```swift
var price: YMKTaxiMoney? { get }
```

Fuel price

## Class methods

### init(name:price:)

```swift
 init(name: String?, price: YMKTaxiMoney?)
```

## Properties

### name

```swift
var name: String? { get }
```

Fuel name.

Optional field, can be nil.

### price

```swift
var price: YMKTaxiMoney? { get }
```

Fuel price.

Optional field, can be nil.
