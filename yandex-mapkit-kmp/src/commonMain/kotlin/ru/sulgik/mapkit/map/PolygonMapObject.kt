package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon

public expect class PolygonMapObject : MapObject {

    public var geometry: Polygon

    public var strokeColor: Color

    public var strokeWidth: Float

    public var fillColor: Color

    public var isGeodesic: Boolean

    /**
     * Sets pattern to fill polygon.
     */
    public fun setPattern(image: ImageProvider, scale: Float)

    /**
     * Sets animated pattern to fill polygon.
     */
    public fun setPattern(animatedImage: AnimatedImageProvider, scale: Float)

    /**
     * Removes pattern.
     */
    public fun resetPattern()
}
