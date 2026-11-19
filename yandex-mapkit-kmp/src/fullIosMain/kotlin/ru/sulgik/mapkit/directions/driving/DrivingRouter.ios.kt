package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKDrivingRouter as NativeDrivingRouter

/** Router that builds driving routes. */
public actual class DrivingRouter internal constructor(private val nativeDrivingRouter: NativeDrivingRouter) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeDrivingRouter {
        return nativeDrivingRouter
    }

    /**
     * Builds routes through [points] in the supplied order.
     *
     * Call on the UI thread and retain the returned session until delivery or cancellation.
     * Call [DrivingSession.cancel] when replacing the request or leaving its owning screen.
     */
    public actual fun requestRoutes(
        points: List<RequestPoint>,
        drivingOptions: DrivingOptions,
        vehicleOptions: VehicleOptions,
        routeListener: DrivingRouteListener,
    ): DrivingSession {
        val request = DrivingRouteRequest(routeListener)
        val session = nativeDrivingRouter.requestRoutesWithPoints(
            points = points.map(RequestPoint::toNative),
            drivingOptions = drivingOptions.toNative(),
            vehicleOptions = vehicleOptions.toNative(),
            routeHandler = request.toNative(),
        )
        return session.toCommon(request)
    }

    /** Two wrappers are equal when they hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DrivingRouter) return false
        return nativeDrivingRouter == other.nativeDrivingRouter
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeDrivingRouter.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeDrivingRouter.toCommon(): DrivingRouter {
    return DrivingRouter(this)
}
