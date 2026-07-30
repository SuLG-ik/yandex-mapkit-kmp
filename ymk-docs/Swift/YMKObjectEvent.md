---
title: "YMKObjectEvent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKObjectEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKObjectEvent.html"
---
# YMKObjectEvent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKObjectEvent.html)

```swift
class YMKObjectEvent : NSObject
```

Base abstract class for an object event. Layers that produce object event callbacks need to provide derived event classes.

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
