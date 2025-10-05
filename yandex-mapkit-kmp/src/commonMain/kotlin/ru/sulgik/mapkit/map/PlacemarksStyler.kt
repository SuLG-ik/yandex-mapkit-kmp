package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF

public expect class PlacemarksStyler {

    public fun setScaleFunction(points: List<PointF>)
    public val isValid: Boolean

}