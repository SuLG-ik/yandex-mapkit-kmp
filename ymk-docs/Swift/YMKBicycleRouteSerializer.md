---
title: "YMKBicycleRouteSerializer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRouteSerializer.html"
---
# YMKBicycleRouteSerializer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleRouteSerializer : NSObject
```

## Summary

### Class methods

```swift
class func save(with route: YMKBicycleRoute) -> Data
```

Returns a route's serialized representation

```swift
class func load(with data: Data) -> YMKBicycleRoute
```

Returns a deserialized route

## Class methods

### save(with:)

```swift
class func save(with route: YMKBicycleRoute) -> Data
```

Returns a route's serialized representation. Returns an empty array if there are any errors.

### load(with:)

```swift
class func load(with data: Data) -> YMKBicycleRoute
```

Returns a deserialized route. Returns null on error.
