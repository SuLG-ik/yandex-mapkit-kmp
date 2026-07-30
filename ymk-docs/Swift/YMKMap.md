---
title: "YMKMap"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMap"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMap.html"
---
# YMKMap

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMap.html)

```swift
class YMKMap : NSObject
```

The object that is used to interact with the map.

## Summary

### Instance methods

```swift
func cameraPosition(with geometry: YMKGeometry) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters || || ##func&nbsp;[cameraPosition](#camerapositionwithfocus)(with&nbsp;geometry:&nbsp;_[YMKGeometry](./YMKGeometry.md)_,## ##&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;focus&nbsp;focusRect:&nbsp;_[YMKScreenRect](./YMKScreenRect.md)_?)&nbsp;-\>&nbsp;_[YMKCameraPosition](./YMKCameraPosition.md)_##  Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters

```swift
func cameraPosition(with geometry: YMKGeometry,
                  focus focusRect: YMKScreenRect?,
                          azimuth: NSNumber?) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters || || ##func&nbsp;[cameraPosition](#camerapositionwithfocusazimuthtilt)(with&nbsp;geometry:&nbsp;_[YMKGeometry](./YMKGeometry.md)_,## ##&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;focus&nbsp;focusRect:&nbsp;_[YMKScreenRect](./YMKScreenRect.md)_?,## ##&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;azimuth:&nbsp;NSNumber?,## ##&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tilt:&nbsp;NSNumber?)&nbsp;-\>&nbsp;_[YMKCameraPosition](./YMKCameraPosition.md)_##  Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {` tilt} camera parameters

```swift
func visibleRegion(with cameraPosition: YMKCameraPosition) -> YMKVisibleRegion
```

```swift
func move(with cameraPosition: YMKCameraPosition)
```

Changes the camera position

```swift
func move(with cameraPosition: YMKCameraPosition, animation: YMKAnimation?)
```

Changes the camera position

```swift
func move(with cameraPosition: YMKCameraPosition,
                    animation: YMKAnimation?,
               cameraCallback: YMKMapCameraCallback? = nil)
```

Changes the camera position

```swift
func addInputListener(with inputListener: any YMKMapInputListener)
```

Adds input listeners

```swift
func removeInputListener(with inputListener: any YMKMapInputListener)
```

Removes input listeners

```swift
func addCameraListener(with cameraListener: any YMKMapCameraListener)
```

Adds camera listeners

```swift
func removeCameraListener(with cameraListener: any YMKMapCameraListener)
```

Removes camera listeners

```swift
func setMapLoadedListenerWith(_ mapLoadedListener: (any YMKMapLoadedListener)?)
```

Sets a map loaded listener

```swift
func addTapListener(with tapListener: any YMKLayersGeoObjectTapListener)
```

Adds a tap listener that is used to obtain brief geo object info

```swift
func removeTapListener(with tapListener: any YMKLayersGeoObjectTapListener)
```

Removes a tap listener that is used to obtain brief geo object info

```swift
func deselectGeoObject()
```

Resets the currently selected geo object

```swift
func selectGeoObject(withSelectionMetaData selectionMetaData: YMKGeoObjectSelectionMetadata)
```

Selects a geo object with the specified objectId in the specified layerId

```swift
func addIndoorStateListener(with indoorStateListener: any YMKIndoorStateListener)
```

Subscribe to indoor state change events

```swift
func removeIndoorStateListener(with indoorStateListener: any YMKIndoorStateListener)
```

Unsubscribe from indoor state change events

```swift
func setMapStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the map

```swift
func setMapStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the map

```swift
func resetMapStyles()
```

Resets all JSON style transformations applied to the map

```swift
func set2DMode(withEnable enable: Bool)
```

Forces the map to be flat

```swift
func addObjectLayer(withLayerId layerId: String) -> YMKRootMapObjectCollection
```

Creates a new independent map object collection linked to the specified layer ID

```swift
func projection() -> YMKProjection
```

Provides map projection

```swift
func wipe()
```

Erases tiles, caches, etc

```swift
func addTileLayer(withLayerId layerId: String,
                         layerOptions: YMKLayerOptions,
                 createTileDataSource: @escaping YMKCreateTileDataSource) -> YMKLayer
```

Adds tile layer

### Properties

```swift
var cameraPosition: YMKCameraPosition { get }
```

```swift
var visibleRegion: YMKVisibleRegion { get }
```

```swift
var cameraBounds: YMKCameraBounds { get }
```

```swift
var isNightModeEnabled: Bool { get set }
```

If enabled, night mode will reduce map brightness and improve contrast

```swift
var isTransparentBackgroundEnabled: Bool { get set }
```

If enabled, the map background will be fully transparent

```swift
var isZoomGesturesEnabled: Bool { get set }
```

Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out)

```swift
var isScrollGesturesEnabled: Bool { get set }
```

Enable/disable scroll gestures, such as the pan gesture

```swift
var isTiltGesturesEnabled: Bool { get set }
```

Enable/disable tilt gestures, such as parallel pan with two fingers

```swift
var isRotateGesturesEnabled: Bool { get set }
```

