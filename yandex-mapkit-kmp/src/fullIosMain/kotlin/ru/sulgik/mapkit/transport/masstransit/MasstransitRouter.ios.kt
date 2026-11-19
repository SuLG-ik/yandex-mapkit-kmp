package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKMasstransitRouter as NativeMasstransitRouter

/** A router that builds public transport routes. */
public actual class MasstransitRouter internal constructor(private val nativeMasstransitRouter: NativeMasstransitRouter) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeMasstransitRouter {
        return nativeMasstransitRouter
    }

    /** Builds routes through [points] in the supplied order.
     *
     * Call on the UI thread. Keep the returned session while the request is active, and
     * [cancel][Session.cancel] it before replacement or screen disposal.
     */
    public actual fun requestRoutes(
        points: List<RequestPoint>,
        transitOptions: TransitOptions,
        routeOptions: RouteOptions,
        routeListener: RouteListener,
    ): Session {
        val request = RouteRequest(routeListener)
        val session = nativeMasstransitRouter.requestRoutesWithPoints(
            points = points.map(RequestPoint::toNative),
            transitOptions = transitOptions.toNative(),
            routeOptions = routeOptions.toNative(),
            routeHandler = request.toNative(),
        )
        return session.toCommon(request)
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MasstransitRouter) return false
        return nativeMasstransitRouter == other.nativeMasstransitRouter
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeMasstransitRouter.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeMasstransitRouter.toCommon(): MasstransitRouter {
    return MasstransitRouter(this)
}
