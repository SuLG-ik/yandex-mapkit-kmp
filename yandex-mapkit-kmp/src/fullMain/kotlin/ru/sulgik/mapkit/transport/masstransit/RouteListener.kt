package ru.sulgik.mapkit.transport.masstransit

/** Alias for the transport session's [Session.RouteListener]. */
public typealias RouteListener = Session.RouteListener

/** Creates a listener from success and failure callbacks. */
public inline fun RouteListener(
    crossinline onMasstransitRoutes: (List<Route>) -> Unit,
    crossinline onMasstransitRoutesError: (RouteError) -> Unit,
): Session.RouteListener {
    return object : Session.RouteListener() {
        override fun onMasstransitRoutes(routes: List<Route>) {
            onMasstransitRoutes.invoke(routes)
        }

        override fun onMasstransitRoutesError(error: RouteError) {
            onMasstransitRoutesError.invoke(error)
        }
    }
}
