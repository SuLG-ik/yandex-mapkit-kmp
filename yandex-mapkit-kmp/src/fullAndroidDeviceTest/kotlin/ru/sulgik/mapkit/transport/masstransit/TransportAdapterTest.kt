package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.MapKitRuntime
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.network.NetworkError
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.transport.toCommon
import java.lang.reflect.Proxy
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Instant
import com.yandex.mapkit.RequestPoint as NativeRequestPoint
import com.yandex.mapkit.transport.Transport as NativeTransport
import com.yandex.mapkit.transport.masstransit.BicycleRouterV2 as NativeBicycleRouter
import com.yandex.mapkit.transport.masstransit.PedestrianRouter as NativePedestrianRouter
import com.yandex.mapkit.transport.masstransit.Route as NativeRoute
import com.yandex.mapkit.transport.masstransit.RouteMetadata as NativeRouteMetadata
import com.yandex.mapkit.transport.masstransit.RouteOptions as NativeRouteOptions
import com.yandex.mapkit.transport.masstransit.Section as NativeSection
import com.yandex.mapkit.transport.masstransit.SectionMetadata as NativeSectionMetadata
import com.yandex.mapkit.transport.masstransit.Session as NativeSession
import com.yandex.mapkit.transport.masstransit.Session.RouteListener as NativeRouteListener
import com.yandex.mapkit.transport.masstransit.TimeOptions as NativeTimeOptions
import com.yandex.runtime.network.NetworkError as NativeNetworkError

public class TransportAdapterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun pedestrian_adapter_preserves_options_alternatives_geometry_and_optional_metadata() {
        val points = points()
        val time = TimeOptions(departureTime = Instant.fromEpochMilliseconds(1_797_432_000_123L))
        val options = RouteOptions(FitnessOptions(avoidStairs = true))
        val requests = RecordingRequests()
        val router: NativePedestrianRouter = proxy { method, args ->
            check(method == "requestRoutes")
            assertEquals(points, (args[0] as List<*>).map { (it as NativeRequestPoint).toCommon() })
            assertEquals(time, (args[1] as NativeTimeOptions).toCommon())
            assertEquals(options, (args[2] as NativeRouteOptions).toCommon())
            requests.open(args[3] as NativeRouteListener)
        }
        val transport: NativeTransport = proxy { method, _ ->
            when (method) {
                "createPedestrianRouter" -> router
                "isValid" -> true
                else -> error("Unexpected transport method $method")
            }
        }
        val results = mutableListOf<List<Route>>()
        val common = transport.toCommon()
        assertTrue(common.isValid)
        assertSame(router, common.createPedestrianRouter().toNative())
        val session = common.createPedestrianRouter().requestRoutes(
            points,
            time,
            options,
            RouteListener({ results.add(it) }, { error("Unexpected routing error") }),
        )
        assertSame(requests.nativeSession, session.toNative())
        val first = route(points, null)
        val second = route(points.reversed(), "second")
        requests.listeners.single().onMasstransitRoutes(listOf(first, second))
        requests.listeners.single().onMasstransitRoutes(emptyList())

