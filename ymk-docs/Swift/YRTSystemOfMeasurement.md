---
title: "YRTSystemOfMeasurement"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YRTSystemOfMeasurement"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTSystemOfMeasurement.html"
---
# YRTSystemOfMeasurement

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTSystemOfMeasurement.html)

```swift
enum YRTSystemOfMeasurement : UInt, @unchecked Sendable
```

The .h generated from this idl should define the same entities as libs/i18n/include/yandex/maps/i18n/prefs.h from the mapscore repo. Please edit these two files simultaneously. The system of measurement to use.

## Summary

### Enum cases

```swift
case `default` = 0
```

```swift
case metric = 1
```

Metric system

```swift
case imperial = 2
```

Imperial system

## Enum cases

### default

```swift
case `default` = 0
```

### metric

```swift
case metric = 1
```

Metric system. (kilometers etc)

### imperial

```swift
case imperial = 2
```

Imperial system. (miles etc)
