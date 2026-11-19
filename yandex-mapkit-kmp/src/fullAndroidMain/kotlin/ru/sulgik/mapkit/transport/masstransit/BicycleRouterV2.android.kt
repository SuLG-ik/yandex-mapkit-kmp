package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.transport.masstransit.BicycleRouterV2 as NativeBicycleRouterV2

/** A router that builds bicycle routes. */
public actual class BicycleRouterV2 internal constructor(private val nativeBicycleRouterV2: NativeBicycleRouterV2) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeBicycleRouterV2 {
        return nativeBicycleRouterV2
    }

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
        val session = nativeBicycleRouterV2.requestRoutes(
            points.map(RequestPoint::toNative),
            timeOptions.toNative(),
            routeOptions.toNative(),
            request.toNative(),
        )
        return session.toCommon(request)
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BicycleRouterV2) return false
        return nativeBicycleRouterV2 == other.nativeBicycleRouterV2
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeBicycleRouterV2.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeBicycleRouterV2.toCommon(): BicycleRouterV2 {
    return BicycleRouterV2(this)
}
