package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.routing.RoutingRequestState
import ru.sulgik.mapkit.search.SearchRequestBindings
import com.yandex.mapkit.transport.masstransit.Route as NativeRoute
import com.yandex.mapkit.transport.masstransit.Session as NativeSession
import com.yandex.mapkit.transport.masstransit.Session.RouteListener as NativeRouteListener
import com.yandex.runtime.Error as NativeError

private val transitRouteRequests = SearchRequestBindings<NativeSession, RoutingRequestState<RouteListener>>()

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
        nativeSession.retry(retryRequest.toNative())
    }

    /** Receives transport routes or a failure on the UI thread. */
    public actual abstract class RouteListener actual constructor() : NativeConvertible<NativeRouteListener> {

        private val nativeListener = object : NativeRouteListener {
            override fun onMasstransitRoutes(routes: List<NativeRoute>) {
                this@RouteListener.onMasstransitRoutes(routes.map { it.toCommon() })
            }

            override fun onMasstransitRoutesError(error: NativeError) {
                this@RouteListener.onMasstransitRoutesError(error.toCommon())
            }
        }

        /** Returns this listener's native adapter. */
        override fun toNative(): NativeRouteListener {
            return nativeListener
        }

        /** Called with the routes in native order. The list may be empty. */
        public actual abstract fun onMasstransitRoutes(routes: List<Route>)

        /** Called with the native request failure. */
        public actual abstract fun onMasstransitRoutesError(error: RouteError)
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
    return Session(this, transitRouteRequests.getOrPut(this) { RoutingRequestState() })
}

internal fun NativeSession.toCommon(request: RouteRequest): Session {
    val requests = transitRouteRequests.getOrPut(this) { RoutingRequestState() }
    requests.replace(request)
    return Session(this, requests)
}
