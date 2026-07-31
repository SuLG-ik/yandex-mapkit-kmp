package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.indoor.IndoorStateListener
import ru.sulgik.mapkit.logo.Logo

public expect class Map {

    /**
     * Current camera position. Target position must be within latitude [-90, 90] and longitude [-180, 180].
     */
    public val cameraPosition: CameraPosition

    /**
     * The map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    public val visibleRegion: VisibleRegion

    public val cameraBounds: CameraBounds

    /**
     * List of map objects associated with the map. The layerId for this collection can be
     * retrieved via LayerIds.mapObjectsLayerId
     */
    public val mapObjects: RootMapObjectCollection

    /**
     * If enabled, night mode will reduce map brightness and improve contrast.
     */
    public var isNightModeEnabled: Boolean

    /**
     * Limits the number of visible basemap POIs.
     *
     * Optional property, can be null.
     */
    public var poiLimit: Int?

    /**
     * Removes the 300 ms delay in emitting a tap gesture.
     *
     * However, a double-tap will emit a tap gesture along with a double-tap.
     */
    public var isFastTapEnabled: Boolean

    /**
     * Enable/disable rotation gestures, such as rotation with two fingers.
     */
    public var isRotateGesturesEnabled: Boolean

    /**
     * Enable/disable tilt gestures, such as parallel pan with two fingers.
     */
    public var isTiltGesturesEnabled: Boolean

    /**
     * Enable/disable scroll gestures.
     */
    public var isScrollGesturesEnabled: Boolean

    /**
     * Enable/disable zoom gestures.
     */
    public var isZoomGesturesEnabled: Boolean

    /**
     * The base map type.
     */
    public var mapType: MapType

    /**
     * Forces the map to be flat.
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.
     */
    public fun set2DMode(enable: Boolean)

    /**
     * Erases tiles, caches, etc.
     *
     * Does not trigger the next frame generation.
     */
    public fun wipe()

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
    public fun cameraPosition(
        geometry: Geometry,
        focusRect: ScreenRect? = null,
        azimuth: Float? = null,
        tilt: Float? = null,
    ): CameraPosition

    /**
     * Calculates the map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    public fun visibleRegion(cameraPosition: CameraPosition): VisibleRegion

    /**
     * Immediately changes the camera position.
     *
     * Can cancel a previous unfinished movement.
     */
    public fun move(cameraPosition: CameraPosition)

    /**
     * Changes camera position.
     *
     * Can cancel a previous unfinished movement.
     * @param animation Required. Defines animation parameters. @see mapkit.Animation for more details.
     * @param cameraCallback A function that takes the bool argument marking the camera action complete. Invoked when:
     * * A camera action is cancelled (for example, as a result of a subsequent request for camera movement), passing false as an argument.
     * * A camera action finished successfully, passing true as an argument.
     */
    public fun move(
        cameraPosition: CameraPosition,
        animation: Animation,
        cameraCallback: CameraCallback? = null,
    )

    /**
     * Adds camera listeners.
     *
     * The class does not retain the object in the 'cameraListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addCameraListener(cameraListener: WeakRef<CameraListener>)

    /**
     * Removes camera listeners.
     */
    public fun removeCameraListener(cameraListener: WeakRef<CameraListener>)

    /**
     * Yandex logo object.
     */
    public val logo: Logo

    /**
     * Adds input listeners.
     *
     * The class does not retain the object in the 'inputListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addInputListener(inputListener: WeakRef<InputListener>)

    /**
     * Removes input listeners.
     */
    public fun removeInputListener(inputListener: WeakRef<InputListener>)

    /**
     * Sets map style.
     */
    public fun setMapStyle(style: String)

    /**
     * Sets map style.
     */
    public fun setMapStyle(id: Int, style: String)

    /**
     * Enables/disables indoor plans on the map.
     *
     * Disabled by default.
     */
    public var isIndoorEnabled: Boolean

    /**
     * Subscribe to indoor state change events.
     *
     * The class does not retain the object in the 'indoorStateListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addIndoorStateListener(listener: WeakRef<IndoorStateListener>)

    /**
     * Unsubscribe from indoor state change events.
     */
    public fun removeIndoorStateListener(listener: WeakRef<IndoorStateListener>)

    /**
     * Resets all JSON style transformations applied to the map.
     */
    public fun resetMapStyles()

    /**
     * Enables hd mode of displayed content
     */
    public var isHdModeEnabled: Boolean

    /**
     * Selects one of predefined map style modes optimized for particular use case(transit, driving, etc).
     *
     * Resets json styles set with setMapStyle. MapMode.Map by deafult.
     */
    public var mode: MapMode

    /**
     * Enables rich textured 3d content on basemap.
     */
    public var isAwesomeModelsEnabled: Boolean

    /**
     * If enabled, the map background will be fully transparent.
     */
    public var isTransparentBackgroundEnabled: Boolean

    /**
     * If set to true, hides the indoor plans and shows the buildings without resetting the current
     * indoor plan.
     */
    public var isBuildingsAboveIndoorEnabled: Boolean

    public val isValid: Boolean
}
