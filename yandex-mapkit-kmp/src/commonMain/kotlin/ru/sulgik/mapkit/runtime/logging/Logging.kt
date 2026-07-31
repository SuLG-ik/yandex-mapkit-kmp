package ru.sulgik.mapkit.runtime.logging

/**
 * The log stream of MapKit.
 */
public expect class Logging {

    /**
     * Subscribes a listener to receive log messages.
     */
    public fun subscribe(logListener: LogListener)

    /**
     * Unsubscribes a listener from receiving log messages.
     */
    public fun unsubscribe(logListener: LogListener)

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
}
