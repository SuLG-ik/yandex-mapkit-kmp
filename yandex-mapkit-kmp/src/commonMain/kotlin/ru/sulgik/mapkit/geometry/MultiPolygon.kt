package ru.sulgik.mapkit.geometry

expect class MultiPolygon {

    constructor(polygons: List<Polygon>)

    val polygons: List<Polygon>

}