package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Circle

expect class CircleMapObject: MapObject {

    var geometry: Circle

    var strokeColor: Color

    var strokeWidth: Float

    var fillColor: Color

    var isGeodesic: Boolean

}