package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.transport.Transport
import ru.sulgik.mapkit.transport.masstransit.Route
import ru.sulgik.mapkit.transport.masstransit.RouteError
import ru.sulgik.mapkit.transport.masstransit.RouteListener
import ru.sulgik.mapkit.transport.masstransit.RouteOptions
import ru.sulgik.mapkit.transport.masstransit.Session
import ru.sulgik.mapkit.transport.masstransit.TimeOptions
import ru.sulgik.mapkit.transport.masstransit.TransitOptions

internal class FullTransportExample(parent: MapObjectCollection) {

    private val transport = Transport.getInstance()
    private val pedestrian = transport.createPedestrianRouter()
    private val bicycle = transport.createBicycleRouterV2()
    private val publicTransport = transport.createMasstransitRouter()
    private val drawing = RoutingOverlay(parent)
    private var session: Session? = null
    private var generation: Long = 0

    fun replaceWalkingRoute(
        points: List<RequestPoint>,
        onRoutes: (List<Route>) -> Unit,
        onFailure: (RouteError) -> Unit,
    ) {
        replaceRoute(
            request = { listener -> pedestrian.requestRoutes(points, TimeOptions(), RouteOptions(), listener) },
            onRoutes = onRoutes,
            onFailure = onFailure,
        )
    }

    fun replaceCyclingRoute(
        points: List<RequestPoint>,
        onRoutes: (List<Route>) -> Unit,
        onFailure: (RouteError) -> Unit,
    ) {
        replaceRoute(
            request = { listener -> bicycle.requestRoutes(points, TimeOptions(), RouteOptions(), listener) },
            onRoutes = onRoutes,
            onFailure = onFailure,
        )
    }

    fun replaceTransitRoute(
        points: List<RequestPoint>,
        transitOptions: TransitOptions,
        onRoutes: (List<Route>) -> Unit,
        onFailure: (RouteError) -> Unit,
    ) {
        replaceRoute(
            request = { listener -> publicTransport.requestRoutes(points, transitOptions, RouteOptions(), listener) },
            onRoutes = onRoutes,
            onFailure = onFailure,
        )
    }

    private fun replaceRoute(
        request: (RouteListener) -> Session,
        onRoutes: (List<Route>) -> Unit,
        onFailure: (RouteError) -> Unit,
    ) {
        clear()
        val owner = generation
        val next = request(
            RouteListener(
                onMasstransitRoutes = { routes ->
                    if (owner == generation && drawing.isValid) {
                        drawing.show(routes.firstOrNull()?.geometry)
                        onRoutes(routes)
                    }
                },
                onMasstransitRoutesError = { failure ->
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
