package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.RequestPoint

/** A router that builds pedestrian routes. */
public expect class PedestrianRouter {

    /** Builds routes through [points] in the supplied order.
     *
     * Call on the UI thread. Keep the returned session while the request is active, and
     * [cancel][Session.cancel] it before replacement or screen disposal.
     */
    public fun requestRoutes(
        points: List<RequestPoint>,
        timeOptions: TimeOptions,
        routeOptions: RouteOptions,
        routeListener: RouteListener,
    ): Session

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
