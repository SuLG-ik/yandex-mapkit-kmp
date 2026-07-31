---
title: "YMKGeoObjectTapEvent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeoObjectTapEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectTapEvent.html"
---
# YMKGeoObjectTapEvent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectTapEvent.html)

```swift
class YMKGeoObjectTapEvent : NSObject
```

Information about the tapped object.

## Summary

### Properties

```swift
var geoObject: YMKGeoObject { get }
```

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### geoObject

```swift
var geoObject: YMKGeoObject { get }
```

**Returns**

GeoObject The object that was tapped.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
