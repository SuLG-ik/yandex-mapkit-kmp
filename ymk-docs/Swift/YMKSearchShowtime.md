---
title: "YMKSearchShowtime"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchShowtime"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchShowtime.html"
---
# YMKSearchShowtime

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchShowtime.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchShowtime : NSObject
```

Session details.

## Summary

### Class methods

```swift
 init(start startTime: YMKTime, price: YMKTaxiMoney?, ticketId: String?)
```

### Properties

```swift
var startTime: YMKTime { get }
```

Session start time

```swift
var price: YMKTaxiMoney? { get }
```

Ticket price

```swift
var ticketId: String? { get }
```

Ticket id

## Class methods

### init(start:price:ticketId:)

```swift
 init(start startTime: YMKTime, price: YMKTaxiMoney?, ticketId: String?)
```

## Properties

### startTime

```swift
var startTime: YMKTime { get }
```

Session start time.

### price

```swift
var price: YMKTaxiMoney? { get }
```

Ticket price.

Optional field, can be nil.

### ticketId

```swift
var ticketId: String? { get }
```

Ticket id.

Optional field, can be nil.
