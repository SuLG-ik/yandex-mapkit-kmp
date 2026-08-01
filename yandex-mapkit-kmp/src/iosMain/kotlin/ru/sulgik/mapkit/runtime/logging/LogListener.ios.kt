package ru.sulgik.mapkit.runtime.logging

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YRTLogListenerProtocol as NativeLogListener
import YandexMapKit.YRTLogMessage as NativeLogMessage

/**
 * Receives the log messages of MapKit.
 */
public actual abstract class LogListener actual constructor() : NativeConvertible<NativeLogListener> {

    private val nativeListener = object : NativeLogListener, NSObject() {
        override fun onMessageReceivedWithMessage(message: NativeLogMessage) {
            onMessageReceived(message.toCommon())
        }
    }

    override fun toNative(): NativeLogListener {
        return nativeListener
    }

    /**
     * Called when a new log message is received.
     */
    public actual abstract fun onMessageReceived(message: LogMessage)
}
