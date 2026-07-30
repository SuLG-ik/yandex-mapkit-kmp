---
title: "Map"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Map"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Map.html"
---
# Map

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Map.html)

**Package** com.yandex.mapkit.map

`interface Map`

The object that is used to interact with the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `CameraPosition` | `getCameraPosition()` |
| `CameraPosition` | `cameraPosition(@NonNull Geometry geometry)`<br>Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters. |
| `CameraPosition` | `cameraPosition(@NonNull Geometry geometry, @Nullable ScreenRect focusRect)`<br>Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters. |
| `CameraPosition` | `cameraPosition(@NonNull Geometry geometry, @Nullable ScreenRect focusRect, @Nullable java.lang.Float azimuth)`<br>Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters. |
| `CameraPosition` | `cameraPosition(@NonNull Geometry geometry, @Nullable ScreenRect focusRect, @Nullable java.lang.Float azimuth, @Nullable java.lang.Float tilt)`<br>Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters. |
| `VisibleRegion` | `getVisibleRegion()` |
| `VisibleRegion` | `visibleRegion(@NonNull CameraPosition cameraPosition)` |
| `void` | `move(@NonNull CameraPosition cameraPosition)`<br>Changes the camera position. |
| `void` | `move(@NonNull CameraPosition cameraPosition, @Nullable Animation animation)`<br>Changes the camera position. |
| `void` | `move(@NonNull CameraPosition cameraPosition, @Nullable Animation animation, @Nullable CameraCallback cameraCallback)`<br>Changes the camera position. |
| `CameraBounds` | `getCameraBounds()` |
| `boolean` | `isNightModeEnabled()`<br>If enabled, night mode will reduce map brightness and improve contrast. |
| `void` | `setNightModeEnabled(boolean nightModeEnabled)` |
| `boolean` | `isTransparentBackgroundEnabled()`<br>If enabled, the map background will be fully transparent. |
| `void` | `setTransparentBackgroundEnabled(boolean transparentBackgroundEnabled)` |
| `boolean` | `isZoomGesturesEnabled()`<br>Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out) |
| `void` | `setZoomGesturesEnabled(boolean zoomGesturesEnabled)` |
| `boolean` | `isScrollGesturesEnabled()`<br>Enable/disable scroll gestures, such as the pan gesture. |
| `void` | `setScrollGesturesEnabled(boolean scrollGesturesEnabled)` |
| `boolean` | `isTiltGesturesEnabled()`<br>Enable/disable tilt gestures, such as parallel pan with two fingers. |
| `void` | `setTiltGesturesEnabled(boolean tiltGesturesEnabled)` |
| `boolean` | `isRotateGesturesEnabled()`<br>Enable/disable rotation gestures, such as rotation with two fingers. |
| `void` | `setRotateGesturesEnabled(boolean rotateGesturesEnabled)` |
| `boolean` | `isFastTapEnabled()`<br>Removes the 300 ms delay in emitting a tap gesture. |
| `void` | `setFastTapEnabled(boolean fastTapEnabled)` |
| `MapType` | `getMapType()`<br>Sets the base map type. |
| `void` | `setMapType(@NonNull MapType mapType)` |
| `void` | `addInputListener(@NonNull java.lang.ref.WeakReference<InputListener> inputListener)`<br>Adds input listeners. |
| `void` | `removeInputListener(@NonNull java.lang.ref.WeakReference<InputListener> inputListener)`<br>Removes input listeners. |
| `void` | `addCameraListener(@NonNull java.lang.ref.WeakReference<CameraListener> cameraListener)`<br>Adds camera listeners. |
| `void` | `removeCameraListener(@NonNull java.lang.ref.WeakReference<CameraListener> cameraListener)`<br>Removes camera listeners. |
| `void` | `setMapLoadedListener(@Nullable java.lang.ref.WeakReference<MapLoadedListener> mapLoadedListener)`<br>Sets a map loaded listener. |
| `RootMapObjectCollection` | `getMapObjects()` |
| `void` | `addTapListener(@NonNull java.lang.ref.WeakReference<GeoObjectTapListener> tapListener)`<br>Adds a tap listener that is used to obtain brief geo object info. |
| `void` | `removeTapListener(@NonNull java.lang.ref.WeakReference<GeoObjectTapListener> tapListener)`<br>Removes a tap listener that is used to obtain brief geo object info. |
| `void` | `deselectGeoObject()`<br>Resets the currently selected geo object. |
| `void` | `selectGeoObject(@NonNull GeoObjectSelectionMetadata selectionMetaData)`<br>Selects a geo object with the specified objectId in the specified layerId. |
| `Logo` | `getLogo()`<br>Yandex logo object. |
| `java.lang.Integer` | `getPoiLimit()`<br>Limits the number of visible basemap POIs. |
| `void` | `setPoiLimit(@Nullable java.lang.Integer poiLimit)` |
| `boolean` | `isIndoorEnabled()`<br>Enables/disables indoor plans on the map. |
| `void` | `setIndoorEnabled(boolean indoorEnabled)` |
| `boolean` | `isBuildingsAboveIndoorEnabled()`<br>If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan. |
| `void` | `setBuildingsAboveIndoorEnabled(boolean buildingsAboveIndoorEnabled)` |
| `void` | `addIndoorStateListener(@NonNull java.lang.ref.WeakReference<IndoorStateListener> indoorStateListener)`<br>Subscribe to indoor state change events. |
| `void` | `removeIndoorStateListener(@NonNull java.lang.ref.WeakReference<IndoorStateListener> indoorStateListener)`<br>Unsubscribe from indoor state change events. |
| `boolean` | `setMapStyle(@NonNull java.lang.String style)`<br>Applies JSON style transformations to the map. |
| `boolean` | `setMapStyle(int id, @NonNull java.lang.String style)`<br>Applies JSON style transformations to the map. |
| `void` | `resetMapStyles()`<br>Resets all JSON style transformations applied to the map. |
| `void` | `set2DMode(boolean enable)`<br>Forces the map to be flat. |
| `RootMapObjectCollection` | `addMapObjectLayer(@NonNull java.lang.String layerId)`<br>Creates a new independent map object collection linked to the specified layer ID. |
| `Projection` | `projection()`<br>Provides map projection |
| `MapMode` | `getMode()`<br>Selects one of predefined map style modes optimized for particular use case(transit, driving, etc). |
| `void` | `setMode(@NonNull MapMode mode)` |
| `boolean` | `isHdModeEnabled()`<br>Enables hd mode of displayed content |
| `void` | `setHdModeEnabled(boolean hdModeEnabled)` |
| `void` | `wipe()`<br>Erases tiles, caches, etc. |
| `boolean` | `isAwesomeModelsEnabled()`<br>Enables rich textured 3d content on basemap. |
| `void` | `setAwesomeModelsEnabled(boolean awesomeModelsEnabled)` |
| `Layer` | `addTileLayer(@NonNull java.lang.String layerId, @NonNull LayerOptions layerOptions, @NonNull CreateTileDataSource createDataSource)`<br>Adds tile layer. |
| `boolean` | `isValid()`<br>Tells if this **Map** is valid or not. |

