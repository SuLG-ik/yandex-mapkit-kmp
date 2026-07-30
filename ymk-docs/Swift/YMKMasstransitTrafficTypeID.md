---
title: "YMKMasstransitTrafficTypeID"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKMasstransitTrafficTypeID"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTrafficTypeID.html"
---
# YMKMasstransitTrafficTypeID

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTrafficTypeID.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKMasstransitTrafficTypeID : UInt, @unchecked Sendable
```

TrafficTypeID describes who the road is designed for.

## Summary

### Enum cases

```swift
case other = 0
```

Road that is not one of the following types

```swift
case pedestrian = 1
```

Footpath, designed only for pedestrian travel

```swift
case bicycle = 2
```

Bikepath, designed only for bicycle travel

```swift
case auto = 3
```

Road designed for motorized vehicles that might be dangerous for cyclists

## Enum cases

### other

```swift
case other = 0
```

Road that is not one of the following types.

### pedestrian

```swift
case pedestrian = 1
```

Footpath, designed only for pedestrian travel.

### bicycle

```swift
case bicycle = 2
```

Bikepath, designed only for bicycle travel.

### auto

```swift
case auto = 3
```

Road designed for motorized vehicles that might be dangerous for cyclists.
