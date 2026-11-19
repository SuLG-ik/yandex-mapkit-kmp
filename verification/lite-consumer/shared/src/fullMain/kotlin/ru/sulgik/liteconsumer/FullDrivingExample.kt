package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.directions.Directions
import ru.sulgik.mapkit.directions.driving.DrivingOptions
import ru.sulgik.mapkit.directions.driving.DrivingRoute
import ru.sulgik.mapkit.directions.driving.DrivingRouteError
import ru.sulgik.mapkit.directions.driving.DrivingRouteListener
import ru.sulgik.mapkit.directions.driving.DrivingRouterType
import ru.sulgik.mapkit.directions.driving.DrivingSession
import ru.sulgik.mapkit.directions.driving.VehicleOptions
import ru.sulgik.mapkit.map.MapObjectCollection

internal class FullDrivingExample(parent: MapObjectCollection) {

    private val router = Directions.getInstance().createDrivingRouter(DrivingRouterType.ONLINE)
    private val drawing = RoutingOverlay(parent)
    private var session: DrivingSession? = null
    private var generation: Long = 0

    fun replaceRoute(
        points: List<RequestPoint>,
        onRoutes: (List<DrivingRoute>) -> Unit,
        onFailure: (DrivingRouteError) -> Unit,
    ) {
        clear()
        val owner = generation
        val next = router.requestRoutes(
            points = points,
            drivingOptions = DrivingOptions(routesCount = 2),
            vehicleOptions = VehicleOptions(),
            routeListener = DrivingRouteListener(
                onDrivingRoutes = { routes ->
                    if (owner == generation && drawing.isValid) {
                        drawing.show(routes.firstOrNull()?.geometry)
                        onRoutes(routes)
                    }
                },
                onDrivingRoutesError = { failure ->
                    if (owner == generation && drawing.isValid) {
                        drawing.clear()
                        onFailure(failure)
                    }
                },
            ),
        )
        if (owner == generation) {
            session = next
        } else {
            next.cancel()
        }
    }

    fun clear() {
        generation++
        val previous = session
        session = null
        previous?.cancel()
        drawing.clear()
    }

    fun dispose() {
        clear()
        drawing.dispose()
    }
}
