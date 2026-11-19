package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.routing.RoutingRequest

internal class RouteRequest(
    listener: RouteListener,
) : RoutingRequest<RouteListener>(listener) {
    private val adapter =
        RouteListener(
            onMasstransitRoutes = { routes -> currentListener()?.onMasstransitRoutes(routes) },
            onMasstransitRoutesError = { error -> currentListener()?.onMasstransitRoutesError(error) },
        )

    fun asListener(): RouteListener = adapter
}
