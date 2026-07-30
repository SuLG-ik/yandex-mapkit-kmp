---
title: "LocationSimulator"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationSimulator"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationSimulator.html"
---
# LocationSimulator

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationSimulator.html)

**Package** com.yandex.mapkit.location

## All Superinterfaces:

*[LocationManager](LocationManager.md)*

`interface LocationSimulator extends LocationManager`

Simulates the device location.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getSpeed()` |
| `void` | `setSpeed(double speed)` |
| `java.util.List<SimulationSettings>` | `getSettings()` |
| `void` | `setSettings(@NonNull java.util.List<SimulationSettings> settings)` |
| `void` | `subscribeForSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)`<br>Subscribes to simulation events. |
| `void` | `unsubscribeFromSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)`<br>Unsubscribes from simulation events. |
| `void` | `startSimulation(@NonNull java.util.List<SimulationSettings> settings)`<br>Start simulation. |
| `void` | `stopSimulation()`<br>Stop simulation. |
| `PolylinePosition` | `polylinePosition()`<br>The position of the polyline. |
| `boolean` | `isActive()`<br>True if simulator is not suspended. |

## Methods

### getSpeed

```java
@Deprecated
double getSpeed()
```

> [!CAUTION] Внимание
> Now field in settings. Movement speed.

### setSpeed

```java
@Deprecated
void setSpeed(double speed)
```

### getSettings

```java
@NonNull
java.util.List<SimulationSettings> getSettings()
```

### setSettings

```java
void setSettings(@NonNull java.util.List<SimulationSettings> settings)
```

### subscribeForSimulatorEvents

```java
void subscribeForSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)
```

Subscribes to simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### unsubscribeFromSimulatorEvents

```java
void unsubscribeFromSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)
```

Unsubscribes from simulation events.

The class does not retain the object in the 'simulatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### startSimulation

```java
void startSimulation(@NonNull java.util.List<SimulationSettings> settings)
```

Start simulation.

| Parameters |   |
| --- | --- |
| `settings` | Generate locations with given simulation settings. |

### stopSimulation

```java
void stopSimulation()
```

Stop simulation.

### polylinePosition

```java
@NonNull
PolylinePosition polylinePosition()
```

The position of the polyline.

### isActive

```java
boolean isActive()
```

True if simulator is not suspended.
