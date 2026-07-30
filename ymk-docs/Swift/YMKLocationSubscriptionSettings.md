---
title: "YMKLocationSubscriptionSettings"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocationSubscriptionSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSubscriptionSettings.html"
---
# YMKLocationSubscriptionSettings

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSubscriptionSettings.html)

```swift
class YMKLocationSubscriptionSettings : NSObject
```

## Summary

### Class methods

```swift
 init(useInBackground: YMKLocationUseInBackground, purpose: YMKPurpose)
```

### Properties

```swift
var useInBackground: YMKLocationUseInBackground { get }
```

If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application

```swift
var purpose: YMKPurpose { get }
```

Defines for what purpose the locations from the subscription will be used

## Class methods

### init(useInBackground:purpose:)

```swift
 init(useInBackground: YMKLocationUseInBackground, purpose: YMKPurpose)
```

## Properties

### useInBackground

```swift
var useInBackground: YMKLocationUseInBackground { get }
```

If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application.

### purpose

```swift
var purpose: YMKPurpose { get }
```

Defines for what purpose the locations from the subscription will be used. Depending on the purpose, it tries to optimize requests for locations.
