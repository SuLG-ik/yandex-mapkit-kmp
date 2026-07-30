---
title: "YMKMapKit"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapKit"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapKit.html"
---
# YMKMapKit

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapKit.html)

```objectivec
@interface YMKMapKit : NSObject
```

> [!NOTE] Примечание
> MapKit holds listener/delegate objects by weak references.

Provides access to all services in the SDK.

Initialize the MapKit factory before using this class.

You need to have strong references to them somewhere in the client code.

## Summary

### Instance methods

```objectivec
- (void)setUserIdWithId:(nonnull NSString *)id;
```

Sets the user id

```objectivec
- (void)setAccount:(nullable id<YRTAccount>)account;
```

Sets the account that is used by services

```objectivec
- (void)setLocationManagerWithLocationManager:
    (nonnull YMKLocationManager *)locationManager;
```

Sets single global location manager that is used by every module in MapKit by default

```objectivec
- (void)resetLocationManagerToDefault;
```

Resets the global location manager to a default one, that is a location manager that is created by YMKMapKit::createLocationManager call

```objectivec
- (void)onStart;
```

Notifies MapKit when the application resumes the foreground state

```objectivec
- (void)onStop;
```

Notifies MapKit when the application pauses and goes to the background

```objectivec
- (void)onTerminate;
```

Notifies MapKit when the application will terminate

```objectivec
- (nonnull YMKLocationManager *)createLocationManager;
```

Creates a manager that allows to listen for device location updates

```objectivec
- (nonnull YMKLocationSimulator *)createLocationSimulatorWithGeometry:
    (nonnull YMKPolyline *)geometry;
```

Creates a suspended LocationSimulator object with the given geometry

```objectivec
- (nonnull YMKLocationSimulator *)createLocationSimulator;
```

Creates a suspended LocationSimulator object

```objectivec
- (nonnull YMKDummyLocationManager *)createDummyLocationManager;
```

Creates a manager that functions as a location proxy

```objectivec
- (nonnull YMKOffscreenMapWindow *)
    createOffscreenMapWindowWithWidth:(NSInteger)width
                               height:(NSInteger)height;
```

Creates an OffscreenMapWindow

```objectivec
- (nonnull YMKOffscreenMapWindow *)
    createOffscreenMapWindowWithWidth:(NSInteger)width
                               height:(NSInteger)height
                    customScaleFactor:(float)customScaleFactor;
```

Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point

```objectivec
- (nonnull YMKTrafficLayer *)createTrafficLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates the traffic layer

```objectivec
- (nonnull YMKRoadEventsManager *)createRoadEventsManager;
```

Creates a manager that allows to interact with road events

```objectivec
- (nonnull YMKUserLocationLayer *)createUserLocationLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Create layer with the user location icon

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKOfflineCacheManager *offlineCacheManager;
```

Returns a manager that handles offline maps, search index and road graph

```objectivec
@property (nonatomic, readonly, nonnull) YMKStorageManager *storageManager;
```

Returns a manager that handles disk size and IO errors

```objectivec
@property (nonatomic, readonly, nonnull) NSString *version;
```

Returns the version of the MapKit bundle

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setUserIdWithId:

```objectivec
- (void)setUserIdWithId:(nonnull NSString *)id;
```

Sets the user id. Don't use this method directly. Use `MapKitFactory.setUserId` instead

| Parameters |   |
| --- | --- |
| id | User id is your own identifier for all mapkit requests |

### setAccount:

```objectivec
- (void)setAccount:(nullable id<YRTAccount>)account;
```

Sets the account that is used by services. Use this method before onStart to avoid double request to server

The class maintains a strong reference to the object in the 'account' parameter until it (the class) is invalidated.

### setLocationManagerWithLocationManager:

```objectivec
- (void)setLocationManagerWithLocationManager:
    (nonnull YMKLocationManager *)locationManager;
```

Sets single global location manager that is used by every module in MapKit by default. The provided location manager must have async implementation in it. Any location manager created by MapKit has async implementation. To provide your own source of location please use YMKDummyLocationManager. Application can change location manager at any moment, all MapKit modules will start receiving new location immediately.

### resetLocationManagerToDefault

```objectivec
- (void)resetLocationManagerToDefault;
```

Resets the global location manager to a default one, that is a location manager that is created by YMKMapKit::createLocationManager call.

### onStart

```objectivec
- (void)onStart;
```

Notifies MapKit when the application resumes the foreground state.

### onStop

```objectivec
- (void)onStop;
```

Notifies MapKit when the application pauses and goes to the background.

### onTerminate

```objectivec
- (void)onTerminate;
```

Notifies MapKit when the application will terminate.

### createLocationManager

```objectivec
- (nonnull YMKLocationManager *)createLocationManager;
```

Creates a manager that allows to listen for device location updates.

### createLocationSimulatorWithGeometry:

```objectivec
- (nonnull YMKLocationSimulator *)createLocationSimulatorWithGeometry:
    (nonnull YMKPolyline *)geometry;
```

Creates a suspended LocationSimulator object with the given geometry.

### createLocationSimulator

```objectivec
- (nonnull YMKLocationSimulator *)createLocationSimulator;
```

Creates a suspended LocationSimulator object. Geometry must be set manually.

### createDummyLocationManager

```objectivec
- (nonnull YMKDummyLocationManager *)createDummyLocationManager;
```

Creates a manager that functions as a location proxy.

### createOffscreenMapWindowWithWidth:height:

```objectivec
- (nonnull YMKOffscreenMapWindow *)
    createOffscreenMapWindowWithWidth:(NSInteger)width
                               height:(NSInteger)height;
```

Creates an OffscreenMapWindow

### createOffscreenMapWindowWithWidth:height:customScaleFactor:

```objectivec
- (nonnull YMKOffscreenMapWindow *)
    createOffscreenMapWindowWithWidth:(NSInteger)width
                               height:(NSInteger)height
                    customScaleFactor:(float)customScaleFactor;
```

Creates an OffscreenMapWindow with custom scale factor The scale factor is equal to the number of pixels per device-independent point.

### createTrafficLayerWithMapWindow:

```objectivec
- (nonnull YMKTrafficLayer *)createTrafficLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates the traffic layer.

### createRoadEventsManager

```objectivec
- (nonnull YMKRoadEventsManager *)createRoadEventsManager;
```

Creates a manager that allows to interact with road events.

### createUserLocationLayerWithMapWindow:

```objectivec
- (nonnull YMKUserLocationLayer *)createUserLocationLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Create layer with the user location icon.

## Properties

### offlineCacheManager

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKOfflineCacheManager *offlineCacheManager;
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Returns a manager that handles offline maps, search index and road graph.

### storageManager

```objectivec
@property (nonatomic, readonly, nonnull) YMKStorageManager *storageManager;
```

Returns a manager that handles disk size and IO errors.

### version

```objectivec
@property (nonatomic, readonly, nonnull) NSString *version;
```

Returns the version of the MapKit bundle.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
