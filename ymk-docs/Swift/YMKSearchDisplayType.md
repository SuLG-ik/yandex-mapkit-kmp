---
title: "YMKSearchDisplayType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchDisplayType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchDisplayType.html"
---
# YMKSearchDisplayType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchDisplayType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchDisplayType : UInt, @unchecked Sendable
```

Result display type.

## Summary

### Enum cases

```swift
case single = 0
```

Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out

```swift
case multiple = 1
```

Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region

## Enum cases

### single

```swift
case single = 0
```

Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out.

### multiple

```swift
case multiple = 1
```

Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region.
