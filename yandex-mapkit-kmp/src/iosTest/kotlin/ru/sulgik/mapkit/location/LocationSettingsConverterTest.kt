package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import YandexMapKit.YMKLocationError as NativeLocationError
import YandexMapKit.YMKLocationSettings as NativeLocationSettings
import YandexMapKit.YMKRange as NativeRange
import YandexMapKit.YMKTimeInterval as NativeTimeInterval

public class LocationSettingsConverterTest {

    @Test
    public fun `time interval is expressed in seconds`() {
        val native = TimeInterval(from = 250.milliseconds, to = 2.seconds).toNative()

        assertEquals(0.25, native.from)
        assertEquals(2.0, native.to)

        val common = NativeTimeInterval.timeIntervalWithFrom(0.5, 1.5).toCommon()

        assertEquals(500.milliseconds, common.from)
        assertEquals(1500.milliseconds, common.to)
    }

    @Test
    public fun `range keeps the lower and the upper bound apart`() {
        val native = Range(from = -3.5, to = 7.25).toNative()

        assertEquals(-3.5, native.from)
        assertEquals(7.25, native.to)

        val common = NativeRange.rangeWithFrom(-3.5, 7.25).toCommon()

        assertEquals(-3.5, common.from)
        assertEquals(7.25, common.to)
    }

    @Test
    public fun `location error keeps the lateral and the longitudinal range apart`() {
        val native = LocationError(
            lateralErrorRange = Range(1.0, 2.0),
            longitudinalErrorRange = Range(3.0, 4.0),
        ).toNative()

        assertEquals(1.0, native.lateralErrorRange.from)
        assertEquals(2.0, native.lateralErrorRange.to)
        assertEquals(3.0, native.longitudinalErrorRange.from)
        assertEquals(4.0, native.longitudinalErrorRange.to)

        val common = NativeLocationError.locationErrorWithLateralErrorRange(
            NativeRange.rangeWithFrom(1.0, 2.0),
            NativeRange.rangeWithFrom(3.0, 4.0),
        ).toCommon()

        assertEquals(Range(1.0, 2.0), common.lateralErrorRange)
        assertEquals(Range(3.0, 4.0), common.longitudinalErrorRange)
    }

    @Test
    public fun `location settings keeps every field in its own native field`() {
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
        assertEquals(0.1, native.locationTimeInterval?.from)
        assertEquals(0.2, native.locationTimeInterval?.to)
        assertEquals(true, native.provideSpeed)
        assertEquals(13.5, native.speed)
        assertEquals(true, native.provideHeading)
        assertEquals(3.0, native.headingError?.from)
        assertEquals(4.0, native.headingError?.to)
        assertEquals(5.0, native.locationError?.lateralErrorRange?.from)
        assertEquals(7.0, native.locationError?.longitudinalErrorRange?.from)
        assertEquals(true, native.provideWheelSpeed)
        assertEquals(0.3, native.wheelSpeedTimeInterval?.from)
        assertEquals(0.4, native.wheelSpeedTimeInterval?.to)

        assertEquals(settings, native.toCommon())
    }

    @Test
    public fun `location settings keeps the optional fields null`() {
        val common = NativeLocationSettings.locationSettingsWithProvideAccuracy(
            provideAccuracy = false,
            accuracy = null,
            locationTimeInterval = null,
            provideSpeed = false,
            speed = 0.0,
            provideHeading = false,
            headingError = null,
            locationError = null,
            provideWheelSpeed = false,
            wheelSpeedTimeInterval = null,
        ).toCommon()

        assertEquals(null, common.accuracy)
        assertEquals(null, common.locationTimeInterval)
        assertEquals(null, common.headingError)
        assertEquals(null, common.locationError)
        assertEquals(null, common.wheelSpeedTimeInterval)
    }

    @Test
    public fun `simulation settings keeps the geometry apart from the location settings`() {
        val geometry = Polyline(listOf(Point(55.0, 37.0), Point(56.0, 38.0)))
        val native = SimulationSettings(
            geometry = geometry,
            locationSettings = LocationSettings(provideSpeed = true, speed = 5.0),
        ).toNative()

        assertEquals(true, native.locationSettings.provideSpeed)
        assertEquals(5.0, native.locationSettings.speed)

        val common = native.toCommon()

        assertEquals(listOf(Point(55.0, 37.0), Point(56.0, 38.0)), common.geometry.points)
        assertEquals(5.0, common.locationSettings.speed)
    }
}
