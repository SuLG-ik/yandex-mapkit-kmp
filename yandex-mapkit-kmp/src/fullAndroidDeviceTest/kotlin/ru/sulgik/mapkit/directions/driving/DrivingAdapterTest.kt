package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.MapKitRuntime
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.annotations.AnnotationLanguage
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.network.NetworkError
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import java.lang.reflect.Proxy
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Instant
import com.yandex.mapkit.RequestPoint as NativeRequestPoint
import com.yandex.mapkit.directions.driving.DrivingOptions as NativeDrivingOptions
import com.yandex.mapkit.directions.driving.DrivingRoute as NativeDrivingRoute
import com.yandex.mapkit.directions.driving.DrivingRouter as NativeDrivingRouter
import com.yandex.mapkit.directions.driving.DrivingSession as NativeDrivingSession
import com.yandex.mapkit.directions.driving.DrivingSession.DrivingRouteListener as NativeRouteListener
import com.yandex.mapkit.directions.driving.VehicleOptions as NativeVehicleOptions
import com.yandex.runtime.network.NetworkError as NativeNetworkError

public class DrivingAdapterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun routes_preserve_order_waypoints_and_native_route_handles() {
        val points = waypoints()
        val options = options()
        val vehicle = vehicle()
        val native = RecordingRouter()
        val results = mutableListOf<List<DrivingRoute>>()
        val session = native.router.toCommon().requestRoutes(
            points,
            options,
            vehicle,
            DrivingRouteListener({ results.add(it) }, { error("Unexpected routing error") }),
        )
        val first = route("first", points)
        val second = route("second", points.reversed())

        assertSame(native.session, session.toNative())
        assertEquals(points, native.points)
        assertEquals(options, native.options)
        assertEquals(vehicle, native.vehicle)
        native.listeners.single().onDrivingRoutes(listOf(first, second))
        native.listeners.single().onDrivingRoutes(emptyList())

        val alternatives = results.first()
        assertEquals(listOf("first", "second"), alternatives.map { it.routeId })
        assertSame(first, alternatives[0].toNative())
        assertSame(second, alternatives[1].toNative())
        assertEquals(points, alternatives[0].requestPoints)
        assertEquals(points.map { it.point }, alternatives[0].geometry.points)
        assertEquals(points.reversed().map { it.point }, alternatives[1].geometry.points)
        assertEquals(listOf(PolylinePosition(0, 0.0), PolylinePosition(1, 1.0)), alternatives[0].wayPoints)
        assertTrue(results.last().isEmpty())
    }

    @Test
    public fun aliases_replace_and_cancel_the_same_native_driving_request() {
        val native = RecordingRouter()
        val aliasBeforeRequest = native.session.toCommon()
        val retired = mutableListOf<List<DrivingRoute>>()
        val current = mutableListOf<DrivingRouteError>()
        val session = native.router.toCommon().requestRoutes(
            waypoints(),
            DrivingOptions(),
            VehicleOptions(),
            DrivingRouteListener({ retired.add(it) }, { error("Retired listener received a failure") }),
        )
        val aliasBeforeRetry = session.toNative().toCommon()
        val failure = object : NativeNetworkError {
            override fun isValid(): Boolean {
                return true
            }
        }
        val listener = DrivingRouteListener({ error("Expected a routing failure") }, { current.add(it) })
        assertSame(listener.toNative(), listener.toNative())

        aliasBeforeRetry.retry(listener)
        assertEquals(2, native.listeners.size)
        native.listeners.first().onDrivingRoutes(emptyList())
        native.listeners.last().onDrivingRoutesError(failure)
        assertTrue(retired.isEmpty())
        assertSame(failure, current.single().toNative())
        assertIs<NetworkError>(current.single().error)
        native.onCancel = { native.listeners.last().onDrivingRoutesError(failure) }

        aliasBeforeRequest.cancel()
        native.listeners.last().onDrivingRoutesError(failure)

        assertEquals(1, native.cancellations)
        assertEquals(1, current.size)
    }

    @Test
    public fun options_round_trip_nulls_departure_time_and_vehicle_dimensions() {
        val options = options()
        val vehicle = vehicle()

        assertEquals(1_797_432_000_123L, options.toNative().departureTime)
        assertEquals(options, options.toNative().toCommon())
        assertEquals(vehicle, vehicle.toNative().toCommon())
        assertEquals(DrivingOptions(), DrivingOptions().toNative().toCommon())
        assertEquals(VehicleOptions(), VehicleOptions().toNative().toCommon())
    }

    private fun waypoints(): List<RequestPoint> {
        return listOf(
            RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT, pointContext = "origin"),
            RequestPoint(Point(55.76, 37.61), RequestPointType.VIAPOINT),
            RequestPoint(
                Point(55.77, 37.60),
                RequestPointType.WAYPOINT,
                drivingArrivalPointId = "entrance",
                indoorLevelId = "ground",
            ),
        )
    }

    private fun options(): DrivingOptions {
        return DrivingOptions(
            initialAzimuth = 210.0,
            routesCount = 2,
            departureTime = Instant.fromEpochMilliseconds(1_797_432_000_123L),
            annotationLanguage = AnnotationLanguage.LATIN_AMERICAN_SPANISH,
            avoidanceFlags = AvoidanceFlags(avoidTolls = true, avoidRailwayCrossing = true, avoidTunnel = true),
        )
    }

    private fun vehicle(): VehicleOptions {
        return VehicleOptions(
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
    }

    private fun route(id: String, points: List<RequestPoint>): NativeDrivingRoute {
        return proxy<NativeDrivingRoute> { method, _ ->
            when (method) {
                "getRouteId" -> id
                "getGeometry" -> Polyline(points.map { it.point }).toNative()
                "getRequestPoints" -> points.map { it.toNative() }
                "getWayPoints" -> listOf(PolylinePosition(0, 0.0).toNative(), PolylinePosition(1, 1.0).toNative())
                else -> error("Unexpected route method: $method")
            }
        }
    }
}

private class RecordingRouter {

    val listeners = mutableListOf<NativeRouteListener>()
    var points: List<RequestPoint> = emptyList()
        private set
    var options: DrivingOptions? = null
        private set
    var vehicle: VehicleOptions? = null
        private set
    var cancellations: Int = 0
        private set
    var onCancel: () -> Unit = {}

    val session: NativeDrivingSession = proxy { method, args ->
        when (method) {
            "retry" -> {
                listeners.add(args.single() as NativeRouteListener)
                null
            }

            "cancel" -> {
                cancellations++
                onCancel()
                null
            }

            else -> error("Unexpected session method: $method")
        }
    }

    val router: NativeDrivingRouter = proxy { method, args ->
        check(method == "requestRoutes") { "Unexpected router method: $method" }
        points = (args[0] as List<*>).map { (it as NativeRequestPoint).toCommon() }
        options = (args[1] as NativeDrivingOptions).toCommon()
        vehicle = (args[2] as NativeVehicleOptions).toCommon()
        listeners.add(args[3] as NativeRouteListener)
        session
    }
}

private inline fun <reified T : Any> proxy(crossinline respond: (String, Array<out Any?>) -> Any?): T {
    return T::class.java.cast(
        Proxy.newProxyInstance(T::class.java.classLoader, arrayOf(T::class.java)) { instance, method, args ->
            when (method.name) {
                "equals" -> instance === args?.singleOrNull()
                "hashCode" -> System.identityHashCode(instance)
                else -> respond(method.name, args.orEmpty())
            }
        },
    )
}
