---
title: "YMKSearchSortType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchSortType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSortType.html"
---
# YMKSearchSortType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSortType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchSortType : UInt, @unchecked Sendable
```

Sort type as returned in response.

## Summary

### Enum cases

```swift
case rank = 0
```

Results are ordered by rank (or "goodness")

```swift
case distance = 1
```

Results are ordered by distance from some origin

## Enum cases

### rank

```swift
case rank = 0
```

Results are ordered by rank (or "goodness").

### distance

```swift
case distance = 1
```

Results are ordered by distance from some origin.
