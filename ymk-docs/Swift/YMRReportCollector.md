---
title: "YMRReportCollector"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMRReportCollector"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMRReportCollector.html"
---
# YMRReportCollector

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMRReportCollector.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMRReportCollector : NSObject
```

## Summary

### Instance methods

```swift
func reports() -> [YMRReportData]
```

Get all stored reports

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### reports()

```swift
func reports() -> [YMRReportData]
```

Get all stored reports. The reports are not stored forever. There is an internal limit on the total size of all reports so older reports will be removed if space is needed for a newer report. The reports are sorted by their start time: the oldest report is first, the newest is last.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
