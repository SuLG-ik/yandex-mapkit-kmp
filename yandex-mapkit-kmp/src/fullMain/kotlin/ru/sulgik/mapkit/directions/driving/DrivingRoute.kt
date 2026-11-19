package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition

/** A driving route returned by MapKit. */
public expect class DrivingRoute {

    /** The SDK route identifier. */
    public val routeId: String

    /** Route geometry. */
    public val geometry: Polyline

    /** The points from the originating request, when supplied by the SDK. */
    public val requestPoints: List<RequestPoint>?

    /** Positions of the waypoints on [geometry], including the first and last points. */
    public val wayPoints: List<PolylinePosition>

    /** Two wrappers are equal when they hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
