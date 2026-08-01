package ru.sulgik.mapkit.runtime.logging

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.runtime.logging.LogListener as NativeLogListener

/**
 * Receives the log messages of MapKit.
 */
public actual abstract class LogListener actual constructor() : NativeConvertible<NativeLogListener> {

    private val nativeListener = NativeLogListener { message ->
        onMessageReceived(message.toCommon())
    }

    override fun toNative(): NativeLogListener {
        return nativeListener
    }

    /**
     * Called when a new log message is received.
     */
    public actual abstract fun onMessageReceived(message: LogMessage)
}
