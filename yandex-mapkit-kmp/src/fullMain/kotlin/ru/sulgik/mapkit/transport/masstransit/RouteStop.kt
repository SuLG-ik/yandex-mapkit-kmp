package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Point

/** A public transport stop on a route. */
public expect class RouteStop {

    /** The stop information and optional entrances or exits. */
    public val metadata: RouteStopMetadata

    /** The stop coordinates. */
    public val position: Point

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
