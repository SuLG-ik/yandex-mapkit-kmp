package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapType

/**
 * Config for [Map] that uses default configuration
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
     * Forces the map to be flat with [Map.set2DMode]
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation.
     * false - All tiles start showing the "rise up" animation.
     * null – use map's default value
     */
    public val use2dMode: Boolean? = null,

    /**
     * Config to control Yandex logo object with [Map.getLogo]
     */
    public val logo: MapLogoConfig = MapLogoConfig(),
)