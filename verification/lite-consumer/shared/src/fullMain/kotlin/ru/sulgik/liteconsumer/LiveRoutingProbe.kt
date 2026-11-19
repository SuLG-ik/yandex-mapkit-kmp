package ru.sulgik.liteconsumer

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.directions.Directions
import ru.sulgik.mapkit.directions.driving.DrivingOptions
import ru.sulgik.mapkit.directions.driving.DrivingRoute
import ru.sulgik.mapkit.directions.driving.DrivingRouteListener
import ru.sulgik.mapkit.directions.driving.DrivingRouterType
import ru.sulgik.mapkit.directions.driving.VehicleOptions
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.network.ForbiddenError
import ru.sulgik.mapkit.runtime.network.UnauthorizedError
import ru.sulgik.mapkit.transport.Transport
import ru.sulgik.mapkit.transport.masstransit.FitnessType
import ru.sulgik.mapkit.transport.masstransit.Route
import ru.sulgik.mapkit.transport.masstransit.RouteListener
import ru.sulgik.mapkit.transport.masstransit.RouteOptions
import ru.sulgik.mapkit.transport.masstransit.Session
import ru.sulgik.mapkit.transport.masstransit.TimeOptions
import ru.sulgik.mapkit.transport.masstransit.TransitOptions
import kotlin.coroutines.resume

private enum class RouteMode(val marker: String) {
    Driving("driving"),
    Walking("walking"),
    Cycling("cycling"),
    Transit("transit"),
}

private data class RouteReply(val status: LiveServiceStatus, val geometry: Polyline? = null)

private typealias StartRoute = (List<RequestPoint>, (RouteReply) -> Unit) -> (() -> Unit)

private val start = RequestPoint(Point(55.756, 37.618), RequestPointType.WAYPOINT)
private val retiredPoints = listOf(start, RequestPoint(Point(55.764, 37.605), RequestPointType.WAYPOINT))
private val replacementPoints = listOf(start, RequestPoint(Point(55.728, 37.581), RequestPointType.WAYPOINT))

internal suspend fun probeLiveRouting(map: Map, onModeResult: (String, LiveServiceStatus) -> Unit): LiveServiceStatus {
    val overlay = try {
        RoutingOverlay(map.mapObjects)
    } catch (_: Exception) {
        return LiveServiceStatus.WrapperOrShape
    }
    var result = LiveServiceStatus.Passed
    try {
        for (mode in RouteMode.entries) {
            val status = probeReplacement(mode, overlay)
            onModeResult(mode.marker, status)
            if (status == LiveServiceStatus.Authorization) return status
            if (result == LiveServiceStatus.Passed) result = status
        }
        return result
    } finally {
        overlay.dispose()
    }
}

private suspend fun probeReplacement(mode: RouteMode, overlay: RoutingOverlay): LiveServiceStatus {
    var cancelRetired: (() -> Unit)? = null
    var cancelCurrent: (() -> Unit)? = null
    var firstReply: RouteReply? = null
    var replaced = false
    var staleReply = false
    return try {
        val request = routeStarter(mode)
        val reply = withTimeoutOrNull(18_000L) {
            suspendCancellableCoroutine<RouteReply> { continuation ->
                cancelRetired = request(retiredPoints) { result ->
                    if (replaced) {
                        staleReply = true
                    } else {
                        firstReply = result
                    }
                }
                val synchronousReply = firstReply
                if (synchronousReply != null) {
                    val status = if (synchronousReply.status == LiveServiceStatus.Passed) {
                        LiveServiceStatus.RunnerOrFixture
                    } else {
                        synchronousReply.status
                    }
                    continuation.resume(RouteReply(status))
                    return@suspendCancellableCoroutine
                }

                replaced = true
                cancelRetired?.invoke()
                cancelRetired = null
                cancelCurrent = request(replacementPoints) { result ->
                    if (continuation.isActive) continuation.resume(result)
                }
            }
        } ?: RouteReply(LiveServiceStatus.ProviderOrNetwork)

        if (staleReply) return LiveServiceStatus.WrapperOrShape
        if (reply.status != LiveServiceStatus.Passed) return reply.status
        val geometry = checkNotNull(reply.geometry)
        val line = checkNotNull(overlay.show(geometry))
        check(line.isValid && line.geometry.points == geometry.points)
        delay(500L)
        overlay.clear()
        check(!line.isValid)
        cancelCurrent?.invoke()
        cancelCurrent = null
        if (staleReply) LiveServiceStatus.WrapperOrShape else LiveServiceStatus.Passed
    } catch (cancelled: CancellationException) {
        throw cancelled
    } catch (_: Exception) {
        LiveServiceStatus.WrapperOrShape
    } finally {
        cancelRetired?.invoke()
        cancelCurrent?.invoke()
        overlay.clear()
    }
}

