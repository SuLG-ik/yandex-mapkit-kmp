---
title: "YMKNavigationFactory"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationFactory.html"
---
# YMKNavigationFactory

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationFactory : NSObject
```

## Summary

### Class methods

```swift
class func createNavigation(with type: YMKDrivingRouterType) -> YMKNavigation
```

Creates navigation engine with given options

## Class methods

### createNavigation(with:)

```swift
class func createNavigation(with type: YMKDrivingRouterType) -> YMKNavigation
```

Creates navigation engine with given options. Each call returns new independent instance of Navigation. Navigation will be in the suspended mode.
