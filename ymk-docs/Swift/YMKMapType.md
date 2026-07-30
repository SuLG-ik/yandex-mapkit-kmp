---
title: "YMKMapType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKMapType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapType.html"
---
# YMKMapType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapType.html)

```swift
enum YMKMapType : UInt, @unchecked Sendable
```

The type of map displayed.

## Summary

### Enum cases

```swift
case none = 0
```

Do not use any of the predefined maps

```swift
case map = 1
```

Raster map

```swift
case satellite = 2
```

Allowed only for Yandex apps Default satellite map

```swift
case hybrid = 3
```

Allowed only for Yandex apps Satellite map with roads, placemarks and labels

```swift
case vectorMap = 4
```

Vector map

## Enum cases

### none

```swift
case none = 0
```

Do not use any of the predefined maps.

### map

```swift
case map = 1
```

Raster map.

### satellite

```swift
case satellite = 2
```

Allowed only for Yandex apps Default satellite map.

### hybrid

```swift
case hybrid = 3
```

Allowed only for Yandex apps Satellite map with roads, placemarks and labels.

### vectorMap

```swift
case vectorMap = 4
```

Vector map.
