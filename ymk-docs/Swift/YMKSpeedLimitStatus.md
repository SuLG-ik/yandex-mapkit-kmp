---
title: "YMKSpeedLimitStatus"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSpeedLimitStatus"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedLimitStatus.html"
---
# YMKSpeedLimitStatus

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedLimitStatus.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
enum YMKSpeedLimitStatus : UInt, @unchecked Sendable
```

## Summary

### Enum cases

```swift
case belowLimit = 0
```

Speed limit is not exceeded

```swift
case strictLimitExceeded = 1
```

Speed limit exceeded

```swift
case tolerantLimitExceeded = 2
```

Speed limit exceeded by tolerance

## Enum cases

### belowLimit

```swift
case belowLimit = 0
```

Speed limit is not exceeded

### strictLimitExceeded

```swift
case strictLimitExceeded = 1
```

Speed limit exceeded

### tolerantLimitExceeded

```swift
case tolerantLimitExceeded = 2
```

Speed limit exceeded by tolerance
