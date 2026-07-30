---
title: "YMKOfflineCacheRegionListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKOfflineCacheRegionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegionListener.html"
---
# YMKOfflineCacheRegionListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegionListener.html)

```swift
protocol YMKOfflineCacheRegionListener : NSObjectProtocol
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Listener to handle region information.

## Summary

### Instance methods

```swift
func onRegionStateChanged(withRegionId regionId: UInt)
```

Region state was changed

```swift
func onRegionProgress(withRegionId regionId: UInt)
```

Progress of specific region download was updated

## Instance methods

### onRegionStateChanged(withRegionId:)

```swift
func onRegionStateChanged(withRegionId regionId: UInt)
```

Region state was changed.

### onRegionProgress(withRegionId:)

```swift
func onRegionProgress(withRegionId regionId: UInt)
```

Progress of specific region download was updated.
