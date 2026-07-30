---
title: "YMKOfflineCacheRegionState"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKOfflineCacheRegionState"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegionState.html"
---
# YMKOfflineCacheRegionState

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegionState.html)

```swift
enum YMKOfflineCacheRegionState : UInt, @unchecked Sendable
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

The state of the region.

## Summary

### Enum cases

```swift
case available = 0
```

Available for download on the server

```swift
case downloading = 1
```

Download in progress

```swift
case paused = 2
```

Download is paused

```swift
case completed = 3
```

Cache data installation is finished

```swift
case outdated = 4
```

The region was completed but there is a newer version on the server

```swift
case unsupported = 5
```

The region was removed from regions list and will never be updated

```swift
case needUpdate = 6
```

The region is significantly outdated or it contains invalid data

## Enum cases

### available

```swift
case available = 0
```

Available for download on the server.

### downloading

```swift
case downloading = 1
```

Download in progress.

### paused

```swift
case paused = 2
```

Download is paused.

### completed

```swift
case completed = 3
```

Cache data installation is finished.

### outdated

```swift
case outdated = 4
```

The region was completed but there is a newer version on the server.

### unsupported

```swift
case unsupported = 5
```

The region was removed from regions list and will never be updated

### needUpdate

```swift
case needUpdate = 6
```

The region is significantly outdated or it contains invalid data. OCM will redownload it automatically if autoupdate enabled.
