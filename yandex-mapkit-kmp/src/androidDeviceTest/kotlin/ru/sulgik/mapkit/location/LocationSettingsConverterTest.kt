package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.MapKitRuntime
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import com.yandex.mapkit.location.LocationError as NativeLocationError
import com.yandex.mapkit.location.LocationSettings as NativeLocationSettings
import com.yandex.mapkit.location.Range as NativeRange
import com.yandex.mapkit.location.TimeInterval as NativeTimeInterval

public class LocationSettingsConverterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun time_interval_is_expressed_in_milliseconds() {
        val native = TimeInterval(from = 250.milliseconds, to = 2.seconds).toNative()

        assertEquals(250L, native.from)
        assertEquals(2000L, native.to)

        val common = NativeTimeInterval(500L, 1500L).toCommon()

        assertEquals(500.milliseconds, common.from)
        assertEquals(1500.milliseconds, common.to)
    }

    @Test
    public fun range_keeps_the_lower_and_the_upper_bound_apart() {
        val native = Range(from = -3.5, to = 7.25).toNative()

        assertEquals(-3.5, native.from, 0.0)
        assertEquals(7.25, native.to, 0.0)

        val common = NativeRange(-3.5, 7.25).toCommon()

        assertEquals(-3.5, common.from, 0.0)
        assertEquals(7.25, common.to, 0.0)
    }

    @Test
    public fun location_error_keeps_the_lateral_and_the_longitudinal_range_apart() {
        val native = LocationError(
            lateralErrorRange = Range(1.0, 2.0),
            longitudinalErrorRange = Range(3.0, 4.0),
        ).toNative()

        assertEquals(1.0, native.lateralErrorRange.from, 0.0)
        assertEquals(2.0, native.lateralErrorRange.to, 0.0)
        assertEquals(3.0, native.longitudinalErrorRange.from, 0.0)
        assertEquals(4.0, native.longitudinalErrorRange.to, 0.0)

        val common = NativeLocationError(NativeRange(1.0, 2.0), NativeRange(3.0, 4.0)).toCommon()

        assertEquals(Range(1.0, 2.0), common.lateralErrorRange)
        assertEquals(Range(3.0, 4.0), common.longitudinalErrorRange)
    }

    @Test
    public fun location_settings_keeps_every_field_in_its_own_native_field() {
        val settings = LocationSettings(
            provideAccuracy = true,
            accuracy = Range(1.0, 2.0),
            locationTimeInterval = TimeInterval(100.milliseconds, 200.milliseconds),
            provideSpeed = true,
            speed = 13.5,
            provideHeading = true,
            headingError = Range(3.0, 4.0),
            locationError = LocationError(Range(5.0, 6.0), Range(7.0, 8.0)),
            provideWheelSpeed = true,
            wheelSpeedTimeInterval = TimeInterval(300.milliseconds, 400.milliseconds),
        )

        val native = settings.toNative()

        assertEquals(true, native.provideAccuracy)
        assertEquals(1.0, native.accuracy?.from)
        assertEquals(2.0, native.accuracy?.to)
        assertEquals(100L, native.locationTimeInterval?.from)
        assertEquals(200L, native.locationTimeInterval?.to)
        assertEquals(true, native.provideSpeed)
        assertEquals(13.5, native.speed, 0.0)
        assertEquals(true, native.provideHeading)
        assertEquals(3.0, native.headingError?.from)
        assertEquals(4.0, native.headingError?.to)
        assertEquals(5.0, native.locationError?.lateralErrorRange?.from)
        assertEquals(7.0, native.locationError?.longitudinalErrorRange?.from)
        assertEquals(true, native.provideWheelSpeed)
        assertEquals(300L, native.wheelSpeedTimeInterval?.from)
        assertEquals(400L, native.wheelSpeedTimeInterval?.to)

        assertEquals(settings, native.toCommon())
    }

    @Test
    public fun location_settings_keeps_the_optional_fields_null() {
        val common = NativeLocationSettings(
            false,
            null,
            null,
            false,
            0.0,
            false,
            null,
            null,
            false,
            null,
        ).toCommon()

        assertEquals(null, common.accuracy)
        assertEquals(null, common.locationTimeInterval)
        assertEquals(null, common.headingError)
        assertEquals(null, common.locationError)
        assertEquals(null, common.wheelSpeedTimeInterval)
    }

    @Test
    public fun simulation_settings_keeps_the_geometry_apart_from_the_location_settings() {
        val geometry = Polyline(listOf(Point(55.0, 37.0), Point(56.0, 38.0)))
        val native = SimulationSettings(
            geometry = geometry,
            locationSettings = LocationSettings(provideSpeed = true, speed = 5.0),
        ).toNative()

        assertEquals(55.0, native.geometry.points[0].latitude, 0.0)
        assertEquals(38.0, native.geometry.points[1].longitude, 0.0)
        assertEquals(true, native.locationSettings.provideSpeed)
        assertEquals(5.0, native.locationSettings.speed, 0.0)

        val common = native.toCommon()

        assertEquals(listOf(Point(55.0, 37.0), Point(56.0, 38.0)), common.geometry.points)
        assertEquals(5.0, common.locationSettings.speed, 0.0)
    }
}
