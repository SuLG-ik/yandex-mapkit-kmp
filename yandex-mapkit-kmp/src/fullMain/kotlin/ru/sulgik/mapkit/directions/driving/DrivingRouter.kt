package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.RequestPoint

/** Router that builds driving routes. */
public expect class DrivingRouter {

    /**
     * Builds routes through [points] in the supplied order.
     *
     * Call on the UI thread and retain the returned session until delivery or cancellation.
     * Call [DrivingSession.cancel] when replacing the request or leaving its owning screen.
     */
    public fun requestRoutes(
        points: List<RequestPoint>,
        drivingOptions: DrivingOptions,
        vehicleOptions: VehicleOptions,
        routeListener: DrivingRouteListener,
    ): DrivingSession

    /** Two wrappers are equal when they hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
