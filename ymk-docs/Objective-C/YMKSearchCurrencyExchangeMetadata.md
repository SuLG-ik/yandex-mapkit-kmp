---
title: "YMKSearchCurrencyExchangeMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchCurrencyExchangeMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCurrencyExchangeMetadata.html"
---
# YMKSearchCurrencyExchangeMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchCurrencyExchangeMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchCurrencyExchangeMetadata : NSObject <YMKBaseMetadata>
```

Currency exchange snippet.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchCurrencyExchangeMetadata *)currencyExchangeMetadataWithCurrencies:(nonnull NSArray<YMKSearchCurrencyExchangeType *> *)currencies;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCurrencyExchangeType *> *currencies;
```

Available currency exchange rates

## Class methods

### currencyExchangeMetadataWithCurrencies:

```objectivec
+ (nonnull YMKSearchCurrencyExchangeMetadata *)currencyExchangeMetadataWithCurrencies:(nonnull NSArray<YMKSearchCurrencyExchangeType *> *)currencies;
```

## Properties

### currencies

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCurrencyExchangeType *> *currencies;
```

Available currency exchange rates.
