package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.PolylinePosition

/** Walking or cycling section data. */
public expect class Fitness {

    /** How the user travels through the section. */
    public val type: FitnessType

    /** Via points projected onto the route. */
    public val viaPoints: List<PolylinePosition>

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
