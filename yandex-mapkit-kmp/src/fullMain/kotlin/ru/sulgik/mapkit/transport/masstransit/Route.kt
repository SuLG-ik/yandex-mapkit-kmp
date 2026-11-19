package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.uri.UriObjectMetadata

/** A walking, cycling or transit route returned by MapKit. */
public expect class Route {
    /** General information about this route. */
    public val metadata: RouteMetadata

    /** Waypoints in route order. */
    public val wayPoints: List<WayPoint>

    /** Sections in route order. */
    public val sections: List<Section>

    /** Geometry of the whole route. */
    public val geometry: Polyline

    /** URI metadata that can identify the route. */
    public val uriMetadata: UriObjectMetadata

    /** Returns the path distance between two positions on this route. */
    public fun distanceBetweenPolylinePositions(
        from: PolylinePosition,
        to: PolylinePosition,
    ): Double

    /** Returns the travel time between two positions on this route. */
    public fun timeBetweenPolylinePositions(
        from: PolylinePosition,
        to: PolylinePosition,
    ): Double

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
