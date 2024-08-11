package ru.sulgik.mapkit.geometry

public expect class MultiPolygon {

    public constructor(polygons: List<Polygon>)

    public val polygons: List<Polygon>

}