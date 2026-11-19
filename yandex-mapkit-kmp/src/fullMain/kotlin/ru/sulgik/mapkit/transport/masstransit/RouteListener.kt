package ru.sulgik.mapkit.transport.masstransit

/** Receives transport routes or a failure on the UI thread. */
public expect abstract class RouteListener() {

    /** Called with the routes in native order. The list may be empty. */
    public abstract fun onMasstransitRoutes(routes: List<Route>)

    /** Called with the native request failure. */
    public abstract fun onMasstransitRoutesError(error: RouteError)
}

/** Creates a listener from success and failure callbacks. */
public inline fun RouteListener(
    crossinline onMasstransitRoutes: (List<Route>) -> Unit,
    crossinline onMasstransitRoutesError: (RouteError) -> Unit,
): RouteListener {
    return object : RouteListener() {
        override fun onMasstransitRoutes(routes: List<Route>) {
            onMasstransitRoutes.invoke(routes)
        }

        override fun onMasstransitRoutesError(error: RouteError) {
            onMasstransitRoutesError.invoke(error)
        }
    }
}
