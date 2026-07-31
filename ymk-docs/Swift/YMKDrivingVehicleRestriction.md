---
title: "YMKDrivingVehicleRestriction"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingVehicleRestriction.html"
---
# YMKDrivingVehicleRestriction

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingVehicleRestriction : NSObject
```

## Summary

### Class methods

```swift
 init(weightLimit: NSNumber?,
  axleWeightLimit: NSNumber?,
   maxWeightLimit: NSNumber?,
      heightLimit: NSNumber?,
       widthLimit: NSNumber?,
      lengthLimit: NSNumber?,
     payloadLimit: NSNumber?,
      minEcoClass: NSNumber?,
 trailerNotAllowed: NSNumber?,
            legal: NSNumber?)
```

### Properties

```swift
var weightLimit: NSNumber? { get }
```

Actual weight limit, tons

```swift
var axleWeightLimit: NSNumber? { get }
```

Axle load weight limit, tons

```swift
var maxWeightLimit: NSNumber? { get }
```

Maximal allowed weight limit, tons

```swift
var heightLimit: NSNumber? { get }
```

Height limit, meters

```swift
var widthLimit: NSNumber? { get }
```

Width limit, meters

```swift
var lengthLimit: NSNumber? { get }
```

Length limit, meters

```swift
var payloadLimit: NSNumber? { get }
```

Payload limit, tons

```swift
var minEcoClass: NSNumber? { get }
```

Minimal allowed engine ecological class

```swift
var trailerNotAllowed: NSNumber? { get }
```

Trailer is not allowed

```swift
var legal: NSNumber? { get }
```

Legal or physical limitation

## Class methods

### init(weightLimit:axleWeightLimit:maxWeightLimit:heightLimit:widthLimit:lengthLimit:payloadLimit:minEcoClass:trailerNotAllowed:legal:)

```swift
 init(weightLimit: NSNumber?,
  axleWeightLimit: NSNumber?,
   maxWeightLimit: NSNumber?,
      heightLimit: NSNumber?,
       widthLimit: NSNumber?,
      lengthLimit: NSNumber?,
     payloadLimit: NSNumber?,
      minEcoClass: NSNumber?,
 trailerNotAllowed: NSNumber?,
            legal: NSNumber?)
```

## Properties

### weightLimit

```swift
var weightLimit: NSNumber? { get }
```

Actual weight limit, tons. See Driving Rules sign 3.11.

Optional field, can be nil.

### axleWeightLimit

```swift
var axleWeightLimit: NSNumber? { get }
```

Axle load weight limit, tons. See Driving Rules sign 3.12.

Optional field, can be nil.

### maxWeightLimit

```swift
var maxWeightLimit: NSNumber? { get }
```

Maximal allowed weight limit, tons. See Driving Rules sign 3.4, table 8.11.

Optional field, can be nil.

### heightLimit

```swift
var heightLimit: NSNumber? { get }
```

Height limit, meters. See Driving Rules sign 3.13.

Optional field, can be nil.

### widthLimit

```swift
var widthLimit: NSNumber? { get }
```

Width limit, meters. See Driving Rules sign 3.14.

Optional field, can be nil.

### lengthLimit

```swift
var lengthLimit: NSNumber? { get }
```

Length limit, meters. See Driving Rules sign 3.15.

Optional field, can be nil.

### payloadLimit

```swift
var payloadLimit: NSNumber? { get }
```

Payload limit, tons.

Optional field, can be nil.

### minEcoClass

```swift
var minEcoClass: NSNumber? { get }
```

Minimal allowed engine ecological class. See Driving Rules sign 5.35 and 5.36.

Optional field, can be nil.

### trailerNotAllowed

```swift
var trailerNotAllowed: NSNumber? { get }
```

Trailer is not allowed. See Driving Rules sign 3.7.

Optional field, can be nil.

### legal

```swift
var legal: NSNumber? { get }
```

Legal or physical limitation.

Optional field, can be nil.
