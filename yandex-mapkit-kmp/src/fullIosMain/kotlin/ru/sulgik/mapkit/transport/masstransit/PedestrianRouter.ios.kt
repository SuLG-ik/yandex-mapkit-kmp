package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPedestrianRouter as NativePedestrianRouter

/** A router that builds pedestrian routes. */
public actual class PedestrianRouter internal constructor(
    private val nativePedestrianRouter: NativePedestrianRouter,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativePedestrianRouter = nativePedestrianRouter

    /** Builds routes through [points] in the supplied order.
     *
     * Call on the UI thread. Keep the returned session while the request is active, and
     * [cancel][Session.cancel] it before replacement or screen disposal.
     */
    public actual fun requestRoutes(
        points: List<RequestPoint>,
        timeOptions: TimeOptions,
        routeOptions: RouteOptions,
        routeListener: RouteListener,
    ): Session {
        val request = RouteRequest(routeListener)
        val session =
            nativePedestrianRouter.requestRoutesWithPoints(
                points = points.map(RequestPoint::toNative),
                timeOptions = timeOptions.toNative(),
                routeOptions = routeOptions.toNative(),
                routeHandler = request.toNative(),
            )
        return session.toCommon(request)
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PedestrianRouter) return false
        return nativePedestrianRouter == other.nativePedestrianRouter
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativePedestrianRouter.hashCode()
}

/** Wraps this native handle. */
public fun NativePedestrianRouter.toCommon(): PedestrianRouter = PedestrianRouter(this)
