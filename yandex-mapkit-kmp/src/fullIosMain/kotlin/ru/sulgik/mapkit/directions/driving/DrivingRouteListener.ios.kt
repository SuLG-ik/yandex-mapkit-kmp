package ru.sulgik.mapkit.directions.driving

import platform.Foundation.NSError
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKDrivingRoute as NativeRoute

/** Receives route alternatives or a request failure on the UI thread. */
public actual abstract class DrivingRouteListener actual constructor() :
    NativeConvertible<(List<*>?, NSError?) -> Unit> {

    private val nativeListener: (List<*>?, NSError?) -> Unit = { routes, error ->
        if (error != null) {
            onDrivingRoutesError(error.toCommon())
        } else {
            onDrivingRoutes(routes.orEmpty().map { (it as NativeRoute).toCommon() })
        }
    }

    /** Returns this listener's native adapter. */
    override fun toNative(): (List<*>?, NSError?) -> Unit {
        return nativeListener
    }

    /** Called with the alternatives in native order. The list may be empty. */
    public actual abstract fun onDrivingRoutes(routes: List<DrivingRoute>)

    /** Called with the original native failure. */
    public actual abstract fun onDrivingRoutesError(error: DrivingRouteError)
}

internal fun DrivingRouteRequest.toNative(): (List<*>?, NSError?) -> Unit {
    return asListener().toNative()
}
