---
title: "YRTError"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTError"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTError.html"
---
# YRTError

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTError.html)

```swift
class YRTError : NSObject
```

An error has occurred.

## Summary

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
