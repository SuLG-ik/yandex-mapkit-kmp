---
title: "YMKConflictResolutionMode"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKConflictResolutionMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKConflictResolutionMode.html"
---
# YMKConflictResolutionMode

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKConflictResolutionMode.html)

```swift
enum YMKConflictResolutionMode : UInt, @unchecked Sendable
```

Determines how feature participates in conflict resolution.

## Summary

### Enum cases

```swift
case minor = 0
```

Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features

```swift
case equal = 1
```

Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features

```swift
case major = 2
```

Feature can NOT be hidden but can displace lower features

```swift
case ignore = 3
```

Feature doesn't participate in conflict resolution

## Enum cases

### minor

```swift
case minor = 0
```

Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features.

### equal

```swift
case equal = 1
```

Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features.

### major

```swift
case major = 2
```

Feature can NOT be hidden but can displace lower features.

### ignore

```swift
case ignore = 3
```

Feature doesn't participate in conflict resolution.
