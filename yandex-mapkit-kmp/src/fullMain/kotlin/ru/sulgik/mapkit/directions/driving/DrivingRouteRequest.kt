package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.routing.RoutingRequest

internal class DrivingRouteRequest(listener: DrivingRouteListener) : RoutingRequest<DrivingRouteListener>(listener) {

    private val adapter = DrivingRouteListener(
        onDrivingRoutes = { routes -> currentListener()?.onDrivingRoutes(routes) },
        onDrivingRoutesError = { error -> currentListener()?.onDrivingRoutesError(error) },
    )

    fun asListener(): DrivingRouteListener {
        return adapter
    }
}
