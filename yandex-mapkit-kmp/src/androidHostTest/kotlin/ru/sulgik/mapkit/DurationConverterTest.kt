package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.layers.LayerOptions
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
import com.yandex.mapkit.Animation as NativeAnimation
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.layers.LayerOptions as NativeLayerOptions
import com.yandex.mapkit.layers.OverzoomMode as NativeOverzoomMode
import com.yandex.mapkit.location.Location as NativeLocation
import com.yandex.mapkit.map.MapLoadStatistics as NativeMapLoadStatistics
import com.yandex.runtime.logging.LogMessage as NativeLogMessage

@OptIn(ExperimentalTime::class)
public class DurationConverterTest {

    @Test
    public fun `animation duration is expressed in seconds`() {
        val native = Animation(Animation.Type.SMOOTH, 1500.milliseconds).toNative()

        assertEquals(1.5f, native.duration, 0f)
        assertEquals(NativeAnimation.Type.SMOOTH, native.type)

        val common = NativeAnimation(NativeAnimation.Type.LINEAR, 2.5f).toCommon()

        assertEquals(2500.milliseconds, common.duration)
        assertEquals(Animation.Type.LINEAR, common.type)
    }

    @Test
    public fun `layer options tile animation duration is expressed in milliseconds`() {
        val native = LayerOptions(tileAppearingAnimationDuration = 250.milliseconds).toNative()

        assertEquals(250L, native.tileAppearingAnimationDuration)

        val common = nativeLayerOptions(tileAppearingAnimationDuration = 400L).toCommon()

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
            overzoomMode = ru.sulgik.mapkit.layers.OverzoomMode.WITH_PREFETCH,
            transparent = true,
            versionSupport = true,
        ).toNative()

        assertEquals(false, native.active)
        assertEquals(true, native.nightModeAvailable)
        assertEquals(false, native.cacheable)
        assertEquals(false, native.animateOnActivation)
        assertEquals(NativeOverzoomMode.WITH_PREFETCH, native.overzoomMode)
        assertEquals(true, native.transparent)
        assertEquals(true, native.versionSupport)
    }

    @Test
    public fun `map load statistics durations are expressed in milliseconds`() {
        val statistics = MapLoadStatistics(
            curZoomGeometryLoaded = 1.milliseconds,
            curZoomPlacemarksLoaded = 2.milliseconds,
            curZoomLabelsLoaded = 3.milliseconds,
            delayedGeometryLoaded = 4.milliseconds,
            curZoomModelsLoaded = 5.milliseconds,
            fullyLoaded = 6.milliseconds,
            fullyAppeared = 7.milliseconds,
            renderObjectCount = 8,
            tileMemoryUsage = 9,
        )

        val native = statistics.toNative()

        assertEquals(1L, native.curZoomGeometryLoaded)
        assertEquals(2L, native.curZoomPlacemarksLoaded)
        assertEquals(3L, native.curZoomLabelsLoaded)
        assertEquals(4L, native.delayedGeometryLoaded)
        assertEquals(5L, native.curZoomModelsLoaded)
        assertEquals(6L, native.fullyLoaded)
        assertEquals(7L, native.fullyAppeared)
        assertEquals(8, native.renderObjectCount)
        assertEquals(9, native.tileMemoryUsage)

        assertEquals(statistics, native.toCommon())
    }

    @Test
    public fun `map load statistics reads a second as one thousand milliseconds`() {
        val common = NativeMapLoadStatistics(1000L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0).toCommon()

        assertEquals(1.seconds, common.curZoomGeometryLoaded)
    }

    @Test
    public fun `log message time is an epoch milliseconds timestamp`() {
        val time = Instant.fromEpochMilliseconds(1_700_000_000_123L)
        val native = LogMessage(
            time = time,
            level = LogMessage.LogLevel.WARNING,
            scope = "scope",
            message = "message",
            verboseInfo = "verbose",
        ).toNative()

        assertEquals(1_700_000_000_123L, native.time)
        assertEquals(NativeLogMessage.LogLevel.WARNING, native.level)
        assertEquals("scope", native.scope)
        assertEquals("message", native.message)
        assertEquals("verbose", native.verboseInfo)

        val common = NativeLogMessage(
            1_700_000_000_123L,
            NativeLogMessage.LogLevel.DEBUG,
            "scope",
            "message",
            "verbose",
        ).toCommon()

        assertEquals(time, common.time)
        assertEquals(LogMessage.LogLevel.DEBUG, common.level)
    }

    @Test
    public fun `location timestamps are expressed in milliseconds`() {
        val location = Location(
            position = Point(55.75, 37.61),
            accuracy = 12.0,
            altitude = 140.0,
            altitudeAccuracy = 3.0,
            heading = 91.0,
            speed = 4.0,
            indoorLevelId = "level",
            absoluteTimestamp = Instant.fromEpochMilliseconds(1_700_000_000_123L),
            relativeTimestamp = 42_000.milliseconds,
        )

        val native = location.toNative()

        assertEquals(1_700_000_000_123L, native.absoluteTimestamp)
        assertEquals(42_000L, native.relativeTimestamp)
        assertEquals(55.75, native.position.latitude, 0.0)
        assertEquals(37.61, native.position.longitude, 0.0)
        assertEquals(12.0, native.accuracy)
        assertEquals(140.0, native.altitude)
        assertEquals(3.0, native.altitudeAccuracy)
        assertEquals(91.0, native.heading)
        assertEquals(4.0, native.speed)
        assertEquals("level", native.indoorLevelId)

        assertEquals(location, native.toCommon())
    }

    @Test
    public fun `location relative timestamp reads a minute of uptime as a duration`() {
        val common = NativeLocation(
            NativePoint(0.0, 0.0),
            null,
            null,
            null,
            null,
            null,
            null,
            0L,
            60_000L,
        ).toCommon()

        assertEquals(60.seconds, common.relativeTimestamp)
        assertEquals(Instant.fromEpochMilliseconds(0L), common.absoluteTimestamp)
    }

    @Test
    public fun `location keeps the optional fields null`() {
        val common = NativeLocation(
            NativePoint(1.0, 2.0),
            null,
            null,
            null,
            null,
            null,
            null,
            0L,
            0L,
        ).toCommon()

        assertEquals(null, common.accuracy)
        assertEquals(null, common.altitude)
        assertEquals(null, common.altitudeAccuracy)
        assertEquals(null, common.heading)
        assertEquals(null, common.speed)
        assertEquals(null, common.indoorLevelId)
    }

    private fun nativeLayerOptions(tileAppearingAnimationDuration: Long): NativeLayerOptions {
        return NativeLayerOptions(
            true,
            false,
            true,
            true,
            tileAppearingAnimationDuration,
            NativeOverzoomMode.DISABLED,
            false,
            false,
        )
    }
}
