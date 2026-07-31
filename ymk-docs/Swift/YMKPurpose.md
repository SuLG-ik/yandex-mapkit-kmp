---
title: "YMKPurpose"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKPurpose"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPurpose.html"
---
# YMKPurpose

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPurpose.html)

```swift
enum YMKPurpose : UInt, @unchecked Sendable
```

## Summary

### Enum cases

```swift
case general = 0
```

This mode uses less resources and is the default

```swift
case automotiveNavigation = 1
```

This mode is used to configure LocationManager for automotive navigation

```swift
case pedestrianNavigation = 2
```

This mode is used to configure LocationManager for pedestrian navigation

```swift
case bicycleNavigation = 3
```

This mode is used to configure LocationManager for bicycle navigation

```swift
case scooterNavigation = 4
```

This mode is used to configure LocationManager for scooter navigation

```swift
case staticDisplayLocation = 5
```

This mode is used to configure LocationManager for show current user location

## Enum cases

### general

```swift
case general = 0
```

This mode uses less resources and is the default.

### automotiveNavigation

```swift
case automotiveNavigation = 1
```

This mode is used to configure LocationManager for automotive navigation. Frequent location updates are desired even though more resources are used.

### pedestrianNavigation

```swift
case pedestrianNavigation = 2
```

This mode is used to configure LocationManager for pedestrian navigation. Frequent location updates are desired even though more resources are used.

### bicycleNavigation

```swift
case bicycleNavigation = 3
```

This mode is used to configure LocationManager for bicycle navigation. Frequent location updates are desired even though more resources are used.

### scooterNavigation

```swift
case scooterNavigation = 4
```

This mode is used to configure LocationManager for scooter navigation. Frequent location updates are desired even though more resources are used.

### staticDisplayLocation

```swift
case staticDisplayLocation = 5
```

This mode is used to configure LocationManager for show current user location. This mode uses less resources and as the default value, but this value turns on location reporting.
