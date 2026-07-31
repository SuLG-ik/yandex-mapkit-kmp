package ru.sulgik.mapkit.runtime.logging

import YandexMapKit.YRTLogging as NativeLogging
import YandexMapKit.YRTLoggingFactory as NativeLoggingFactory

/**
 * The log stream of MapKit.
 */
public actual class Logging internal constructor(private val nativeLogging: NativeLogging) {

    public fun toNative(): NativeLogging {
        return nativeLogging
    }

    /**
     * Subscribes a listener to receive log messages.
     */
    public actual fun subscribe(logListener: LogListener) {
        nativeLogging.subscribeWithLogListener(logListener.toNative())
    }

    /**
     * Unsubscribes a listener from receiving log messages.
     */
    public actual fun unsubscribe(logListener: LogListener) {
        nativeLogging.unsubscribeWithLogListener(logListener.toNative())
    }

    /**
     * Tells if this **Logging** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeLogging.isValid()

    public actual companion object {

        /**
         * Returns the [Logging] instance for subscribing to log messages.
         */
        public actual fun getLogging(): Logging {
            return NativeLoggingFactory.getLogging().toCommon()
        }
    }
}

public fun NativeLogging.toCommon(): Logging {
    return Logging(this)
}
