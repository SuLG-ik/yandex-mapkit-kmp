---
title: "MapKit"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / MapKit"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/MapKit.html"
---
# MapKit

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/MapKit.html)

**Package** com.yandex.mapkit

`interface MapKit`

Provides access to all services in the SDK.

Initialize the MapKit factory before using this class.

> [!NOTE] Примечание
> MapKit holds listener/delegate objects by weak references. You need to have strong references to them somewhere in the client code.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setUserId(@NonNull java.lang.String id)`<br>Sets the user id. |
| `void` | `setAccount(@Nullable Account account)`<br>Sets the account that is used by services. |
| `void` | `setLocationManager(@NonNull LocationManager locationManager)`<br>Sets single global location manager that is used by every module in MapKit by default. |
| `void` | `resetLocationManagerToDefault()`<br>Resets the global location manager to a default one, that is a location manager that is created by [mapkit.MapKit#createLocationManager()](MapKit.md#createlocationmanager)  call. |
| `void` | `onStart()`<br>Notifies MapKit when the application resumes the foreground state. |
| `void` | `onStop()`<br>Notifies MapKit when the application pauses and goes to the background. |
| `void` | `onTerminate()`<br>Notifies MapKit when the application will terminate. |
| `LocationManager` | `createLocationManager()`<br>Creates a manager that allows to listen for device location updates. |
| `LocationSimulator` | `createLocationSimulator(@NonNull Polyline geometry)`<br>Creates a suspended LocationSimulator object with the given geometry. |
| `LocationSimulator` | `createLocationSimulator()`<br>Creates a suspended LocationSimulator object. |
| `DummyLocationManager` | `createDummyLocationManager()`<br>Creates a manager that functions as a location proxy. |
| `OffscreenMapWindow` | `createOffscreenMapWindow(int width, int height)`<br>Creates an OffscreenMapWindow |
| `OffscreenMapWindow` | `createOffscreenMapWindow(int width, int height, float customScaleFactor)`<br>Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point. |
| `OfflineCacheManager` | `getOfflineCacheManager()`<br>Returns a manager that handles offline maps, search index and road graph. |
| `StorageManager` | `getStorageManager()`<br>Returns a manager that handles disk size and IO errors. |
| `TrafficLayer` | `createTrafficLayer(@NonNull MapWindow mapWindow)`<br>Creates the traffic layer. |
| `RoadEventsManager` | `createRoadEventsManager()`<br>Creates a manager that allows to interact with road events. |
| `UserLocationLayer` | `createUserLocationLayer(@NonNull MapWindow mapWindow)`<br>Create layer with the user location icon. |
| `java.lang.String` | `getVersion()`<br>Returns the version of the MapKit bundle. |
| `boolean` | `isValid()`<br>Tells if this **MapKit** is valid or not. |

## Methods

### setUserId

```java
void setUserId(@NonNull java.lang.String id)
```

Sets the user id.

Don't use this method directly. Use `MapKitFactory.setUserId` instead

| Parameters |   |
| --- | --- |
| `id` | User id is your own identifier for all mapkit requests |

### setAccount

```java
void setAccount(@Nullable Account account)
```

Sets the account that is used by services.

Use this method before onStart to avoid double request to server

The class maintains a strong reference to the object in the 'account' parameter until it (the class) is invalidated.

### setLocationManager

```java
void setLocationManager(@NonNull LocationManager locationManager)
```

Sets single global location manager that is used by every module in MapKit by default.

The provided location manager must have async implementation in it. Any location manager created by MapKit has async implementation. To provide your own source of location please use [mapkit.location.DummyLocationManager](location/DummyLocationManager.md). Application can change location manager at any moment, all MapKit modules will start receiving new location immediately.

### resetLocationManagerToDefault

```java
void resetLocationManagerToDefault()
```

Resets the global location manager to a default one, that is a location manager that is created by [mapkit.MapKit#createLocationManager()](MapKit.md#createlocationmanager)  call.

### onStart

```java
void onStart()
```

Notifies MapKit when the application resumes the foreground state.

### onStop

```java
void onStop()
```

Notifies MapKit when the application pauses and goes to the background.

### onTerminate

```java
void onTerminate()
```

Notifies MapKit when the application will terminate.

### createLocationManager

```java
@NonNull
LocationManager createLocationManager()
```

Creates a manager that allows to listen for device location updates.

### createLocationSimulator

```java
@NonNull
LocationSimulator createLocationSimulator(@NonNull Polyline geometry)
```

Creates a suspended LocationSimulator object with the given geometry.

### createLocationSimulator

```java
@NonNull
LocationSimulator createLocationSimulator()
```

Creates a suspended LocationSimulator object.

Geometry must be set manually.

### createDummyLocationManager

```java
@NonNull
DummyLocationManager createDummyLocationManager()
```

Creates a manager that functions as a location proxy.

### createOffscreenMapWindow

```java
@NonNull
OffscreenMapWindow createOffscreenMapWindow(int width,
                                            int height)
```

Creates an OffscreenMapWindow

### createOffscreenMapWindow

```java
@NonNull
OffscreenMapWindow createOffscreenMapWindow(int width,
                                            int height,
                                            float customScaleFactor)
```

Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point.

### getOfflineCacheManager

```java
@NonNull
OfflineCacheManager getOfflineCacheManager()
```

Returns a manager that handles offline maps, search index and road graph.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

### getStorageManager

```java
@NonNull
StorageManager getStorageManager()
```

Returns a manager that handles disk size and IO errors.

### createTrafficLayer

```java
@NonNull
TrafficLayer createTrafficLayer(@NonNull MapWindow mapWindow)
```

Creates the traffic layer.

### createRoadEventsManager

```java
@NonNull
RoadEventsManager createRoadEventsManager()
```

Creates a manager that allows to interact with road events.

### createUserLocationLayer

```java
@NonNull
UserLocationLayer createUserLocationLayer(@NonNull MapWindow mapWindow)
```

Create layer with the user location icon.

### getVersion

```java
@NonNull
java.lang.String getVersion()
```

Returns the version of the MapKit bundle.

### isValid

```java
boolean isValid()
```

Tells if this **MapKit** is valid or not.

Any other method (except for this one) called on an invalid **MapKit** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
