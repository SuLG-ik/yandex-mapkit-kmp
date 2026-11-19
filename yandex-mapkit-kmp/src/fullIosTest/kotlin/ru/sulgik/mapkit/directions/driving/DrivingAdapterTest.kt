package ru.sulgik.mapkit.directions.driving

import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey
import platform.Foundation.NSObject
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.annotations.AnnotationLanguage
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.routing.RoutingRequestState
import ru.sulgik.mapkit.search.SearchRequestBindings
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Instant

public class DrivingAdapterTest {

    @Test
    public fun native_options_waypoints_and_geometry_preserve_values_and_order() {
        val options = DrivingOptions(
            initialAzimuth = 210.0,
            routesCount = 2,
            departureTime = Instant.fromEpochMilliseconds(1_797_432_000_123L),
            annotationLanguage = AnnotationLanguage.LATIN_AMERICAN_SPANISH,
            avoidanceFlags = AvoidanceFlags(avoidTolls = true, avoidRailwayCrossing = true, avoidTunnel = true),
        )
        val vehicle = VehicleOptions(
            vehicleType = VehicleType.TRUCK,
            weight = 4.25f,
            axleWeight = 1.5f,
            maxWeight = 7.5f,
            height = 3.0f,
            width = 2.25f,
            length = 6.75f,
            payload = 2.125f,
            ecoClass = 5,
            hasTrailer = false,
            buswayPermitted = true,
        )
        val points = listOf(
            RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT, pointContext = "origin"),
            RequestPoint(Point(55.76, 37.61), RequestPointType.VIAPOINT),
            RequestPoint(
                Point(55.77, 37.60),
                RequestPointType.WAYPOINT,
                drivingArrivalPointId = "entrance",
                indoorLevelId = "ground",
            ),
        )
        val nativeOptions = options.toNative()

        assertEquals(1_797_432_000.123, checkNotNull(nativeOptions.departureTime).timeIntervalSince1970, 0.001)
        assertEquals(options, nativeOptions.toCommon())
        assertEquals(vehicle, vehicle.toNative().toCommon())
        assertEquals(DrivingOptions(), DrivingOptions().toNative().toCommon())
        assertEquals(VehicleOptions(), VehicleOptions().toNative().toCommon())
        assertEquals(points, points.map(RequestPoint::toNative).map { it.toCommon() })
        assertEquals(points.map { it.point }, Polyline(points.map { it.point }).toNative().toCommon().points)
        val wayPoints = listOf(PolylinePosition(0, 0.0), PolylinePosition(1, 1.0))
        assertEquals(wayPoints, wayPoints.map { it.toNative().toCommon() })
    }

    @Test
    public fun native_handler_preserves_empty_results_errors_and_disposal() {
        val error = NSError(
            domain = "DrivingTest",
            code = 42,
            userInfo = mapOf(NSLocalizedDescriptionKey to "Network unavailable"),
        )
        val results = mutableListOf<List<DrivingRoute>>()
        val failures = mutableListOf<DrivingRouteError>()
        val listener = DrivingRouteListener({ results.add(it) }, { failures.add(it) })
        val retired = DrivingRouteRequest(listener)
        val retiredHandler = retired.toNative()
        assertSame(retiredHandler, retired.toNative())
        retiredHandler(emptyList<Any>(), null)

        retired.dispose()
        retiredHandler(null, error)
        retiredHandler(emptyList<Any>(), null)
        assertTrue(results.single().isEmpty())
        assertTrue(failures.isEmpty())

        val next = DrivingRouteRequest(listener).toNative()
        next(null, error)
        assertSame(error, failures.single().toNative())
        assertEquals("Network unavailable", failures.single().description)
        assertNull(failures.single().error)
        assertEquals(1, results.size)
    }

    @Test
    public fun shared_lifecycle_state_cancels_a_replacement_through_an_earlier_surrogate_alias() {
        val handle = NSObject()
        val bindings = SearchRequestBindings<NSObject, RoutingRequestState<DrivingRouteListener>>()
        val aliasBeforeRequest = bindings.getOrPut(handle) { RoutingRequestState() }
        val oldResults = mutableListOf<List<DrivingRoute>>()
        val oldRequest = DrivingRouteRequest(
            DrivingRouteListener({ oldResults.add(it) }, { error("Unexpected initial failure") }),
        )
        val owner = bindings.getOrPut(handle) { error("Earlier alias lost its request state") }
        owner.replace(oldRequest)
        val retiredHandler = oldRequest.toNative()
        val aliasBeforeRetry = bindings.getOrPut(handle) { error("Request state was replaced") }
        val currentResults = mutableListOf<List<DrivingRoute>>()
        val retryRequest = DrivingRouteRequest(
            DrivingRouteListener({ currentResults.add(it) }, { error("Unexpected retry failure") }),
        )
        aliasBeforeRetry.replace(retryRequest)
        val currentHandler = retryRequest.toNative()

        retiredHandler(emptyList<Any>(), null)
        currentHandler(emptyList<Any>(), null)
        aliasBeforeRequest.cancel()
        currentHandler(emptyList<Any>(), null)

        assertSame(aliasBeforeRequest, owner)
        assertSame(aliasBeforeRequest, aliasBeforeRetry)
        assertTrue(oldResults.isEmpty())
        assertTrue(currentResults.single().isEmpty())
    }
}
