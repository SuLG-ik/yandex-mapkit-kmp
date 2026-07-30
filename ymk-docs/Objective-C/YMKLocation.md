---
title: "YMKLocation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocation.html"
---
# YMKLocation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocation.html)

```objectivec
@interface YMKLocation : NSObject
```

The geographical position of the object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocation *)locationWithPosition:(nonnull YMKPoint *)position
                                     accuracy:(nullable NSNumber *)accuracy
                                     altitude:(nullable NSNumber *)altitude
                             altitudeAccuracy:(nullable NSNumber *)altitudeAccuracy
                                      heading:(nullable NSNumber *)heading
                                        speed:(nullable NSNumber *)speed
                                indoorLevelId:(nullable NSString *)indoorLevelId
                            absoluteTimestamp:(nonnull NSDate *)absoluteTimestamp
                            relativeTimestamp:(nonnull NSDate *)relativeTimestamp;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

The geographical position

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *accuracy;
```

Location accuracy in meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *altitude;
```

The altitude of the location in meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *altitudeAccuracy;
```

The accuracy of the altitude in meters

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *heading;
```

The current heading in degrees relative to true north, clockwise

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speed;
```

The speed in meters per second

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevelId;
```

The universal identifier of indoor level

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *absoluteTimestamp;
```

Absolute timestamp, in milliseconds since January 1, 1970

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *relativeTimestamp;
```

Relative timestamp, number of milliseconds passed on steady clock

## Class methods

### locationWithPosition:accuracy:altitude:altitudeAccuracy:heading:speed:indoorLevelId:absoluteTimestamp:relativeTimestamp:

```objectivec
+ (nonnull YMKLocation *)locationWithPosition:(nonnull YMKPoint *)position
                                     accuracy:(nullable NSNumber *)accuracy
                                     altitude:(nullable NSNumber *)altitude
                             altitudeAccuracy:(nullable NSNumber *)altitudeAccuracy
                                      heading:(nullable NSNumber *)heading
                                        speed:(nullable NSNumber *)speed
                                indoorLevelId:(nullable NSString *)indoorLevelId
                            absoluteTimestamp:(nonnull NSDate *)absoluteTimestamp
                            relativeTimestamp:(nonnull NSDate *)relativeTimestamp;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

The geographical position.

### accuracy

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *accuracy;
```

Location accuracy in meters.

Optional field, can be nil.

### altitude

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *altitude;
```

The altitude of the location in meters.

Optional field, can be nil.

### altitudeAccuracy

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *altitudeAccuracy;
```

The accuracy of the altitude in meters.

Optional field, can be nil.

### heading

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *heading;
```

The current heading in degrees relative to true north, clockwise.

Optional field, can be nil.

### speed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speed;
```

The speed in meters per second.

Optional field, can be nil.

### indoorLevelId

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevelId;
```

The universal identifier of indoor level.

Optional field, can be nil.

### absoluteTimestamp

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *absoluteTimestamp;
```

Absolute timestamp, in milliseconds since January 1, 1970.

### relativeTimestamp

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *relativeTimestamp;
```

Relative timestamp, number of milliseconds passed on steady clock. Use for interval calculation.
