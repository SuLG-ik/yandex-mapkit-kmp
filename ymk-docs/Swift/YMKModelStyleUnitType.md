---
title: "YMKModelStyleUnitType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKModelStyleUnitType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModelStyleUnitType.html"
---
# YMKModelStyleUnitType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModelStyleUnitType.html)

```swift
enum YMKModelStyleUnitType : UInt, @unchecked Sendable
```

## Summary

### Enum cases

```swift
case unit = 0
```

The model is given in units

```swift
case normalized = 1
```

Scale model proportionally to fit into 1x1x1 box

```swift
case meter = 2
```

The model is given in meters

## Enum cases

### unit

```swift
case unit = 0
```

The model is given in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### normalized

```swift
case normalized = 1
```

Scale model proportionally to fit into 1x1x1 box.

> [!CAUTION] Внимание
> Use UnitType.Unit instead.

### meter

```swift
case meter = 2
```

The model is given in meters.