## Methods

### getCameraPosition

```java
@NonNull
CameraPosition getCameraPosition()
```

**Returns**

Current camera position. Target position must be within latitude [-90, 90] and longitude [-180, 180].

### cameraPosition

```java
@NonNull
CameraPosition cameraPosition(@NonNull Geometry geometry)
```

Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters.

If  is not provided, the current focus rect is used (or the full view if no focus rect is set).

If  is not provided, the current  is used.

If  is not provided, the current  is used.

**Returns**

The computed camera position.

### cameraPosition

```java
@NonNull
CameraPosition cameraPosition(@NonNull Geometry geometry,
                              @Nullable ScreenRect focusRect)
```

Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters.

If  is not provided, the current focus rect is used (or the full view if no focus rect is set).

If  is not provided, the current  is used.

If  is not provided, the current  is used.

**Returns**

The computed camera position.

### cameraPosition

```java
@NonNull
CameraPosition cameraPosition(@NonNull Geometry geometry,
                              @Nullable ScreenRect focusRect,
                              @Nullable java.lang.Float azimuth)
```

Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters.

If  is not provided, the current focus rect is used (or the full view if no focus rect is set).

If  is not provided, the current  is used.

If  is not provided, the current  is used.

**Returns**

The computed camera position.

### cameraPosition

```java
@NonNull
CameraPosition cameraPosition(@NonNull Geometry geometry,
                              @Nullable ScreenRect focusRect,
                              @Nullable java.lang.Float azimuth,
                              @Nullable java.lang.Float tilt)
```

Calculates a camera position that projects the specified geometry into the given , using the provided  and  camera parameters.

If  is not provided, the current focus rect is used (or the full view if no focus rect is set).

If  is not provided, the current  is used.

If  is not provided, the current  is used.

**Returns**

The computed camera position.

### getVisibleRegion

```java
@NonNull
VisibleRegion getVisibleRegion()
```

**Returns**

The map region that is currently visible. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.

### visibleRegion

```java
@NonNull
VisibleRegion visibleRegion(@NonNull CameraPosition cameraPosition)
```

**Returns**

The map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.

### move

```java
void move(@NonNull CameraPosition cameraPosition)
```

Changes the camera position.

Can cancel a previous unfinished movement.

