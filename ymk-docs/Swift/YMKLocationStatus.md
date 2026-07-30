---
title: "YMKLocationStatus"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKLocationStatus"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationStatus.html"
---
# YMKLocationStatus

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationStatus.html)

```swift
enum YMKLocationStatus : UInt, @unchecked Sendable
```

Defines if the location is available or not.

## Summary

### Enum cases

```swift
case notAvailable = 0
```

Location is not available

```swift
case available = 1
```

Location is available

```swift
case reset = 2
```

Global location manager has been changed

## Enum cases

### notAvailable

```swift
case notAvailable = 0
```

Location is not available.

### available

```swift
case available = 1
```

Location is available.

### reset

```swift
case reset = 2
```

Global location manager has been changed. Clients need to reset any state and checks related to location.
