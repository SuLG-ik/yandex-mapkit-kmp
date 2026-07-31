package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.indoor.IndoorStateListener
import ru.sulgik.mapkit.logo.Logo
import ru.sulgik.mapkit.logo.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.Map as NativeMap

public actual class Map internal constructor(private val nativeMap: NativeMap) {

    public fun toNative(): NativeMap {
        return nativeMap
    }

    /**
     * Current camera position. Target position must be within latitude [-90, 90] and longitude [-180, 180].
     */
    public actual val cameraPosition: CameraPosition
        get() = nativeMap.cameraPosition.toCommon()

    /**
     * The map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    public actual val visibleRegion: VisibleRegion
        get() = nativeMap.visibleRegion.toCommon()

    public actual val cameraBounds: CameraBounds
        get() = nativeMap.cameraBounds.toCommon()

    /**
     * List of map objects associated with the map. The layerId for this collection can be
     * retrieved via LayerIds.mapObjectsLayerId
     */
    public actual val mapObjects: RootMapObjectCollection = nativeMap.mapObjects.toCommon()

    /**
     * If enabled, night mode will reduce map brightness and improve contrast.
     */
    public actual var isNightModeEnabled: Boolean
        get() = nativeMap.isNightModeEnabled
        set(value) {
            nativeMap.isNightModeEnabled = value
        }

    /**
     * Limits the number of visible basemap POIs.
     *
     * Optional property, can be null.
     */
    public actual var poiLimit: Int?
        get() = nativeMap.poiLimit
        set(value) {
            nativeMap.poiLimit = value
        }

    /**
     * Removes the 300 ms delay in emitting a tap gesture.
     *
     * However, a double-tap will emit a tap gesture along with a double-tap.
     */
    public actual var isFastTapEnabled: Boolean
        get() = nativeMap.isFastTapEnabled
        set(value) {
            nativeMap.isFastTapEnabled = value
        }

    /**
     * Enable/disable rotation gestures, such as rotation with two fingers.
     */
    public actual var isRotateGesturesEnabled: Boolean
        get() = nativeMap.isRotateGesturesEnabled
        set(value) {
            nativeMap.isRotateGesturesEnabled = value
        }

    /**
     * Enable/disable tilt gestures, such as parallel pan with two fingers.
     */
    public actual var isTiltGesturesEnabled: Boolean
        get() = nativeMap.isTiltGesturesEnabled
        set(value) {
            nativeMap.isTiltGesturesEnabled = value
        }

    /**
     * Enable/disable scroll gestures.
     */
    public actual var isScrollGesturesEnabled: Boolean
        get() = nativeMap.isScrollGesturesEnabled
        set(value) {
            nativeMap.isScrollGesturesEnabled = value
        }

    /**
     * Enable/disable zoom gestures.
     */
    public actual var isZoomGesturesEnabled: Boolean
        get() = nativeMap.isZoomGesturesEnabled
        set(value) {
            nativeMap.isZoomGesturesEnabled = value
        }

    /**
     * Forces the map to be flat.
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.
     */
    public actual fun set2DMode(enable: Boolean) {
        nativeMap.set2DMode(enable)
    }

    /**
     * Erases tiles, caches, etc.
     *
     * Does not trigger the next frame generation.
     */
    public actual fun wipe() {
        nativeMap.wipe()
    }

    /**
     * Calculates a camera position that projects the specified geometry into the given [focusRect],
     * using the provided [azimuth] and [tilt] camera parameters.
     *
     * If [focusRect] is not provided, the current focus rect is used (or the full view if no focus
     * rect is set).
     *
     * If [azimuth] is not provided, the current [cameraPosition] azimuth is used.
     *
     * If [tilt] is not provided, the current [cameraPosition] tilt is used.
     */
    public actual fun cameraPosition(
        geometry: Geometry,
        focusRect: ScreenRect?,
        azimuth: Float?,
        tilt: Float?,
    ): CameraPosition {
        return nativeMap.cameraPosition(
            geometry.toNative(),
            focusRect?.toNative(),
            azimuth,
            tilt,
        ).toCommon()
    }

    /**
     * Calculates the map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    public actual fun visibleRegion(cameraPosition: CameraPosition): VisibleRegion {
        return nativeMap.visibleRegion(cameraPosition.toNative()).toCommon()
    }

    /**
     * Immediately changes the camera position.
     *
     * Can cancel a previous unfinished movement.
     */
    public actual fun move(cameraPosition: CameraPosition) {
        nativeMap.move(cameraPosition.toNative())
    }

    /**
     * Changes camera position.
     *
     * Can cancel a previous unfinished movement.
     * @param animation Required. Defines animation parameters. @see mapkit.Animation for more details.
     * @param cameraCallback A function that takes the bool argument marking the camera action complete. Invoked when:
     * * A camera action is cancelled (for example, as a result of a subsequent request for camera movement), passing false as an argument.
     * * A camera action finished successfully, passing true as an argument.
     */
    public actual fun move(
        cameraPosition: CameraPosition,
        animation: Animation,
        cameraCallback: CameraCallback?,
    ) {
        nativeMap.move(cameraPosition.toNative(), animation.toNative(), cameraCallback?.toNative())
    }

    /**
     * Adds camera listeners.
     */
    public actual fun addCameraListener(cameraListener: WeakRef<CameraListener>) {
        nativeMap.addCameraListener(cameraListener.toNative())
    }

    /**
     * Removes camera listeners.
     */
    public actual fun removeCameraListener(cameraListener: WeakRef<CameraListener>) {
        nativeMap.removeCameraListener(cameraListener.toNative())
    }

    /**
     * Yandex logo object.
     */
    public actual val logo: Logo
        get() = nativeMap.logo.toCommon()

    /**
     * The base map type.
     */
    public actual var mapType: MapType
        get() = nativeMap.mapType.toCommon()
        set(value) {
            nativeMap.mapType = value.toNative()
        }

    /**
     * Adds input listeners.
     */
    public actual fun addInputListener(inputListener: WeakRef<InputListener>) {
        nativeMap.addInputListener(inputListener.toNative())
    }

    /**
     * Removes input listeners.
     */
    public actual fun removeInputListener(inputListener: WeakRef<InputListener>) {
        nativeMap.removeInputListener(inputListener.toNative())
    }

    /**
     * Sets map style.
     */
    public actual fun setMapStyle(style: String) {
        nativeMap.setMapStyle(style)
    }

    /**
     * Sets map style.
     */
    public actual fun setMapStyle(id: Int, style: String) {
        nativeMap.setMapStyle(id, style)
    }

    /**
     * Enables/disables indoor plans on the map.
     *
     * Disabled by default.
     */
    public actual var isIndoorEnabled: Boolean
        get() = nativeMap.isIndoorEnabled
        set(value) {
            nativeMap.isIndoorEnabled = value
        }

    /**
     * Subscribe to indoor state change events.
     *
     * The class does not retain the object in the 'indoorStateListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addIndoorStateListener(listener: WeakRef<IndoorStateListener>) {
        nativeMap.addIndoorStateListener(listener.toNative())
    }

    /**
     * Unsubscribe from indoor state change events.
     */
    public actual fun removeIndoorStateListener(listener: WeakRef<IndoorStateListener>) {
        nativeMap.removeIndoorStateListener(listener.toNative())
    }

    /**
     * Resets all JSON style transformations applied to the map.
     */
    public actual fun resetMapStyles() {
        nativeMap.resetMapStyles()
    }

    /**
     * Enables hd mode of displayed content
     */
    public actual var isHdModeEnabled: Boolean
        get() = nativeMap.isHdModeEnabled
        set(value) {
            nativeMap.isHdModeEnabled = value
        }

    /**
     * Selects one of predefined map style modes optimized for particular use case(transit, driving, etc).
     *
     * Resets json styles set with setMapStyle. MapMode.Map by deafult.
     */
    public actual var mode: MapMode
        get() = nativeMap.mode.toCommon()
        set(value) {
            nativeMap.mode = value.toNative()
        }

    /**
     * Enables rich textured 3d content on basemap.
     */
    public actual var isAwesomeModelsEnabled: Boolean
        get() = nativeMap.isAwesomeModelsEnabled
        set(value) {
            nativeMap.isAwesomeModelsEnabled = value
        }

    /**
     * If enabled, the map background will be fully transparent.
     */
    public actual var isTransparentBackgroundEnabled: Boolean
        get() = nativeMap.isTransparentBackgroundEnabled
        set(value) {
            nativeMap.isTransparentBackgroundEnabled = value
        }

    /**
     * If set to true, hides the indoor plans and shows the buildings without resetting the current
     * indoor plan.
     */
    public actual var isBuildingsAboveIndoorEnabled: Boolean
        get() = nativeMap.isBuildingsAboveIndoorEnabled
        set(value) {
            nativeMap.isBuildingsAboveIndoorEnabled = value
        }

    public actual val isValid: Boolean
        get() = nativeMap.isValid
}

public fun NativeMap.toCommon(): Map {
    return Map(this)
}
