---
title: "YMKTrafficDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKTrafficDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTrafficDelegate.html"
---
# YMKTrafficDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTrafficDelegate.html)

```swift
protocol YMKTrafficDelegate : NSObjectProtocol
```

Listener to handle traffic information.

## Summary

### Instance methods

```swift
func onTrafficChanged(with trafficLevel: YMKTrafficLevel?)
```

Triggered when traffic level changes

```swift
func onTrafficLoading()
```

Triggered when traffic information is loading

```swift
func onTrafficExpired()
```

Triggered when traffic information expires

## Instance methods

### onTrafficChanged(with:)

```swift
func onTrafficChanged(with trafficLevel: YMKTrafficLevel?)
```

Triggered when traffic level changes.

### onTrafficLoading()

```swift
func onTrafficLoading()
```

Triggered when traffic information is loading.

### onTrafficExpired()

```swift
func onTrafficExpired()
```

Triggered when traffic information expires.
