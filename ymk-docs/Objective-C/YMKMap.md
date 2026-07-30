---
title: "YMKMap"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMap"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMap.html"
---
# YMKMap

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMap.html)

```objectivec
@interface YMKMap : NSObject
```

The object that is used to interact with the map.

## Summary

### Instance methods

```objectivec
- (nonnull YMKCameraPosition *)cameraPositionWithGeometry:
    (nonnull YMKGeometry *)geometry;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters || || ##-&nbsp;(nonnull&nbsp;_[YMKCameraPosition](./YMKCameraPosition.md)_&nbsp;\*) &nbsp;&nbsp;&nbsp;&nbsp;[cameraPositionWithGeometry](#camerapositionwithgeometryfocusrect):(nonnull&nbsp;_[YMKGeometry](./YMKGeometry.md)_&nbsp;\*)geometry &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;focusRect:(nullable&nbsp;_[YMKScreenRect](./YMKScreenRect.md)_&nbsp;\*)focusRect;##  Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters

```objectivec
- (nonnull YMKCameraPosition *)
    cameraPositionWithGeometry:(nonnull YMKGeometry *)geometry
                     focusRect:(nullable YMKScreenRect *)focusRect
                       azimuth:(nullable NSNumber *)azimuth;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters || || ##-&nbsp;(nonnull&nbsp;_[YMKCameraPosition](./YMKCameraPosition.md)_&nbsp;\*) &nbsp;&nbsp;&nbsp;&nbsp;[cameraPositionWithGeometry](#camerapositionwithgeometryfocusrectazimuthtilt):(nonnull&nbsp;_[YMKGeometry](./YMKGeometry.md)_&nbsp;\*)geometry &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;focusRect:(nullable&nbsp;_[YMKScreenRect](./YMKScreenRect.md)_&nbsp;\*)focusRect &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;azimuth:(nullable&nbsp;NSNumber&nbsp;\*)azimuth &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tilt:(nullable&nbsp;NSNumber&nbsp;\*)tilt;##  Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters

```objectivec
- (nonnull YMKVisibleRegion *)visibleRegionWithCameraPosition:
    (nonnull YMKCameraPosition *)cameraPosition;
```

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition;
```

Changes the camera position

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition
                     animation:(nullable YMKAnimation *)animation;
```

Changes the camera position

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition
                     animation:(nullable YMKAnimation *)animation
                cameraCallback:(nullable YMKMapCameraCallback)cameraCallback;
```

Changes the camera position

```objectivec
- (void)addInputListenerWithInputListener:
    (nonnull id<YMKMapInputListener>)inputListener;
```

Adds input listeners

```objectivec
- (void)removeInputListenerWithInputListener:
    (nonnull id<YMKMapInputListener>)inputListener;
```

Removes input listeners

```objectivec
- (void)addCameraListenerWithCameraListener:
    (nonnull id<YMKMapCameraListener>)cameraListener;
```

Adds camera listeners

```objectivec
- (void)removeCameraListenerWithCameraListener:
    (nonnull id<YMKMapCameraListener>)cameraListener;
```

Removes camera listeners

```objectivec
- (void)setMapLoadedListenerWithMapLoadedListener:
    (nullable id<YMKMapLoadedListener>)mapLoadedListener;
```

Sets a map loaded listener

```objectivec
- (void)addTapListenerWithTapListener:
    (nonnull id<YMKLayersGeoObjectTapListener>)tapListener;
```

Adds a tap listener that is used to obtain brief geo object info

```objectivec
- (void)removeTapListenerWithTapListener:
    (nonnull id<YMKLayersGeoObjectTapListener>)tapListener;
```

Removes a tap listener that is used to obtain brief geo object info

```objectivec
- (void)deselectGeoObject;
```

Resets the currently selected geo object

```objectivec
- (void)selectGeoObjectWithSelectionMetaData:
    (nonnull YMKGeoObjectSelectionMetadata *)selectionMetaData;
```

Selects a geo object with the specified objectId in the specified layerId

```objectivec
- (void)addIndoorStateListenerWithIndoorStateListener:
    (nonnull id<YMKIndoorStateListener>)indoorStateListener;
