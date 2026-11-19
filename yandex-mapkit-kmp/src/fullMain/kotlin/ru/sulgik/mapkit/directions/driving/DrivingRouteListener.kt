package ru.sulgik.mapkit.directions.driving

/** Receives route alternatives or a request failure on the UI thread. */
public expect abstract class DrivingRouteListener() {

    /** Called with the alternatives in native order. The list may be empty. */
    public abstract fun onDrivingRoutes(routes: List<DrivingRoute>)

    /** Called with the original native failure. */
    public abstract fun onDrivingRoutesError(error: DrivingRouteError)
}

/** Creates a listener from success and failure callbacks. */
public inline fun DrivingRouteListener(
    crossinline onDrivingRoutes: (List<DrivingRoute>) -> Unit,
    crossinline onDrivingRoutesError: (DrivingRouteError) -> Unit,
): DrivingRouteListener {
    return object : DrivingRouteListener() {
        override fun onDrivingRoutes(routes: List<DrivingRoute>) {
            onDrivingRoutes.invoke(routes)
        }

        override fun onDrivingRoutesError(error: DrivingRouteError) {
            onDrivingRoutesError.invoke(error)
        }
    }
}
