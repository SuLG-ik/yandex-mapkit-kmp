---
title: "YMKDrivingVehicleRestriction"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingVehicleRestriction.html"
---
# YMKDrivingVehicleRestriction

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingVehicleRestriction : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingVehicleRestriction *)vehicleRestrictionWithWeightLimit:(nullable NSNumber *)weightLimit
                                                            axleWeightLimit:(nullable NSNumber *)axleWeightLimit
                                                             maxWeightLimit:(nullable NSNumber *)maxWeightLimit
                                                                heightLimit:(nullable NSNumber *)heightLimit
                                                                 widthLimit:(nullable NSNumber *)widthLimit
                                                                lengthLimit:(nullable NSNumber *)lengthLimit
                                                               payloadLimit:(nullable NSNumber *)payloadLimit
                                                                minEcoClass:(nullable NSNumber *)minEcoClass
                                                          trailerNotAllowed:(nullable NSNumber *)trailerNotAllowed
                                                                      legal:(nullable NSNumber *)legal;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *weightLimit;
```

Actual weight limit, tons

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *axleWeightLimit;
```

Axle load weight limit, tons

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *maxWeightLimit;
```

Maximal allowed weight limit, tons

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *heightLimit;
```

Height limit, meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *widthLimit;
```

Width limit, meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *lengthLimit;
```

Length limit, meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *payloadLimit;
```

Payload limit, tons

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *minEcoClass;
```

Minimal allowed engine ecological class

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *trailerNotAllowed;
```

Trailer is not allowed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *legal;
```

Legal or physical limitation

## Class methods

### vehicleRestrictionWithWeightLimit:axleWeightLimit:maxWeightLimit:heightLimit:widthLimit:lengthLimit:payloadLimit:minEcoClass:trailerNotAllowed:legal:

```objectivec
+ (nonnull YMKDrivingVehicleRestriction *)vehicleRestrictionWithWeightLimit:(nullable NSNumber *)weightLimit
                                                            axleWeightLimit:(nullable NSNumber *)axleWeightLimit
                                                             maxWeightLimit:(nullable NSNumber *)maxWeightLimit
                                                                heightLimit:(nullable NSNumber *)heightLimit
                                                                 widthLimit:(nullable NSNumber *)widthLimit
                                                                lengthLimit:(nullable NSNumber *)lengthLimit
                                                               payloadLimit:(nullable NSNumber *)payloadLimit
                                                                minEcoClass:(nullable NSNumber *)minEcoClass
                                                          trailerNotAllowed:(nullable NSNumber *)trailerNotAllowed
                                                                      legal:(nullable NSNumber *)legal;
```

## Properties

### weightLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *weightLimit;
```

Actual weight limit, tons. See Driving Rules sign 3.11.

Optional field, can be nil.

### axleWeightLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *axleWeightLimit;
```

Axle load weight limit, tons. See Driving Rules sign 3.12.

Optional field, can be nil.

### maxWeightLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *maxWeightLimit;
```

Maximal allowed weight limit, tons. See Driving Rules sign 3.4, table 8.11.

Optional field, can be nil.

### heightLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *heightLimit;
```

Height limit, meters. See Driving Rules sign 3.13.

Optional field, can be nil.

### widthLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *widthLimit;
```

Width limit, meters. See Driving Rules sign 3.14.

Optional field, can be nil.

### lengthLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *lengthLimit;
```

Length limit, meters. See Driving Rules sign 3.15.

Optional field, can be nil.

### payloadLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *payloadLimit;
```

Payload limit, tons.

Optional field, can be nil.

### minEcoClass

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *minEcoClass;
```

Minimal allowed engine ecological class. See Driving Rules sign 5.35 and 5.36.

Optional field, can be nil.

### trailerNotAllowed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *trailerNotAllowed;
```

Trailer is not allowed. See Driving Rules sign 3.7.

Optional field, can be nil.

### legal

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *legal;
```

Legal or physical limitation.

Optional field, can be nil.
