---
title: "YMKDrivingVehicleOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingVehicleOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingVehicleOptions.html"
---
# YMKDrivingVehicleOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingVehicleOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingVehicleOptions : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingVehicleOptions *)vehicleOptionsWithVehicleType:( YMKDrivingVehicleType)vehicleType
                                                             weight:(nullable NSNumber *)weight
                                                         axleWeight:(nullable NSNumber *)axleWeight
                                                          maxWeight:(nullable NSNumber *)maxWeight
                                                             height:(nullable NSNumber *)height
                                                              width:(nullable NSNumber *)width
                                                             length:(nullable NSNumber *)length
                                                            payload:(nullable NSNumber *)payload
                                                           ecoClass:(nullable NSNumber *)ecoClass
                                                         hasTrailer:(nullable NSNumber *)hasTrailer
                                                    buswayPermitted:(nullable NSNumber *)buswayPermitted;
```

### Instance methods

```objectivec
- (nonnull YMKDrivingVehicleOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKDrivingVehicleType vehicleType;
```

Sets the vehicle type for special routing

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *weight;
```

Real vehicle weight

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *axleWeight;
```

Maximal weight supported by a vehicle axle

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *maxWeight;
```

Maximal allowed weight for the vehicle

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *height;
```

Vehicle height

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *width;
```

Vehicle width

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *length;
```

Vehicle length

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *payload;
```

Vehicle cargo weight

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *ecoClass;
```

Vehicle eco class

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *hasTrailer;
```

The vehicle has a trailer attached

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *buswayPermitted;
```

The vehicle is permitted for busway

## Class methods

### vehicleOptionsWithVehicleType:weight:axleWeight:maxWeight:height:width:length:payload:ecoClass:hasTrailer:buswayPermitted:

```objectivec
+ (nonnull YMKDrivingVehicleOptions *)vehicleOptionsWithVehicleType:( YMKDrivingVehicleType)vehicleType
                                                             weight:(nullable NSNumber *)weight
                                                         axleWeight:(nullable NSNumber *)axleWeight
                                                          maxWeight:(nullable NSNumber *)maxWeight
                                                             height:(nullable NSNumber *)height
                                                              width:(nullable NSNumber *)width
                                                             length:(nullable NSNumber *)length
                                                            payload:(nullable NSNumber *)payload
                                                           ecoClass:(nullable NSNumber *)ecoClass
                                                         hasTrailer:(nullable NSNumber *)hasTrailer
                                                    buswayPermitted:(nullable NSNumber *)buswayPermitted;
```

## Instance methods

### init

```objectivec
- (nonnull YMKDrivingVehicleOptions *)init;
```

## Properties

### vehicleType

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKDrivingVehicleType vehicleType;
```

Sets the vehicle type for special routing.

### weight

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *weight;
```

Real vehicle weight.

Optional field, can be nil.

### axleWeight

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *axleWeight;
```

Maximal weight supported by a vehicle axle.

Optional field, can be nil.

### maxWeight

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *maxWeight;
```

Maximal allowed weight for the vehicle.

Optional field, can be nil.

### height

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *height;
```

Vehicle height.

Optional field, can be nil.

### width

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *width;
```

Vehicle width.

Optional field, can be nil.

### length

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *length;
```

Vehicle length.

Optional field, can be nil.

### payload

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *payload;
```

Vehicle cargo weight.

Optional field, can be nil.

### ecoClass

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *ecoClass;
```

Vehicle eco class.

Optional field, can be nil.

### hasTrailer

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *hasTrailer;
```

The vehicle has a trailer attached.

Optional field, can be nil.

### buswayPermitted

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *buswayPermitted;
```

The vehicle is permitted for busway.

Optional field, can be nil.
