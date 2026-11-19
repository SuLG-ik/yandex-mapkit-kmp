package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.routing.RoutingRequestState
import ru.sulgik.mapkit.search.SearchRequestBindings
import YandexMapKit.YMKDrivingSession as NativeDrivingSession

private val drivingRouteRequests = SearchRequestBindings<NativeDrivingSession, RoutingRequestState<DrivingRouteListener>>()

/** A driving route request session. */
public actual class DrivingSession internal constructor(
    private val nativeDrivingSession: NativeDrivingSession,
    private val requests: RoutingRequestState<DrivingRouteListener>,
) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeDrivingSession {
        return nativeDrivingSession
    }

    /** Cancels the current request and releases its listener through any alias. Call on the UI thread. */
    public actual fun cancel() {
        requests.cancel()
        nativeDrivingSession.cancel()
    }

    /** Retries the request using [routeListener]. Call on the UI thread. */
    public actual fun retry(routeListener: DrivingRouteListener) {
        val retryRequest = DrivingRouteRequest(routeListener)
        requests.replace(retryRequest)
        nativeDrivingSession.retryWithRouteHandler(retryRequest.toNative())
    }

    /** Two wrappers are equal when they hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DrivingSession) return false
        return nativeDrivingSession == other.nativeDrivingSession
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeDrivingSession.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeDrivingSession.toCommon(): DrivingSession {
    return DrivingSession(this, drivingRouteRequests.getOrPut(this) { RoutingRequestState() })
}

internal fun NativeDrivingSession.toCommon(request: DrivingRouteRequest): DrivingSession {
    val requests = drivingRouteRequests.getOrPut(this) { RoutingRequestState() }
    requests.replace(request)
    return DrivingSession(this, requests)
}
