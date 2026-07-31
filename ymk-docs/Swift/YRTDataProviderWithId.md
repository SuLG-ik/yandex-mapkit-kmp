---
title: "YRTDataProviderWithId"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YRTDataProviderWithId"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTDataProviderWithId.html"
---
# YRTDataProviderWithId

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTDataProviderWithId.html)

```swift
protocol YRTDataProviderWithId : NSObjectProtocol
```

Provides any data.

## Summary

### Instance methods

```swift
func providerId() -> String
```

Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM

```swift
func load() -> Data
```

Returns data

## Instance methods

### providerId()

```swift
func providerId() -> String
```

Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM.

This method may be called on any thread. Its implementation must be thread-safe.

### load()

```swift
func load() -> Data
```

Returns data.

This method will be called on a background thread.