Enable/disable rotation gestures, such as rotation with two fingers

```swift
var isFastTapEnabled: Bool { get set }
```

Removes the 300 ms delay in emitting a tap gesture

```swift
var mapType: YMKMapType { get set }
```

Sets the base map type

```swift
var mapObjects: YMKRootMapObjectCollection { get }
```

```swift
var logo: YMKLogo { get }
```

Yandex logo object

```swift
var poiLimit: NSNumber? { get set }
```

Limits the number of visible basemap POIs

```swift
var isIndoorEnabled: Bool { get set }
```

Enables/disables indoor plans on the map

```swift
var isBuildingsAboveIndoorEnabled: Bool { get set }
```

If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan

```swift
var mode: YMKMapMode { get set }
```

Selects one of predefined map style modes optimized for particular use case(transit, driving, etc)

```swift
var isHdModeEnabled: Bool { get set }
```

Enables hd mode of displayed content

```swift
var isAwesomeModelsEnabled: Bool { get set }
```

Enables rich textured 3d content on basemap

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### cameraPosition(with:)

```swift
func cameraPosition(with geometry: YMKGeometry) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPosition(with:focus:)

```swift
func cameraPosition(with geometry: YMKGeometry,
                  focus focusRect: YMKScreenRect?) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPosition(with:focus:azimuth:)

```swift
func cameraPosition(with geometry: YMKGeometry,
                  focus focusRect: YMKScreenRect?,
                          azimuth: NSNumber?) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### cameraPosition(with:focus:azimuth:tilt:)

```swift
func cameraPosition(with geometry: YMKGeometry,
                  focus focusRect: YMKScreenRect?,
                          azimuth: NSNumber?,
                             tilt: NSNumber?) -> YMKCameraPosition
```

Calculates a camera position that projects the specified geometry into the given {` focusRect}, using the provided {` azimuth} and {``` tilt} camera parameters.

If {``` focusRect} is not provided, the current focus rect is used (or the full view if no focus rect is set).

If {``` azimuth} is not provided, the current {``` cameraPosition.azimuth} is used.

If {``` tilt} is not provided, the current {``` cameraPosition.tilt} is used.

- returns: The computed camera position.

### visibleRegion(with:)

```swift
func visibleRegion(with cameraPosition: YMKCameraPosition) -> YMKVisibleRegion
```

**Returns**

The map region that is visible from the given camera

position. Region IS bounded by latitude limits [-90, 90] and IS NOT

bounded by longitude limits [-180, 180]. If the longitude exceeds its

limits, we see the world's edge and another instance of the world

beyond this edge.

### move(with:)

```swift
func move(with cameraPosition: YMKCameraPosition)
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### move(with:animation:)

```swift
func move(with cameraPosition: YMKCameraPosition, animation: YMKAnimation?)
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### move(with:animation:cameraCallback:)

```swift
func move(with cameraPosition: YMKCameraPosition,
                    animation: YMKAnimation?,
               cameraCallback: YMKMapCameraCallback? = nil)
```

Changes the camera position. Can cancel a previous unfinished movement.

` null}, the camera position changes instantly. - see: mapkit.Animation for more details. - parameter: cameraCallback A function that receives a boolean indicating whether the camera action completed successfully. Invoked when: <ul> <li>The camera action is cancelled (for example, due to a new camera movement request), in which case {` false} is passed.

The camera action finishes successfully, in which case {``` true} is passed.

