package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Point

/** An origin, destination or intermediate stop of a route. */
public data class WayPoint(
    /** The original waypoint coordinates. */
    public val position: Point,
    /** The arrival coordinates selected by the router. */
    public val selectedArrivalPoint: Point? = null,
    /** The departure coordinates selected by the router. */
    public val selectedDeparturePoint: Point? = null,
    /** The originating request's context for this waypoint. */
    public val context: String? = null,
    /** The indoor level identifier. */
    public val levelId: String? = null,
    /** The indoor level name. */
    public val levelName: String? = null,
)
