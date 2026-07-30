---
title: "YMKDummyLocationQuality"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKDummyLocationQuality"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDummyLocationQuality.html"
---
# YMKDummyLocationQuality

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDummyLocationQuality.html)

```objectivec
enum YMKDummyLocationQuality : NSUInteger {}
```

The overall current quality of locations.

This is used to switch MapKit between different operating modes. If the locations are of high-quality and frequent (1 Hz), then specify 'High'; otherwise, specify 'Low'.

It is strongly recommended not to change it often, e.g., every location.

## Summary

### Enum cases

```objectivec
YMKDummyLocationQualityHigh
```

```objectivec
YMKDummyLocationQualityLow
```

## Enum cases

### YMKDummyLocationQualityHigh

```objectivec
YMKDummyLocationQualityHigh
```

### YMKDummyLocationQualityLow

```objectivec
YMKDummyLocationQualityLow
```
