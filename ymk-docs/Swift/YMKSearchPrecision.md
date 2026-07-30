---
title: "YMKSearchPrecision"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchPrecision"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPrecision.html"
---
# YMKSearchPrecision

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPrecision.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchPrecision : UInt, @unchecked Sendable
```

Precision for matching house numbers (response vs. request).

## Summary

### Enum cases

```swift
case exact = 0
```

The house number in the response is exactly the same as requested (3/2 vs

```swift
case number = 1
```

The house number in the response has the same number part as the requested one (5 vs

```swift
case range = 2
```

The house number and coordinates are restored from the house range

```swift
case nearby = 3
```

The house number in the response is close to the requested one (13 vs

## Enum cases

### exact

```swift
case exact = 0
```

The house number in the response is exactly the same as requested (3/2 vs. 3/2)

### number

```swift
case number = 1
```

The house number in the response has the same number part as the requested one (5 vs. 5a).

### range

```swift
case range = 2
```

The house number and coordinates are restored from the house range. This means that there is no information about this specific house, but there is information about a range of houses to infer house position from.

### nearby

```swift
case nearby = 3
```

The house number in the response is close to the requested one (13 vs. 11).
