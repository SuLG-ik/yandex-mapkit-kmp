package ru.sulgik.mapkit.runtime.logging

import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import YandexMapKit.YRTLogMessage as NativeLogMessage
import YandexMapKit.YRTLogMessageLogLevel as NativeLogLevel

@OptIn(ExperimentalTime::class)
public fun LogMessage.toNative(): NativeLogMessage {
    return NativeLogMessage.logMessageWithTime(
        time = NSDate.dateWithTimeIntervalSince1970(time.toEpochMilliseconds() / 1000.0),
        level = level.toNative(),
        scope = scope,
        message = message,
        verboseInfo = verboseInfo,
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeLogMessage.toCommon(): LogMessage {
    return LogMessage(
        time = Instant.fromEpochMilliseconds((time.timeIntervalSince1970 * 1000).toLong()),
        level = level.toCommon(),
        scope = scope,
        message = message,
        verboseInfo = verboseInfo,
    )
}

public fun LogMessage.LogLevel.toNative(): NativeLogLevel {
    return when (this) {
        LogMessage.LogLevel.ERROR -> NativeLogLevel.YRTLogMessageLogLevelError
        LogMessage.LogLevel.WARNING -> NativeLogLevel.YRTLogMessageLogLevelWarning
        LogMessage.LogLevel.INFO -> NativeLogLevel.YRTLogMessageLogLevelInfo
        LogMessage.LogLevel.DEBUG -> NativeLogLevel.YRTLogMessageLogLevelDebug
    }
}

public fun NativeLogLevel.toCommon(): LogMessage.LogLevel {
    return when (this) {
        NativeLogLevel.YRTLogMessageLogLevelError -> LogMessage.LogLevel.ERROR
        NativeLogLevel.YRTLogMessageLogLevelWarning -> LogMessage.LogLevel.WARNING
        NativeLogLevel.YRTLogMessageLogLevelInfo -> LogMessage.LogLevel.INFO
        NativeLogLevel.YRTLogMessageLogLevelDebug -> LogMessage.LogLevel.DEBUG
        else -> throw IllegalArgumentException("Unknown NativeLogLevel ($this)")
    }
}
