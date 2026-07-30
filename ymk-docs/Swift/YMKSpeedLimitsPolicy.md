---
title: "YMKSpeedLimitsPolicy"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSpeedLimitsPolicy"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedLimitsPolicy.html"
---
# YMKSpeedLimitsPolicy

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedLimitsPolicy.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKSpeedLimitsPolicy : NSObject
```

## Summary

### Instance methods

```swift
func customSpeedLimits(withToleranceRatio toleranceRatio: Double) -> YMKNavigationSpeedLimits
```

For example ratio = 0

### Properties

```swift
var legalSpeedLimits: YMKNavigationSpeedLimits { get }
```

For example for Russia 60/90/110 km/h

```swift
var speedLimitsRules: YMKNavigationSpeedLimitsRules { get }
```

## Instance methods

### customSpeedLimits(withToleranceRatio:)

```swift
func customSpeedLimits(withToleranceRatio toleranceRatio: Double) -> YMKNavigationSpeedLimits
```

For example ratio = 0.8 and current speed limit is 60 km/h - for Russia: enforcement tolerance is 20 km/h for all speed limits => we should start warning the user when current speed > 60 + 20 * 0.8 = 76 km/h - for Turkey: enforcement tolerance is 10 percent over the speed limit => we should start warning the user when current speed > 60 + 60 * 0.1 * 0.8 = 64.8 km/h

## Properties

### legalSpeedLimits

```swift
var legalSpeedLimits: YMKNavigationSpeedLimits { get }
```

For example for Russia 60/90/110 km/h

### speedLimitsRules

```swift
var speedLimitsRules: YMKNavigationSpeedLimitsRules { get }
```
