package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.map.GestureFocusPointMode
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapMode
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.PointOfView

/**
 * Config for [Map] and [MapWindow] that uses default configuration
 */
public data class MapConfig(
    /**
     * If enabled, night mode will reduce map brightness and improve contrast.
     *
     * If null use map's default value
     */
    public val isNightModeEnabled: Boolean? = null,
    /**
     * Limits the number of visible basemap POIs with [Map.poiLimit]
     *
     * Optional property, can be null.
     */
    public val poiLimit: Int? = null,
    /**
     * Removes the 300 ms delay in emitting a tap gesture with [Map.isFastTapEnabled]
     *
     * However, a double-tap will emit a tap gesture along with a double-tap.
     *
     * If null use map's default value
     */
    public val isFastTapEnabled: Boolean? = null,
    /**
     * Enable/disable rotation gestures, such as rotation with two fingers with [Map.isRotateGesturesEnabled]]
     *
     * If null use map's default value
     */
    public val isRotateGesturesEnabled: Boolean? = null,
    /**
     * Enable/disable tilt gestures, such as parallel pan with two fingers with [Map.isTiltGesturesEnabled]
     *
     * If null use map's default value
     */
    public val isTiltGesturesEnabled: Boolean? = null,
    /**
     * Enable/disable scroll gestures with [Map.isScrollGesturesEnabled]
     *
     * If null use map's default value
     */
    public val isScrollGesturesEnabled: Boolean? = null,
    /**
     * Enable/disable zoom gestures with [Map.isZoomGesturesEnabled]
     *
     * If null use map's default value
     */
    public val isZoomGesturesEnabled: Boolean? = null,
    /**
     * The base map type with [Map.mapType]
     *
     * If null use map's default value
     */
    public val mapType: MapType? = null,

    /**
     * One of predefined map style modes optimized for particular use case with [Map.mode]
     *
     * Resets json styles set with [mapStyle].
     *
     * If null use map's default value
     */
    public val mode: MapMode? = null,

    /**
     * JSON style transformation applied to the map with [Map.setMapStyle]
     *
     * If null use map's default value
     */
    public val mapStyle: String? = null,

    /**
     * Enables hd mode of displayed content with [Map.isHdModeEnabled]
     *
     * If null use map's default value
     */
    public val isHdModeEnabled: Boolean? = null,

    /**
     * Enables/disables indoor plans on the map with [Map.isIndoorEnabled]
     *
     * If null use map's default value
     */
    public val isIndoorEnabled: Boolean? = null,

    /**
     * Enables rich textured 3d content on basemap with [Map.isAwesomeModelsEnabled]
     *
     * If null use map's default value
     */
    public val isAwesomeModelsEnabled: Boolean? = null,

    /**
     * Makes the map background fully transparent with [Map.isTransparentBackgroundEnabled]
     *
     * If null use map's default value
     */
    public val isTransparentBackgroundEnabled: Boolean? = null,

    /**
     * Hides the indoor plans and shows the buildings without resetting the current indoor plan
     * with [Map.isBuildingsAboveIndoorEnabled]
     *
     * If null use map's default value
     */
    public val isBuildingsAboveIndoorEnabled: Boolean? = null,

    /**
     * Config to control zoom limits and the world bounding box with [Map.cameraBounds]
     */
    public val cameraBounds: MapCameraBoundsConfig = MapCameraBoundsConfig(),

    /**
     * The area of interest inside the view with [MapWindow.focusRect]
     *
     * If null use map's default value
     */
    public val focusRect: ScreenRect? = null,

    /**
     * The point on the screen that corresponds to camera position with [MapWindow.focusPoint]
     *
     * If null use map's default value
     */
    public val focusPoint: ScreenPoint? = null,

    /**
     * The focus point of gestures with [MapWindow.gestureFocusPoint]
     *
     * If null use map's default value
     */
    public val gestureFocusPoint: ScreenPoint? = null,

    /**
     * The way provided gesture focus point affects gestures with [MapWindow.gestureFocusPointMode]
     *
     * If null use map's default value
     */
    public val gestureFocusPointMode: GestureFocusPointMode? = null,

    /**
     * The position of the point of view with [MapWindow.pointOfView]
     *
     * If null use map's default value
     */
    public val pointOfView: PointOfView? = null,

    /**
     * Scale factor of the map with [MapWindow.scaleFactor]
     *
     * If null use map's default value
     */
    public val scaleFactor: Float? = null,

    /**
     * Forces the map to be flat with [Map.set2DMode]
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation.
     * false - All tiles start showing the "rise up" animation.
     * null – use map's default value
     */
    public val use2dMode: Boolean? = null,

    /**
     * Config to control Yandex logo object with [Map.logo]
     */
    public val logo: MapLogoConfig = MapLogoConfig(),

    /**
     * The base map type with [MapWindow.setMaxFps].
     *
     * Valid range: [0, max display refresh rate]. 0 means max display refresh rate.
     *
     * If null use map's default value
     */
    public val fps: Int? = null,
)
