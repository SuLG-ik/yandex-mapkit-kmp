package ru.sulgik.mapkit.geometry

public expect class Polygon {

    public constructor(outerRing: LinearRing, innerRings: List<LinearRing>)

    public val outerRing: LinearRing

    public val innerRings: List<LinearRing>
}