private fun routeStarter(mode: RouteMode): StartRoute {
    if (mode == RouteMode.Driving) {
        val router = Directions.getInstance().createDrivingRouter(DrivingRouterType.ONLINE)
        return { points, deliver ->
            val session = router.requestRoutes(
                points,
                DrivingOptions(routesCount = 2),
                VehicleOptions(),
                DrivingRouteListener(
                    onDrivingRoutes = { routes ->
                        deliver(verifyReply(routes) { drivingGeometry(routes, points) })
                    },
                    onDrivingRoutesError = { error -> deliver(errorReply { error.error }) },
                ),
            )
            session::cancel
        }
    }
    val transport = Transport.getInstance()
    val request: (List<RequestPoint>, RouteListener) -> Session = when (mode) {
        RouteMode.Walking -> transport.createPedestrianRouter().let { router ->
            { points: List<RequestPoint>, listener: RouteListener ->
                router.requestRoutes(points, TimeOptions(), RouteOptions(), listener)
            }
        }

        RouteMode.Cycling -> transport.createBicycleRouterV2().let { router ->
            { points: List<RequestPoint>, listener: RouteListener ->
                router.requestRoutes(points, TimeOptions(), RouteOptions(), listener)
            }
        }

        RouteMode.Transit -> transport.createMasstransitRouter().let { router ->
            { points: List<RequestPoint>, listener: RouteListener ->
                router.requestRoutes(points, TransitOptions(), RouteOptions(), listener)
            }
        }

        RouteMode.Driving -> error("Driving uses its own router")
    }
    return { points, deliver ->
        val session = request(
            points,
            RouteListener(
                onMasstransitRoutes = { routes ->
                    deliver(verifyReply(routes) { transportGeometry(routes, points, mode) })
                },
                onMasstransitRoutesError = { error -> deliver(errorReply { error.error }) },
            ),
        )
        session::cancel
    }
}

private fun drivingGeometry(routes: List<DrivingRoute>, points: List<RequestPoint>): Polyline {
    val selected = routes.first()
    val geometry = selected.geometry
    check(selected.routeId.isNotBlank())
    check(
        drivingWaypointsMatch(
            geometry = geometry,
            wayPoints = selected.wayPoints,
            requestedPoints = points.map(RequestPoint::point),
            reportedRequestPoints = selected.requestPoints?.map(RequestPoint::point),
        ),
    )
    return geometry
}

private fun transportGeometry(routes: List<Route>, points: List<RequestPoint>, mode: RouteMode): Polyline {
    val selected = routes.first { route ->
        when (mode) {
            RouteMode.Walking -> route.sections.any { it.metadata.data.fitness?.type == FitnessType.PEDESTRIAN }
            RouteMode.Cycling -> route.sections.any { it.metadata.data.fitness?.type == FitnessType.BICYCLE }
            RouteMode.Transit -> route.sections.any { it.metadata.data.transports.orEmpty().isNotEmpty() }
            RouteMode.Driving -> false
        }
    }
    check(selected.wayPoints.map { it.position } == points.map(RequestPoint::point))
    return selected.geometry
}

private fun verifyReply(routes: List<*>, readGeometry: () -> Polyline): RouteReply {
    if (routes.isEmpty()) return RouteReply(LiveServiceStatus.ProviderNoRoute)
    return try {
        val geometry = readGeometry()
        val points = geometry.points
        check(points.size >= 2 && points.any { it != points.first() })
        check(points.all { it.latitude.value in -90.0..90.0 && it.longitude.value in -180.0..180.0 })
        RouteReply(LiveServiceStatus.Passed, geometry)
    } catch (_: Exception) {
        RouteReply(LiveServiceStatus.WrapperOrShape)
    }
}

private fun errorReply(readError: () -> Error?): RouteReply {
    val status = try {
        when (readError()) {
            is UnauthorizedError, is ForbiddenError -> LiveServiceStatus.Authorization
            else -> LiveServiceStatus.ProviderOrNetwork
        }
    } catch (_: Exception) {
        LiveServiceStatus.WrapperOrShape
    }
    return RouteReply(status)
}

internal fun verifyNoRouteReplies() {
    val emptyReply = verifyReply(emptyList<Any>()) { error("Empty alternatives have no geometry to decode") }
    check(emptyReply.status == LiveServiceStatus.ProviderNoRoute)
    val undecodable = verifyReply(listOf(Any())) { error("A nonempty route failed decoding") }
    check(undecodable.status == LiveServiceStatus.WrapperOrShape)
}
