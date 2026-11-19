package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.routing.RoutingRequestBindings
import ru.sulgik.mapkit.routing.RoutingRequestState
import YandexMapKit.YMKMasstransitSession as NativeSession

private val transitRouteRequests = RoutingRequestBindings<NativeSession, RouteListener>()

/** A session for a walking, cycling or transit route request. */
public actual class Session internal constructor(
    private val nativeSession: NativeSession,
    private val requests: RoutingRequestState<RouteListener>,
) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeSession {
        return nativeSession
    }

    /** Cancels the current request and releases its listener through any alias. Call on the UI thread. */
    public actual fun cancel() {
        requests.cancel()
        nativeSession.cancel()
    }

    /** Retries using [routeListener]. Call on the UI thread. */
    public actual fun retry(routeListener: RouteListener) {
        val retryRequest = RouteRequest(routeListener)
        requests.replace(retryRequest)
        nativeSession.retryWithRouteHandler(retryRequest.toNative())
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Session) return false
        return nativeSession == other.nativeSession
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeSession.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeSession.toCommon(): Session {
    return Session(this, transitRouteRequests.stateFor(this))
}

internal fun NativeSession.toCommon(request: RouteRequest): Session {
    val requests = transitRouteRequests.stateFor(this)
    requests.replace(request)
    return Session(this, requests)
}
