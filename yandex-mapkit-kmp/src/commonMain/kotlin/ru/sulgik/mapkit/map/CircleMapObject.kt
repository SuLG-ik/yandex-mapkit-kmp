package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Circle

public expect class CircleMapObject: MapObject {

    public var geometry: Circle

    public var strokeColor: Color

    public var strokeWidth: Float

    public var fillColor: Color

    public var isGeodesic: Boolean

}