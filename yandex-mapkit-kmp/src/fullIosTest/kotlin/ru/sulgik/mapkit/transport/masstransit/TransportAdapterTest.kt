package ru.sulgik.mapkit.transport.masstransit

import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey
import platform.darwin.NSObject
import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.RequestPointType
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.routing.RoutingRequestState
import ru.sulgik.mapkit.search.SearchRequestBindings
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Instant
import YandexMapKit.YMKMasstransitFitness as NativeFitness
import YandexMapKit.YMKMasstransitLine as NativeLine
import YandexMapKit.YMKMasstransitRouteMetadata as NativeRouteMetadata
import YandexMapKit.YMKMasstransitRouteStop as NativeRouteStop
import YandexMapKit.YMKMasstransitRouteStopMetadata as NativeRouteStopMetadata
import YandexMapKit.YMKMasstransitSection as NativeSection
import YandexMapKit.YMKMasstransitSectionMetadata as NativeSectionMetadata
import YandexMapKit.YMKMasstransitSectionMetadataSectionData as NativeSectionData
import YandexMapKit.YMKMasstransitStop as NativeStop
import YandexMapKit.YMKMasstransitTransport as NativeTransportLeg

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

        assertTrue(native.isEqual(bicycle.toNative()))
        assertEquals(FitnessType.BICYCLE, bicycle.type)
        assertEquals(via, bicycle.viaPoints)
        assertNull(section.wait)
        assertNull(section.transports)
    }

    @Test
    public fun single_filter_flags_round_trip_and_combined_masks_stay_in_options() {
        for (flag in FilterVehicleTypes.entries) {
            val native = flag.toNative()
            assertEquals(flag.value.toULong(), native)
            assertEquals(flag, FilterVehicleTypes.toCommon(native))
        }
        val combined = FilterVehicleTypes.BUS.toNative() or FilterVehicleTypes.TRAMWAY.toNative()
        assertFailsWith<IllegalArgumentException> { FilterVehicleTypes.toCommon(combined) }
        assertFailsWith<IllegalArgumentException> { FilterVehicleTypes.toCommon(1uL shl 31) }
        assertFailsWith<IllegalArgumentException> { FilterVehicleTypes.toCommon(1uL shl 33) }
        val mask = combined or (1uL shl 31)
        val options = TransitOptions(avoid = mask.toInt())
        assertEquals(mask, options.toNative().avoid)
        assertEquals(options, options.toNative().toCommon())
    }

    @Test
    public fun transit_filters_and_nullable_access_points_survive_native_mapping() {
        val filters = FilterVehicleTypes.BUS.value or FilterVehicleTypes.TRAMWAY.value
        val options = TransitOptions(
            avoid = filters,
            timeOptions = TimeOptions(arrivalTime = Instant.fromEpochMilliseconds(1_797_432_000_123L)),
        )
        assertEquals(17uL, options.toNative().avoid)
        assertEquals(options, options.toNative().toCommon())
        assertEquals(TransitOptions(), TransitOptions().toNative().toCommon())

        val places = listOf(Point(55.75, 37.62), Point(55.76, 37.61))
        val stops = places.mapIndexed { index, place ->
            val stop = NativeStop.stopWithId(
                id = "stop-$index",
                name = "Station $index",
                additionalName = null,
                features = null,
                transportContours = emptyList<Any>(),
            )
            NativeRouteStop.routeStopWithMetadata(
                metadata = NativeRouteStopMetadata.routeStopMetadataWithStop(
                    stop = stop,
                    stopExit = null,
                    exitPoint = null,
                    stopEntrance = null,
                    entrancePoint = if (index == 0) place.toNative() else null,
                ),
                position = place.toNative(),
            )
        }
        val nativeLine = NativeLine.lineWithId(
            id = "line-1",
            name = "M1",
            vehicleTypes = listOf("underground"),
            style = null,
            isNight = false,
            uri = null,
            shortName = null,
            transportSystemId = null,
        )
        val ride = NativeTransportLeg.transportWithLine(nativeLine, emptyList<Any>(), emptyList<Any>())
        val weight = Weight(LocalizedValue(70.0, "70 s"), LocalizedValue(0.0, "0 m"), 0)
        val sectionGeometry = Subpolyline(PolylinePosition(0, 0.0), PolylinePosition(0, 1.0))
        val section = NativeSection.sectionWithMetadata(
            metadata = NativeSectionMetadata.sectionMetadataWithWeight(
                weight = weight.toNative(),
                data = NativeSectionData.sectionDataWithTransports(listOf(ride)),
                estimation = null,
                legIndex = 0uL,
                paymentOptions = emptyList<Any>(),
            ),
            geometry = sectionGeometry.toNative(),
            stops = stops,
            rideLegs = listOf(sectionGeometry.toNative()),
        ).toCommon()

        assertNull(section.metadata.data.fitness)
        val line = checkNotNull(section.metadata.data.transports).single().line
        assertTrue(nativeLine.isEqual(line.toNative()))
        assertEquals("line-1", line.id)
        assertEquals("M1", line.name)
        assertEquals(listOf("underground"), line.vehicleTypes)
        assertEquals(listOf("stop-0", "stop-1"), section.stops.map { it.metadata.stop.id })
        assertEquals(places, section.stops.map { it.position })
        assertEquals(places[0], section.stops.first().metadata.entrancePoint)
        assertNull(section.stops.last().metadata.entrancePoint)
        assertNull(section.stops.last().metadata.stop.additionalName)
        assertEquals(listOf(sectionGeometry), section.rideLegs)
    }

    @Test
    public fun native_handler_delivers_no_route_and_error_and_ignores_retired_callbacks() {
        val nativeError = NSError(
            domain = "TransportTest",
            code = 42,
            userInfo = mapOf(NSLocalizedDescriptionKey to "Routing unavailable"),
        )
        val results = mutableListOf<List<Route>>()
        val errors = mutableListOf<RouteError>()
        val listener: Session.RouteListener = RouteListener({ results.add(it) }, { errors.add(it) })
        assertSame(listener.toNative(), listener.toNative())
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
    public fun shared_lifecycle_state_cancels_replacement_through_an_earlier_surrogate_alias() {
        val handle = NSObject()
        val bindings = SearchRequestBindings<NSObject, RoutingRequestState<RouteListener>>()
        val aliasBeforeRequest = bindings.getOrPut(handle) { RoutingRequestState() }
        val oldResults = mutableListOf<List<Route>>()
        val oldRequest = RouteRequest(
            RouteListener({ oldResults.add(it) }, { error("Unexpected initial failure") }),
        )
        val owner = bindings.getOrPut(handle) { error("Earlier alias lost its request state") }
        owner.replace(oldRequest)
        val retiredHandler = oldRequest.toNative()
        val aliasBeforeRetry = bindings.getOrPut(handle) { error("Request state was replaced") }
        val currentResults = mutableListOf<List<Route>>()
        val currentRequest = RouteRequest(
            RouteListener({ currentResults.add(it) }, { error("Unexpected retry failure") }),
        )
        aliasBeforeRetry.replace(currentRequest)
        val currentHandler = currentRequest.toNative()

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
