---
title: "YMKMapKit"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapKit"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapKit.html"
---
# YMKMapKit

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapKit.html)

```swift
class YMKMapKit : NSObject
```

> [!NOTE] Примечание
> MapKit holds listener/delegate objects by weak references.

Provides access to all services in the SDK.

Initialize the MapKit factory before using this class.

You need to have strong references to them somewhere in the client code.

## Summary

### Instance methods

```swift
func setUserIdWithId(_ id: String)
```

Sets the user id

```swift
func setAccount(_ account: (any YRTAccount)?)
```

Sets the account that is used by services

```swift
func setLocationManagerWith(_ locationManager: YMKLocationManager)
```

Sets single global location manager that is used by every module in MapKit by default

```swift
func resetLocationManagerToDefault()
```

Resets the global location manager to a default one, that is a location manager that is created by YMKMapKit::createLocationManager call

```swift
func onStart()
```

Notifies MapKit when the application resumes the foreground state

```swift
func onStop()
```

Notifies MapKit when the application pauses and goes to the background

```swift
func onTerminate()
```

Notifies MapKit when the application will terminate

```swift
func createLocationManager() -> YMKLocationManager
```

Creates a manager that allows to listen for device location updates

```swift
func createLocationSimulator(withGeometry geometry: YMKPolyline) -> YMKLocationSimulator
```

Creates a suspended LocationSimulator object with the given geometry

```swift
func createLocationSimulator() -> YMKLocationSimulator
```

Creates a suspended LocationSimulator object

```swift
func createDummyLocationManager() -> YMKDummyLocationManager
```

Creates a manager that functions as a location proxy

```swift
func createOffscreenMapWindow(withWidth width: Int,
                                       height: Int) -> YMKOffscreenMapWindow
```

Creates an OffscreenMapWindow

```swift
func createOffscreenMapWindow(withWidth width: Int,
                                       height: Int,
                            customScaleFactor: Float) -> YMKOffscreenMapWindow
```

Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point

```swift
func createTrafficLayer(with mapWindow: YMKMapWindow) -> YMKTrafficLayer
```

Creates the traffic layer

```swift
func createRoadEventsManager() -> YMKRoadEventsManager
```

Creates a manager that allows to interact with road events

```swift
func createUserLocationLayer(with mapWindow: YMKMapWindow) -> YMKUserLocationLayer
```

Create layer with the user location icon

### Properties

```swift
var offlineCacheManager: YMKOfflineCacheManager { get }
```

Returns a manager that handles offline maps, search index and road graph

```swift
var storageManager: YMKStorageManager { get }
```

Returns a manager that handles disk size and IO errors

```swift
var version: String { get }
```

Returns the version of the MapKit bundle

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setUserIdWithId(_:)

```swift
func setUserIdWithId(_ id: String)
```

Sets the user id. Don't use this method directly. Use `MapKitFactory.setUserId` instead

| Parameters |   |
| --- | --- |
| id | User id is your own identifier for all mapkit requests |

### setAccount(_:)

```swift
func setAccount(_ account: (any YRTAccount)?)
```

Sets the account that is used by services. Use this method before onStart to avoid double request to server

The class maintains a strong reference to the object in the 'account' parameter until it (the class) is invalidated.

### setLocationManagerWith(_:)

```swift
func setLocationManagerWith(_ locationManager: YMKLocationManager)
```

Sets single global location manager that is used by every module in MapKit by default. The provided location manager must have async implementation in it. Any location manager created by MapKit has async implementation. To provide your own source of location please use YMKDummyLocationManager. Application can change location manager at any moment, all MapKit modules will start receiving new location immediately.

### resetLocationManagerToDefault()

```swift
func resetLocationManagerToDefault()
```

Resets the global location manager to a default one, that is a location manager that is created by YMKMapKit::createLocationManager call.

### onStart()

```swift
func onStart()
```

Notifies MapKit when the application resumes the foreground state.

### onStop()

```swift
func onStop()
```

Notifies MapKit when the application pauses and goes to the background.

### onTerminate()

```swift
func onTerminate()
```

Notifies MapKit when the application will terminate.

### createLocationManager()

```swift
func createLocationManager() -> YMKLocationManager
```

Creates a manager that allows to listen for device location updates.

### createLocationSimulator(withGeometry:)

```swift
func createLocationSimulator(withGeometry geometry: YMKPolyline) -> YMKLocationSimulator
```

Creates a suspended LocationSimulator object with the given geometry.

### createLocationSimulator()

```swift
func createLocationSimulator() -> YMKLocationSimulator
```

Creates a suspended LocationSimulator object. Geometry must be set manually.

### createDummyLocationManager()

```swift
func createDummyLocationManager() -> YMKDummyLocationManager
```

Creates a manager that functions as a location proxy.

### createOffscreenMapWindow(withWidth:height:)

```swift
func createOffscreenMapWindow(withWidth width: Int,
                                       height: Int) -> YMKOffscreenMapWindow
```

Creates an OffscreenMapWindow

### createOffscreenMapWindow(withWidth:height:customScaleFactor:)

```swift
func createOffscreenMapWindow(withWidth width: Int,
                                       height: Int,
                            customScaleFactor: Float) -> YMKOffscreenMapWindow
```

Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point.

### createTrafficLayer(with:)

```swift
func createTrafficLayer(with mapWindow: YMKMapWindow) -> YMKTrafficLayer
```

Creates the traffic layer.

### createRoadEventsManager()

```swift
func createRoadEventsManager() -> YMKRoadEventsManager
```

Creates a manager that allows to interact with road events.

### createUserLocationLayer(with:)

```swift
func createUserLocationLayer(with mapWindow: YMKMapWindow) -> YMKUserLocationLayer
```

Create layer with the user location icon.

## Properties

### offlineCacheManager

```swift
var offlineCacheManager: YMKOfflineCacheManager { get }
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Returns a manager that handles offline maps, search index and road graph.

### storageManager

```swift
var storageManager: YMKStorageManager { get }
```

Returns a manager that handles disk size and IO errors.

### version

```swift
var version: String { get }
```

Returns the version of the MapKit bundle.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
