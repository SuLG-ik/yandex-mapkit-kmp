package ru.sulgik.mapkit.transport.masstransit

import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey
import platform.Foundation.errorWithDomain
import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Instant
import YandexMapKit.YMKMasstransitFitness as NativeFitness
import YandexMapKit.YMKMasstransitRouteMetadata as NativeRouteMetadata
import YandexMapKit.YMKMasstransitSection as NativeSection
import YandexMapKit.YMKMasstransitSectionMetadata as NativeSectionMetadata
import YandexMapKit.YMKMasstransitSectionMetadataSectionData as NativeSectionData
import YandexMapKit.YMKMasstransitSession as NativeSession

public class TransportAdapterTest {

    @Test
    public fun optional_times_waypoints_and_fitness_options_round_trip() {
        val departure = TimeOptions(departureTime = Instant.fromEpochMilliseconds(1_797_432_000_123L))
        val arrival = TimeOptions(arrivalTime = Instant.fromEpochMilliseconds(1_797_432_123_456L))
        val request = listOf(
            RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT, pointContext = "first"),
            RequestPoint(Point(55.76, 37.61), RequestPointType.WAYPOINT, indoorLevelId = "ground"),
        )
        val routeOptions = RouteOptions(FitnessOptions(avoidStairs = true))

        assertEquals(departure, departure.toNative().toCommon())
        assertEquals(arrival, arrival.toNative().toCommon())
        assertEquals(TimeOptions(), TimeOptions().toNative().toCommon())
        assertEquals(routeOptions, routeOptions.toNative().toCommon())
        assertEquals(request, request.map { it.toNative().toCommon() })
        val points = request.map { it.point }
        assertEquals(points, Polyline(points).toNative().toCommon().points)
    }

    @Test
    public fun optional_native_metadata_and_section_geometry_survive_conversion() {
        val wayPoints = listOf(
            WayPoint(position = Point(55.75, 37.62), context = "origin"),
            WayPoint(
                position = Point(55.76, 37.61),
                selectedArrivalPoint = Point(55.76, 37.6101),
                levelId = "ground",
            ),
        )
        val weight = Weight(LocalizedValue(90.0, "90 s"), LocalizedValue(120.0, "120 m"), 0)
        val metadata = NativeRouteMetadata.routeMetadataWithWeight(
            weight = weight.toNative(),
            settings = null,
            estimation = null,
            wayPoints = wayPoints.map { it.toNative() },
            routeId = null,
            flags = null,
            comfortTags = emptyList<Any>(),
            stairsSummary = StairsSummary(2, 1).toNative(),
            paymentOptions = emptyList<Any>(),
            routeExplanation = null,
        ).toCommon()
        val sectionGeometry = Subpolyline(PolylinePosition(0, 0.0), PolylinePosition(0, 1.0))
        val section = NativeSection.sectionWithMetadata(
            metadata = NativeSectionMetadata.sectionMetadataWithWeight(
                weight = weight.toNative(),
                data = NativeSectionData.sectionDataWithWait(Wait(1).toNative()),
                estimation = null,
                legIndex = 0uL,
                paymentOptions = emptyList<Any>(),
            ),
            geometry = sectionGeometry.toNative(),
            stops = emptyList<Any>(),
            rideLegs = emptyList<Any>(),
        ).toCommon()

        assertEquals(wayPoints, metadata.wayPoints)
        assertEquals(weight, metadata.weight)
        assertEquals(StairsSummary(2, 1), metadata.stairsSummary)
        assertNull(metadata.routeId)
        assertNull(metadata.settings)
        assertNull(metadata.estimation)
        assertNull(metadata.flags)
        assertNull(metadata.routeExplanation)
        assertEquals(sectionGeometry, section.geometry)
        assertEquals(Wait(1), section.metadata.data.wait)
        assertNull(section.metadata.data.transports)
        assertNull(section.metadata.estimation)
    }

    @Test
    public fun bicycle_section_keeps_kind_and_via_positions() {
        val via = listOf(PolylinePosition(0, 0.25), PolylinePosition(1, 0.5))
        val native = NativeFitness.fitnessWithType(
            type = FitnessType.BICYCLE.toNative(),
            constructions = emptyList<Any>(),
            restrictedEntries = emptyList<Any>(),
            viaPoints = via.map { it.toNative() },
            annotations = emptyList<Any>(),
            trafficTypes = emptyList<Any>(),
            elevationData = null,
            indoorSegments = emptyList<Any>(),
        )
        val section = NativeSectionData.sectionDataWithFitness(native).toCommon()
        val bicycle = checkNotNull(section.fitness)

        assertSame(native, bicycle.toNative())
        assertEquals(FitnessType.BICYCLE, bicycle.type)
        assertEquals(via, bicycle.viaPoints)
        assertNull(section.wait)
        assertNull(section.transports)
    }

    @Test
    public fun native_handler_delivers_no_route_and_error_and_ignores_retired_callbacks() {
        val nativeError = NSError.errorWithDomain(
            domain = "TransportTest",
            code = 42,
            userInfo = mapOf(NSLocalizedDescriptionKey to "Routing unavailable"),
        )
        val results = mutableListOf<List<Route>>()
        val errors = mutableListOf<RouteError>()
        val listener = RouteListener({ results.add(it) }, { errors.add(it) })
        val retired = RouteRequest(listener)
        val first = retired.toNative()
        assertSame(first, retired.toNative())
        first(emptyList<Any>(), null)
        retired.dispose()
        first(null, nativeError)
        first(emptyList<Any>(), null)
        assertTrue(results.single().isEmpty())
        assertTrue(errors.isEmpty())

        RouteRequest(listener).toNative()(null, nativeError)
        assertSame(nativeError, errors.single().toNative())
        assertEquals("Routing unavailable", errors.single().description)
        assertNull(errors.single().error)
    }

    @Test
    public fun aliases_replace_and_cancel_the_same_native_transport_request() {
        val native = RecordingSession()
        val aliasBeforeRequest = native.toCommon()
        val oldResults = mutableListOf<List<Route>>()
        val oldRequest = RouteRequest(
            RouteListener({ oldResults.add(it) }, { error("Unexpected initial failure") }),
        )
        native.callbacks.add(oldRequest.toNative())
        val owner = native.toCommon(oldRequest)
        val aliasBeforeRetry = owner.toNative().toCommon()
        val currentResults = mutableListOf<List<Route>>()
        aliasBeforeRetry.retry(RouteListener({ currentResults.add(it) }, { error("Unexpected retry failure") }))
        assertEquals(2, native.callbacks.size)

        native.callbacks[0](emptyList<Any>(), null)
        native.callbacks[1](emptyList<Any>(), null)
        aliasBeforeRequest.cancel()
        native.callbacks[1](emptyList<Any>(), null)

        assertSame(native, owner.toNative())
        assertEquals(1, native.cancelCount)
        assertTrue(oldResults.isEmpty())
        assertTrue(currentResults.single().isEmpty())
    }

}

private class RecordingSession : NativeSession() {

    val callbacks = mutableListOf<(List<*>?, NSError?) -> Unit>()
    var cancelCount = 0
        private set

    override fun retryWithRouteHandler(routeHandler: (List<*>?, NSError?) -> Unit) {
        callbacks.add(routeHandler)
    }

    override fun cancel() {
        cancelCount++
        callbacks.lastOrNull()?.invoke(emptyList<Any>(), null)
    }
}
