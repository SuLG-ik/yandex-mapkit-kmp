---
title: "YMKSearchSortOrigin"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchSortOrigin"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSortOrigin.html"
---
# YMKSearchSortOrigin

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSortOrigin.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchSortOrigin : UInt, @unchecked Sendable
```

Sort origin types when results are ordered by distance (see YMKSearchSortType).

## Summary

### Enum cases

```swift
case user = 0
```

Sort origin is a user position

```swift
case query = 1
```

Sort origin is a toponym extracted from the user query

```swift
case request = 2
```

Sort origin is directly specified by client

## Enum cases

### user

```swift
case user = 0
```

Sort origin is a user position. User position can be set via {link SearchOptions}.

### query

```swift
case query = 1
```

Sort origin is a toponym extracted from the user query. For example this type can be set for queries like "cafe near Central Park".

### request

```swift
case request = 2
```

Sort origin is directly specified by client. This type can be set for sessions with {link search.Session#setSortByDistance(const mapkit.geometry.Geometry)} called.
