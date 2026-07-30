---
title: "YMKMasstransitSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSession.html"
---
# YMKMasstransitSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitSession : NSObject
```

Handler for an async request for mass transit routes.

## Summary

### Instance methods

```swift
func cancel()
```

Tries to cancel the current request for mass transit routes

```swift
func retry(routeHandler: @escaping YMKMasstransitSessionRouteHandler)
```

Retries the request for mass transit routes using the specified callback

## Instance methods

### cancel()

```swift
func cancel()
```

Tries to cancel the current request for mass transit routes.

### retry(routeHandler:)

```swift
func retry(routeHandler: @escaping YMKMasstransitSessionRouteHandler)
```

Retries the request for mass transit routes using the specified callback.
