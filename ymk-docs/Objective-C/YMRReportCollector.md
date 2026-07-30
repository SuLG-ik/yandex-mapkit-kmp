---
title: "YMRReportCollector"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMRReportCollector"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMRReportCollector.html"
---
# YMRReportCollector

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMRReportCollector.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMRReportCollector : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull NSArray<YMRReportData *> *)reports;
```

Get all stored reports

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### reports

```objectivec
- (nonnull NSArray<YMRReportData *> *)reports;
```

Get all stored reports. The reports are not stored forever. There is an internal limit on the total size of all reports so older reports will be removed if space is needed for a newer report. The reports are sorted by their start time: the oldest report is first, the newest is last.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
