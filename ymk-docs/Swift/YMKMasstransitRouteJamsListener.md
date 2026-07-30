---
title: "YMKMasstransitRouteJamsListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMasstransitRouteJamsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteJamsListener.html"
---
# YMKMasstransitRouteJamsListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteJamsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKMasstransitRouteJamsListener : NSObjectProtocol
```

A listener to monitor changes to traffic jams on the route.

## Summary

### Instance methods

```swift
func onJamsUpdated(with route: YMKMasstransitRoute)
```

Triggered when traffic jams are updated

```swift
func onJamsOutdated(with route: YMKMasstransitRoute)
```

Triggered when traffic jams are outdated

## Instance methods

### onJamsUpdated(with:)

```swift
func onJamsUpdated(with route: YMKMasstransitRoute)
```

Triggered when traffic jams are updated.

### onJamsOutdated(with:)

```swift
func onJamsOutdated(with route: YMKMasstransitRoute)
```

Triggered when traffic jams are outdated.
