package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.directions.driving.DrivingRoute as NativeRoute
import com.yandex.mapkit.directions.driving.DrivingSession.DrivingRouteListener as NativeRouteListener
import com.yandex.runtime.Error as NativeError

/** Receives route alternatives or a request failure on the UI thread. */
public actual abstract class DrivingRouteListener actual constructor() : NativeConvertible<NativeRouteListener> {

    private val nativeListener = object : NativeRouteListener {
        override fun onDrivingRoutes(routes: List<NativeRoute>) {
            this@DrivingRouteListener.onDrivingRoutes(routes.map { it.toCommon() })
        }

        override fun onDrivingRoutesError(error: NativeError) {
            this@DrivingRouteListener.onDrivingRoutesError(error.toCommon())
        }
    }

    /** Returns this listener's native adapter. */
    override fun toNative(): NativeRouteListener {
        return nativeListener
    }

    /** Called with the alternatives in native order. The list may be empty. */
    public actual abstract fun onDrivingRoutes(routes: List<DrivingRoute>)

    /** Called with the original native failure. */
    public actual abstract fun onDrivingRoutesError(error: DrivingRouteError)
}

internal fun DrivingRouteRequest.toNative(): NativeRouteListener {
    return asListener().toNative()
}
