---
title: "YMKDrivingConditionsListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKDrivingConditionsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingConditionsListener.html"
---
# YMKDrivingConditionsListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingConditionsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKDrivingConditionsListener : NSObjectProtocol
```

A listener to monitor route condition changes.

## Summary

### Instance methods

```swift
func onConditionsUpdated()
```

Triggers when the conditions are updated

```swift
func onConditionsOutdated()
```

Triggers when the conditions are outdated

## Instance methods

### onConditionsUpdated()

```swift
func onConditionsUpdated()
```

Triggers when the conditions are updated.

### onConditionsOutdated()

```swift
func onConditionsOutdated()
```

Triggers when the conditions are outdated.
