package ru.sulgik.mapkit.geometry

expect class Polygon {

    constructor(outerRing: LinearRing, innerRing: List<LinearRing>)

    val outerRing: LinearRing

    val innerRing: List<LinearRing>

}