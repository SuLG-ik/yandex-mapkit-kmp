---
title: "YMKCameraBounds"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCameraBounds"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraBounds.html"
---
# YMKCameraBounds

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraBounds.html)

```swift
class YMKCameraBounds : NSObject
```

The object that is used to interact with the map bounds.

## Summary

### Instance methods

```swift
func getMinZoom() -> Float
```

Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference

```swift
func getMaxZoom() -> Float
```

Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference

```swift
func setMinZoomPreferenceWithZoom(_ zoom: Float)
```

Set minimum available zoom level hint

```swift
func setMaxZoomPreferenceWithZoom(_ zoom: Float)
```

Set maximum available zoom level hint

```swift
func resetMinMaxZoomPreference()
```

Reset minimum and maximum available zoom level hints

### Properties

```swift
var latLngBounds: YMKBoundingBox? { get set }
```

Latitudes should be in range [-89

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### getMinZoom()

```swift
func getMinZoom() -> Float
```

Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.

### getMaxZoom()

```swift
func getMaxZoom() -> Float
```

Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference

### setMinZoomPreferenceWithZoom(_:)

```swift
func setMinZoomPreferenceWithZoom(_ zoom: Float)
```

Set minimum available zoom level hint.

### setMaxZoomPreferenceWithZoom(_:)

```swift
func setMaxZoomPreferenceWithZoom(_ zoom: Float)
```

Set maximum available zoom level hint.

### resetMinMaxZoomPreference()

```swift
func resetMinMaxZoomPreference()
```

Reset minimum and maximum available zoom level hints.

## Properties

### latLngBounds

```swift
var latLngBounds: YMKBoundingBox? { get set }
```

Latitudes should be in range [-89.3, 89.3]. Longitudes should be in range [-180, 180).

Optional property, can be nil.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
