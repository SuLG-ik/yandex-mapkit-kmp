package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Subpolyline

/** A section of a walking, cycling or transit route. */
public expect class Section {

    /** General information about this section. */
    public val metadata: SectionMetadata

    /** The fragment of the route polyline that describes this section. */
    public val geometry: Subpolyline

    /** Stops from boarding to exiting transport, in route order. */
    public val stops: List<RouteStop>

    /** The geometry connecting consecutive stops on a transit ride. */
    public val rideLegs: List<Subpolyline>

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
