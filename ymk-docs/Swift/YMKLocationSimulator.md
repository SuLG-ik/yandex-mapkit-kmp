---
title: "YMKLocationSimulator"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocationSimulator"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSimulator.html"
---
# YMKLocationSimulator

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationSimulator.html)

```swift
class YMKLocationSimulator : YMKLocationManager
```

Simulates the device location.

## Summary

### Instance methods

```swift
func subscribeForSimulatorEvents(with simulatorListener: any YMKLocationSimulatorListener)
```

Subscribes to simulation events

```swift
func unsubscribeFromSimulatorEvents(with simulatorListener: any YMKLocationSimulatorListener)
```

Unsubscribes from simulation events

```swift
func startSimulation(withSettings settings: [YMKSimulationSettings])
```

Start simulation

```swift
func stopSimulation()
```

Stop simulation

```swift
func polylinePosition() -> YMKPolylinePosition
```

The position of the polyline

### Properties

```swift
var speed: Double { get set }
```

Movement speed

```swift
var settings: [YMKSimulationSettings] { get set }
```

```swift
var isActive: Bool { get }
```

True if simulator is not suspended

## Instance methods

### subscribeForSimulatorEvents(with:)

```swift
func subscribeForSimulatorEvents(with simulatorListener: any YMKLocationSimulatorListener)
```

Subscribes to simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### unsubscribeFromSimulatorEvents(with:)

```swift
func unsubscribeFromSimulatorEvents(with simulatorListener: any YMKLocationSimulatorListener)
```

Unsubscribes from simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### startSimulation(withSettings:)

```swift
func startSimulation(withSettings settings: [YMKSimulationSettings])
```

Start simulation.

| Parameters |   |
| --- | --- |
| settings | Generate locations with given simulation settings. |

### stopSimulation()

```swift
func stopSimulation()
```

Stop simulation.

### polylinePosition()

```swift
func polylinePosition() -> YMKPolylinePosition
```

The position of the polyline.

## Properties

### speed

```swift
var speed: Double { get set }
```

Movement speed.

> [!CAUTION] Внимание
> Now field in settings.

### settings

```swift
var settings: [YMKSimulationSettings] { get set }
```

### isActive

```swift
var isActive: Bool { get }
```

True if simulator is not suspended.
