package ru.sulgik.mapkit.geometry

public expect class LinearRing {

    public constructor(points: List<Point>)

    public val points: List<Point>

}

internal fun List<LinearRing>.linearRingsListToString(): String {
    return "[${joinToString(", ")}]"
}