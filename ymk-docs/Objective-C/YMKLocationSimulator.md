---
title: "YMKLocationSimulator"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocationSimulator"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSimulator.html"
---
# YMKLocationSimulator

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSimulator.html)

```objectivec
@interface YMKLocationSimulator : YMKLocationManager
```

Simulates the device location.

## Summary

### Instance methods

```objectivec
- (void)subscribeForSimulatorEventsWithSimulatorListener:
    (nonnull id<YMKLocationSimulatorListener>)simulatorListener;
```

Subscribes to simulation events

```objectivec
- (void)unsubscribeFromSimulatorEventsWithSimulatorListener:
    (nonnull id<YMKLocationSimulatorListener>)simulatorListener;
```

Unsubscribes from simulation events

```objectivec
- (void)startSimulationWithSettings:
    (nonnull NSArray<YMKSimulationSettings *> *)settings;
```

Start simulation

```objectivec
- (void)stopSimulation;
```

Stop simulation

```objectivec
- (nonnull YMKPolylinePosition *)polylinePosition;
```

The position of the polyline

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) double speed;
```

Movement speed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<YMKSimulationSettings *> *settings;
```

```objectivec
@property (nonatomic, readonly, getter=isActive) BOOL active;
```

True if simulator is not suspended

## Instance methods

### subscribeForSimulatorEventsWithSimulatorListener:

```objectivec
- (void)subscribeForSimulatorEventsWithSimulatorListener:
    (nonnull id<YMKLocationSimulatorListener>)simulatorListener;
```

Subscribes to simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### unsubscribeFromSimulatorEventsWithSimulatorListener:

```objectivec
- (void)unsubscribeFromSimulatorEventsWithSimulatorListener:
    (nonnull id<YMKLocationSimulatorListener>)simulatorListener;
```

Unsubscribes from simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### startSimulationWithSettings:

```objectivec
- (void)startSimulationWithSettings:
    (nonnull NSArray<YMKSimulationSettings *> *)settings;
```

Start simulation.

| Parameters |   |
| --- | --- |
| settings | Generate locations with given simulation settings. |

### stopSimulation

```objectivec
- (void)stopSimulation;
```

Stop simulation.

### polylinePosition

```objectivec
- (nonnull YMKPolylinePosition *)polylinePosition;
```

The position of the polyline.

## Properties

### speed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) double speed;
```

Movement speed.

> [!CAUTION] Внимание
> Now field in settings.

### settings

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<YMKSimulationSettings *> *settings;
```

### active

```objectivec
@property (nonatomic, readonly, getter=isActive) BOOL active;
```

True if simulator is not suspended.
