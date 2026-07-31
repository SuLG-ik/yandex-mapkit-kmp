---
title: "YMKLocationSettings"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocationSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSettings.html"
---
# YMKLocationSettings

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSettings.html)

```objectivec
@interface YMKLocationSettings : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocationSettings *)locationSettingsWithProvideAccuracy:( BOOL)provideAccuracy
                                                            accuracy:(nullable YMKRange *)accuracy
                                                locationTimeInterval:(nullable YMKTimeInterval *)locationTimeInterval
                                                        provideSpeed:( BOOL)provideSpeed
                                                               speed:( double)speed
                                                      provideHeading:( BOOL)provideHeading
                                                        headingError:(nullable YMKRange *)headingError
                                                       locationError:(nullable YMKLocationError *)locationError
                                                   provideWheelSpeed:( BOOL)provideWheelSpeed
                                              wheelSpeedTimeInterval:(nullable YMKTimeInterval *)wheelSpeedTimeInterval;
```

### Instance methods

```objectivec
- (nonnull YMKLocationSettings *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideAccuracy;
```

Flag whether to provide accuracy value

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRange *accuracy;
```

Location accuracy range in meters

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKTimeInterval *locationTimeInterval;
```

Location time interval in milliseconds

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideSpeed;
```

Flag whether to provide speed value

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) double speed;
```

The speed in meters per second

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideHeading;
```

Flag whether to provide error of heading

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRange *headingError;
```

The current heading error range in degrees relative to true heading, clockwise

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKLocationError *locationError;
```

Optional field, can be nil

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL provideWheelSpeed;
```

Flag whether to provide wheel speed value

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKTimeInterval *wheelSpeedTimeInterval;
```

Time interval of getting the wheel speed in milliseconds

## Class methods

### locationSettingsWithProvideAccuracy:accuracy:locationTimeInterval:provideSpeed:speed:provideHeading:headingError:locationError:provideWheelSpeed:wheelSpeedTimeInterval:

```objectivec
+ (nonnull YMKLocationSettings *)locationSettingsWithProvideAccuracy:( BOOL)provideAccuracy
                                                            accuracy:(nullable YMKRange *)accuracy
                                                locationTimeInterval:(nullable YMKTimeInterval *)locationTimeInterval
                                                        provideSpeed:( BOOL)provideSpeed
                                                               speed:( double)speed
                                                      provideHeading:( BOOL)provideHeading
                                                        headingError:(nullable YMKRange *)headingError
                                                       locationError:(nullable YMKLocationError *)locationError
                                                   provideWheelSpeed:( BOOL)provideWheelSpeed
                                              wheelSpeedTimeInterval:(nullable YMKTimeInterval *)wheelSpeedTimeInterval;
```

## Instance methods

### init

```objectivec
- (nonnull YMKLocationSettings *)init;
```

## Properties

### provideAccuracy

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideAccuracy;
```

Flag whether to provide accuracy value.

### accuracy

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRange *accuracy;
```

Location accuracy range in meters.

Optional field, can be nil.

### locationTimeInterval

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKTimeInterval *locationTimeInterval;
```

Location time interval in milliseconds.

Optional field, can be nil.

### provideSpeed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideSpeed;
```

Flag whether to provide speed value.

### speed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) double speed;
```

The speed in meters per second.

### provideHeading

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL provideHeading;
```

Flag whether to provide error of heading.

### headingError

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRange *headingError;
```

The current heading error range in degrees relative to true heading, clockwise.

Optional field, can be nil.

### locationError

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKLocationError *locationError;
```

Optional field, can be nil.

### provideWheelSpeed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL provideWheelSpeed;
```

Flag whether to provide wheel speed value.

### wheelSpeedTimeInterval

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKTimeInterval *wheelSpeedTimeInterval;
```

Time interval of getting the wheel speed in milliseconds. After publication the wheel speed corresponds to the speed value.

Optional field, can be nil.
