package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.logo.Logo

expect class Map {

    /**
     * Current camera position. Target position must be within latitude [-90, 90] and longitude [-180, 180].
     */
    val cameraPosition: CameraPosition

    /**
     * The map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    val visibleRegion: VisibleRegion

    val cameraBounds: CameraBounds

    val mapObjects: MapObjectCollection

    /**
     * If enabled, night mode will reduce map brightness and improve contrast.
     */
    var isNightModeEnabled: Boolean

    /**
     * Limits the number of visible basemap POIs.
     *
     * Optional property, can be null.
     */
    var poiLimit: Int?

    /**
     * Removes the 300 ms delay in emitting a tap gesture.
     *
     * However, a double-tap will emit a tap gesture along with a double-tap.
     */
    var isFastTapEnabled: Boolean

    /**
     * Enable/disable rotation gestures, such as rotation with two fingers.
     */
    var isRotateGesturesEnabled: Boolean

    /**
     * Enable/disable tilt gestures, such as parallel pan with two fingers.
     */
    var isTiltGesturesEnabled: Boolean

    /**
     * Enable/disable scroll gestures.
     */
    var isScrollGesturesEnabled: Boolean

    /**
     * Enable/disable zoom gestures.
     */
    var isZoomGesturesEnabled: Boolean

    /**
     * The base map type.
     */
    var mapType: MapType

    /**
     * Forces the map to be flat.
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.
     */
    fun set2DMode(enable: Boolean)

    /**
     * Erases tiles, caches, etc.
     *
     * Does not trigger the next frame generation.
     */
    fun wipe()

    /**
     * Calculates the camera position that projects the specified geometry into the current focusRect, or the full view if the focusRect is not set.
     */
    fun calculateCameraPosition(geometry: Geometry): CameraPosition

    /**
     * Calculates the camera position that projects the specified geometry into the custom focusRect.
     */
    fun calculateCameraPosition(geometry: Geometry, screenRect: ScreenRect): CameraPosition

    /**
     * Calculates the map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    fun calculateVisibleRegion(cameraPosition: CameraPosition): VisibleRegion

    /**
     * Camera position that projects the specified geometry into the custom focusRect, with custom azimuth and tilt camera parameters. If focus rect is not provided, current focus rect is used.
     */
    fun calculateCameraPosition(
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
    fun move(cameraPosition: CameraPosition)

    /**
     * Changes camera position.
     *
     * Can cancel a previous unfinished movement.
     * @param animation Required. Defines animation parameters. @see mapkit.Animation for more details.
     * @param cameraCallback A function that takes the bool argument marking the camera action complete. Invoked when:
     * * A camera action is cancelled (for example, as a result of a subsequent request for camera movement), passing false as an argument.
     * * A camera action finished successfully, passing true as an argument.
     */
    fun move(
        cameraPosition: CameraPosition,
        animation: Animation,
        cameraCallback: CameraCallback? = null,
    )

    /**
     * Adds camera listeners.
     */
    fun addCameraListener(cameraListener: CameraListener)

    /**
     * Removes camera listeners.
     */
    fun removeCameraListener(cameraListener: CameraListener)

    /**
     * Yandex logo object.
     */
    fun getLogo(): Logo

    /**
     * Adds input listeners.
     */
    fun addInputListener(inputListener: InputListener)

    /**
     * Removes input listeners.
     */
    fun removeInputListener(inputListener: InputListener)
    
}