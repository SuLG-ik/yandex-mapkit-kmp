package ru.sulgik.mapkit.transport.masstransit

/** Settings used by a transit router for a specific route. */
public data class RouteSettings(
    /** Transport types excluded from the route. */
    public val avoidTypes: List<String>,
    /** Transport types allowed in the route. */
    public val acceptTypes: List<String>,
)
