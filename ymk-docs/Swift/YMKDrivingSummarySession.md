---
title: "YMKDrivingSummarySession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingSummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSummarySession.html"
---
# YMKDrivingSummarySession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingSummarySession : NSObject
```

Driving session summary.

## Summary

### Instance methods

```swift
func cancel()
```

Cancels route summary generation

```swift
func retry(summaryHandler: @escaping YMKDrivingSummarySessionSummaryHandler)
```

Tries to generate a driving session summary again

## Instance methods

### cancel()

```swift
func cancel()
```

Cancels route summary generation.

### retry(summaryHandler:)

```swift
func retry(summaryHandler: @escaping YMKDrivingSummarySessionSummaryHandler)
```

Tries to generate a driving session summary again.
