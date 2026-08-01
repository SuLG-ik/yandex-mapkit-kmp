package ru.sulgik.mapkit

import ru.sulgik.mapkit.runtime.logging.LogListener
import ru.sulgik.mapkit.runtime.logging.LogMessage
import ru.sulgik.mapkit.runtime.logging.Logging
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.fail
import kotlin.time.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import com.yandex.runtime.logging.Logger as NativeLogger

@OptIn(ExperimentalTime::class)
public class LiveLoggingTest {

    private val received = CopyOnWriteArrayList<LogMessage>()
    private val logListener = LogListener { received.add(it) }

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
        Logging.getLogging().subscribe(logListener.asWeakRef())
    }

    @AfterTest
    public fun tearDown() {
        Logging.getLogging().unsubscribe(logListener.asWeakRef())
    }

    @Test
    public fun a_pushed_message_reaches_the_listener() {
        val marker = marker()
        val before = Clock.System.now()

        NativeLogger.error(marker)

        val message = awaitMessage(marker)

        assertEquals(LogMessage.LogLevel.ERROR, message.level)
        assertEquals(marker, message.message)
        assertTrue(message.scope.isNotEmpty(), "scope is empty in $message")
        assertTrue(message.time >= before - TimeSlack, "time of $message is before $before")
        assertTrue(message.time <= Clock.System.now() + TimeSlack, "time of $message is in the future")
    }

    @Test
    public fun an_error_and_a_warning_arrive_with_their_own_levels() {
        val error = marker()
        val warning = marker()

        NativeLogger.error(error)
        NativeLogger.warn(warning)

        assertEquals(LogMessage.LogLevel.ERROR, awaitMessage(error).level)
        assertEquals(LogMessage.LogLevel.WARNING, awaitMessage(warning).level)
    }

    @Test
    public fun info_and_debug_stay_below_the_log_level_threshold_of_mapkit() {
        val info = marker()
        val debug = marker()

        NativeLogger.info(info)
        NativeLogger.debug(debug)

        assertNull(findMessage(info, SilenceTimeout))
        assertNull(findMessage(debug, SilenceTimeout))
    }

    @Test
    public fun an_unsubscribed_listener_receives_nothing_more() {
        awaitMessage(marker().also { NativeLogger.error(it) })

        Logging.getLogging().unsubscribe(logListener.asWeakRef())
        val dropped = marker()
        NativeLogger.error(dropped)

        assertNull(findMessage(dropped, SilenceTimeout))
    }

    private fun marker(): String {
        markerCount += 1
        return "yandex-mapkit-kmp-$markerCount-${System.nanoTime()}"
    }

    private fun awaitMessage(marker: String): LogMessage {
        return findMessage(marker, DeliveryTimeout)
            ?: fail("no log message with the marker $marker arrived in $DeliveryTimeout, received $received")
    }

    private fun findMessage(marker: String, timeout: Duration): LogMessage? {
        val deadline = System.nanoTime() + timeout.inWholeNanoseconds
        while (true) {
            val message = received.firstOrNull { marker in it.message }
            if (message != null) {
                return message
            }
            if (System.nanoTime() >= deadline) {
                return null
            }
            Thread.sleep(PollInterval.inWholeMilliseconds)
        }
    }

    private companion object {

        val DeliveryTimeout = 5.seconds
        val SilenceTimeout = 1.seconds
        val PollInterval = 50.milliseconds
        val TimeSlack = 1.minutes

        var markerCount = 0
    }
}
