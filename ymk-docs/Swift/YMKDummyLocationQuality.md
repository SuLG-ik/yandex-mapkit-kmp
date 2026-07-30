---
title: "YMKDummyLocationQuality"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKDummyLocationQuality"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDummyLocationQuality.html"
---
# YMKDummyLocationQuality

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDummyLocationQuality.html)

```swift
enum YMKDummyLocationQuality : UInt, @unchecked Sendable
```

The overall current quality of locations.

This is used to switch MapKit between different operating modes. If the locations are of high-quality and frequent (1 Hz), then specify 'High'; otherwise, specify 'Low'.

It is strongly recommended not to change it often, e.g., every location.

## Summary

### Enum cases

```swift
case high = 0
```

```swift
case low = 1
```

## Enum cases

### high

```swift
case high = 0
```

### low

```swift
case low = 1
```
