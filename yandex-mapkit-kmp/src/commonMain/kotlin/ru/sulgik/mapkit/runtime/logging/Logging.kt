package ru.sulgik.mapkit.runtime.logging

import ru.sulgik.mapkit.WeakRef

/**
 * The log stream of MapKit.
 */
public expect class Logging {

    /**
     * Subscribes a listener to receive log messages.
     *
     * The class does not retain the object in the 'logListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun subscribe(logListener: WeakRef<LogListener>)

    /**
     * Unsubscribes a listener from receiving log messages.
     */
    public fun unsubscribe(logListener: WeakRef<LogListener>)

    /**
     * Tells if this **Logging** is valid or not.
     */
    public val isValid: Boolean

    public companion object {

        /**
         * Returns the [Logging] instance for subscribing to log messages.
         */
        public fun getLogging(): Logging
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
