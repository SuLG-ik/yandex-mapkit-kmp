---
title: "YMKLocationDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKLocationDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationDelegate.html"
---
# YMKLocationDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationDelegate.html)

```swift
protocol YMKLocationDelegate : NSObjectProtocol
```

The listener that handles the updates to the device location.

## Summary

### Instance methods

```swift
func onLocationUpdated(with location: YMKLocation)
```

Handle location update information

```swift
func onLocationStatusUpdated(with status: YMKLocationStatus)
```

Handle change in location provider status

## Instance methods

### onLocationUpdated(with:)

```swift
func onLocationUpdated(with location: YMKLocation)
```

Handle location update information.

### onLocationStatusUpdated(with:)

```swift
func onLocationStatusUpdated(with status: YMKLocationStatus)
```

Handle change in location provider status.
