---
title: "YMKSearchPrecision"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchPrecision"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPrecision.html"
---
# YMKSearchPrecision

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPrecision.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchPrecision : NSUInteger {}
```

Precision for matching house numbers (response vs. request).

## Summary

### Enum cases

```objectivec
YMKSearchPrecisionExact
```

The house number in the response is exactly the same as requested (3/2 vs

```objectivec
YMKSearchPrecisionNumber
```

The house number in the response has the same number part as the requested one (5 vs

```objectivec
YMKSearchPrecisionRange
```

The house number and coordinates are restored from the house range

```objectivec
YMKSearchPrecisionNearby
```

The house number in the response is close to the requested one (13 vs

## Enum cases

### YMKSearchPrecisionExact

```objectivec
YMKSearchPrecisionExact
```

The house number in the response is exactly the same as requested (3/2 vs. 3/2)

### YMKSearchPrecisionNumber

```objectivec
YMKSearchPrecisionNumber
```

The house number in the response has the same number part as the requested one (5 vs. 5a).

### YMKSearchPrecisionRange

```objectivec
YMKSearchPrecisionRange
```

The house number and coordinates are restored from the house range. This means that there is no information about this specific house, but there is information about a range of houses to infer house position from.

### YMKSearchPrecisionNearby

```objectivec
YMKSearchPrecisionNearby
```

The house number in the response is close to the requested one (13 vs. 11).
