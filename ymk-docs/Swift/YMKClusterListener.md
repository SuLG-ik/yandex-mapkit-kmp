---
title: "YMKClusterListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKClusterListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterListener.html"
---
# YMKClusterListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterListener.html)

```swift
protocol YMKClusterListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onClusterAdded(with cluster: YMKCluster)
```

This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content

## Instance methods

### onClusterAdded(with:)

```swift
func onClusterAdded(with cluster: YMKCluster)
```

This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content.
