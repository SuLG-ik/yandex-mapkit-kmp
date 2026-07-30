---
title: "YMKDrivingVehicleOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingVehicleOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingVehicleOptions.html"
---
# YMKDrivingVehicleOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingVehicleOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingVehicleOptions : NSObject
```

## Summary

### Class methods

```swift
 init(vehicleType: YMKDrivingVehicleType,
           weight: NSNumber?,
       axleWeight: NSNumber?,
        maxWeight: NSNumber?,
           height: NSNumber?,
            width: NSNumber?,
           length: NSNumber?,
          payload: NSNumber?,
         ecoClass: NSNumber?,
       hasTrailer: NSNumber?,
  buswayPermitted: NSNumber?)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var vehicleType: YMKDrivingVehicleType { get set }
```

Sets the vehicle type for special routing

```swift
@NSCopying var weight: NSNumber? { get set }
```

Real vehicle weight

```swift
@NSCopying var axleWeight: NSNumber? { get set }
```

Maximal weight supported by a vehicle axle

```swift
@NSCopying var maxWeight: NSNumber? { get set }
```

Maximal allowed weight for the vehicle

```swift
@NSCopying var height: NSNumber? { get set }
```

Vehicle height

```swift
@NSCopying var width: NSNumber? { get set }
```

Vehicle width

```swift
@NSCopying var length: NSNumber? { get set }
```

Vehicle length

```swift
@NSCopying var payload: NSNumber? { get set }
```

Vehicle cargo weight

```swift
@NSCopying var ecoClass: NSNumber? { get set }
```

Vehicle eco class

```swift
@NSCopying var hasTrailer: NSNumber? { get set }
```

The vehicle has a trailer attached

```swift
@NSCopying var buswayPermitted: NSNumber? { get set }
```

The vehicle is permitted for busway

## Class methods

### init(vehicleType:weight:axleWeight:maxWeight:height:width:length:payload:ecoClass:hasTrailer:buswayPermitted:)

```swift
 init(vehicleType: YMKDrivingVehicleType,
           weight: NSNumber?,
       axleWeight: NSNumber?,
        maxWeight: NSNumber?,
           height: NSNumber?,
            width: NSNumber?,
           length: NSNumber?,
          payload: NSNumber?,
         ecoClass: NSNumber?,
       hasTrailer: NSNumber?,
  buswayPermitted: NSNumber?)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### vehicleType

```swift
var vehicleType: YMKDrivingVehicleType { get set }
```

Sets the vehicle type for special routing.

### weight

```swift
@NSCopying var weight: NSNumber? { get set }
```

Real vehicle weight.

Optional field, can be nil.

### axleWeight

```swift
@NSCopying var axleWeight: NSNumber? { get set }
```

Maximal weight supported by a vehicle axle.

Optional field, can be nil.

### maxWeight

```swift
@NSCopying var maxWeight: NSNumber? { get set }
```

Maximal allowed weight for the vehicle.

Optional field, can be nil.

### height

```swift
@NSCopying var height: NSNumber? { get set }
```

Vehicle height.

Optional field, can be nil.

### width

```swift
@NSCopying var width: NSNumber? { get set }
```

Vehicle width.

Optional field, can be nil.

### length

```swift
@NSCopying var length: NSNumber? { get set }
```

Vehicle length.

Optional field, can be nil.

### payload

```swift
@NSCopying var payload: NSNumber? { get set }
```

Vehicle cargo weight.

Optional field, can be nil.

### ecoClass

```swift
@NSCopying var ecoClass: NSNumber? { get set }
```

Vehicle eco class.

Optional field, can be nil.

### hasTrailer

```swift
@NSCopying var hasTrailer: NSNumber? { get set }
```

The vehicle has a trailer attached.

Optional field, can be nil.

### buswayPermitted

```swift
@NSCopying var buswayPermitted: NSNumber? { get set }
```

The vehicle is permitted for busway.

Optional field, can be nil.
