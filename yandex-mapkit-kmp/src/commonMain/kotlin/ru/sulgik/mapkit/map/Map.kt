package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.ScreenRect
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

    public val mapObjects: MapObjectCollection

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
     * Calculates the camera position that projects the specified geometry into the current focusRect, or the full view if the focusRect is not set.
     */
    public fun calculateCameraPosition(geometry: Geometry): CameraPosition

    /**
     * Calculates the camera position that projects the specified geometry into the custom focusRect.
     */
    public fun calculateCameraPosition(geometry: Geometry, screenRect: ScreenRect): CameraPosition

    /**
     * Calculates the map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    public fun calculateVisibleRegion(cameraPosition: CameraPosition): VisibleRegion

    /**
     * Camera position that projects the specified geometry into the custom focusRect, with custom azimuth and tilt camera parameters. If focus rect is not provided, current focus rect is used.
     */
    public fun calculateCameraPosition(
        geometry: Geometry,
        azimuth: Float,
        tilt: Float,
        screenRect: ScreenRect,
    ): CameraPosition


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
     */
    public fun addCameraListener(cameraListener: CameraListener)

    /**
     * Removes camera listeners.
     */
    public fun removeCameraListener(cameraListener: CameraListener)

    /**
     * Yandex logo object.
     */
    public fun getLogo(): Logo

    /**
     * Adds input listeners.
     */
    public fun addInputListener(inputListener: InputListener)

    /**
     * Removes input listeners.
     */
    public fun removeInputListener(inputListener: InputListener)

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
    public fun addIndoorStateListener(listener: IndoorStateListener)

    /**
     * Unsubscribe from indoor state change events.
     */
    public fun removeIndoorStateListener(listener: IndoorStateListener)

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
}