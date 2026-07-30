---
title: "YMKUserLocationView"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKUserLocationView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationView.html"
---
# YMKUserLocationView

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationView.html)

```swift
class YMKUserLocationView : NSObject
```

Use this interface to specify the appearance of the user location icon elements.

## Summary

### Properties

```swift
var arrow: YMKPlacemarkMapObject { get }
```

Gets the location arrow map object

```swift
var pin: YMKPlacemarkMapObject { get }
```

Gets the location pin map object

```swift
var accuracyCircle: YMKCircleMapObject { get }
```

Gets the GPS accuracy circle map object

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### arrow

```swift
var arrow: YMKPlacemarkMapObject { get }
```

Gets the location arrow map object.

### pin

```swift
var pin: YMKPlacemarkMapObject { get }
```

Gets the location pin map object.

### accuracyCircle

```swift
var accuracyCircle: YMKCircleMapObject { get }
```

Gets the GPS accuracy circle map object.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
