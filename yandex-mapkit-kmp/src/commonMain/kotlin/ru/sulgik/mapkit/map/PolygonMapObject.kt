package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon

expect class PolygonMapObject: MapObject {

    var geometry: Polygon

    var strokeColor: Color

    var strokeWidth: Float

    var fillColor: Color

    var isGeodesic: Boolean

    fun setPattern(image: ImageProvider, scale: Float)

    fun resetPattern()

}