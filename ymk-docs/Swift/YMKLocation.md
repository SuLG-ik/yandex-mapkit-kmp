---
title: "YMKLocation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocation.html"
---
# YMKLocation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocation.html)

```swift
class YMKLocation : NSObject
```

The geographical position of the object.

## Summary

### Class methods

```swift
 init(position: YMKPoint,
      accuracy: NSNumber?,
      altitude: NSNumber?,
 altitudeAccuracy: NSNumber?,
       heading: NSNumber?,
         speed: NSNumber?,
 indoorLevelId: String?,
 absoluteTimestamp: Date,
 relativeTimestamp: Date)
```

### Properties

```swift
var position: YMKPoint { get }
```

The geographical position

```swift
var accuracy: NSNumber? { get }
```

Location accuracy in meters

```swift
var altitude: NSNumber? { get }
```

The altitude of the location in meters

```swift
var altitudeAccuracy: NSNumber? { get }
```

The accuracy of the altitude in meters

```swift
var heading: NSNumber? { get }
```

The current heading in degrees relative to true north, clockwise

```swift
var speed: NSNumber? { get }
```

The speed in meters per second

```swift
var indoorLevelId: String? { get }
```

The universal identifier of indoor level

```swift
var absoluteTimestamp: Date { get }
```

Absolute timestamp, in milliseconds since January 1, 1970

```swift
var relativeTimestamp: Date { get }
```

Relative timestamp, number of milliseconds passed on steady clock

## Class methods

### init(position:accuracy:altitude:altitudeAccuracy:heading:speed:indoorLevelId:absoluteTimestamp:relativeTimestamp:)

```swift
 init(position: YMKPoint,
      accuracy: NSNumber?,
      altitude: NSNumber?,
 altitudeAccuracy: NSNumber?,
       heading: NSNumber?,
         speed: NSNumber?,
 indoorLevelId: String?,
 absoluteTimestamp: Date,
 relativeTimestamp: Date)
```

## Properties

### position

```swift
var position: YMKPoint { get }
```

The geographical position.

### accuracy

```swift
var accuracy: NSNumber? { get }
```

Location accuracy in meters.

Optional field, can be nil.

### altitude

```swift
var altitude: NSNumber? { get }
```

The altitude of the location in meters.

Optional field, can be nil.

### altitudeAccuracy

```swift
var altitudeAccuracy: NSNumber? { get }
```

The accuracy of the altitude in meters.

Optional field, can be nil.

### heading

```swift
var heading: NSNumber? { get }
```

The current heading in degrees relative to true north, clockwise.

Optional field, can be nil.

### speed

```swift
var speed: NSNumber? { get }
```

The speed in meters per second.

Optional field, can be nil.

### indoorLevelId

```swift
var indoorLevelId: String? { get }
```

The universal identifier of indoor level.

Optional field, can be nil.

### absoluteTimestamp

```swift
var absoluteTimestamp: Date { get }
```

Absolute timestamp, in milliseconds since January 1, 1970.

### relativeTimestamp

```swift
var relativeTimestamp: Date { get }
```

Relative timestamp, number of milliseconds passed on steady clock. Use for interval calculation.
