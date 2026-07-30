---
title: "YMKGeoObjectSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeoObjectSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectSession.html"
---
# YMKGeoObjectSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectSession.html)

```swift
class YMKGeoObjectSession : NSObject
```

The interface for working with the session.

## Summary

### Instance methods

```swift
func cancel()
```

Cancels the current request

```swift
func retry(geoObjectHandler: @escaping YMKGeoObjectSessionGeoObjectHandler)
```

Retries the last request

## Instance methods

### cancel()

```swift
func cancel()
```

Cancels the current request.

### retry(geoObjectHandler:)

```swift
func retry(geoObjectHandler: @escaping YMKGeoObjectSessionGeoObjectHandler)
```

Retries the last request. Cancels the current request if it is active.