```

Subscribe to indoor state change events

```objectivec
- (void)removeIndoorStateListenerWithIndoorStateListener:
    (nonnull id<YMKIndoorStateListener>)indoorStateListener;
```

Unsubscribe from indoor state change events

```objectivec
- (BOOL)setMapStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the map

```objectivec
- (BOOL)setMapStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the map

```objectivec
- (void)resetMapStyles;
```

Resets all JSON style transformations applied to the map

```objectivec
- (void)set2DModeWithEnable:(BOOL)enable;
```

Forces the map to be flat

```objectivec
- (nonnull YMKRootMapObjectCollection *)addMapObjectLayerWithLayerId:
    (nonnull NSString *)layerId;
```

Creates a new independent map object collection linked to the specified layer ID

```objectivec
- (nonnull YMKProjection *)projection;
```

Provides map projection

```objectivec
- (void)wipe;
```

Erases tiles, caches, etc

```objectivec
- (nonnull YMKLayer *)
    addTileLayerWithLayerId:(nonnull NSString *)layerId
               layerOptions:(nonnull YMKLayerOptions *)layerOptions
       createTileDataSource:
           (nonnull YMKCreateTileDataSource)createTileDataSource;
```

Adds tile layer

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKCameraPosition *cameraPosition;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKVisibleRegion *visibleRegion;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKCameraBounds *cameraBounds;
```

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isNightModeEnabled) BOOL nightModeEnabled;
```

If enabled, night mode will reduce map brightness and improve contrast

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isTransparentBackgroundEnabled)
    BOOL transparentBackgroundEnabled;
```

If enabled, the map background will be fully transparent

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isZoomGesturesEnabled) BOOL zoomGesturesEnabled;
```

Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out)

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isScrollGesturesEnabled) BOOL scrollGesturesEnabled;
```

Enable/disable scroll gestures, such as the pan gesture

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isTiltGesturesEnabled) BOOL tiltGesturesEnabled;
```

Enable/disable tilt gestures, such as parallel pan with two fingers

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isRotateGesturesEnabled) BOOL rotateGesturesEnabled;
```

Enable/disable rotation gestures, such as rotation with two fingers

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isFastTapEnabled) BOOL fastTapEnabled;
```

Removes the 300 ms delay in emitting a tap gesture

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) YMKMapType mapType;
```

Sets the base map type

```objectivec
@property (nonatomic, readonly, nonnull) YMKRootMapObjectCollection *mapObjects;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKLogo *logo;
```

Yandex logo object

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    NSNumber *poiLimit;
```

Limits the number of visible basemap POIs

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isIndoorEnabled) BOOL indoorEnabled;
```

Enables/disables indoor plans on the map

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isBuildingsAboveIndoorEnabled)
    BOOL buildingsAboveIndoorEnabled;
```

If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) YMKMapMode mode;
```

Selects one of predefined map style modes optimized for particular use case(transit, driving, etc)

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isHdModeEnabled) BOOL hdModeEnabled;
```

Enables hd mode of displayed content

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isAwesomeModelsEnabled) BOOL awesomeModelsEnabled;
```

Enables rich textured 3d content on basemap

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### cameraPositionWithGeometry:

```objectivec
- (nonnull YMKCameraPosition *)cameraPositionWithGeometry:
    (nonnull YMKGeometry *)geometry;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPositionWithGeometry:focusRect:

```objectivec
- (nonnull YMKCameraPosition *)
    cameraPositionWithGeometry:(nonnull YMKGeometry *)geometry
                     focusRect:(nullable YMKScreenRect *)focusRect;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPositionWithGeometry:focusRect:azimuth:

```objectivec
- (nonnull YMKCameraPosition *)
    cameraPositionWithGeometry:(nonnull YMKGeometry *)geometry
                     focusRect:(nullable YMKScreenRect *)focusRect
                       azimuth:(nullable NSNumber *)azimuth;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPositionWithGeometry:focusRect:azimuth:tilt:

```objectivec
- (nonnull YMKCameraPosition *)
    cameraPositionWithGeometry:(nonnull YMKGeometry *)geometry
                     focusRect:(nullable YMKScreenRect *)focusRect
                       azimuth:(nullable NSNumber *)azimuth
                          tilt:(nullable NSNumber *)tilt;
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### visibleRegionWithCameraPosition:

