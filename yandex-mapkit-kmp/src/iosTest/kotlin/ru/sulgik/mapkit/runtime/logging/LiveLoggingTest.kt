package ru.sulgik.mapkit.runtime.logging

import platform.Foundation.NSDate
import platform.Foundation.NSLock
import platform.Foundation.dateWithTimeIntervalSinceNow
import platform.Foundation.timeIntervalSinceNow
import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
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
import YandexMapKit.YRTLogger as NativeLogger

@OptIn(ExperimentalTime::class)
public class LiveLoggingTest {

    private val lock = NSLock()
    private val received = mutableListOf<LogMessage>()
    private val logListener = LogListener { message ->
        lock.lock()
        received.add(message)
        lock.unlock()
    }

    @BeforeTest
    public fun setUp() {
        Logging.getLogging().subscribe(logListener.asWeakRef())
    }

    @AfterTest
    public fun tearDown() {
        Logging.getLogging().unsubscribe(logListener.asWeakRef())
    }

    @Test
    public fun `a pushed message reaches the listener`() {
        val marker = marker()
        val before = Clock.System.now()

        NativeLogger.errorWithStr(marker)

        val message = awaitMessage(marker)

        assertEquals(LogMessage.LogLevel.ERROR, message.level)
        assertEquals(marker, message.message)
        assertTrue(message.scope.isNotEmpty(), "scope is empty in $message")
        assertTrue(message.time >= before - TimeSlack, "time of $message is before $before")
        assertTrue(message.time <= Clock.System.now() + TimeSlack, "time of $message is in the future")
    }

    @Test
    public fun `an error and a warning arrive with their own levels`() {
        val error = marker()
        val warning = marker()

        NativeLogger.errorWithStr(error)
        NativeLogger.warnWithStr(warning)

        assertEquals(LogMessage.LogLevel.ERROR, awaitMessage(error).level)
        assertEquals(LogMessage.LogLevel.WARNING, awaitMessage(warning).level)
    }

    @Test
    public fun `info and debug stay below the log level threshold of mapkit`() {
        val info = marker()
        val debug = marker()

        NativeLogger.infoWithStr(info)
        NativeLogger.debugWithStr(debug)

        assertNull(findMessage(info, SilenceTimeout))
        assertNull(findMessage(debug, SilenceTimeout))
    }

    @Test
    public fun `an unsubscribed listener receives nothing more`() {
        awaitMessage(marker().also { NativeLogger.errorWithStr(it) })

        Logging.getLogging().unsubscribe(logListener.asWeakRef())
        val dropped = marker()
        NativeLogger.errorWithStr(dropped)

        assertNull(findMessage(dropped, SilenceTimeout))
    }

    private fun marker(): String {
        markerCount += 1
        return "yandex-mapkit-kmp-$markerCount-${Clock.System.now().toEpochMilliseconds()}"
    }

    private fun awaitMessage(marker: String): LogMessage {
        return findMessage(marker, DeliveryTimeout)
            ?: fail("no log message with the marker $marker arrived in $DeliveryTimeout")
    }

    private fun findMessage(marker: String, timeout: Duration): LogMessage? {
        val deadline = NSDate.dateWithTimeIntervalSinceNow(timeout.inWholeMilliseconds / 1000.0)
        while (true) {
            val message = snapshot().firstOrNull { marker in it.message }
            if (message != null) {
                return message
            }
            if (deadline.timeIntervalSinceNow <= 0.0) {
                return null
            }
            LiveMap.drainMainQueue(PollInterval)
        }
    }

    private fun snapshot(): List<LogMessage> {
        lock.lock()
        val messages = received.toList()
        lock.unlock()
        return messages
    }

    private companion object {

        val DeliveryTimeout = 5.seconds
        val SilenceTimeout = 1.seconds
        val PollInterval = 50.milliseconds
        val TimeSlack = 1.minutes

        var markerCount = 0
    }
}
