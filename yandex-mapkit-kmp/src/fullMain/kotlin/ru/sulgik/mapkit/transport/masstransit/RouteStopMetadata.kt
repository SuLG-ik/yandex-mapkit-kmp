package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.BaseMetadata

/** Stop information, with optional station entrances and exits. */
public expect class RouteStopMetadata : BaseMetadata {

    /** The stop on the route. */
    public val stop: Stop

    /** An underground station exit, when present. */
    public val stopExit: Stop?

    /** The exit coordinates, when present. */
    public val exitPoint: Point?

    /** An underground station entrance, when present. */
    public val stopEntrance: Stop?

    /** The entrance coordinates, when present. */
    public val entrancePoint: Point?

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
