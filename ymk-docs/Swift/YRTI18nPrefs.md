---
title: "YRTI18nPrefs"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTI18nPrefs"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nPrefs.html"
---
# YRTI18nPrefs

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nPrefs.html)

```swift
class YRTI18nPrefs : NSObject
```

Localization preferences.

## Summary

### Class methods

```swift
class func i18nPrefs(withSom som: YRTSystemOfMeasurement,
                      timeFormat: YRTTimeFormat) -> YRTI18nPrefs
```

### Properties

```swift
var som: YRTSystemOfMeasurement { get }
```

System of measurement (metric or imperial)

```swift
var timeFormat: YRTTimeFormat { get }
```

Time format (12- or 24-hour)

## Class methods

### i18nPrefs(withSom:timeFormat:)

```swift
class func i18nPrefs(withSom som: YRTSystemOfMeasurement,
                      timeFormat: YRTTimeFormat) -> YRTI18nPrefs
```

## Properties

### som

```swift
var som: YRTSystemOfMeasurement { get }
```

System of measurement (metric or imperial).

### timeFormat

```swift
var timeFormat: YRTTimeFormat { get }
```

Time format (12- or 24-hour).
