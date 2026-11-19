package ru.sulgik.mapkit.transport.masstransit

import platform.Foundation.NSError
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKMasstransitRoute as NativeRoute

/** Receives transport routes or a failure on the UI thread. */
public actual abstract class RouteListener actual constructor() : NativeConvertible<(List<*>?, NSError?) -> Unit> {

    private val nativeListener: (List<*>?, NSError?) -> Unit = { routes, error ->
        if (error != null) {
            onMasstransitRoutesError(error.toCommon())
        } else {
            onMasstransitRoutes(routes.orEmpty().map { (it as NativeRoute).toCommon() })
        }
    }

    /** Returns this listener's native adapter. */
    override fun toNative(): (List<*>?, NSError?) -> Unit {
        return nativeListener
    }

    /** Called with the routes in native order. The list may be empty. */
    public actual abstract fun onMasstransitRoutes(routes: List<Route>)

    /** Called with the native request failure. */
    public actual abstract fun onMasstransitRoutesError(error: RouteError)
}

internal fun RouteRequest.toNative(): (List<*>?, NSError?) -> Unit {
    return asListener().toNative()
}
