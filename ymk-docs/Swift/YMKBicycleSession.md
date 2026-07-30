---
title: "YMKBicycleSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSession.html"
---
# YMKBicycleSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleSession : NSObject
```

Handler for an async request for bicycle routes.

## Summary

### Instance methods

```swift
func cancel()
```

Tries to cancel the current request for bicycle routes

```swift
func retry(routeListener: @escaping YMKBicycleSessionRouteListener)
```

Retries the request for bicycle routes using the specified callback

## Instance methods

### cancel()

```swift
func cancel()
```

Tries to cancel the current request for bicycle routes.

### retry(routeListener:)

```swift
func retry(routeListener: @escaping YMKBicycleSessionRouteListener)
```

Retries the request for bicycle routes using the specified callback.
