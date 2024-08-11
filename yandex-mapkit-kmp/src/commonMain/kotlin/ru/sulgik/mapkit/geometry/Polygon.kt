package ru.sulgik.mapkit.geometry

public expect class Polygon {

    public constructor(outerRing: LinearRing, innerRing: List<LinearRing>)

    public val outerRing: LinearRing

    public val innerRing: List<LinearRing>

}