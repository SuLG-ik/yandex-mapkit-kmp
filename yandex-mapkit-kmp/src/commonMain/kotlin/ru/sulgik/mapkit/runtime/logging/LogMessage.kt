package ru.sulgik.mapkit.runtime.logging

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * A single log record produced by MapKit.
 */
@OptIn(ExperimentalTime::class)
public data class LogMessage(
    /**
     * Absolute timestamp of the log message.
     */
    val time: Instant,
    /**
     * Severity level of the log message.
     */
    val level: LogLevel,
    /**
     * Scope or category of the log message.
     */
    val scope: String,
    /**
     * The log message content.
     */
    val message: String,
    /**
     * Additional verbose information about the log message.
     */
    val verboseInfo: String,
) {

    public enum class LogLevel {
        ERROR,
        WARNING,
        INFO,
        DEBUG,
    }
}
