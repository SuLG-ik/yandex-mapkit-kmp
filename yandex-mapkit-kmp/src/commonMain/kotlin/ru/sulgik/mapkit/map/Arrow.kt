package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.PolylinePosition

expect class Arrow {

    val position: PolylinePosition

    var fillColor: Color

    var outlineColor: Color

    var outlineWidth: Float

    var length: Float

    var isVisible: Boolean

    var triangleHeight: Float

}