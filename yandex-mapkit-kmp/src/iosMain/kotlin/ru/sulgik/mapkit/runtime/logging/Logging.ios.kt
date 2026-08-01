package ru.sulgik.mapkit.runtime.logging

import ru.sulgik.mapkit.WeakRef
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
     *
     * The class does not retain the object in the 'logListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun subscribe(logListener: WeakRef<LogListener>) {
        nativeLogging.subscribeWithLogListener(logListener.get()?.toNative() ?: return)
    }

    /**
     * Unsubscribes a listener from receiving log messages.
     */
    public actual fun unsubscribe(logListener: WeakRef<LogListener>) {
        nativeLogging.unsubscribeWithLogListener(logListener.get()?.toNative() ?: return)
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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Logging) return false
        if (this::class != other::class) return false
        return nativeLogging == other.nativeLogging
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLogging.hashCode()
    }
}

public fun NativeLogging.toCommon(): Logging {
    return Logging(this)
}
