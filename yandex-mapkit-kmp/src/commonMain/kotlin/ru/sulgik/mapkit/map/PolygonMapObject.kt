package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon

public expect class PolygonMapObject : MapObject {

    public var geometry: Polygon

    public var strokeColor: Color

    public var strokeWidth: Float

    public var fillColor: Color

    public var isGeodesic: Boolean

    public fun setPattern(image: ImageProvider, scale: Float)

    public fun resetPattern()

}