| Parameters |   |
| --- | --- |
| `animation` | Defines animation parameters. If , the camera position changes instantly. @see mapkit.Animation for more details. |
| `cameraCallback` | A function that receives a boolean indicating whether the camera action completed successfully. Invoked when:<br>- The camera action is cancelled (for example, due to a new camera movement request), in which case  is passed.<br>- The camera action finishes successfully, in which case  is passed. |

### move

```java
void move(@NonNull CameraPosition cameraPosition,
          @Nullable Animation animation)
```

Changes the camera position.

Can cancel a previous unfinished movement.

| Parameters |   |
| --- | --- |
| `animation` | Defines animation parameters. If , the camera position changes instantly. @see mapkit.Animation for more details. |
| `cameraCallback` | A function that receives a boolean indicating whether the camera action completed successfully. Invoked when:<br>- The camera action is cancelled (for example, due to a new camera movement request), in which case  is passed.<br>- The camera action finishes successfully, in which case  is passed. |

### move

```java
void move(@NonNull CameraPosition cameraPosition,
          @Nullable Animation animation,
          @Nullable CameraCallback cameraCallback)
```

Changes the camera position.

Can cancel a previous unfinished movement.

| Parameters |   |
| --- | --- |
| `animation` | Defines animation parameters. If , the camera position changes instantly. @see mapkit.Animation for more details. |
| `cameraCallback` | A function that receives a boolean indicating whether the camera action completed successfully. Invoked when:<br>- The camera action is cancelled (for example, due to a new camera movement request), in which case  is passed.<br>- The camera action finishes successfully, in which case  is passed. |

### getCameraBounds

```java
@NonNull
CameraBounds getCameraBounds()
```

### isNightModeEnabled

```java
boolean isNightModeEnabled()
```

If enabled, night mode will reduce map brightness and improve contrast.

### setNightModeEnabled

```java
void setNightModeEnabled(boolean nightModeEnabled)
```

### isTransparentBackgroundEnabled

```java
boolean isTransparentBackgroundEnabled()
```

If enabled, the map background will be fully transparent.

Note: the underlying platform view must be created with transparency support enabled for this flag to take effect (e.g. on Android, set the 'transparent' XML attribute on MapView; ; on iOS, create the MapView with transparencySupport: true).

### setTransparentBackgroundEnabled

```java
void setTransparentBackgroundEnabled(boolean transparentBackgroundEnabled)
```

### isZoomGesturesEnabled

```java
boolean isZoomGesturesEnabled()
```

Enable/disable zoom gestures, for example: - pinch - double tap (zoom in) - tap with two fingers (zoom out)

### setZoomGesturesEnabled

```java
void setZoomGesturesEnabled(boolean zoomGesturesEnabled)
```

### isScrollGesturesEnabled

```java
boolean isScrollGesturesEnabled()
```

Enable/disable scroll gestures, such as the pan gesture.

### setScrollGesturesEnabled

```java
void setScrollGesturesEnabled(boolean scrollGesturesEnabled)
```

### isTiltGesturesEnabled

```java
boolean isTiltGesturesEnabled()
```

Enable/disable tilt gestures, such as parallel pan with two fingers.

### setTiltGesturesEnabled

```java
void setTiltGesturesEnabled(boolean tiltGesturesEnabled)
```

### isRotateGesturesEnabled

```java
boolean isRotateGesturesEnabled()
```

Enable/disable rotation gestures, such as rotation with two fingers.

### setRotateGesturesEnabled

```java
void setRotateGesturesEnabled(boolean rotateGesturesEnabled)
```

### isFastTapEnabled

```java
boolean isFastTapEnabled()
```

Removes the 300 ms delay in emitting a tap gesture.

However, a double-tap will emit a tap gesture along with a double-tap.

### setFastTapEnabled

```java
void setFastTapEnabled(boolean fastTapEnabled)
```

### getMapType

```java
@NonNull
MapType getMapType()
```

Sets the base map type.

### setMapType

```java
void setMapType(@NonNull MapType mapType)
```

### addInputListener

```java
void addInputListener(@NonNull java.lang.ref.WeakReference<InputListener> inputListener)
```

Adds input listeners.

The class does not retain the object in the 'inputListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeInputListener

```java
void removeInputListener(@NonNull java.lang.ref.WeakReference<InputListener> inputListener)
```

Removes input listeners.

### addCameraListener

```java
void addCameraListener(@NonNull java.lang.ref.WeakReference<CameraListener> cameraListener)
```

Adds camera listeners.

The class does not retain the object in the 'cameraListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeCameraListener

```java
void removeCameraListener(@NonNull java.lang.ref.WeakReference<CameraListener> cameraListener)
```

Removes camera listeners.

### setMapLoadedListener

```java
void setMapLoadedListener(@Nullable java.lang.ref.WeakReference<MapLoadedListener> mapLoadedListener)
```

Sets a map loaded listener.

The class does not retain the object in the 'mapLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### getMapObjects

