---
title: "YMKLocationError"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocationError"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationError.html"
---
# YMKLocationError

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationError.html)

```swift
class YMKLocationError : NSObject
```

## Summary

### Class methods

```swift
 init(lateralErrorRange: YMKRange, longitudinalErrorRange: YMKRange)
```

### Properties

```swift
var lateralErrorRange: YMKRange { get }
```

The error of spreading locations across the route

```swift
var longitudinalErrorRange: YMKRange { get }
```

The error of spreading locations along the route

## Class methods

### init(lateralErrorRange:longitudinalErrorRange:)

```swift
 init(lateralErrorRange: YMKRange, longitudinalErrorRange: YMKRange)
```

## Properties

### lateralErrorRange

```swift
var lateralErrorRange: YMKRange { get }
```

The error of spreading locations across the route.

### longitudinalErrorRange

```swift
var longitudinalErrorRange: YMKRange { get }
```

The error of spreading locations along the route.
