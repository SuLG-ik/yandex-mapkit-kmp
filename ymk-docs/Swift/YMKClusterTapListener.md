---
title: "YMKClusterTapListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKClusterTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterTapListener.html"
---
# YMKClusterTapListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterTapListener.html)

```swift
protocol YMKClusterTapListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onClusterTap(with cluster: YMKCluster) -> Bool
```

Called when cluster is tapped

## Instance methods

### onClusterTap(with:)

```swift
func onClusterTap(with cluster: YMKCluster) -> Bool
```

Called when cluster is tapped. Return true if the event was handled. Otherwise it will be passed to underlying objects.
