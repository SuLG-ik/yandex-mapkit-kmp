package ru.sulgik.mapkit

import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.layers.LayerOptions
import ru.sulgik.mapkit.layers.OverzoomMode
import ru.sulgik.mapkit.layers.toCommon
import ru.sulgik.mapkit.layers.toNative
import ru.sulgik.mapkit.location.Location
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.location.toNative
import ru.sulgik.mapkit.map.MapLoadStatistics
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.map.toNative
import ru.sulgik.mapkit.runtime.logging.LogMessage
import ru.sulgik.mapkit.runtime.logging.toCommon
import ru.sulgik.mapkit.runtime.logging.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import YandexMapKit.YMKAnimation as NativeAnimation
import YandexMapKit.YMKAnimationType as NativeAnimationType
import YandexMapKit.YMKLayerOptions as NativeLayerOptions
import YandexMapKit.YMKLocation as NativeLocation
import YandexMapKit.YMKMapLoadStatistics as NativeMapLoadStatistics
import YandexMapKit.YMKOverzoomMode as NativeOverzoomMode
import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YRTLogMessage as NativeLogMessage
import YandexMapKit.YRTLogMessageLogLevel as NativeLogLevel

@OptIn(ExperimentalTime::class)
public class DurationConverterTest {

    @Test
    public fun `animation duration is expressed in seconds`() {
        val native = Animation(Animation.Type.SMOOTH, 1500.milliseconds).toNative()

        assertEquals(1.5f, native.duration)
        assertEquals(NativeAnimationType.YMKAnimationTypeSmooth, native.type)

        val common = NativeAnimation.animationWithType(NativeAnimationType.YMKAnimationTypeLinear, 2.5f).toCommon()

        assertEquals(2500.milliseconds, common.duration)
        assertEquals(Animation.Type.LINEAR, common.type)
    }

    @Test
    public fun `layer options tile animation duration is expressed in seconds`() {
        val native = LayerOptions(tileAppearingAnimationDuration = 250.milliseconds).toNative()

        assertEquals(0.25, native.tileAppearingAnimationDuration)

        val common = nativeLayerOptions(tileAppearingAnimationDuration = 0.4).toCommon()

        assertEquals(400.milliseconds, common.tileAppearingAnimationDuration)
    }

    @Test
    public fun `layer options keeps every flag in its own native field`() {
        val native = LayerOptions(
            active = false,
            nightModeAvailable = true,
            cacheable = false,
            animateOnActivation = false,
            tileAppearingAnimationDuration = 10.milliseconds,
            overzoomMode = OverzoomMode.WITH_PREFETCH,
            transparent = true,
            versionSupport = true,
        ).toNative()

        assertEquals(false, native.active)
        assertEquals(true, native.nightModeAvailable)
        assertEquals(false, native.cacheable)
        assertEquals(false, native.animateOnActivation)
        assertEquals(NativeOverzoomMode.YMKOverzoomModeWithPrefetch, native.overzoomMode)
        assertEquals(true, native.transparent)
        assertEquals(true, native.versionSupport)
    }

    @Test
    public fun `map load statistics durations are expressed in seconds`() {
        val statistics = MapLoadStatistics(
            curZoomGeometryLoaded = 1000.milliseconds,
            curZoomPlacemarksLoaded = 2000.milliseconds,
            curZoomLabelsLoaded = 3000.milliseconds,
            delayedGeometryLoaded = 4000.milliseconds,
            curZoomModelsLoaded = 5000.milliseconds,
            fullyLoaded = 6000.milliseconds,
            fullyAppeared = 7000.milliseconds,
            renderObjectCount = 8,
            tileMemoryUsage = 9,
        )

        val native = statistics.toNative()

        assertEquals(1.0, native.curZoomGeometryLoaded)
        assertEquals(2.0, native.curZoomPlacemarksLoaded)
        assertEquals(3.0, native.curZoomLabelsLoaded)
        assertEquals(4.0, native.delayedGeometryLoaded)
        assertEquals(5.0, native.curZoomModelsLoaded)
        assertEquals(6.0, native.fullyLoaded)
        assertEquals(7.0, native.fullyAppeared)
        assertEquals(8L, native.renderObjectCount)
        assertEquals(9UL, native.tileMemoryUsage)

        assertEquals(statistics, native.toCommon())
    }