```java
@NonNull
RootMapObjectCollection getMapObjects()
```

**Returns**

List of map objects associated with the map. The layerId for this collection can be retrieved via LayerIds.mapObjectsLayerId

### addTapListener

```java
void addTapListener(@NonNull java.lang.ref.WeakReference<GeoObjectTapListener> tapListener)
```

Adds a tap listener that is used to obtain brief geo object info.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListener

```java
void removeTapListener(@NonNull java.lang.ref.WeakReference<GeoObjectTapListener> tapListener)
```

Removes a tap listener that is used to obtain brief geo object info.

### deselectGeoObject

```java
void deselectGeoObject()
```

Resets the currently selected geo object.

### selectGeoObject

```java
void selectGeoObject(@NonNull GeoObjectSelectionMetadata selectionMetaData)
```

Selects a geo object with the specified objectId in the specified layerId.

If the object is not currently on the screen, it is selected anyway, but the user will not actually see that. You need to move the camera in addition to this call to be sure that the selected object is visible for the user. GeoObjectSelectionMetadata can be extracted from the geo object's metadata container when the user taps on a geo object.

### getLogo

```java
@NonNull
Logo getLogo()
```

Yandex logo object.

### getPoiLimit

```java
@Nullable
java.lang.Integer getPoiLimit()
```

Limits the number of visible basemap POIs.

Optional property, can be null.

### setPoiLimit

```java
void setPoiLimit(@Nullable java.lang.Integer poiLimit)
```

### isIndoorEnabled

```java
boolean isIndoorEnabled()
```

Enables/disables indoor plans on the map.

Disabled by default.

### setIndoorEnabled

```java
void setIndoorEnabled(boolean indoorEnabled)
```

### isBuildingsAboveIndoorEnabled

```java
boolean isBuildingsAboveIndoorEnabled()
```

If set to true, hides the indoor plans and shows the buildings without resetting the current indoor plan.

False by default.

### setBuildingsAboveIndoorEnabled

```java
void setBuildingsAboveIndoorEnabled(boolean buildingsAboveIndoorEnabled)
```

### addIndoorStateListener

```java
void addIndoorStateListener(@NonNull java.lang.ref.WeakReference<IndoorStateListener> indoorStateListener)
```

Subscribe to indoor state change events.

The class does not retain the object in the 'indoorStateListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeIndoorStateListener

```java
void removeIndoorStateListener(@NonNull java.lang.ref.WeakReference<IndoorStateListener> indoorStateListener)
```

Unsubscribe from indoor state change events.

### setMapStyle

```java
boolean setMapStyle(@NonNull java.lang.String style)
```

Applies JSON style transformations to the map.

Same as setMapStyle(0, style). Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### setMapStyle

```java
boolean setMapStyle(int id,
                    @NonNull java.lang.String style)
```

Applies JSON style transformations to the map.

Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Affects VectorMap and Hybrid map types. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed, and false otherwise. If the returned value is false, the current map style remains unchanged.

### resetMapStyles

```java
void resetMapStyles()
```

Resets all JSON style transformations applied to the map.

### set2DMode

```java
void set2DMode(boolean enable)
```

Forces the map to be flat.

true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.

### addMapObjectLayer

```java
@NonNull
RootMapObjectCollection addMapObjectLayer(@NonNull java.lang.String layerId)
```

Creates a new independent map object collection linked to the specified layer ID.

Sublayers will be added after corresponding sublayers of the topmost layer.

### projection

```java
@NonNull
Projection projection()
```

Provides map projection

### getMode

```java
@NonNull
MapMode getMode()
```

Selects one of predefined map style modes optimized for particular use case(transit, driving, etc).

Resets json styles set with setMapStyle. MapMode.Map by deafult.

### setMode

```java
void setMode(@NonNull MapMode mode)
```

### isHdModeEnabled

```java
boolean isHdModeEnabled()
```

Enables hd mode of displayed content

### setHdModeEnabled

```java
void setHdModeEnabled(boolean hdModeEnabled)
```

### wipe

```java
void wipe()
```

Erases tiles, caches, etc.

Does not trigger the next frame generation.

### isAwesomeModelsEnabled

```java
boolean isAwesomeModelsEnabled()
```

Enables rich textured 3d content on basemap.

### setAwesomeModelsEnabled

```java
void setAwesomeModelsEnabled(boolean awesomeModelsEnabled)
```

### addTileLayer

```java
@NonNull
Layer addTileLayer(@NonNull java.lang.String layerId,
                   @NonNull LayerOptions layerOptions,
                   @NonNull CreateTileDataSource createDataSource)
```

Adds tile layer.

### isValid

```java
boolean isValid()
```

Tells if this **Map** is valid or not.

Any other method (except for this one) called on an invalid **Map** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
