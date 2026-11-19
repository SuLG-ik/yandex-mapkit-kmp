package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata

/** Information about a walking, cycling or transit route. */
public expect class RouteMetadata : BaseMetadata {
    /** Travel time, walking distance and transfer count. */
    public val weight: Weight

    /** The router's settings, when reported. */
    public val settings: RouteSettings?

    /** Estimated times, when the route is time-dependent. */
    public val estimation: TravelEstimation?

    /** Waypoints in route order. */
    public val wayPoints: List<WayPoint>

    /** The SDK route identifier, when reported. */
    public val routeId: String?

    /** Route flags, when reported. */
    public val flags: Flags?

    /** Stair and ramp counts. */
    public val stairsSummary: StairsSummary

    /** The SDK explanation of this route, when reported. */
    public val routeExplanation: String?

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
