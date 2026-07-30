---
title: "YMKPanoramaErrorDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaErrorDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaErrorDelegate.html"
---
# YMKPanoramaErrorDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaErrorDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaErrorDelegate : NSObjectProtocol
```

Listener to handle possible errors.

## Summary

### Instance methods

```swift
func onPanoramaOpenError(with player: YMKPanoramaPlayer, error: any Error)
```

Error notification listener for the panoramaOpen class

## Instance methods

### onPanoramaOpenError(with:error:)

```swift
func onPanoramaOpenError(with player: YMKPanoramaPlayer, error: any Error)
```

Error notification listener for the panoramaOpen class. Called if the panorama could not be opened.
