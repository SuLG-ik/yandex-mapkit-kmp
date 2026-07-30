---
title: "YMKSearchShowtime"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchShowtime"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchShowtime.html"
---
# YMKSearchShowtime

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchShowtime.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchShowtime : NSObject
```

Session details.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchShowtime *)showtimeWithStartTime:(nonnull YMKTime *)startTime
                                               price:(nullable YMKTaxiMoney *)price
                                            ticketId:(nullable NSString *)ticketId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *startTime;
```

Session start time

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *price;
```

Ticket price

```objectivec
@property (nonatomic, readonly, nullable) NSString *ticketId;
```

Ticket id

## Class methods

### showtimeWithStartTime:price:ticketId:

```objectivec
+ (nonnull YMKSearchShowtime *)showtimeWithStartTime:(nonnull YMKTime *)startTime
                                               price:(nullable YMKTaxiMoney *)price
                                            ticketId:(nullable NSString *)ticketId;
```

## Properties

### startTime

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *startTime;
```

Session start time.

### price

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *price;
```

Ticket price.

Optional field, can be nil.

### ticketId

```objectivec
@property (nonatomic, readonly, nullable) NSString *ticketId;
```

Ticket id.

Optional field, can be nil.
