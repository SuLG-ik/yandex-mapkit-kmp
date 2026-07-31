---
title: "YMKConflictResolutionMode"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKConflictResolutionMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKConflictResolutionMode.html"
---
# YMKConflictResolutionMode

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKConflictResolutionMode.html)

```objectivec
enum YMKConflictResolutionMode : NSUInteger {}
```

Determines how feature participates in conflict resolution.

## Summary

### Enum cases

```objectivec
YMKConflictResolutionModeMinor
```

Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features

```objectivec
YMKConflictResolutionModeEqual
```

Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features

```objectivec
YMKConflictResolutionModeMajor
```

Feature can NOT be hidden but can displace lower features

```objectivec
YMKConflictResolutionModeIgnore
```

Feature doesn't participate in conflict resolution

## Enum cases

### YMKConflictResolutionModeMinor

```objectivec
YMKConflictResolutionModeMinor
```

Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features.

### YMKConflictResolutionModeEqual

```objectivec
YMKConflictResolutionModeEqual
```

Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features.

### YMKConflictResolutionModeMajor

```objectivec
YMKConflictResolutionModeMajor
```

Feature can NOT be hidden but can displace lower features.

### YMKConflictResolutionModeIgnore

```objectivec
YMKConflictResolutionModeIgnore
```

Feature doesn't participate in conflict resolution.
