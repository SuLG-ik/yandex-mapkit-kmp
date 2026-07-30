---
title: "YMKMasstransitRouteSerializer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteSerializer.html"
---
# YMKMasstransitRouteSerializer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouteSerializer : NSObject
```

## Summary

### Instance methods

```swift
func save(with route: YMKMasstransitRoute) -> Data
```

Serializes the route

```swift
func load(with data: Data) -> YMKMasstransitRoute?
```

Deserializes the route

## Instance methods

### save(with:)

```swift
func save(with route: YMKMasstransitRoute) -> Data
```

Serializes the route.

**Returns**

Route's serialized representation. Empty array in case of any

errors.

### load(with:)

```swift
func load(with data: Data) -> YMKMasstransitRoute?
```

Deserializes the route.

**Returns**

Deserialized Route. Null in case of any errors.