    @Test
    public fun `map load statistics reads a second as one thousand milliseconds`() {
        val common = NativeMapLoadStatistics.mapLoadStatisticsWithCurZoomGeometryLoaded(
            curZoomGeometryLoaded = 1.0,
            curZoomPlacemarksLoaded = 0.0,
            curZoomLabelsLoaded = 0.0,
            delayedGeometryLoaded = 0.0,
            curZoomModelsLoaded = 0.0,
            fullyLoaded = 0.0,
            fullyAppeared = 0.0,
            renderObjectCount = 0L,
            tileMemoryUsage = 0UL,
        ).toCommon()

        assertEquals(1.seconds, common.curZoomGeometryLoaded)
        assertEquals(1000.milliseconds, common.curZoomGeometryLoaded)
    }

    @Test
    public fun `log message time is an epoch date`() {
        val time = Instant.fromEpochMilliseconds(1_700_000_000_000L)
        val native = LogMessage(
            time = time,
            level = LogMessage.LogLevel.WARNING,
            scope = "scope",
            message = "message",
            verboseInfo = "verbose",
        ).toNative()

        assertEquals(1_700_000_000.0, native.time.timeIntervalSince1970)
        assertEquals(NativeLogLevel.YRTLogMessageLogLevelWarning, native.level)
        assertEquals("scope", native.scope)
        assertEquals("message", native.message)
        assertEquals("verbose", native.verboseInfo)

        val common = NativeLogMessage.logMessageWithTime(
            time = NSDate.dateWithTimeIntervalSince1970(1_700_000_000.0),
            level = NativeLogLevel.YRTLogMessageLogLevelDebug,
            scope = "scope",
            message = "message",
            verboseInfo = "verbose",
        ).toCommon()

        assertEquals(time, common.time)
        assertEquals(LogMessage.LogLevel.DEBUG, common.level)
    }

    @Test
    public fun `location timestamps are expressed in seconds`() {
        val location = Location(
            position = Point(55.75, 37.61),
            accuracy = 12.0,
            altitude = 140.0,
            altitudeAccuracy = 3.0,
            heading = 91.0,
            speed = 4.0,
            indoorLevelId = "level",
            absoluteTimestamp = Instant.fromEpochMilliseconds(1_700_000_000_000L),
            relativeTimestamp = 42.seconds,
        )

        val native = location.toNative()

        assertEquals(1_700_000_000.0, native.absoluteTimestamp.timeIntervalSince1970)
        assertEquals(42.0, native.relativeTimestamp.timeIntervalSince1970)
        assertEquals(55.75, native.position.latitude)
        assertEquals(37.61, native.position.longitude)
        assertEquals(12.0, native.accuracy?.doubleValue)
        assertEquals(140.0, native.altitude?.doubleValue)
        assertEquals(3.0, native.altitudeAccuracy?.doubleValue)
        assertEquals(91.0, native.heading?.doubleValue)
        assertEquals(4.0, native.speed?.doubleValue)
        assertEquals("level", native.indoorLevelId)

        assertEquals(location, native.toCommon())
    }

    @Test
    public fun `location relative timestamp reads a minute of uptime as a duration`() {
        val common = NativeLocation.locationWithPosition(
            position = NativePoint.pointWithLatitude(0.0, 0.0),
            accuracy = null,
            altitude = null,
            altitudeAccuracy = null,
            heading = null,
            speed = null,
            indoorLevelId = null,
            absoluteTimestamp = NSDate.dateWithTimeIntervalSince1970(0.0),
            relativeTimestamp = NSDate.dateWithTimeIntervalSince1970(60.0),
        ).toCommon()

        assertEquals(60.seconds, common.relativeTimestamp)
        assertEquals(Instant.fromEpochMilliseconds(0L), common.absoluteTimestamp)
    }

    @Test
    public fun `location keeps the optional fields null`() {
        val common = NativeLocation.locationWithPosition(
            position = NativePoint.pointWithLatitude(1.0, 2.0),
            accuracy = null,
            altitude = null,
            altitudeAccuracy = null,
            heading = null,
            speed = null,
            indoorLevelId = null,
            absoluteTimestamp = NSDate.dateWithTimeIntervalSince1970(0.0),
            relativeTimestamp = NSDate.dateWithTimeIntervalSince1970(0.0),
        ).toCommon()

        assertEquals(null, common.accuracy)
        assertEquals(null, common.altitude)
        assertEquals(null, common.altitudeAccuracy)
        assertEquals(null, common.heading)
        assertEquals(null, common.speed)
        assertEquals(null, common.indoorLevelId)
    }

    private fun nativeLayerOptions(tileAppearingAnimationDuration: Double): NativeLayerOptions {
        return NativeLayerOptions.layerOptionsWithActive(
            active = true,
            nightModeAvailable = false,
            cacheable = true,
            animateOnActivation = true,
            tileAppearingAnimationDuration = tileAppearingAnimationDuration,
            overzoomMode = NativeOverzoomMode.YMKOverzoomModeDisabled,
            transparent = false,
            versionSupport = false,
        )
    }
}
