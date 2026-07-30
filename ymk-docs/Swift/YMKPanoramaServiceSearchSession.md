---
title: "YMKPanoramaServiceSearchSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaServiceSearchSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaServiceSearchSession.html"
---
# YMKPanoramaServiceSearchSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaServiceSearchSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaServiceSearchSession : NSObject
```

Session for receiving the result of the findNearest() method.

Should be stored until the listener is notified. Can be used to cancel the active request. Can be used to retry the last request (for example, if it failed).

## Summary

### Instance methods

```swift
func retry(searchHandler: @escaping YMKPanoramaServiceSearchHandler)
```

Retries the last request

```swift
func cancel()
```

Cancels the active request

## Instance methods

### retry(searchHandler:)

```swift
func retry(searchHandler: @escaping YMKPanoramaServiceSearchHandler)
```

Retries the last request.

### cancel()

```swift
func cancel()
```

Cancels the active request.
