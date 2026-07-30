---
title: "YMKNavigationCustomRouteOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationCustomRouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationCustomRouteOptions.html"
---
# YMKNavigationCustomRouteOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationCustomRouteOptions.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationCustomRouteOptions : NSObject
```

## Summary

### Class methods

```swift
 init(allowMoreUturns: NSNumber?)
```

### Properties

```swift
@NSCopying var allowMoreUturns: NSNumber? { get set }
```

Enabling this option will reduce the total route mileage but will include more u-turns along the route

Optional field, can be nil

## Class methods

### init(allowMoreUturns:)

```swift
 init(allowMoreUturns: NSNumber?)
```

## Properties

### allowMoreUturns

```swift
@NSCopying var allowMoreUturns: NSNumber? { get set }
```

Enabling this option will reduce the total route mileage but will include more u-turns along the route

Optional field, can be nil.