        val alternatives = results.first()
        assertEquals(listOf(null, "second"), alternatives.map { it.metadata.routeId })
        assertEquals(points.map { it.point }, alternatives[0].geometry.points)
        assertEquals(points.reversed().map { it.point }, alternatives[1].geometry.points)
        assertEquals(points.map { it.point }, alternatives[0].wayPoints.map { it.position })
        assertNull(alternatives[0].metadata.estimation)
        assertNull(alternatives[0].metadata.flags)
        assertNull(alternatives[0].metadata.settings)
        assertEquals(0, alternatives[0].sections.single().metadata.legIndex)
        assertEquals(Wait(1), alternatives[0].sections.single().metadata.data.wait)
        assertNull(alternatives[0].sections.single().metadata.data.transports)
        assertEquals(Subpolyline(PolylinePosition(0, 0.0), PolylinePosition(0, 1.0)), alternatives[0].sections.single().geometry)
        assertTrue(results.last().isEmpty())
        assertSame(first, alternatives[0].toNative())
    }

    @Test
    public fun aliases_replace_and_cancel_the_same_native_transport_request() {
        val requests = RecordingRequests()
        val router: NativePedestrianRouter = proxy { method, args ->
            check(method == "requestRoutes")
            requests.open(args[3] as NativeRouteListener)
        }
        val aliasBeforeRequest = requests.nativeSession.toCommon()
        val old = mutableListOf<List<Route>>()
        val failures = mutableListOf<RouteError>()
        val nativeError = object : NativeNetworkError {
            override fun isValid(): Boolean {
                return true
            }
        }
        val session = router.toCommon().requestRoutes(
            points(), TimeOptions(), RouteOptions(),
            RouteListener({ old.add(it) }, { error("Unexpected old error") }),
        )
        val aliasBeforeRetry = session.toNative().toCommon()
        aliasBeforeRetry.retry(RouteListener({ error("Unexpected route") }, { failures.add(it) }))
        requests.listeners.first().onMasstransitRoutes(emptyList())
        requests.listeners.last().onMasstransitRoutesError(nativeError)
        requests.onCancel = { requests.listeners.last().onMasstransitRoutesError(nativeError) }
        aliasBeforeRequest.cancel()
        requests.listeners.last().onMasstransitRoutesError(nativeError)

        assertEquals(1, requests.cancelCount)
        assertTrue(old.isEmpty())
        assertSame(nativeError, failures.single().toNative())
        assertIs<NetworkError>(failures.single().error)
    }

    @Test
    public fun bicycle_factory_keeps_via_points_and_returns_route_geometry() {
        val points = points().toMutableList().apply {
            add(1, RequestPoint(Point(55.751, 37.618), RequestPointType.VIAPOINT))
        }
        val time = TimeOptions(arrivalTime = Instant.fromEpochMilliseconds(1_797_432_123_456L))
        val options = RouteOptions(FitnessOptions(avoidSteep = true))
        val requests = RecordingRequests()
        val router: NativeBicycleRouter = proxy { method, args ->
            check(method == "requestRoutes")
            assertEquals(points, (args[0] as List<*>).map { (it as NativeRequestPoint).toCommon() })
            assertEquals(time, (args[1] as NativeTimeOptions).toCommon())
            assertEquals(options, (args[2] as NativeRouteOptions).toCommon())
            requests.open(args[3] as NativeRouteListener)
        }
        val transport: NativeTransport = proxy { method, _ ->
            check(method == "createBicycleRouterV2")
            router
        }
        val results = mutableListOf<Route>()
        val common = transport.toCommon().createBicycleRouterV2()
        assertSame(router, common.toNative())
        val session = common.requestRoutes(points, time, options, RouteListener({ results.addAll(it) }, { error("Unexpected failure") }))
        val route = route(points, "bicycle")
        requests.listeners.single().onMasstransitRoutes(listOf(route))
        session.cancel()
        requests.listeners.single().onMasstransitRoutes(listOf(route))

        assertEquals("bicycle", results.single().metadata.routeId)
        assertEquals(points.map { it.point }, results.single().geometry.points)
        assertEquals(1, requests.cancelCount)
    }

    private fun points(): List<RequestPoint> {
        return listOf(
            RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT, pointContext = "first"),
            RequestPoint(Point(55.76, 37.61), RequestPointType.WAYPOINT, indoorLevelId = "ground"),
        )
    }

    private fun route(points: List<RequestPoint>, id: String?): NativeRoute {
        val wayPoints = points.map { WayPoint(position = it.point, context = it.pointContext).toNative() }
        val geometry = Polyline(points.map { it.point }).toNative()
        val weight = Weight(LocalizedValue(90.0, "90 s"), LocalizedValue(120.0, "120 m"), 0).toNative()
        val metadata = NativeRouteMetadata(
            weight,
            null,
            null,
            wayPoints,
            id,
            null,
            emptyList(),
            StairsSummary(2, 1).toNative(),
            emptyList(),
            null,
        )
        val sectionMetadata = NativeSectionMetadata(
            weight,
            NativeSectionMetadata.SectionData.fromWait(Wait(1).toNative()),
            null,
            0,
            emptyList(),
        )
        val sectionGeometry = Subpolyline(PolylinePosition(0, 0.0), PolylinePosition(0, 1.0)).toNative()
        val section = NativeSection(sectionMetadata, sectionGeometry, emptyList(), emptyList())
        return proxy { method, _ ->
            when (method) {
                "getMetadata" -> metadata
                "getWayPoints" -> wayPoints
                "getSections" -> listOf(section)
                "getGeometry" -> geometry
                else -> error("Unexpected route method $method")
            }
        }
    }
}

private class RecordingRequests {

    val listeners = mutableListOf<NativeRouteListener>()
    var cancelCount = 0
        private set
    var onCancel: () -> Unit = {}

    val nativeSession: NativeSession = proxy { method, args ->
        when (method) {
            "retry" -> listeners.add(args.single() as NativeRouteListener)
            "cancel" -> {
                cancelCount++
                onCancel()
            }
            else -> error("Unexpected session method $method")
        }
        null
    }

    fun open(listener: NativeRouteListener): NativeSession {
        listeners.add(listener)
        return nativeSession
    }
}

private inline fun <reified T : Any> proxy(crossinline respond: (String, Array<out Any?>) -> Any?): T {
    return T::class.java.cast(
        Proxy.newProxyInstance(T::class.java.classLoader, arrayOf(T::class.java)) { _, method, args ->
            respond(method.name, args.orEmpty())
        },
    )
}
