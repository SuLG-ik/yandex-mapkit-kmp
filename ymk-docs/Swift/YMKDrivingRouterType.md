---
title: "YMKDrivingRouterType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKDrivingRouterType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouterType.html"
---
# YMKDrivingRouterType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouterType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKDrivingRouterType : UInt, @unchecked Sendable
```

Driving router type.

## Summary

### Enum cases

```swift
case online = 0
```

Online driving router

```swift
case offline = 1
```

Offline driving router

```swift
case combined = 2
```

Combined driving router

## Enum cases

### online

```swift
case online = 0
```

Online driving router. Always tries to use online router even if network is not available.

### offline

```swift
case offline = 1
```

Offline driving router. Always tries to use offline router even if network is available.

### combined

```swift
case combined = 2
```

Combined driving router. Decision to use online or offline router is based on internal timeout. If server manages to respond within given time, then online router result is returned. Otherwise uses offline router. Will combine online and offline router result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline router is returned to the listener. After that timeout is reduced to zero for all following resubmits.