```objectivec
- (nonnull YMKVisibleRegion *)visibleRegionWithCameraPosition:
    (nonnull YMKCameraPosition *)cameraPosition;
```

**Returns**

The map region that is visible from the given camera

position. Region IS bounded by latitude limits [-90, 90] and IS NOT

bounded by longitude limits [-180, 180]. If the longitude exceeds its

limits, we see the world's edge and another instance of the world

beyond this edge.

### moveWithCameraPosition:

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition;
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### moveWithCameraPosition:animation:

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition
                     animation:(nullable YMKAnimation *)animation;
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### moveWithCameraPosition:animation:cameraCallback:

```objectivec
- (void)moveWithCameraPosition:(nonnull YMKCameraPosition *)cameraPosition
                     animation:(nullable YMKAnimation *)animation
                cameraCallback:(nullable YMKMapCameraCallback)cameraCallback;
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### addInputListenerWithInputListener:

```objectivec
- (void)addInputListenerWithInputListener:
    (nonnull id<YMKMapInputListener>)inputListener;
```

Adds input listeners.

The class does not retain the object in the 'inputListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeInputListenerWithInputListener:

```objectivec
- (void)removeInputListenerWithInputListener:
    (nonnull id<YMKMapInputListener>)inputListener;
```

Removes input listeners.

### addCameraListenerWithCameraListener:

```objectivec
- (void)addCameraListenerWithCameraListener:
    (nonnull id<YMKMapCameraListener>)cameraListener;
```

Adds camera listeners.

The class does not retain the object in the 'cameraListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeCameraListenerWithCameraListener:

```objectivec
- (void)removeCameraListenerWithCameraListener:
    (nonnull id<YMKMapCameraListener>)cameraListener;
```

Removes camera listeners.

### setMapLoadedListenerWithMapLoadedListener:

```objectivec
- (void)setMapLoadedListenerWithMapLoadedListener:
    (nullable id<YMKMapLoadedListener>)mapLoadedListener;
```

Sets a map loaded listener.

The class does not retain the object in the 'mapLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### addTapListenerWithTapListener:

```objectivec
- (void)addTapListenerWithTapListener:
    (nonnull id<YMKLayersGeoObjectTapListener>)tapListener;
```

Adds a tap listener that is used to obtain brief geo object info.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListenerWithTapListener:

```objectivec
- (void)removeTapListenerWithTapListener:
    (nonnull id<YMKLayersGeoObjectTapListener>)tapListener;
```

Removes a tap listener that is used to obtain brief geo object info.

### deselectGeoObject

```objectivec
- (void)deselectGeoObject;
```

Resets the currently selected geo object.

### selectGeoObjectWithSelectionMetaData:

```objectivec
- (void)selectGeoObjectWithSelectionMetaData:
    (nonnull YMKGeoObjectSelectionMetadata *)selectionMetaData;
```

Selects a geo object with the specified objectId in the specified layerId. If the object is not currently on the screen, it is selected anyway, but the user will not actually see that. You need to move the camera in addition to this call to be sure that the selected object is visible for the user. GeoObjectSelectionMetadata can be extracted from the geo object's metadata container when the user taps on a geo object.

### addIndoorStateListenerWithIndoorStateListener:

```objectivec
- (void)addIndoorStateListenerWithIndoorStateListener:
    (nonnull id<YMKIndoorStateListener>)indoorStateListener;
```

Subscribe to indoor state change events.

The class does not retain the object in the 'indoorStateListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeIndoorStateListenerWithIndoorStateListener:

```objectivec
- (void)removeIndoorStateListenerWithIndoorStateListener:
    (nonnull id<YMKIndoorStateListener>)indoorStateListener;
```

Unsubscribe from indoor state change events.

### setMapStyleWithStyle:

```objectivec
- (BOOL)setMapStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the map. Same as setMapStyle(0, style). Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### setMapStyleWithId:style:

```objectivec
- (BOOL)setMapStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the map. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### resetMapStyles

```objectivec
- (void)resetMapStyles;
```

Resets all JSON style transformations applied to the map.

### set2DModeWithEnable:

```objectivec
- (void)set2DModeWithEnable:(BOOL)enable;
```

Forces the map to be flat. true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.

### addMapObjectLayerWithLayerId:

```objectivec
- (nonnull YMKRootMapObjectCollection *)addMapObjectLayerWithLayerId:
    (nonnull NSString *)layerId;
