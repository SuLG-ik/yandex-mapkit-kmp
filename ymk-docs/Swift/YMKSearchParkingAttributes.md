---
title: "YMKSearchParkingAttributes"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchParkingAttributes"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchParkingAttributes.html"
---
# YMKSearchParkingAttributes

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchParkingAttributes.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchParkingAttributes : NSObject
```

## Summary

### Class methods

```swift
 init(orgURI: String?, firstHourPrice: YMKTaxiMoney?, placesCount: NSNumber?)
```

### Properties

```swift
var orgURI: String? { get }
```

Parking organization URI

```swift
var firstHourPrice: YMKTaxiMoney? { get }
```

Price of the first hour

```swift
var placesCount: NSNumber? { get }
```

Maximum number of parking places (capacity)

## Class methods

### init(orgURI:firstHourPrice:placesCount:)

```swift
 init(orgURI: String?, firstHourPrice: YMKTaxiMoney?, placesCount: NSNumber?)
```

## Properties

### orgURI

```swift
var orgURI: String? { get }
```

Parking organization URI. For example, parking zone or any toll area or inside building parking.

Optional field, can be nil.

### firstHourPrice

```swift
var firstHourPrice: YMKTaxiMoney? { get }
```

Price of the first hour.

Optional field, can be nil.

### placesCount

```swift
var placesCount: NSNumber? { get }
```

Maximum number of parking places (capacity).

Optional field, can be nil.
