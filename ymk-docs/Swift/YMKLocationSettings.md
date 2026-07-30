---
title: "YMKLocationSettings"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocationSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSettings.html"
---
# YMKLocationSettings

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSettings.html)

```swift
class YMKLocationSettings : NSObject
```

## Summary

### Class methods

```swift
 init(provideAccuracy: Bool,
             accuracy: YMKRange?,
 locationTimeInterval: YMKTimeInterval?,
         provideSpeed: Bool,
                speed: Double,
       provideHeading: Bool,
         headingError: YMKRange?,
        locationError: YMKLocationError?,
    provideWheelSpeed: Bool,
 wheelSpeedTimeInterval: YMKTimeInterval?)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var provideAccuracy: Bool { get set }
```

Flag whether to provide accuracy value

```swift
var accuracy: YMKRange? { get set }
```

Location accuracy range in meters

```swift
var locationTimeInterval: YMKTimeInterval? { get set }
```

Location time interval in milliseconds

```swift
var provideSpeed: Bool { get set }
```

Flag whether to provide speed value

```swift
var speed: Double { get set }
```

The speed in meters per second

```swift
var provideHeading: Bool { get set }
```

Flag whether to provide error of heading

```swift
var headingError: YMKRange? { get set }
```

The current heading error range in degrees relative to true heading, clockwise

```swift
var locationError: YMKLocationError? { get set }
```

Optional field, can be nil

```swift
var provideWheelSpeed: Bool { get set }
```

Flag whether to provide wheel speed value

```swift
var wheelSpeedTimeInterval: YMKTimeInterval? { get set }
```

Time interval of getting the wheel speed in milliseconds

## Class methods

### init(provideAccuracy:accuracy:locationTimeInterval:provideSpeed:speed:provideHeading:headingError:locationError:provideWheelSpeed:wheelSpeedTimeInterval:)

```swift
 init(provideAccuracy: Bool,
             accuracy: YMKRange?,
 locationTimeInterval: YMKTimeInterval?,
         provideSpeed: Bool,
                speed: Double,
       provideHeading: Bool,
         headingError: YMKRange?,
        locationError: YMKLocationError?,
    provideWheelSpeed: Bool,
 wheelSpeedTimeInterval: YMKTimeInterval?)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### provideAccuracy

```swift
var provideAccuracy: Bool { get set }
```

Flag whether to provide accuracy value.

### accuracy

```swift
var accuracy: YMKRange? { get set }
```

Location accuracy range in meters.

Optional field, can be nil.

### locationTimeInterval

```swift
var locationTimeInterval: YMKTimeInterval? { get set }
```

Location time interval in milliseconds.

Optional field, can be nil.

### provideSpeed

```swift
var provideSpeed: Bool { get set }
```

Flag whether to provide speed value.

### speed

```swift
var speed: Double { get set }
```

The speed in meters per second.

### provideHeading

```swift
var provideHeading: Bool { get set }
```

Flag whether to provide error of heading.

### headingError

```swift
var headingError: YMKRange? { get set }
```

The current heading error range in degrees relative to true heading, clockwise.

Optional field, can be nil.

### locationError

```swift
var locationError: YMKLocationError? { get set }
```

Optional field, can be nil.

### provideWheelSpeed

```swift
var provideWheelSpeed: Bool { get set }
```

Flag whether to provide wheel speed value.

### wheelSpeedTimeInterval

```swift
var wheelSpeedTimeInterval: YMKTimeInterval? { get set }
```

Time interval of getting the wheel speed in milliseconds. After publication the wheel speed corresponds to the speed value.

Optional field, can be nil.
