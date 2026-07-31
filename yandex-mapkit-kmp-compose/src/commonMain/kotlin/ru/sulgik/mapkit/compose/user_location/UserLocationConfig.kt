package ru.sulgik.mapkit.compose.user_location

import androidx.compose.ui.graphics.Color
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.user_location.UserLocationLayer

/**
 * Config for [UserLocationLayer]
 */
public data class UserLocationConfig(
    /**
     * User location visibility.
     *
     * null if use map's default. Use null as initial value, don't affect after change custom value to null
     */
    public val isVisible: Boolean? = null,
    /**
     * Heading mode.
     *
     * null if use map's default. Use null as initial value, don't affect after change custom value to null
     */
    public val isHeadingEnabled: Boolean? = null,
    /**
     * Auto zoom.
     *
     * null if use map's default. Use null as initial value, don't affect after change custom value to null
     */
    public val isAutoZoomEnabled: Boolean? = null,

    /**
     * Sets the anchor to the specified position in pixels and enables Anchor mode with [UserLocationLayer.setAnchor]
     *
     * null if use map's default. Use null as initial value, don't affect after change custom value to null
     */
    val anchor: Anchor? = null,

    val arrow: LocationIcon? = null,
    val pin: LocationIcon? = null,
    val accuracy: LocationAccuracy? = null,
) {
    public data class Anchor(
        public val normal: PointF,
        public val course: PointF,
    )

    public data class LocationIcon(
        public val image: ImageProvider,
        public val style: IconStyle = IconStyle(),
        public val direction: Float? = null,
        public val opacity: Float = 1f,
    )

    public data class LocationAccuracy(
        public val strokeColor: Color = DefaultStrokeColor,
        public val strokeWidth: Float = DefaultStrokeWidth,
        public val fillColor: Color = DefaultFillColor,
        public val isGeodesic: Boolean = DefaultGeodesic,
    )
}

private val DefaultStrokeColor = Color(0xFF66FF00)
private const val DefaultStrokeWidth = 5f
private val DefaultFillColor = Color(0x9966FF00)
private const val DefaultGeodesic = false