| Parameters |   |
| --- | --- |
| animation | Defines animation parameters. If { |

### addInputListener(with:)

```swift
func addInputListener(with inputListener: any YMKMapInputListener)
```

Adds input listeners.

The class does not retain the object in the 'inputListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeInputListener(with:)

```swift
func removeInputListener(with inputListener: any YMKMapInputListener)
```

Removes input listeners.

### addCameraListener(with:)

```swift
func addCameraListener(with cameraListener: any YMKMapCameraListener)
```

Adds camera listeners.

The class does not retain the object in the 'cameraListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeCameraListener(with:)

```swift
func removeCameraListener(with cameraListener: any YMKMapCameraListener)
```

Removes camera listeners.

### setMapLoadedListenerWith(_:)

```swift
func setMapLoadedListenerWith(_ mapLoadedListener: (any YMKMapLoadedListener)?)
```

Sets a map loaded listener.

The class does not retain the object in the 'mapLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### addTapListener(with:)

```swift
func addTapListener(with tapListener: any YMKLayersGeoObjectTapListener)
```

Adds a tap listener that is used to obtain brief geo object info.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListener(with:)

```swift
func removeTapListener(with tapListener: any YMKLayersGeoObjectTapListener)
```

Removes a tap listener that is used to obtain brief geo object info.

### deselectGeoObject()

```swift
func deselectGeoObject()
```

Resets the currently selected geo object.

### selectGeoObject(withSelectionMetaData:)

```swift
func selectGeoObject(withSelectionMetaData selectionMetaData: YMKGeoObjectSelectionMetadata)
```

Selects a geo object with the specified objectId in the specified layerId. If the object is not currently on the screen, it is selected anyway, but the user will not actually see that. You need to move the camera in addition to this call to be sure that the selected object is visible for the user. GeoObjectSelectionMetadata can be extracted from the geo object's metadata container when the user taps on a geo object.

### addIndoorStateListener(with:)

```swift
func addIndoorStateListener(with indoorStateListener: any YMKIndoorStateListener)
```

Subscribe to indoor state change events.

The class does not retain the object in the 'indoorStateListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeIndoorStateListener(with:)

```swift
func removeIndoorStateListener(with indoorStateListener: any YMKIndoorStateListener)
```

Unsubscribe from indoor state change events.

### setMapStyleWithStyle(_:)

```swift
func setMapStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the map. Same as setMapStyle(0, style). Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### setMapStyleWithId(_:style:)

```swift
func setMapStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the map. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### resetMapStyles()

```swift
func resetMapStyles()
```

Resets all JSON style transformations applied to the map.

### set2DMode(withEnable:)

```swift
func set2DMode(withEnable enable: Bool)
```

Forces the map to be flat. true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.

### addObjectLayer(withLayerId:)

```swift
func addObjectLayer(withLayerId layerId: String) -> YMKRootMapObjectCollection
```

Creates a new independent map object collection linked to the specified layer ID. Sublayers will be added after corresponding sublayers of the topmost layer.

### projection()

```swift
func projection() -> YMKProjection
```

Provides map projection

### wipe()

```swift
func wipe()
```

Erases tiles, caches, etc. Does not trigger the next frame generation.

### addTileLayer(withLayerId:layerOptions:createTileDataSource:)

```swift
func addTileLayer(withLayerId layerId: String,
                         layerOptions: YMKLayerOptions,
                 createTileDataSource: @escaping YMKCreateTileDataSource) -> YMKLayer
```

Adds tile layer.

## Properties

### cameraPosition

```swift
var cameraPosition: YMKCameraPosition { get }
```

**Returns**

Current camera position. Target position must be within

latitude [-90, 90] and longitude [-180, 180].

### visibleRegion

```swift
var visibleRegion: YMKVisibleRegion { get }
```

**Returns**

The map region that is currently visible. Region IS bounded

by latitude limits [-90, 90] and IS NOT bounded by longitude limits

[-180, 180]. If the longitude exceeds its limits, we see the world's

edge and another instance of the world beyond this edge.

### cameraBounds

```swift
var cameraBounds: YMKCameraBounds { get }
```

### isNightModeEnabled

```swift
var isNightModeEnabled: Bool { get set }
```

If enabled, night mode will reduce map brightness and improve contrast.

### isTransparentBackgroundEnabled

```swift
var isTransparentBackgroundEnabled: Bool { get set }
```

If enabled, the map background will be fully transparent. Note: the underlying platform view must be created with transparency support enabled for this flag to take effect (e.g. on Android, set the 'transparent' XML attribute on MapView; ; on iOS, create the MapView with transparencySupport: true).

### isZoomGesturesEnabled

```swift
var isZoomGesturesEnabled: Bool { get set }
```

Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out)

### isScrollGesturesEnabled

```swift
var isScrollGesturesEnabled: Bool { get set }
```

Enable/disable scroll gestures, such as the pan gesture.

### isTiltGesturesEnabled

```swift
var isTiltGesturesEnabled: Bool { get set }
```

Enable/disable tilt gestures, such as parallel pan with two fingers.

### isRotateGesturesEnabled

```swift
var isRotateGesturesEnabled: Bool { get set }
```

Enable/disable rotation gestures, such as rotation with two fingers.

### isFastTapEnabled

```swift
var isFastTapEnabled: Bool { get set }
```

Removes the 300 ms delay in emitting a tap gesture. However, a double-tap will emit a tap gesture along with a double-tap.

### mapType

```swift
var mapType: YMKMapType { get set }
```

Sets the base map type.

### mapObjects

```swift
var mapObjects: YMKRootMapObjectCollection { get }
```

**Returns**

List of map objects associated with the map. The layerId for

this collection can be retrieved via LayerIds.mapObjectsLayerId

### logo

```swift
var logo: YMKLogo { get }
```

Yandex logo object.

### poiLimit

```swift
var poiLimit: NSNumber? { get set }
```

Limits the number of visible basemap POIs.

Optional property, can be nil.

### isIndoorEnabled

```swift
var isIndoorEnabled: Bool { get set }
```

Enables/disables indoor plans on the map. Disabled by default.

### isBuildingsAboveIndoorEnabled

```swift
var isBuildingsAboveIndoorEnabled: Bool { get set }
```

If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan. False by default.

### mode

```swift
var mode: YMKMapMode { get set }
```

Selects one of predefined map style modes optimized for particular use case(transit, driving, etc). Resets json styles set with setMapStyle. MapMode.Map by deafult.

### isHdModeEnabled

```swift
var isHdModeEnabled: Bool { get set }
```

Enables hd mode of displayed content

### isAwesomeModelsEnabled

```swift
var isAwesomeModelsEnabled: Bool { get set }
```

Enables rich textured 3d content on basemap.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
