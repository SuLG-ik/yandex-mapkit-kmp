---
title: "YMKDrivingSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSession.html"
---
# YMKDrivingSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingSession : NSObject
```

Driving session information.

## Summary

### Instance methods

```swift
func cancel()
```

Cancels the driving session

```swift
func retry(routeHandler: @escaping YMKDrivingSessionRouteHandler)
```

Tries to create a driving session again

## Instance methods

### cancel()

```swift
func cancel()
```

Cancels the driving session.

### retry(routeHandler:)

```swift
func retry(routeHandler: @escaping YMKDrivingSessionRouteHandler)
```

Tries to create a driving session again.
