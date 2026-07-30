---
title: "YMKImagesImageUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKImagesImageUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKImagesImageUrlProvider.html"
---
# YMKImagesImageUrlProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKImagesImageUrlProvider.html)

```swift
protocol YMKImagesImageUrlProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func formatUrl(with descriptor: YMKImagesImageDataDescriptor) -> String
```

Generates an URL that is used to load described image

## Instance methods

### formatUrl(with:)

```swift
func formatUrl(with descriptor: YMKImagesImageDataDescriptor) -> String
```

Generates an URL that is used to load described image.

This method may be called on any thread. Its implementation must be thread-safe.
