package ru.sulgik.mapkit.runtime.logging

import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import com.yandex.runtime.logging.LogMessage as NativeLogMessage

@OptIn(ExperimentalTime::class)
public fun LogMessage.toNative(): NativeLogMessage {
    return NativeLogMessage(
        time.toEpochMilliseconds(),
        level.toNative(),
        scope,
        message,
        verboseInfo,
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeLogMessage.toCommon(): LogMessage {
    return LogMessage(
        time = Instant.fromEpochMilliseconds(time),
        level = level.toCommon(),
        scope = scope,
        message = message,
        verboseInfo = verboseInfo,
    )
}

public fun LogMessage.LogLevel.toNative(): NativeLogMessage.LogLevel {
    return when (this) {
        LogMessage.LogLevel.ERROR -> NativeLogMessage.LogLevel.ERROR
        LogMessage.LogLevel.WARNING -> NativeLogMessage.LogLevel.WARNING
        LogMessage.LogLevel.INFO -> NativeLogMessage.LogLevel.INFO
        LogMessage.LogLevel.DEBUG -> NativeLogMessage.LogLevel.DEBUG
    }
}

public fun NativeLogMessage.LogLevel.toCommon(): LogMessage.LogLevel {
    return when (this) {
        NativeLogMessage.LogLevel.ERROR -> LogMessage.LogLevel.ERROR
        NativeLogMessage.LogLevel.WARNING -> LogMessage.LogLevel.WARNING
        NativeLogMessage.LogLevel.INFO -> LogMessage.LogLevel.INFO
        NativeLogMessage.LogLevel.DEBUG -> LogMessage.LogLevel.DEBUG
    }
}