```

Creates a new independent map object collection linked to the specified layer ID. Sublayers will be added after corresponding sublayers of the topmost layer.

### projection

```objectivec
- (nonnull YMKProjection *)projection;
```

Provides map projection

### wipe

```objectivec
- (void)wipe;
```

Erases tiles, caches, etc. Does not trigger the next frame generation.

### addTileLayerWithLayerId:layerOptions:createTileDataSource:

```objectivec
- (nonnull YMKLayer *)
    addTileLayerWithLayerId:(nonnull NSString *)layerId
               layerOptions:(nonnull YMKLayerOptions *)layerOptions
       createTileDataSource:
           (nonnull YMKCreateTileDataSource)createTileDataSource;
```

Adds tile layer.

## Properties

### cameraPosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKCameraPosition *cameraPosition;
```

**Returns**

Current camera position. Target position must be within

latitude [-90, 90] and longitude [-180, 180].

### visibleRegion

```objectivec
@property (nonatomic, readonly, nonnull) YMKVisibleRegion *visibleRegion;
```

**Returns**

The map region that is currently visible. Region IS bounded

by latitude limits [-90, 90] and IS NOT bounded by longitude limits

[-180, 180]. If the longitude exceeds its limits, we see the world's

edge and another instance of the world beyond this edge.

### cameraBounds

```objectivec
@property (nonatomic, readonly, nonnull) YMKCameraBounds *cameraBounds;
```

### nightModeEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isNightModeEnabled) BOOL nightModeEnabled;
```

If enabled, night mode will reduce map brightness and improve contrast.

### transparentBackgroundEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isTransparentBackgroundEnabled)
    BOOL transparentBackgroundEnabled;
```

If enabled, the map background will be fully transparent. Note: the underlying platform view must be created with transparency support enabled for this flag to take effect (e.g. on Android, set the 'transparent' XML attribute on MapView; ; on iOS, create the MapView with transparencySupport: true).

### zoomGesturesEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isZoomGesturesEnabled) BOOL zoomGesturesEnabled;
```

Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out)

### scrollGesturesEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isScrollGesturesEnabled) BOOL scrollGesturesEnabled;
```

Enable/disable scroll gestures, such as the pan gesture.

### tiltGesturesEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isTiltGesturesEnabled) BOOL tiltGesturesEnabled;
```

Enable/disable tilt gestures, such as parallel pan with two fingers.

### rotateGesturesEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isRotateGesturesEnabled) BOOL rotateGesturesEnabled;
```

Enable/disable rotation gestures, such as rotation with two fingers.

### fastTapEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isFastTapEnabled) BOOL fastTapEnabled;
```

Removes the 300 ms delay in emitting a tap gesture. However, a double-tap will emit a tap gesture along with a double-tap.

### mapType

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) YMKMapType mapType;
```

Sets the base map type.

### mapObjects

```objectivec
@property (nonatomic, readonly, nonnull) YMKRootMapObjectCollection *mapObjects;
```

**Returns**

List of map objects associated with the map. The layerId for

this collection can be retrieved via LayerIds.mapObjectsLayerId

### logo

```objectivec
@property (nonatomic, readonly, nonnull) YMKLogo *logo;
```

Yandex logo object.

### poiLimit

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    NSNumber *poiLimit;
```

Limits the number of visible basemap POIs.

Optional property, can be nil.

### indoorEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isIndoorEnabled) BOOL indoorEnabled;
```

Enables/disables indoor plans on the map. Disabled by default.

### buildingsAboveIndoorEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isBuildingsAboveIndoorEnabled)
    BOOL buildingsAboveIndoorEnabled;
```

If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan. False by default.

### mode

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) YMKMapMode mode;
```

Selects one of predefined map style modes optimized for particular use case(transit, driving, etc). Resets json styles set with setMapStyle. MapMode.Map by deafult.

### hdModeEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isHdModeEnabled) BOOL hdModeEnabled;
```

Enables hd mode of displayed content

### awesomeModelsEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isAwesomeModelsEnabled) BOOL awesomeModelsEnabled;
```

Enables rich textured 3d content on basemap.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
