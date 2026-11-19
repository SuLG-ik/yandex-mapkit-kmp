package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.transport.masstransit.Route as NativeRoute
import com.yandex.mapkit.transport.masstransit.Session.RouteListener as NativeRouteListener
import com.yandex.runtime.Error as NativeError

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

internal fun RouteRequest.toNative(): NativeRouteListener {
    return asListener().toNative()
}
