---
title: "YMKBicycleSummarySession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleSummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSummarySession.html"
---
# YMKBicycleSummarySession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleSummarySession : NSObject
```

Handler for an async request for a summary of bicycle routes.

## Summary

### Instance methods

```swift
func cancel()
```

Tries to cancel the current request for a summary of mass transit routes

```swift
func retry(summaryHandler: @escaping YMKBicycleSummarySessionSummaryHandler)
```

Retries the request for a summary of mass transit routes, using the specified callback

## Instance methods

### cancel()

```swift
func cancel()
```

Tries to cancel the current request for a summary of mass transit routes.

### retry(summaryHandler:)

```swift
func retry(summaryHandler: @escaping YMKBicycleSummarySessionSummaryHandler)
```

Retries the request for a summary of mass transit routes, using the specified callback.
