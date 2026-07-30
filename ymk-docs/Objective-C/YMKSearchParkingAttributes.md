---
title: "YMKSearchParkingAttributes"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchParkingAttributes"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchParkingAttributes.html"
---
# YMKSearchParkingAttributes

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchParkingAttributes.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchParkingAttributes : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchParkingAttributes *)parkingAttributesWithOrgURI:(nullable NSString *)orgURI
                                                     firstHourPrice:(nullable YMKTaxiMoney *)firstHourPrice
                                                        placesCount:(nullable NSNumber *)placesCount;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *orgURI;
```

Parking organization URI

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *firstHourPrice;
```

Price of the first hour

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *placesCount;
```

Maximum number of parking places (capacity)

## Class methods

### parkingAttributesWithOrgURI:firstHourPrice:placesCount:

```objectivec
+ (nonnull YMKSearchParkingAttributes *)parkingAttributesWithOrgURI:(nullable NSString *)orgURI
                                                     firstHourPrice:(nullable YMKTaxiMoney *)firstHourPrice
                                                        placesCount:(nullable NSNumber *)placesCount;
```

## Properties

### orgURI

```objectivec
@property (nonatomic, readonly, nullable) NSString *orgURI;
```

Parking organization URI. For example, parking zone or any toll area or inside building parking.

Optional field, can be nil.

### firstHourPrice

```objectivec
@property (nonatomic, readonly, nullable) YMKTaxiMoney *firstHourPrice;
```

Price of the first hour.

Optional field, can be nil.

### placesCount

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *placesCount;
```

Maximum number of parking places (capacity).

Optional field, can be nil.
